package proyecto.daw.anonygram.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import proyecto.daw.anonygram.implementation.ChatServiceImp;
import proyecto.daw.anonygram.implementation.UsuarioServiceImp;
import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Mensaje;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.models.response.ChatDataAdminResponse;
import proyecto.daw.anonygram.models.response.ChatStadisticsResponse;
import proyecto.daw.anonygram.utils.AnonygramUtils;
import proyecto.daw.anonygram.utils.TemporalEnum;
import proyecto.daw.anonygram.webSocket.model.ChatResponse;

/**
 * The Class ChatController.
 *
 * @author Gonzalo Waack Carneado
 */
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class ChatController {

    /** The usuario service. */
    @Autowired
    private UsuarioServiceImp usuarioService;

    /** The chat service. */
    @Autowired
    private ChatServiceImp chatService;

    /**
     * Gets the chats.
     *
     * @param idUsuario
     *            the id usuario
     * @return the chats
     */
    @ResponseBody
    @GetMapping(value = "/chat/all",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<ChatResponse> getChats(@RequestParam(required = true, name = "idUsuario") String idUsuario) {
        System.out.println("idUsuario: " + idUsuario);
        Usuario usuario = usuarioService.findByIdUsuario(Long.parseLong(idUsuario));
        if (usuario != null) {
            List<Chat> otherUsers = new ArrayList<>();
            otherUsers.addAll(usuario.getChatsCreados());
            otherUsers.addAll(usuario.getChatsRespondidos());
            otherUsers = new ArrayList<>(new HashSet<>(otherUsers));
            return ordenarChatFechaUltimoMensaje(otherUsers);
        }
        return new ArrayList<>();
    }

    /**
     * Ordenar chat fecha ultimo mensaje.
     *
     * @param listChat
     *            the list chat
     * @return the list
     */
    private List<ChatResponse> ordenarChatFechaUltimoMensaje(List<Chat> listChat) {
        List<ChatResponse> listResponse = new ArrayList<>();
        for (Chat chat : listChat) {
            ArrayList<Mensaje> mensajes = new ArrayList<>(chat.getMensajes());
            Collections.sort(mensajes);
            ChatResponse response = new ChatResponse();
            response.setId_chat(chat.getId_chat());
            if (mensajes.size() > 0) {
                response.setFecha_ultimo_mensaje(mensajes.get(mensajes.size() - 1).getTimestamp() + "");
                response.setUltimo_mensaje(mensajes.get(mensajes.size() - 1).getMessage());
            }
            response.setFecha_creacion(chat.getFechaCreacion() + "");
            response.setNombre_chat_creador(chat.getNombreChatCreador());
            response.setNombre_chat_respuesta(chat.getNombreChatRespuesta());
            response.setId_usuario_creador(chat.getUsuarioCreador().getId());
            response.setId_usuario_respuesta(chat.getUsuarioRespuesta().getId());
            response.setImagen(chat.getImagen());
            listResponse.add(response);
        }
        return listResponse;
    }

    /**
     * Gets the chats stadistics by date.
     *
     * @param date
     *            the date
     * @return the chats stadistics by date
     */
    @ResponseBody
    @GetMapping(value = "/admin/chat/stadistics",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ChatStadisticsResponse
        getChatsStadisticsByDate(@RequestParam(required = false, name = "date") String date) {
        List<Chat> listChats = chatService.getAllChats();
        LocalDate fecha = null;
        ChatStadisticsResponse response = new ChatStadisticsResponse();
        if (date != null) {
            fecha = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            listChats = filterChatsByDate(listChats, fecha, TemporalEnum.MINOR);
        }
        response.setChats_totales(listChats.size());
        response.setChats_activos(getChatsActivos(listChats));
        response.setChats_inactivos(getChatsInactivos(listChats));
        response.setChats_sin_comenzar(chatSinMensajes(listChats));
        listChats = fecha != null ? filterChatsByDate(listChats, fecha, TemporalEnum.SAME)
            : filterChatsByDate(listChats, AnonygramUtils.convertToLocalDate(new Date()), TemporalEnum.SAME);
        response.setChats_hoy(listChats.size());
        return response;
    }

    /**
     * Gets the chats activos.
     *
     * @param listChats
     *            the list chats
     * @return the chats activos
     */
    private int getChatsActivos(List<Chat> listChats) {
        int cantidad = 0;
        for (Chat chat : listChats) {
            if (chat.isActivo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Gets the chats inactivos.
     *
     * @param listChats
     *            the list chats
     * @return the chats inactivos
     */
    private int getChatsInactivos(List<Chat> listChats) {
        int cantidad = 0;
        for (Chat chat : listChats) {
            if (!chat.isActivo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Filter chats by date.
     *
     * @param listChats
     *            the list chats
     * @param fecha
     *            the fecha
     * @param tempo
     *            the tempo
     * @return the list
     */
    private List<Chat> filterChatsByDate(List<Chat> listChats, LocalDate fecha, TemporalEnum tempo) {
        List<Chat> response = new ArrayList<>();
        System.out.println(fecha.toString());
        for (Chat chat : listChats) {
            LocalDate fechaChat = AnonygramUtils.convertToLocalDate(chat.getFechaCreacion());
            if (TemporalEnum.SAME.equals(tempo)) {
                if (AnonygramUtils.esMismaFecha(fechaChat, fecha)) {
                    response.add(chat);
                }
            } else if (TemporalEnum.MINOR.equals(tempo)) {
                if (AnonygramUtils.esAnteriorFecha(fechaChat, fecha)) {
                    response.add(chat);
                }
            }
        }
        return response;
    }

    /**
     * Chat sin mensajes.
     *
     * @param listChats
     *            the list chats
     * @return the int
     */
    private int chatSinMensajes(List<Chat> listChats) {
        int cantidad = 0;
        for (Chat chat : listChats) {
            if (chat.getMensajes().size() == 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Gets the all chats admin.
     *
     * @return the all chats admin
     */
    @ResponseBody
    @GetMapping(value = "/admin/chat/allChats",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<ChatDataAdminResponse> getAllChatsAdmin() {
        List<Chat> listChats = chatService.getAllChats();
        List<ChatDataAdminResponse> listResponse = new ArrayList<>();
        for (Chat chat : listChats) {
            listResponse.add(new ChatDataAdminResponse(chat));
        }
        return listResponse;
    }

    /**
     * Update chat.
     *
     * @param chatUpdate
     *            the chat update
     * @return the chat data admin response
     */
    @ResponseBody
    @PostMapping(value = "/admin/chat/update",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ChatDataAdminResponse updateChat(@RequestBody Chat chatUpdate) {
        Chat chat = chatService.findByIdChat(chatUpdate.getId_chat());
        chat.setNombreChatCreador(chatUpdate.getNombreChatCreador());
        chat.setNombreChatRespuesta(chatUpdate.getNombreChatRespuesta());
        return new ChatDataAdminResponse(chat);
    }
}

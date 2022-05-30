package proyecto.daw.anonygram.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import proyecto.daw.anonygram.implementation.UsuarioServiceImp;
import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Mensaje;
import proyecto.daw.anonygram.models.Usuario;
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

    /**
     * Gets the chats.
     *
     * @param userLogin
     *            the user login
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
            response.setId_chat(chat.getId());
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
}

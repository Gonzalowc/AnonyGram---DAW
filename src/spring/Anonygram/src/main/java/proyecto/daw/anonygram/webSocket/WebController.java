package proyecto.daw.anonygram.webSocket;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import proyecto.daw.anonygram.implementation.ChatServiceImp;
import proyecto.daw.anonygram.implementation.MensajeServiceImp;
import proyecto.daw.anonygram.implementation.UsuarioServiceImp;
import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Mensaje;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.utils.AnonygramUtils;
import proyecto.daw.anonygram.webSocket.model.ChatResponse;
import proyecto.daw.anonygram.webSocket.model.MensajeResponse;

@Transactional
@Controller
public class WebController {

    @Autowired
    MensajeServiceImp mensajeSevice;

    @Autowired
    UsuarioServiceImp usuarioService;

    @Autowired
    ChatServiceImp chatService;

    @MessageMapping("hello")
    @SendTo("/topic/hi")
    public MensajeResponse greeting(String mensaje) throws Exception {
        System.out.println(mensaje);
        JSONObject mensajeObject = new JSONObject(mensaje);
        if (isObjectJSONgoodFormat(mensajeObject)) {
            Long idUsuario = mensajeObject.getLong("id_usuario");
            Long idChat = mensajeObject.getLong("id_chat");
            String mensajeRequest = mensajeObject.getString("mensaje");
            if (idChat != null && idUsuario != null && !mensajeRequest.equals("")) {
                Usuario usuario = getUsuario(idUsuario);
                Chat chat = getChat(idChat);
                if (chat != null && usuario != null) {
                    MensajeResponse response = new MensajeResponse(mensajeRequest, idUsuario, idChat,
                        mensajeObject.getString("timestamp"), mensajeObject.getBoolean("active"));
                    System.out.println(new Date());
                    Mensaje mensajeDB = new Mensaje(response.getMensaje(), usuario, chat, new Date(),
                        response.isActive());
                    System.out.println("Mensaje creado");
                    System.out.println("Mensaje enviado a insertar");
                    mensajeSevice.insertMensaje(mensajeDB);
                    return response;
                }
            }
        }
        return null;
    }

    private Usuario getUsuario(Long idUsuario) {
        return idUsuario != null ? usuarioService.findByIdUsuario(idUsuario) : null;
    }

    private Chat getChat(Long idChat) {
        try {
            return idChat != null ? chatService.findByIdChat(idChat) : null;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    private boolean isObjectJSONgoodFormat(JSONObject mensaje) {
        try {
            mensaje.getLong("id_usuario");
            mensaje.getLong("id_chat");
            mensaje.getString("mensaje");
            mensaje.getString("timestamp");
            mensaje.getBoolean("active");
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    @MessageMapping("newChat")
    @SendTo("/topic/newChat")
    public ChatResponse newChat(String mensaje) throws Exception {
        System.out.println("Mensaje: " + mensaje);
        JSONObject mensajeObject = new JSONObject(mensaje);
        try {
            Long idUsuario = mensajeObject.getLong("id_usuario");
            System.out.println(idUsuario);
            Usuario usuario = getUsuario(idUsuario);
            System.out.println(usuario);
            usuario.setActiveNewChat(true);
            List<Usuario> posibleNuevoChat = haveNewPeopeToChat(usuario);
            if (posibleNuevoChat.size() > 0) {
                int index = AnonygramUtils.getRandomIndex(posibleNuevoChat.size());
                Chat chat = new Chat();
                String randomizedString = RandomStringUtils.randomAlphanumeric(8);
                chat.setNombreChatRespuesta(randomizedString);
                chat.setNombreChatCreador(randomizedString);
                chat.setFechaCreacion(new Date());
                usuario.addChatCrear(chat, posibleNuevoChat.get(index));
                if (usuarioService.updateUsuario(usuario) != null) {
                    chat = chatService.findByUsuarioCreadorAndUsuarioRespuesta(usuario,
                        posibleNuevoChat.get(index));
                    ChatResponse chatResponse = new ChatResponse(chat);
                    updateUsersNoNewChat(usuario, posibleNuevoChat.get(index));
                    return chatResponse;
                }
            } else {
                usuarioService.updateUsuario(usuario);
            }
        } catch (JSONException e) {
            return null;
        }
        return null;
    }

    private List<Usuario> haveNewPeopeToChat(Usuario usuario) {
        List<Usuario> usuariosNuevoChat = usuarioService.getAllUsersNewChat();
        if (usuariosNuevoChat != null && usuariosNuevoChat.size() > 0) {
            System.out.println(usuariosNuevoChat);
            List<Usuario> usuariosChatActivo = usersNotChat(usuario);
            if (usuariosChatActivo != null && usuariosChatActivo.size() > 0) {
                usuariosNuevoChat.removeAll(usuariosChatActivo);
            }
            for (int i = 0; i < usuariosNuevoChat.size(); i++) {
                if (usuariosNuevoChat.get(i).getId() == usuario.getId()) {
                    usuariosNuevoChat.remove(i);
                    return usuariosNuevoChat;
                }
            }
        }
        return usuariosNuevoChat;
    }

    private List<Usuario> usersNotChat(Usuario usuario) {
        List<Usuario> otherUsers = new ArrayList<>();
        for (Chat c : usuario.getChatsCreados()) {
            otherUsers.add(c.getUsuarioRespuesta());
        }
        for (Chat c : usuario.getChatsRespondidos()) {
            otherUsers.add(c.getUsuarioCreador());
        }
        return new ArrayList<>(new HashSet<>(otherUsers));
    }

    private boolean updateUsersNoNewChat(Usuario usuarioCreador, Usuario usuarioRespuesta) {
        usuarioCreador.setActiveNewChat(false);
        usuarioRespuesta.setActiveNewChat(false);
        if (usuarioService.updateUsuario(usuarioCreador) != null
            && usuarioService.updateUsuario(usuarioRespuesta) != null) {
            return true;
        }
        return false;
    }
}

package proyecto.daw.anonygram.controller;

import java.util.ArrayList;
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
import proyecto.daw.anonygram.webSocket.model.AllMensajesResponse;
import proyecto.daw.anonygram.webSocket.model.MensajeRequest;

/**
 * The Class MensajeController.
 */
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class MensajeController {
    
    /** The usuario service. */
    @Autowired
    private UsuarioServiceImp usuarioService;

    
    
    /**
     * Gets the all mensajes.
     *
     * @param idUsuario the id usuario
     * @return the all mensajes
     */
    @ResponseBody
    @GetMapping(value = "/mensaje/all",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<AllMensajesResponse> getAllMensajes(@RequestParam(required = true, name = "idUsuario") String idUsuario) {
        Usuario usuario = usuarioService.findByIdUsuario(Long.parseLong(idUsuario));
        if (usuario != null) {
            ArrayList<Chat> chats = new ArrayList<>(usuario.getChatsCreados());
            chats.addAll(new ArrayList<>(usuario.getChatsRespondidos()));
            ArrayList<AllMensajesResponse> response = new ArrayList<>();
            for(Chat chat : chats) {
                AllMensajesResponse mensajes = new AllMensajesResponse();
                mensajes.setIdChat(chat.getId());
                ArrayList<MensajeRequest> mensajesRequest = new ArrayList<>();
                for(Mensaje mensaje : chat.getMensajes()) {
                    MensajeRequest mensajeRequest = new MensajeRequest();
                    mensajeRequest.setActive(mensaje.isActive());
                    mensajeRequest.setId_chat(mensaje.getChat().getId());
                    mensajeRequest.setId_usuario(mensaje.getUsuario().getId());
                    mensajeRequest.setMensaje(mensaje.getMessage());
                    mensajeRequest.setTimestamp(mensaje.getTimestamp());
                    mensajesRequest.add(mensajeRequest);
                    mensajes.setListMensajes(mensajesRequest);                    
                }
                response.add(mensajes);
            }
            return response;
        }
        return new ArrayList<>();
    }
}

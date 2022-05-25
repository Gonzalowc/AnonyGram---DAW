package proyecto.daw.anonygram.service;

import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Usuario;

public interface ChatService {

    public Chat findByIdChat(Long idChat);

    public Chat registerChat(Chat chat);

    public Chat findByUsuarioCreadorAndUsuarioRespuesta(Usuario usuarioCreador, Usuario usuarioRespuesta);
}

package proyecto.daw.anonygram.service;

import java.util.List;

import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Usuario;

/**
 * The Interface ChatService.
 * 
 * @author Gonzalo Waack Carneado
 */
public interface ChatService {

    /**
     * Gets the all chats.
     *
     * @return the all chats
     */
    public List<Chat> getAllChats();

    /**
     * Find by id chat.
     *
     * @param idChat
     *            the id chat
     * @return the chat
     */
    public Chat findByIdChat(Long idChat);

    /**
     * Register chat.
     *
     * @param chat
     *            the chat
     * @return the chat
     */
    public Chat registerChat(Chat chat);

    /**
     * Find by usuario creador and usuario respuesta.
     *
     * @param usuarioCreador
     *            the usuario creador
     * @param usuarioRespuesta
     *            the usuario respuesta
     * @return the chat
     */
    public Chat findByUsuarioCreadorAndUsuarioRespuesta(Usuario usuarioCreador, Usuario usuarioRespuesta);

    /**
     * Update chat.
     *
     * @param chat
     *            the chat
     * @return the chat
     */
    public Chat updateChat(Chat chat);
}

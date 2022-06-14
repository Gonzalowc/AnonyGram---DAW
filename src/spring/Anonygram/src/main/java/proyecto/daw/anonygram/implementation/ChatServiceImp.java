package proyecto.daw.anonygram.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.repository.ChatRepository;
import proyecto.daw.anonygram.service.ChatService;

/**
 * The Class ChatServiceImp.
 * 
 * @author Gonzalo Waack Carneado
 */
@Service
public class ChatServiceImp implements ChatService {

    /** The chat repo. */
    @Autowired
    ChatRepository chatRepo;

    /**
     * Find by id chat.
     *
     * @param idChat
     *            the id chat
     * @return the chat
     */
    @Override
    public Chat findByIdChat(Long idChat) {
        return chatRepo.getById(idChat);
    }

    /**
     * Register chat.
     *
     * @param chat
     *            the chat
     * @return the chat
     */
    @Override
    public Chat registerChat(Chat chat) {
        if (chat.getId_chat() == null) {
            return chatRepo.save(chat);
        }
        return null;
    }

    /**
     * Find by usuario creador and usuario respuesta.
     *
     * @param usuarioCreador
     *            the usuario creador
     * @param usuarioRespuesta
     *            the usuario respuesta
     * @return the chat
     */
    @Override
    public Chat findByUsuarioCreadorAndUsuarioRespuesta(Usuario usuarioCreador, Usuario usuarioRespuesta) {
        if (usuarioCreador != null && usuarioRespuesta != null) {
            return chatRepo.findByUsuarioCreadorAndUsuarioRespuesta(usuarioCreador, usuarioRespuesta);
        }
        return null;
    }

    /**
     * Gets the all chats.
     *
     * @return the all chats
     */
    @Override
    public List<Chat> getAllChats() {
        return chatRepo.findAll();
    }

    /**
     * Update chat.
     *
     * @param chat
     *            the chat
     * @return the chat
     */
    @Override
    public Chat updateChat(Chat chat) {
        if (chat.getId_chat() != null) {
            return chatRepo.save(chat);
        }
        return null;
    }
}

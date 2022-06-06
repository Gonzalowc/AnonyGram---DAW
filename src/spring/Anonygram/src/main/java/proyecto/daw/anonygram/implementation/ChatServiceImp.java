package proyecto.daw.anonygram.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.repository.ChatRepository;
import proyecto.daw.anonygram.service.ChatService;

@Service
public class ChatServiceImp implements ChatService {

    @Autowired
    ChatRepository chatRepo;

    @Override
    public Chat findByIdChat(Long idChat) {
        return chatRepo.getById(idChat);
    }

    @Override
    public Chat registerChat(Chat chat) {
        if (chat.getId_chat() == null) {
            return chatRepo.save(chat);
        }
        return null;
    }

    @Override
    public Chat findByUsuarioCreadorAndUsuarioRespuesta(Usuario usuarioCreador, Usuario usuarioRespuesta) {
        if (usuarioCreador != null && usuarioRespuesta != null) {
            return chatRepo.findByUsuarioCreadorAndUsuarioRespuesta(usuarioCreador, usuarioRespuesta);
        }
        return null;
    }

    @Override
    public List<Chat> getAllChats() {
        return chatRepo.findAll();
    }
}

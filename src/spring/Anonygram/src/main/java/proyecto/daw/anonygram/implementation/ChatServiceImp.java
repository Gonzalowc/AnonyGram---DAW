package proyecto.daw.anonygram.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.repository.ChatRepository;
import proyecto.daw.anonygram.service.ChatService;

@Service
public class ChatServiceImp implements ChatService {

	@Autowired
	ChatRepository chatRepo;
}

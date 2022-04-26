package proyecto.daw.anonygram.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.repository.MessageRepository;
import proyecto.daw.anonygram.service.MessageService;

@Service
public class MessageServiceImp implements MessageService {

	@Autowired
	MessageRepository messageRepo;
}

package proyecto.daw.anonygram.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.repository.UsuarioRepository;
import proyecto.daw.anonygram.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	
}

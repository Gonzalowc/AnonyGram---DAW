package proyecto.daw.anonygram.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.SecurityConfiguration;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.models.request.ModelLoginUser;
import proyecto.daw.anonygram.repository.UsuarioRepository;
import proyecto.daw.anonygram.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Override
    public Usuario findByIdUsuario(Long idUsuario) {
        return idUsuario != null ? usuarioRepo.getById(idUsuario) : null;
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        if (usuario.getId() == null) {
            Usuario userInsert = usuarioRepo.save(usuario);
            if (userInsert.getId() != null) {
                return userInsert;
            }
        }
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        if (usuario.getId() != null) {
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    @Override
    public boolean deleteUsuario(Usuario usuario) {
        if (usuario.getId() != null) {
            usuario.setActivo(false);
            usuarioRepo.save(usuario);
            return true;
        }
        return false;
    }

    @Override
    public Usuario findUsuarioLogin(ModelLoginUser usuario) {
        Usuario user = usuarioRepo.findByUsuario(usuario.getUsuario());
        PasswordEncoder encoder = SecurityConfiguration.getPasswordEncoder();
        if (user != null && encoder.matches(usuario.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public Usuario findByUsuario(String usuario) {
        return usuarioRepo.findByUsuario(usuario);
    }

    @Override
    public List<Usuario> getAllUsersNewChat() {
        return usuarioRepo.getAllByActiveNewChat(true);
    }

    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepo.findAll();
    }
    
    
}

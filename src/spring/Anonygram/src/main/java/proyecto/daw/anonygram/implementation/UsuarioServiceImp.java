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

/**
 * The Class UsuarioServiceImp.
 * 
 * @author Gonzalo Waack Carneado
 */
@Service
public class UsuarioServiceImp implements UsuarioService {

    /** The usuario repo. */
    @Autowired
    UsuarioRepository usuarioRepo;

    /**
     * Find by id usuario.
     *
     * @param idUsuario
     *            the id usuario
     * @return the usuario
     */
    @Override
    public Usuario findByIdUsuario(Long idUsuario) {
        return idUsuario != null ? usuarioRepo.getById(idUsuario) : null;
    }

    /**
     * Insert usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
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

    /**
     * Update usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    @Override
    public Usuario updateUsuario(Usuario usuario) {
        if (usuario.getId() != null) {
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    /**
     * Delete usuario.
     *
     * @param usuario
     *            the usuario
     * @return true, if successful
     */
    @Override
    public boolean deleteUsuario(Usuario usuario) {
        if (usuario.getId() != null) {
            usuario.setActivo(false);
            usuarioRepo.save(usuario);
            return true;
        }
        return false;
    }

    /**
     * Find usuario login.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    @Override
    public Usuario findUsuarioLogin(ModelLoginUser usuario) {
        Usuario user = usuarioRepo.findByUsuario(usuario.getUsuario());
        PasswordEncoder encoder = SecurityConfiguration.getPasswordEncoder();
        if (user != null && encoder.matches(usuario.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }

    /**
     * Find by usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    @Override
    public Usuario findByUsuario(String usuario) {
        return usuarioRepo.findByUsuario(usuario);
    }

    /**
     * Gets the all users new chat.
     *
     * @return the all users new chat
     */
    @Override
    public List<Usuario> getAllUsersNewChat() {
        return usuarioRepo.getAllByActiveNewChat(true);
    }

    /**
     * Gets the all users.
     *
     * @return the all users
     */
    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepo.findAll();
    }
}

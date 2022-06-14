package proyecto.daw.anonygram.service;

import java.util.List;

import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.models.request.ModelLoginUser;

/**
 * The Interface UsuarioService.
 * 
 * @author Gonzalo Waack Carneado
 */
public interface UsuarioService {

    /**
     * Find usuario login.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    public Usuario findUsuarioLogin(ModelLoginUser usuario);

    /**
     * Find by id usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    public Usuario findByIdUsuario(Long usuario);

    /**
     * Insert usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    public Usuario insertUsuario(Usuario usuario);

    /**
     * Update usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    public Usuario updateUsuario(Usuario usuario);

    /**
     * Delete usuario.
     *
     * @param usuario
     *            the usuario
     * @return true, if successful
     */
    public boolean deleteUsuario(Usuario usuario);

    /**
     * Find by usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    public Usuario findByUsuario(String usuario);

    /**
     * Gets the all users new chat.
     *
     * @return the all users new chat
     */
    public List<Usuario> getAllUsersNewChat();

    /**
     * Gets the all users.
     *
     * @return the all users
     */
    public List<Usuario> getAllUsers();
}

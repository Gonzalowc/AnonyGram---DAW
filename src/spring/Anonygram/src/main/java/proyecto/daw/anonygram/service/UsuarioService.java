package proyecto.daw.anonygram.service;

import java.util.List;

import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.models.request.ModelLoginUser;

public interface UsuarioService {

    public Usuario findUsuarioLogin(ModelLoginUser usuario);

    public Usuario findByIdUsuario(Long usuario);

    public Usuario insertUsuario(Usuario usuario);

    public Usuario updateUsuario(Usuario usuario);

    public boolean deleteUsuario(Usuario usuario);

    public Usuario findByUsuario(String usuario);

    List<Usuario> getAllUsersNewChat();
}

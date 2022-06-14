package proyecto.daw.anonygram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Usuario;

/**
 * The Interface UsuarioRepository.
 * 
 * @author Gonzalo Waack Carneado
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Find by usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    Usuario findByUsuario(String usuario);

    /**
     * Gets the all by active new chat.
     *
     * @param active
     *            the active
     * @return the all by active new chat
     */
    List<Usuario> getAllByActiveNewChat(boolean active);
}

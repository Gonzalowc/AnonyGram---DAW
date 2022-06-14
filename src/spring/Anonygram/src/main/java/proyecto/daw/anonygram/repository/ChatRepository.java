package proyecto.daw.anonygram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Usuario;

/**
 * The Interface ChatRepository.
 * 
 * @author Gonzalo Waack Carneado
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    /**
     * Find by usuario creador and usuario respuesta.
     *
     * @param usuarioCreador
     *            the usuario creador
     * @param usuarioRespuesta
     *            the usuario respuesta
     * @return the chat
     */
    public Chat findByUsuarioCreadorAndUsuarioRespuesta(Usuario usuarioCreador, Usuario usuarioRespuesta);

    /**
     * Find by usuario creador.
     *
     * @param usuarioCreador
     *            the usuario creador
     * @return the chat
     */
    public Chat findByUsuarioCreador(Usuario usuarioCreador);
}

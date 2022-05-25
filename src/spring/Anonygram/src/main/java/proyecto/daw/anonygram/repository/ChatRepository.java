package proyecto.daw.anonygram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Usuario;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    public Chat findByUsuarioCreadorAndUsuarioRespuesta(Usuario usuarioCreador, Usuario usuarioRespuesta);

    public Chat findByUsuarioCreador(Usuario usuarioCreador);
}

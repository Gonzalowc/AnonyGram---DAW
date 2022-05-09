package proyecto.daw.anonygram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Mensaje;
import proyecto.daw.anonygram.models.Usuario;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long>{

	public Mensaje findByUsuario(Usuario Usuario);
}

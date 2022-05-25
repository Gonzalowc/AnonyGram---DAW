package proyecto.daw.anonygram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}

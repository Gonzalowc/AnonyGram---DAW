package proyecto.daw.anonygram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Mensaje;

/**
 * The Interface MensajeRepository.
 * 
 * @author Gonzalo Waack Carneado
 */
@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    /**
     * Gets the all by reported and active.
     *
     * @param reported
     *            the reported
     * @param active
     *            the active
     * @return the all by reported and active
     */
    public List<Mensaje> getAllByReportedAndActive(boolean reported, boolean active);
}

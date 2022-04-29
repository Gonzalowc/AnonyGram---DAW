package proyecto.daw.anonygram.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, BigDecimal>{

}

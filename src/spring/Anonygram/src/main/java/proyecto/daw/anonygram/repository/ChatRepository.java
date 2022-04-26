package proyecto.daw.anonygram.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.daw.anonygram.models.Chat;

public interface ChatRepository extends JpaRepository<Chat, BigDecimal>{

}

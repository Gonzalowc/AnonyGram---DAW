package proyecto.daw.anonygram.repository;

import java.math.BigDecimal;

import org.apache.logging.log4j.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, BigDecimal>{

}

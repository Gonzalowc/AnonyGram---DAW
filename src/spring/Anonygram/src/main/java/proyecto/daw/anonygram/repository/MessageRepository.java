package proyecto.daw.anonygram.repository;

import org.apache.logging.log4j.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>{

}

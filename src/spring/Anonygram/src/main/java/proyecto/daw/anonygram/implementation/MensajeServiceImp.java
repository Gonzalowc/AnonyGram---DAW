package proyecto.daw.anonygram.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.models.Mensaje;
import proyecto.daw.anonygram.repository.MensajeRepository;
import proyecto.daw.anonygram.service.MessageService;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeServiceImp.
 */
@Service
public class MensajeServiceImp implements MessageService {

    /** The message repo. */
    @Autowired
    MensajeRepository messageRepo;
    
    /**
     * Instantiates a new mensaje service imp.
     */
    public MensajeServiceImp() {
    }

    /**
     * Insert mensaje.
     *
     * @param mensaje the mensaje
     * @return the mensaje
     */
    @Override
    public Mensaje insertMensaje(Mensaje mensaje) {
        System.out.println("InsertMensaje");
        if (mensaje != null && mensaje.getId() == null) {
            return messageRepo.save(mensaje);
        }
        return null;
    }

    /**
     * Gets the all mensajes.
     *
     * @return the all mensajes
     */
    @Override
    public List<Mensaje> getAllMensajes() {
        return messageRepo.findAll();
    }

    
    
    
}

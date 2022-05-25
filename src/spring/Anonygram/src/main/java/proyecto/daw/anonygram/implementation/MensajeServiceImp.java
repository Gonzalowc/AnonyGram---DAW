package proyecto.daw.anonygram.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.models.Mensaje;
import proyecto.daw.anonygram.repository.MensajeRepository;
import proyecto.daw.anonygram.service.MessageService;

@Service
public class MensajeServiceImp implements MessageService {

    @Autowired
    MensajeRepository messageRepo;
    
    public MensajeServiceImp() {
    }

    @Override
    public Mensaje insertMensaje(Mensaje mensaje) {
        System.out.println("InsertMensaje");
        if (mensaje != null && mensaje.getId() == null) {
            return messageRepo.save(mensaje);
        }
        return null;
    }

    
    
    
}

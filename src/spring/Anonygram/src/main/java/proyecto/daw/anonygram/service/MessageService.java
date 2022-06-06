package proyecto.daw.anonygram.service;

import java.util.List;

import proyecto.daw.anonygram.models.Mensaje;

/**
 * The Interface MessageService.
 */
public interface MessageService {

    /**
     * Insert mensaje.
     *
     * @param mensaje the mensaje
     * @return the mensaje
     */
    public Mensaje insertMensaje(Mensaje mensaje);

    /**
     * Gets the all mensajes.
     *
     * @return the all mensajes
     */
    List<Mensaje> getAllMensajes();
}

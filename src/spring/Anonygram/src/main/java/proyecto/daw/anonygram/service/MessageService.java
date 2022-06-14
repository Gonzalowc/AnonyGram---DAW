package proyecto.daw.anonygram.service;

import java.util.List;

import proyecto.daw.anonygram.models.Mensaje;

/**
 * The Interface MessageService.
 * 
 * @author Gonzalo Waack Carneado
 */
public interface MessageService {

    /**
     * Find by id mensaje.
     *
     * @param mensaje
     *            the mensaje
     * @return the mensaje
     */
    public Mensaje findByIdMensaje(Long mensaje);

    /**
     * Insert mensaje.
     *
     * @param mensaje
     *            the mensaje
     * @return the mensaje
     */
    public Mensaje insertMensaje(Mensaje mensaje);

    /**
     * Gets the all mensajes.
     *
     * @return the all mensajes
     */
    List<Mensaje> getAllMensajes();

    /**
     * Gets the all by reported.
     *
     * @param reported
     *            the reported
     * @param activo
     *            the activo
     * @return the all by reported
     */
    public List<Mensaje> getAllByReported(boolean reported, boolean activo);

    /**
     * Update mensaje.
     *
     * @param mensaje
     *            the mensaje
     * @return the mensaje
     */
    public Mensaje updateMensaje(Mensaje mensaje);
}

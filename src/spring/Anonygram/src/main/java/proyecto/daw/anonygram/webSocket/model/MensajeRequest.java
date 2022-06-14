package proyecto.daw.anonygram.webSocket.model;

import java.util.Date;

/**
 * The Class MensajeRequest.
 * 
 * @author Gonzalo Waack Carneado
 */
public class MensajeRequest implements Comparable<MensajeRequest> {

    /** The id mensaje. */
    private Long id_mensaje;

    /** The mensaje. */
    private String mensaje;

    /** The id usuario. */
    private Long id_usuario;

    /** The usuario. */
    private String usuario;

    /** The id chat. */
    private Long id_chat;

    /** The timestamp. */
    private Date timestamp;

    /** The active. */
    private boolean activo = true;

    /** The reported. */
    private boolean reported = false;

    /**
     * Instantiates a new mensaje request.
     */
    public MensajeRequest() {
    }

    /**
     * Instantiates a new mensaje request.
     *
     * @param mensaje
     *            the mensaje
     * @param id_usuario
     *            the id usuario
     * @param id_chat
     *            the id chat
     * @param timestamp
     *            the timestamp
     * @param active
     *            the active
     * @param reported
     *            the reported
     * @param nombreUsuario
     *            the nombre usuario
     */
    public MensajeRequest(
        String mensaje,
        Long id_usuario,
        Long id_chat,
        Date timestamp,
        boolean active,
        boolean reported,
        String nombreUsuario) {
        this.mensaje = mensaje;
        this.id_usuario = id_usuario;
        this.id_chat = id_chat;
        this.timestamp = timestamp;
        this.activo = active;
        this.reported = reported;
        this.usuario = nombreUsuario;
    }

    /**
     * Gets the id mensaje.
     *
     * @return the id mensaje
     */
    public Long getId_mensaje() {
        return id_mensaje;
    }

    /**
     * Sets the id mensaje.
     *
     * @param id_mensaje
     *            the new id mensaje
     */
    public void setId_mensaje(Long id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    /**
     * Gets the mensaje.
     *
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Sets the mensaje.
     *
     * @param mensaje
     *            the new mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Gets the id usuario.
     *
     * @return the id usuario
     */
    public Long getId_usuario() {
        return id_usuario;
    }

    /**
     * Sets the id usuario.
     *
     * @param id_usuario
     *            the new id usuario
     */
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Gets the id chat.
     *
     * @return the id chat
     */
    public Long getId_chat() {
        return id_chat;
    }

    /**
     * Sets the id chat.
     *
     * @param id_chat
     *            the new id chat
     */
    public void setId_chat(Long id_chat) {
        this.id_chat = id_chat;
    }

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp.
     *
     * @param timestamp
     *            the new timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive() {
        return activo;
    }

    /**
     * Sets the active.
     *
     * @param active
     *            the new active
     */
    public void setActive(boolean active) {
        this.activo = active;
    }

    /**
     * Checks if is reported.
     *
     * @return true, if is reported
     */
    public boolean isReported() {
        return reported;
    }

    /**
     * Sets the reported.
     *
     * @param reported
     *            the new reported
     */
    public void setReported(boolean reported) {
        this.reported = reported;
    }

    /**
     * Gets the usuario.
     *
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the usuario.
     *
     * @param usuario
     *            the new usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "MensajeRequest [mensaje=" + mensaje + ", id_usuario=" + id_usuario + ", id_chat=" + id_chat
            + ", timestamp=" + timestamp + ", active=" + activo + ", reported=" + reported + "]";
    }

    /**
     * Compare to.
     *
     * @param o
     *            the o
     * @return the int
     */
    @Override
    public int compareTo(MensajeRequest o) {
        return o.timestamp.compareTo(this.timestamp);
    }
}

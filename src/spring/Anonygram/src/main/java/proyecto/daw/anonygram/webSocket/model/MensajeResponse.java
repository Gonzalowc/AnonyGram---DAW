package proyecto.daw.anonygram.webSocket.model;

import proyecto.daw.anonygram.models.Mensaje;

/**
 * The Class MensajeResponse.
 * 
 * @author Gonzalo Waack Carneado
 */
public class MensajeResponse {

    /** The id mensaje. */
    private Long id_mensaje;

    /** The mensaje. */
    private String mensaje;

    /** The id usuario. */
    private Long id_usuario;

    /** The id chat. */
    private Long id_chat;

    /** The timestamp. */
    private String timestamp;

    /** The active. */
    private boolean active;

    /** The reported. */
    private boolean reported;

    /**
     * Instantiates a new mensaje response.
     */
    public MensajeResponse() {
    }

    /**
     * Instantiates a new mensaje response.
     *
     * @param id_mensaje
     *            the id mensaje
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
     */
    public MensajeResponse(
        Long id_mensaje,
        String mensaje,
        Long id_usuario,
        Long id_chat,
        String timestamp,
        boolean active,
        boolean reported) {
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
        this.id_usuario = id_usuario;
        this.id_chat = id_chat;
        this.timestamp = timestamp;
        this.active = active;
        this.reported = reported;
    }

    /**
     * Instantiates a new mensaje response.
     *
     * @param mensaje
     *            the mensaje
     */
    public MensajeResponse(
        Mensaje mensaje) {
        this.id_mensaje = mensaje.getId_mensaje();
        this.mensaje = mensaje.getMensaje();
        this.id_usuario = mensaje.getUsuario().getId_usuario();
        this.id_chat = mensaje.getChat().getId_chat();
        this.timestamp = mensaje.getTimestamp().toString();
        this.active = mensaje.isActive();
        this.reported = mensaje.isReported();
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
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp.
     *
     * @param timestamp
     *            the new timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the active.
     *
     * @param active
     *            the new active
     */
    public void setActive(boolean active) {
        this.active = active;
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
}

package proyecto.daw.anonygram.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The Class Mensaje.
 * 
 * @author Gonzalo Waack Carneado
 */
@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable, Comparable<Mensaje> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 904186107637100858L;

    /** The id mensaje. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mensaje;

    /** The mensaje. */
    @Column(nullable = false, length = 10000)
    private String mensaje;

    /** The usuario. */
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    /** The chat. */
    @ManyToOne
    @JoinColumn(name = "idChat", nullable = false)
    private Chat chat;

    /** The timestamp. */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;

    /** The active. */
    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean active = true;

    /** The reported. */
    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean reported = false;

    /**
     * Instantiates a new mensaje.
     */
    public Mensaje() {
    }

    /**
     * Instantiates a new mensaje.
     *
     * @param id
     *            the id
     * @param message
     *            the message
     * @param usuario
     *            the usuario
     * @param chat
     *            the chat
     * @param timestamp
     *            the timestamp
     * @param active
     *            the active
     * @param reported
     *            the reported
     */
    public Mensaje(
        Long id,
        String message,
        Usuario usuario,
        Chat chat,
        Date timestamp,
        boolean active,
        boolean reported) {
        this(message, usuario, chat, timestamp, active, reported);
        this.id_mensaje = id;
    }

    /**
     * Instantiates a new mensaje.
     *
     * @param message
     *            the message
     * @param usuario
     *            the usuario
     * @param chat
     *            the chat
     * @param timestamp
     *            the timestamp
     * @param active
     *            the active
     * @param reported
     *            the reported
     */
    public Mensaje(
        String message,
        Usuario usuario,
        Chat chat,
        Date timestamp,
        boolean active,
        boolean reported) {
        this.mensaje = message;
        this.usuario = usuario;
        this.chat = chat;
        this.timestamp = timestamp;
        this.active = active;
        this.reported = reported;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id_mensaje;
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
     * Gets the usuario.
     *
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Sets the usuario.
     *
     * @param usuario
     *            the new usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Gets the chat.
     *
     * @return the chat
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * Sets the chat.
     *
     * @param chat
     *            the new chat
     */
    public void setChat(Chat chat) {
        this.chat = chat;
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
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_mensaje);
    }

    /**
     * Equals.
     *
     * @param obj
     *            the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mensaje other = (Mensaje) obj;
        return Objects.equals(id_mensaje, other.id_mensaje);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Mensaje [id_mensaje=" + id_mensaje + ", mensaje=" + mensaje + ", timestamp=" + timestamp
            + ", active=" + active + ", reported=" + reported + "]";
    }

    /**
     * Compare to.
     *
     * @param o
     *            the o
     * @return the int
     */
    @Override
    public int compareTo(Mensaje o) {
        return this.getTimestamp().compareTo(o.timestamp);
    }
}

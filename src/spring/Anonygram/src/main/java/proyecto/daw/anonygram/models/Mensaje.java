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
 */
@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable,Comparable<Mensaje> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 904186107637100858L;

    /** The id mensaje. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mensaje;

    /** The mensaje. */
    @Column(nullable = false, length =10000)
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

    /**
     * Instantiates a new mensaje.
     */
    public Mensaje() {
    }

    /**
     * Instantiates a new mensaje.
     *
     * @param id the id
     * @param message the message
     * @param usuario the usuario
     * @param chat the chat
     * @param timestamp the timestamp
     * @param active the active
     */
    public Mensaje(
        Long id,
        String message,
        Usuario usuario,
        Chat chat,
        Date timestamp,
        boolean active) {
        this(message, usuario, chat, timestamp, active);
        this.id_mensaje = id;
    }

    /**
     * Instantiates a new mensaje.
     *
     * @param message the message
     * @param usuario the usuario
     * @param chat the chat
     * @param timestamp the timestamp
     * @param active the active
     */
    public Mensaje(
        String message,
        Usuario usuario,
        Chat chat,
        Date timestamp,
        boolean active) {
        this.mensaje = message;
        this.usuario = usuario;
        this.chat = chat;
        this.timestamp = timestamp;
        this.active = active;
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
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return mensaje;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.mensaje = message;
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
     * @param usuario the new usuario
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
     * @param chat the new chat
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
     * @param timestamp the new timestamp
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
     * @param active the new active
     */
    public void setActive(boolean active) {
        this.active = active;
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
     * @param obj the obj
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
        return "Message [id=" + id_mensaje + ", mensaje=" + mensaje + ", usuario=" + usuario + ", chat=" + chat
            + ", timestamp=" + timestamp + ", active=" + active + "]";
    }

    /**
     * Compare to.
     *
     * @param o the o
     * @return the int
     */
    @Override
    public int compareTo(Mensaje o) {
        return this.getTimestamp().compareTo(o.timestamp);
    }
}

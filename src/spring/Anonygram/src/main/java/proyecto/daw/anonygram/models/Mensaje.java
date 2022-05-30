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

@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable,Comparable<Mensaje> {

    private static final long serialVersionUID = 904186107637100858L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mensaje;

    @Column(nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idChat", nullable = false)
    private Chat chat;

    @Column(nullable = false)
    private Date timestamp;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean active = true;

    public Mensaje() {
    }

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

    public Long getId() {
        return id_mensaje;
    }

    public String getMessage() {
        return mensaje;
    }

    public void setMessage(String message) {
        this.mensaje = message;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_mensaje);
    }

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

    @Override
    public String toString() {
        return "Message [id=" + id_mensaje + ", mensaje=" + mensaje + ", usuario=" + usuario + ", chat=" + chat
            + ", timestamp=" + timestamp + ", active=" + active + "]";
    }

    @Override
    public int compareTo(Mensaje o) {
        return this.getTimestamp().compareTo(o.timestamp);
    }
}

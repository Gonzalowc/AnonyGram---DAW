package proyecto.daw.anonygram.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The Class Chat.
 * 
 * @author Gonzalo Waack Carneado
 */
@Entity
@Table(name = "chat")
public class Chat implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6198995106942182276L;

    /** The id chat. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_chat;

    /** The usuario creador. */
    @ManyToOne
    @JoinColumn(name = "idUsuarioCreador", nullable = false)
    private Usuario usuarioCreador;

    /** The usuario respuesta. */
    @ManyToOne
    @JoinColumn(name = "idUsuarioRespuesta", nullable = false)
    private Usuario usuarioRespuesta;

    /** The fecha creacion. */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaCreacion;

    /** The activo. */
    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean activo = true;

    /** The nombre chat creador. */
    @Column(nullable = true)
    private String nombreChatCreador;

    /** The nombre chat respuesta. */
    @Column(nullable = true)
    private String nombreChatRespuesta;

    /** The mensajes. */
    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mensaje> mensajes = new HashSet<>();

    /** The imagen. */
    @Column(nullable = true)
    private String imagen;

    /**
     * Instantiates a new chat.
     */
    public Chat() {
    }

    /**
     * Instantiates a new chat.
     *
     * @param id
     *            the id
     * @param usuarioCreador
     *            the usuario creador
     * @param usuarioRespuesta
     *            the usuario respuesta
     * @param nombreChat
     *            the nombre chat
     * @param fechaCreacion
     *            the fecha creacion
     * @param activo
     *            the activo
     */
    public Chat(
        Long id,
        Usuario usuarioCreador,
        Usuario usuarioRespuesta,
        String nombreChat,
        Date fechaCreacion,
        boolean activo) {
        this(usuarioCreador, usuarioRespuesta, fechaCreacion, activo, nombreChat);
        this.id_chat = id;
    }

    /**
     * Instantiates a new chat.
     *
     * @param usuarioCreador
     *            the usuario creador
     * @param usuarioRespuesta
     *            the usuario respuesta
     * @param fechaCreacion
     *            the fecha creacion
     * @param activo
     *            the activo
     * @param nombreChat
     *            the nombre chat
     */
    public Chat(
        Usuario usuarioCreador,
        Usuario usuarioRespuesta,
        Date fechaCreacion,
        boolean activo,
        String nombreChat) {
        this.usuarioCreador = usuarioCreador;
        this.usuarioRespuesta = usuarioRespuesta;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
        this.nombreChatCreador = nombreChat;
        this.nombreChatRespuesta = nombreChat;
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
     * Gets the usuario creador.
     *
     * @return the usuario creador
     */
    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    /**
     * Sets the usuario creador.
     *
     * @param usuarioCreador
     *            the new usuario creador
     */
    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    /**
     * Gets the usuario respuesta.
     *
     * @return the usuario respuesta
     */
    public Usuario getUsuarioRespuesta() {
        return usuarioRespuesta;
    }

    /**
     * Sets the usuario respuesta.
     *
     * @param usuarioRespuesta
     *            the new usuario respuesta
     */
    public void setUsuarioRespuesta(Usuario usuarioRespuesta) {
        this.usuarioRespuesta = usuarioRespuesta;
    }

    /**
     * Gets the fecha creacion.
     *
     * @return the fecha creacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets the fecha creacion.
     *
     * @param fechaCreacion
     *            the new fecha creacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Checks if is activo.
     *
     * @return true, if is activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Sets the activo.
     *
     * @param activo
     *            the new activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Gets the nombre chat creador.
     *
     * @return the nombre chat creador
     */
    public String getNombreChatCreador() {
        return nombreChatCreador;
    }

    /**
     * Sets the nombre chat creador.
     *
     * @param nombreChatCreador
     *            the new nombre chat creador
     */
    public void setNombreChatCreador(String nombreChatCreador) {
        this.nombreChatCreador = nombreChatCreador;
    }

    /**
     * Gets the nombre chat respuesta.
     *
     * @return the nombre chat respuesta
     */
    public String getNombreChatRespuesta() {
        return nombreChatRespuesta;
    }

    /**
     * Sets the nombre chat respuesta.
     *
     * @param nombreChatRespuesta
     *            the new nombre chat respuesta
     */
    public void setNombreChatRespuesta(String nombreChatRespuesta) {
        this.nombreChatRespuesta = nombreChatRespuesta;
    }

    /**
     * Gets the mensajes.
     *
     * @return the mensajes
     */
    public Set<Mensaje> getMensajes() {
        return mensajes;
    }

    /**
     * Sets the mensajes.
     *
     * @param mensajes
     *            the new mensajes
     */
    public void setMensajes(Set<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    /**
     * Gets the imagen.
     *
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Sets the imagen.
     *
     * @param imagen
     *            the new imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(activo, usuarioCreador, usuarioRespuesta);
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
        Chat other = (Chat) obj;
        return activo == other.activo && Objects.equals(usuarioCreador, other.usuarioCreador)
            && Objects.equals(usuarioRespuesta, other.usuarioRespuesta);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Chat [id=" + id_chat + ", usuarioCreador=" + usuarioCreador + ", usuarioRespuesta="
            + usuarioRespuesta + ", fechaCreacion=" + fechaCreacion + ", activo=" + activo + "]";
    }

    /**
     * Adds the message.
     *
     * @param mensaje
     *            the mensaje
     */
    // HELPERS
    public void addMessage(Mensaje mensaje) {
        this.mensajes.add(mensaje);
        mensaje.setChat(this);
    }

    /**
     * Removes the message.
     *
     * @param mensaje
     *            the mensaje
     */
    public void removeMessage(Mensaje mensaje) {
        this.mensajes.remove(mensaje);
        mensaje.setChat(null);
    }
}

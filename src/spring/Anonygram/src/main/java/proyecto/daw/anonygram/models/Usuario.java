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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The Class Usuario.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4841757474975900255L;

    /** The id usuario. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    /** The usuario. */
    @Column(nullable = false, unique = true)
    private String usuario;

    /** The name. */
    @Column(nullable = false)
    private String name;

    /** The password. */
    @Column(nullable = false)
    private String password;

    /** The rol. */
    @Column(nullable = false)
    private String rol;

    /** The activo. */
    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean activo = true;

    /** The active new chat. */
    @Column(name = "activeNewChat", nullable = false, columnDefinition = "BOOLEAN")
    private boolean activeNewChat = false;

    /** The chats creados. */
    @OneToMany(mappedBy = "usuarioCreador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chat> chatsCreados = new HashSet<>();

    /** The chats respondidos. */
    @OneToMany(mappedBy = "usuarioRespuesta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chat> chatsRespondidos = new HashSet<>();

    /** The mensajes. */
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mensaje> mensajes = new HashSet<>();

    /** The registro. */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date registro;

    /**
     * Instantiates a new usuario.
     */
    public Usuario() {
    }

    /**
     * Instantiates a new usuario.
     *
     * @param id_usuario
     *            the id usuario
     * @param usuario
     *            the usuario
     * @param name
     *            the name
     * @param password
     *            the password
     * @param rol
     *            the rol
     * @param activo
     *            the activo
     * @param activeNewChat
     *            the active new chat
     * @param registro
     *            the registro
     */
    public Usuario(
        Long id_usuario,
        String usuario,
        String name,
        String password,
        String rol,
        boolean activo,
        boolean activeNewChat,
        Date registro) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.name = name;
        this.password = password;
        this.rol = rol;
        this.activo = activo;
        this.activeNewChat = activeNewChat;
        this.registro = registro;
    }

    /**
     * Instantiates a new usuario.
     *
     * @param usuario
     *            the usuario
     * @param name
     *            the name
     * @param rol
     *            the rol
     * @param password
     *            the password
     */
    public Usuario(
        String usuario,
        String name,
        String rol,
        String password) {
        this.usuario = usuario;
        this.name = name;
        this.rol = rol;
        this.password = password;
        this.activo = true;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id_usuario;
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
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if is active new chat.
     *
     * @return true, if is active new chat
     */
    public boolean isActiveNewChat() {
        return activeNewChat;
    }

    /**
     * Sets the active new chat.
     *
     * @param activeNewChat
     *            the new active new chat
     */
    public void setActiveNewChat(boolean activeNewChat) {
        this.activeNewChat = activeNewChat;
    }

    /**
     * Gets the chats creados.
     *
     * @return the chats creados
     */
    public Set<Chat> getChatsCreados() {
        return chatsCreados;
    }

    /**
     * Sets the chats creados.
     *
     * @param chatsCreados
     *            the new chats creados
     */
    public void setChatsCreados(Set<Chat> chatsCreados) {
        this.chatsCreados = chatsCreados;
    }

    /**
     * Gets the chats respondidos.
     *
     * @return the chats respondidos
     */
    public Set<Chat> getChatsRespondidos() {
        return chatsRespondidos;
    }

    /**
     * Sets the chats respondidos.
     *
     * @param chatsRespondidos
     *            the new chats respondidos
     */
    public void setChatsRespondidos(Set<Chat> chatsRespondidos) {
        this.chatsRespondidos = chatsRespondidos;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
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
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Gets the rol.
     *
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Sets the rol.
     *
     * @param rol
     *            the new rol
     */
    public void setRol(String rol) {
        this.rol = rol;
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
     * Gets the registro.
     *
     * @return the registro
     */
    public Date getRegistro() {
        return registro;
    }

    /**
     * Sets the registro.
     *
     * @param registro
     *            the new registro
     */
    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(usuario);
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
        Usuario other = (Usuario) obj;
        return Objects.equals(usuario, other.usuario);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", name=" + name + ", password="
            + password + ", rol=" + rol + ", activo=" + activo + ", activeNewChat=" + activeNewChat + "]";
    }
    // HELPERS

    /**
     * Adds the message.
     *
     * @param mensaje
     *            the mensaje
     */
    public void addMessage(Mensaje mensaje) {
        this.mensajes.add(mensaje);
        mensaje.setUsuario(this);
    }

    /**
     * Removes the message.
     *
     * @param mensaje
     *            the mensaje
     */
    public void removeMessage(Mensaje mensaje) {
        this.mensajes.remove(mensaje);
        mensaje.setUsuario(null);
    }

    /**
     * Adds the chat crear.
     *
     * @param chat
     *            the chat
     * @param usuarioRespuesta
     *            the usuario respuesta
     */
    public void addChatCrear(Chat chat, Usuario usuarioRespuesta) {
        this.chatsCreados.add(chat);
        chat.setUsuarioCreador(this);
        addChatResponder(chat, usuarioRespuesta);
    }

    /**
     * Removes the chat crear.
     *
     * @param chat
     *            the chat
     */
    public void removeChatCrear(Chat chat) {
        this.chatsCreados.remove(chat);
        chat.setUsuarioCreador(null);
        removeChatResponder(chat);
    }

    /**
     * Adds the chat responder.
     *
     * @param chat
     *            the chat
     * @param usuarioRespuesta
     *            the usuario respuesta
     */
    private void addChatResponder(Chat chat, Usuario usuarioRespuesta) {
        this.chatsRespondidos.add(chat);
        chat.setUsuarioRespuesta(usuarioRespuesta);
    }

    /**
     * Removes the chat responder.
     *
     * @param chat
     *            the chat
     */
    private void removeChatResponder(Chat chat) {
        this.chatsRespondidos.remove(chat);
        chat.setUsuarioRespuesta(null);
    }
}

package proyecto.daw.anonygram.models;

import java.io.Serializable;
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

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 4841757474975900255L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String rol;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean activo = true;

    @Column(name = "activeNewChat", nullable = false, columnDefinition = "BOOLEAN")
    private boolean activeNewChat = false;

    @OneToMany(mappedBy = "usuarioCreador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chat> chatsCreados = new HashSet<>();

    @OneToMany(mappedBy = "usuarioRespuesta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chat> chatsRespondidos = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mensaje> mensajes = new HashSet<>();

    public Usuario() {
    }

    public Usuario(
        Long id,
        String usuario,
        String name,
        String rol,
        String password) {
        this(usuario, name, rol, password);
        this.id_usuario = id;
    }

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

    public Long getId() {
        return id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getName() {
        return name;
    }

    public boolean isActiveNewChat() {
        return activeNewChat;
    }

    public void setActiveNewChat(boolean activeNewChat) {
        this.activeNewChat = activeNewChat;
    }

    public Set<Chat> getChatsCreados() {
        return chatsCreados;
    }

    public void setChatsCreados(Set<Chat> chatsCreados) {
        this.chatsCreados = chatsCreados;
    }

    public Set<Chat> getChatsRespondidos() {
        return chatsRespondidos;
    }

    public void setChatsRespondidos(Set<Chat> chatsRespondidos) {
        this.chatsRespondidos = chatsRespondidos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(Set<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }

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

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", name=" + name + ", password="
            + password + ", rol=" + rol + ", activo=" + activo + ", activeNewChat=" + activeNewChat + "]";
    }
    // HELPERS

    public void addMessage(Mensaje mensaje) {
        this.mensajes.add(mensaje);
        mensaje.setUsuario(this);
    }

    public void removeMessage(Mensaje mensaje) {
        this.mensajes.remove(mensaje);
        mensaje.setUsuario(null);
    }

    public void addChatCrear(Chat chat, Usuario usuarioRespuesta) {
        this.chatsCreados.add(chat);
        chat.setUsuarioCreador(this);
        addChatResponder(chat, usuarioRespuesta);
    }

    public void removeChatCrear(Chat chat) {
        this.chatsCreados.remove(chat);
        chat.setUsuarioCreador(null);
        removeChatResponder(chat);
    }

    private void addChatResponder(Chat chat, Usuario usuarioRespuesta) {
        this.chatsRespondidos.add(chat);
        chat.setUsuarioRespuesta(usuarioRespuesta);
    }

    private void removeChatResponder(Chat chat) {
        this.chatsRespondidos.remove(chat);
        chat.setUsuarioRespuesta(null);
    }
}

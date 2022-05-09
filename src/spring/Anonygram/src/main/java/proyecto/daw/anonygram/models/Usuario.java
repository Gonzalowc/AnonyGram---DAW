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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column(nullable = false)
	private String usuario;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String rol;

	@Column(nullable = false, columnDefinition = "BOOLEAN")
	private boolean activo = true;

	@OneToMany(mappedBy = "usuarioCreador", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Chat> chatsCreados = new HashSet<>();

	@OneToMany(mappedBy = "usuarioRespuesta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Chat> chatsRespondidos = new HashSet<>();

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Mensaje> mensajes = new HashSet<>();

	public Usuario() {
	}

	public Usuario(Long id, String usuario, String rol, boolean activo) {
		this(usuario, rol, activo);
		this.id_usuario = id;
	}

	public Usuario(String usuario, String rol, boolean activo) {
		this.usuario = usuario;
		this.rol = rol;
		this.activo = activo;
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

	public void setName(String name) {
		this.name = name;
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
		return Objects.hash(id_usuario);
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
		return Objects.equals(id_usuario, other.id_usuario);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id_usuario + ", usuario=" + usuario + ", rol=" + rol + ", activo=" + activo + "]";
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

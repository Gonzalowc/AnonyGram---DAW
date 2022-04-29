package proyecto.daw.anonygram.models;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity
@Table(name = "chat")
public class Chat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id_chat;

	@ManyToOne
	@JoinColumn(name = "id_usuarioCreador", nullable = false)
	private Usuario usuarioCreador;

	@ManyToOne
	@JoinColumn(name = "id_usuarioRespuesta", nullable = false)
	private Usuario usuarioRespuesta;

	@Column(nullable = false)
	private Date fechaCreacion;

	@Column(nullable = false, columnDefinition = "BOOLEAN")
	private boolean activo;

	@OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Mensaje> mensajes = new HashSet<>();

	public Chat() {
	}

	public Chat(BigDecimal id, Usuario usuarioCreador, Usuario usuarioRespuesta, Date fechaCreacion, boolean activo) {
		this(usuarioCreador, usuarioRespuesta, fechaCreacion, activo);
		this.id_chat = id;
	}

	public Chat(Usuario usuarioCreador, Usuario usuarioRespuesta, Date fechaCreacion, boolean activo) {
		this.usuarioCreador = usuarioCreador;
		this.usuarioRespuesta = usuarioRespuesta;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}

	public BigDecimal getId() {
		return id_chat;
	}

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public Usuario getUsuarioRespuesta() {
		return usuarioRespuesta;
	}

	public void setUsuarioRespuesta(Usuario usuarioRespuesta) {
		this.usuarioRespuesta = usuarioRespuesta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, usuarioCreador, usuarioRespuesta);
	}

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

	@Override
	public String toString() {
		return "Chat [id=" + id_chat + ", usuarioCreador=" + usuarioCreador + ", usuarioRespuesta=" + usuarioRespuesta
				+ ", fechaCreacion=" + fechaCreacion + ", activo=" + activo + "]";
	}

	// HELPERS
	public void addMessage(Mensaje mensaje) {
		this.mensajes.add(mensaje);
		mensaje.setChat(this);
	}

	public void removeMessage(Mensaje mensaje) {
		this.mensajes.remove(mensaje);
		mensaje.setChat(null);
	}

}

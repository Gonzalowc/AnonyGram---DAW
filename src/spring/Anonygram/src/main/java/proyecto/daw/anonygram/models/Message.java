package proyecto.daw.anonygram.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="mensaje")
public class Message implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id;
	
	@Column(nullable=false, name="mensaje")
	private String mensaje;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private String usuario;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private int chat;
	
	@Column(nullable=false)
	private Date timestamp;
	
	@Column(nullable=false)
	private boolean active;
	
	public Message() {
	}

	public Message(BigDecimal id, String message, String usuario, int chat, Date timestamp, boolean active) {
		this(message, usuario, chat, timestamp, active);
		this.id = id;
	}
	
	public Message( String message, String usuario, int chat, Date timestamp, boolean active) {
		this.mensaje = message;
		this.usuario = usuario;
		this.chat = chat;
		this.timestamp = timestamp;
		this.active = active;
	}

	public BigDecimal getId() {
		return id;
	}

	public String getMessage() {
		return mensaje;
	}

	public void setMessage(String message) {
		this.mensaje = message;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getChat() {
		return chat;
	}

	public void setChat(int chat) {
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", mensaje=" + mensaje + ", usuario=" + usuario + ", chat=" + chat + ", timestamp="
				+ timestamp + ", active=" + active + "]";
	}
} 
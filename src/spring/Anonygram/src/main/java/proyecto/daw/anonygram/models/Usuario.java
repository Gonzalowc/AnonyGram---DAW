package proyecto.daw.anonygram.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	@Id
	private String id;
	
	@Column(nullable=false)
	private String usuario;
	
	@Column(nullable=false)
	private String rol;

	@Column(nullable=false, columnDefinition="BOOLEAN")
	private boolean activo;

	public Usuario() {
	}

	public Usuario(String id, String usuario, String rol, boolean activo) {
		this(usuario, rol, activo);
		this.id = id;
	}
	
	public Usuario( String usuario, String rol, boolean activo) {
		this.usuario = usuario;
		this.rol = rol;
		this.activo = activo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", rol=" + rol + ", activo=" + activo + "]";
	}
	
	
	
}

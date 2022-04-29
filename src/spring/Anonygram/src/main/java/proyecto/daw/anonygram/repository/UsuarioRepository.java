package proyecto.daw.anonygram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.daw.anonygram.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	public Usuario findByUsuario(String usuario);

}

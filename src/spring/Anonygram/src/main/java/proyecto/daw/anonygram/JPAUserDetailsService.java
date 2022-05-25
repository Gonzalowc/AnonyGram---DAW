package proyecto.daw.anonygram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import proyecto.daw.anonygram.implementation.UsuarioServiceImp;
import proyecto.daw.anonygram.models.Usuario;

@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioServiceImp usuarioService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        // Obtengo el usuario
        Usuario user = usuarioService.findByUsuario(usuario);
        // Si el usuario no existe debo devolver una
        // excepción
        if (user == null) {
            throw new UsernameNotFoundException("Not found:" + usuario);
        }
        // Adapto la información del usuario al UserDetails
        // que es lo que debe devolver el método
        JPAUserDetails userDetails = new JPAUserDetails(user);
        return userDetails;
    }
}

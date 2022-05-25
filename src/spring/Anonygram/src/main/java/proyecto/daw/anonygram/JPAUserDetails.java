package proyecto.daw.anonygram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import proyecto.daw.anonygram.models.Usuario;

public class JPAUserDetails implements UserDetails {

    private static final long serialVersionUID = 7253791946163593096L;

    private String usuario;

    private String password;

    private boolean activo;

    private List<GrantedAuthority> authorities;

    public JPAUserDetails(
        Usuario usuario) {
        this.usuario = usuario.getUsuario();
        this.password = usuario.getPassword();
        this.activo = usuario.isActivo();
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority(usuario.getRol()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.activo;
    }
}

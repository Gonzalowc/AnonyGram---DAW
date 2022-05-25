package proyecto.daw.anonygram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import proyecto.daw.anonygram.SecurityConfiguration;
import proyecto.daw.anonygram.implementation.UsuarioServiceImp;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.models.request.ModelLoginUser;
import proyecto.daw.anonygram.models.request.ModelRegisterUser;
import proyecto.daw.anonygram.models.response.ModelRegisterUserResponse;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioServiceImp usuarioService;

    @ResponseBody
    @PostMapping(value = "/usuario/login",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ModelRegisterUserResponse loginUser(@RequestBody ModelLoginUser userLogin) {
        PasswordEncoder encoder = SecurityConfiguration.getPasswordEncoder();
        Usuario usuario = usuarioService.findUsuarioLogin(userLogin);
        if (usuario != null && encoder.matches(userLogin.getPassword(), usuario.getPassword())) {
            ModelRegisterUserResponse response = new ModelRegisterUserResponse();
            response.setId_usuario(usuario.getId());
            response.setUsuario(usuario.getUsuario());
            response.setActivo(usuario.isActivo());
            response.setName(usuario.getName());
            response.setRol(usuario.getRol());
            return response;
        }
        return null;
    }

    @ResponseBody
    @PostMapping(value = "/usuario/register",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Usuario registerUser(@RequestBody ModelRegisterUser userRegister) {
        Usuario user = new Usuario();
        user.setUsuario(userRegister.getUsuario());
        user.setName(userRegister.getName());
        PasswordEncoder encoder = SecurityConfiguration.getPasswordEncoder();
        String passwordEncoded = encoder.encode(userRegister.getPassword());
        user.setRol("USER");
        user.setPassword(passwordEncoded);
        if (usuarioService.insertUsuario(user).getId() != null) {
            return new Usuario();
        } else {
            return null;
        }
    }
}

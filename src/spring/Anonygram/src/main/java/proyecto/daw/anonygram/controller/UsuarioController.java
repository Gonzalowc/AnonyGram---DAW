package proyecto.daw.anonygram.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import proyecto.daw.anonygram.SecurityConfiguration;
import proyecto.daw.anonygram.implementation.UsuarioServiceImp;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.models.request.ModelLoginUser;
import proyecto.daw.anonygram.models.request.ModelRegisterUser;
import proyecto.daw.anonygram.models.response.ModelRegisterUserResponse;
import proyecto.daw.anonygram.models.response.UsuarioStadisticsResponse;
import proyecto.daw.anonygram.utils.AnonygramUtils;
import proyecto.daw.anonygram.utils.TemporalEnum;

/**
 * The Class UsuarioController.
 * 
 * @author Gonzalo Waack Carneado
 */
@Controller
public class UsuarioController {

    /** The usuario service. */
    @Autowired
    private UsuarioServiceImp usuarioService;

    /**
     * Login user.
     *
     * @param userLogin
     *            the user login
     * @return the model register user response
     */
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
            response.setActive_new_chat(usuario.isActiveNewChat());
            response.setRegistro(usuario.getRegistro());
            return response;
        }
        return null;
    }

    /**
     * Gets the user.
     *
     * @param idUsuario
     *            the id usuario
     * @return the user
     */
    @ResponseBody
    @GetMapping(value = "/usuario",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ModelRegisterUserResponse
        getUser(@RequestParam(required = true, name = "idUsuario") Long idUsuario) {
        Usuario usuario = usuarioService.findByIdUsuario(idUsuario);
        if (usuario != null) {
            ModelRegisterUserResponse response = new ModelRegisterUserResponse();
            response.setId_usuario(usuario.getId());
            response.setUsuario(usuario.getUsuario());
            response.setActivo(usuario.isActivo());
            response.setName(usuario.getName());
            response.setRol(usuario.getRol());
            response.setActive_new_chat(usuario.isActiveNewChat());
            response.setRegistro(usuario.getRegistro());
            return response;
        }
        return new ModelRegisterUserResponse();
    }

    /**
     * Register user.
     *
     * @param userRegister
     *            the user register
     * @return the usuario
     */
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

    /**
     * Gets the chats stadistics by date.
     *
     * @param date
     *            the date
     * @return the chats stadistics by date
     */
    @ResponseBody
    @GetMapping(value = "/admin/usuario/stadistics",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public UsuarioStadisticsResponse
        getChatsStadisticsByDate(@RequestParam(required = false, name = "date") String date) {
        List<Usuario> listUsuarios = usuarioService.getAllUsers();
        LocalDate fecha = null;
        UsuarioStadisticsResponse response = new UsuarioStadisticsResponse();
        if (date != null) {
            fecha = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            listUsuarios = filterUsuarioByDate(listUsuarios, fecha, TemporalEnum.MINOR);
        }
        response.setUsuarios_totales(listUsuarios.size());
        response.setUsuarios_activos(getUsuariosActivos(listUsuarios));
        response.setUsuarios_inactivos(getUsuariosInactivos(listUsuarios));
        response.setUsuarios_buscando_chat(getUsuariosBuscandoChat());
        listUsuarios = fecha != null ? filterUsuarioByDate(listUsuarios, fecha, TemporalEnum.SAME)
            : filterUsuarioByDate(listUsuarios, AnonygramUtils.convertToLocalDate(new Date()),
                TemporalEnum.SAME);
        response.setUsuarios_registro_hoy(listUsuarios.size());
        return response;
    }

    /**
     * Gets the usuarios buscando chat.
     *
     * @return the usuarios buscando chat
     */
    private int getUsuariosBuscandoChat() {
        return usuarioService.getAllUsersNewChat().size();
    }

    /**
     * Gets the usuarios activos.
     *
     * @param listUser
     *            the list user
     * @return the usuarios activos
     */
    private int getUsuariosActivos(List<Usuario> listUser) {
        int cantidad = 0;
        for (Usuario usuario : listUser) {
            if (usuario.isActivo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Gets the usuarios inactivos.
     *
     * @param listUser
     *            the list user
     * @return the usuarios inactivos
     */
    private int getUsuariosInactivos(List<Usuario> listUser) {
        int cantidad = 0;
        for (Usuario user : listUser) {
            if (!user.isActivo()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Filter usuario by date.
     *
     * @param listUser
     *            the list user
     * @param fecha
     *            the fecha
     * @param tempo
     *            the tempo
     * @return the list
     */
    private List<Usuario> filterUsuarioByDate(List<Usuario> listUser, LocalDate fecha, TemporalEnum tempo) {
        List<Usuario> response = new ArrayList<>();
        for (Usuario user : listUser) {
            LocalDate fechaChat = AnonygramUtils.convertToLocalDate(user.getRegistro());
            if (TemporalEnum.SAME.equals(tempo)) {
                if (AnonygramUtils.esMismaFecha(fechaChat, fecha)) {
                    response.add(user);
                }
            } else if (TemporalEnum.MINOR.equals(tempo)) {
                if (AnonygramUtils.esAnteriorFecha(fechaChat, fecha)) {
                    response.add(user);
                }
            }
        }
        return response;
    }

    /**
     * Gets the all usuarios.
     *
     * @return the all usuarios
     */
    @ResponseBody
    @GetMapping(value = "/admin/usuario/allUsuarios",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<ModelRegisterUserResponse> getAllUsuarios() {
        List<Usuario> listaUsuarios = usuarioService.getAllUsers();
        List<ModelRegisterUserResponse> response = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            if (usuario != null) {
                ModelRegisterUserResponse modelResponse = new ModelRegisterUserResponse();
                modelResponse.setId_usuario(usuario.getId());
                modelResponse.setUsuario(usuario.getUsuario());
                modelResponse.setActivo(usuario.isActivo());
                modelResponse.setName(usuario.getName());
                modelResponse.setRegistro(usuario.getRegistro());
                modelResponse.setRol(usuario.getRol());
                modelResponse.setActive_new_chat(usuario.isActiveNewChat());
                response.add(modelResponse);
            }
        }
        return response;
    }

    /**
     * Update usuario.
     *
     * @param usuarioModify
     *            the usuario modify
     * @return the model register user response
     */
    @ResponseBody
    @PostMapping(value = "/admin/usuario/update",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ModelRegisterUserResponse updateUsuario(@RequestBody ModelRegisterUserResponse usuarioModify) {
        System.out.println(usuarioModify.getName());
        Usuario userDB = usuarioService.findByIdUsuario(usuarioModify.getId_usuario());
        userDB.setUsuario(usuarioModify.getUsuario());
        userDB.setName(usuarioModify.getName());
        userDB.setRol(usuarioModify.getRol());
        Usuario responseDB = usuarioService.updateUsuario(userDB);
        ModelRegisterUserResponse response = new ModelRegisterUserResponse();
        response.setId_usuario(responseDB.getId());
        response.setUsuario(responseDB.getUsuario());
        response.setActivo(responseDB.isActivo());
        response.setName(responseDB.getName());
        response.setRegistro(responseDB.getRegistro());
        response.setRol(responseDB.getRol());
        response.setActive_new_chat(responseDB.isActiveNewChat());
        response.setRegistro(responseDB.getRegistro());
        return response;
    }

    /**
     * Update search chat.
     *
     * @param idUsuario
     *            the id usuario
     * @return true, if successful
     */
    @ResponseBody
    @GetMapping(value = "/admin/usuario/searchChat",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean updateSearchChat(@RequestParam(required = true, name = "idUsuario") Long idUsuario) {
        Usuario userDB = usuarioService.findByIdUsuario(idUsuario);
        userDB.setActiveNewChat(!userDB.isActiveNewChat());
        usuarioService.updateUsuario(userDB);
        return true;
    }

    /**
     * Update active usuario.
     *
     * @param idUsuario
     *            the id usuario
     * @return true, if successful
     */
    @ResponseBody
    @GetMapping(value = "/admin/usuario/active",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean updateActiveUsuario(@RequestParam(required = true, name = "idUsuario") Long idUsuario) {
        Usuario userDB = usuarioService.findByIdUsuario(idUsuario);
        userDB.setActivo(!userDB.isActivo());
        usuarioService.updateUsuario(userDB);
        return true;
    }
}

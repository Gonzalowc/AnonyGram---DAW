package proyecto.daw.anonygram.models.response;

import java.util.Date;

/**
 * The Class ModelRegisterUserResponse.
 */
public class ModelRegisterUserResponse {

    /** The id usuario. */
    private Long id_usuario;

    /** The activo. */
    private boolean activo;

    /** The name. */
    private String name;

    /** The rol. */
    private String rol;

    /** The usuario. */
    private String usuario;

    /** The active new chat. */
    private boolean active_new_chat;

    /** The registro. */
    private Date registro;

    /**
     * Instantiates a new model register user response.
     */
    public ModelRegisterUserResponse() {
    }

    /**
     * Gets the id usuario.
     *
     * @return the id usuario
     */
    public Long getId_usuario() {
        return id_usuario;
    }

    /**
     * Sets the id usuario.
     *
     * @param id_usuario
     *            the new id usuario
     */
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Checks if is activo.
     *
     * @return true, if is activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Sets the activo.
     *
     * @param activo
     *            the new activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the rol.
     *
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Sets the rol.
     *
     * @param rol
     *            the new rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Gets the usuario.
     *
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the usuario.
     *
     * @param usuario
     *            the new usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Checks if is active new chat.
     *
     * @return true, if is active new chat
     */
    public boolean isActive_new_chat() {
        return active_new_chat;
    }

    /**
     * Sets the active new chat.
     *
     * @param active_new_chat
     *            the new active new chat
     */
    public void setActive_new_chat(boolean active_new_chat) {
        this.active_new_chat = active_new_chat;
    }

    /**
     * Gets the registro.
     *
     * @return the registro
     */
    public Date getRegistro() {
        return registro;
    }

    /**
     * Sets the registro.
     *
     * @param registro
     *            the new registro
     */
    public void setRegistro(Date registro) {
        this.registro = registro;
    }
}

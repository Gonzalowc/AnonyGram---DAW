package proyecto.daw.anonygram.models.request;

/**
 * The Class ModelRegisterUser.
 * 
 * @author Gonzalo Waack Carneado
 */
public class ModelRegisterUser {

    /** The name. */
    private String name;

    /** The usuario. */
    private String usuario;

    /** The password. */
    private String password;

    /**
     * Instantiates a new model register user.
     */
    public ModelRegisterUser() {
    }

    /**
     * Instantiates a new model register user.
     *
     * @param usuario
     *            the usuario
     * @param name
     *            the name
     * @param password
     *            the password
     */
    public ModelRegisterUser(
        String usuario,
        String name,
        String password) {
        this.usuario = usuario;
        this.name = name;
        this.password = password;
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
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

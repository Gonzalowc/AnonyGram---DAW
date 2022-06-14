package proyecto.daw.anonygram.models.request;

/**
 * The Class ModelLoginUser.
 * 
 * @author Gonzalo Waack Carneado
 */
public class ModelLoginUser {

    /** The usuario. */
    private String usuario;

    /** The password. */
    private String password;

    /**
     * Instantiates a new model login user.
     */
    public ModelLoginUser() {
    }

    /**
     * Instantiates a new model login user.
     *
     * @param usuario
     *            the usuario
     * @param password
     *            the password
     */
    public ModelLoginUser(
        String usuario,
        String password) {
        super();
        this.usuario = usuario;
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

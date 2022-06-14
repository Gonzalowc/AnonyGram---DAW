package proyecto.daw.anonygram.models.request;

/**
 * The Class UserSearch.
 * 
 * @author Gonzalo Waack Carneado
 */
public class UserSearch {

    /** The id usuario. */
    private Long idUsuario;

    /**
     * Instantiates a new user search.
     */
    public UserSearch() {
    }

    /**
     * Gets the id usuario.
     *
     * @return the id usuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * Sets the id usuario.
     *
     * @param idUsuario
     *            the new id usuario
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}

package proyecto.daw.anonygram.models.response;

/**
 * The Class UsuarioStadisticsResponse.
 */
public class UsuarioStadisticsResponse {

    /** The usuarios totales. */
    private int usuarios_totales;

    /** The usuarios activos. */
    private int usuarios_activos;

    /** The usuarios inactivos. */
    private int usuarios_inactivos;

    /** The usuarios registro hoy. */
    private int usuarios_registro_hoy;

    /** The usuarios buscando chat. */
    private int usuarios_buscando_chat;

    /**
     * Instantiates a new usuario stadistics response.
     */
    public UsuarioStadisticsResponse() {
    }

    /**
     * Instantiates a new usuario stadistics response.
     *
     * @param usuarios_totales
     *            the usuarios totales
     * @param usuarios_activos
     *            the usuarios activos
     * @param usuarios_inactivos
     *            the usuarios inactivos
     * @param usuarios_registro_hoy
     *            the usuarios registro hoy
     * @param usuarios_buscando_chat
     *            the usuarios buscando chat
     */
    public UsuarioStadisticsResponse(
        int usuarios_totales,
        int usuarios_activos,
        int usuarios_inactivos,
        int usuarios_registro_hoy,
        int usuarios_buscando_chat) {
        super();
        this.usuarios_totales = usuarios_totales;
        this.usuarios_activos = usuarios_activos;
        this.usuarios_inactivos = usuarios_inactivos;
        this.usuarios_registro_hoy = usuarios_registro_hoy;
        this.usuarios_buscando_chat = usuarios_buscando_chat;
    }

    /**
     * Gets the usuarios totales.
     *
     * @return the usuarios totales
     */
    public int getUsuarios_totales() {
        return usuarios_totales;
    }

    /**
     * Sets the usuarios totales.
     *
     * @param usuarios_totales
     *            the new usuarios totales
     */
    public void setUsuarios_totales(int usuarios_totales) {
        this.usuarios_totales = usuarios_totales;
    }

    /**
     * Gets the usuarios activos.
     *
     * @return the usuarios activos
     */
    public int getUsuarios_activos() {
        return usuarios_activos;
    }

    /**
     * Sets the usuarios activos.
     *
     * @param usuarios_activos
     *            the new usuarios activos
     */
    public void setUsuarios_activos(int usuarios_activos) {
        this.usuarios_activos = usuarios_activos;
    }

    /**
     * Gets the usuarios inactivos.
     *
     * @return the usuarios inactivos
     */
    public int getUsuarios_inactivos() {
        return usuarios_inactivos;
    }

    /**
     * Sets the usuarios inactivos.
     *
     * @param usuarios_inactivos
     *            the new usuarios inactivos
     */
    public void setUsuarios_inactivos(int usuarios_inactivos) {
        this.usuarios_inactivos = usuarios_inactivos;
    }

    /**
     * Gets the usuarios registro hoy.
     *
     * @return the usuarios registro hoy
     */
    public int getUsuarios_registro_hoy() {
        return usuarios_registro_hoy;
    }

    /**
     * Sets the usuarios registro hoy.
     *
     * @param usuarios_registro_hoy
     *            the new usuarios registro hoy
     */
    public void setUsuarios_registro_hoy(int usuarios_registro_hoy) {
        this.usuarios_registro_hoy = usuarios_registro_hoy;
    }

    /**
     * Gets the usuarios buscando chat.
     *
     * @return the usuarios buscando chat
     */
    public int getUsuarios_buscando_chat() {
        return usuarios_buscando_chat;
    }

    /**
     * Sets the usuarios buscando chat.
     *
     * @param usuarios_buscando_chat
     *            the new usuarios buscando chat
     */
    public void setUsuarios_buscando_chat(int usuarios_buscando_chat) {
        this.usuarios_buscando_chat = usuarios_buscando_chat;
    }
}

package proyecto.daw.anonygram.models.response;

/**
 * The Class ChatStadisticsResponse.
 */
public class ChatStadisticsResponse {

    /** The chats totales. */
    private int chats_totales;

    /** The chats activos. */
    private int chats_activos;

    /** The chats inactivos. */
    private int chats_inactivos;

    /** The chats hoy. */
    private int chats_hoy;

    /** The chats sin comenzar. */
    private int chats_sin_comenzar;

    /**
     * Instantiates a new chat stadistics response.
     */
    public ChatStadisticsResponse() {
    }

    /**
     * Instantiates a new chat stadistics response.
     *
     * @param usuarios_buscando_chat
     *            the usuarios buscando chat
     * @param chats_totales
     *            the chats totales
     * @param chats_activos
     *            the chats activos
     * @param chats_inactivos
     *            the chats inactivos
     * @param chats_hoy
     *            the chats hoy
     * @param chats_sin_comenzar
     *            the chats sin comenzar
     */
    public ChatStadisticsResponse(
        int usuarios_buscando_chat,
        int chats_totales,
        int chats_activos,
        int chats_inactivos,
        int chats_hoy,
        int chats_sin_comenzar) {
        this.chats_totales = chats_totales;
        this.chats_activos = chats_activos;
        this.chats_inactivos = chats_inactivos;
        this.chats_hoy = chats_hoy;
        this.chats_sin_comenzar = chats_sin_comenzar;
    }

    /**
     * Gets the chats totales.
     *
     * @return the chats totales
     */
    public int getChats_totales() {
        return chats_totales;
    }

    /**
     * Sets the chats totales.
     *
     * @param chats_totales
     *            the new chats totales
     */
    public void setChats_totales(int chats_totales) {
        this.chats_totales = chats_totales;
    }

    /**
     * Gets the chats activos.
     *
     * @return the chats activos
     */
    public int getChats_activos() {
        return chats_activos;
    }

    /**
     * Sets the chats activos.
     *
     * @param chats_activos
     *            the new chats activos
     */
    public void setChats_activos(int chats_activos) {
        this.chats_activos = chats_activos;
    }

    /**
     * Gets the chats inactivos.
     *
     * @return the chats inactivos
     */
    public int getChats_inactivos() {
        return chats_inactivos;
    }

    /**
     * Sets the chats inactivos.
     *
     * @param chats_inactivos
     *            the new chats inactivos
     */
    public void setChats_inactivos(int chats_inactivos) {
        this.chats_inactivos = chats_inactivos;
    }

    /**
     * Gets the chats hoy.
     *
     * @return the chats hoy
     */
    public int getChats_hoy() {
        return chats_hoy;
    }

    /**
     * Sets the chats hoy.
     *
     * @param chats_hoy
     *            the new chats hoy
     */
    public void setChats_hoy(int chats_hoy) {
        this.chats_hoy = chats_hoy;
    }

    /**
     * Gets the chats sin comenzar.
     *
     * @return the chats sin comenzar
     */
    public int getChats_sin_comenzar() {
        return chats_sin_comenzar;
    }

    /**
     * Sets the chats sin comenzar.
     *
     * @param chats_sin_comenzar
     *            the new chats sin comenzar
     */
    public void setChats_sin_comenzar(int chats_sin_comenzar) {
        this.chats_sin_comenzar = chats_sin_comenzar;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "{chats_totales=" + chats_totales + ", chats_activos=" + chats_activos + ", chats_inactivos="
            + chats_inactivos + ", chats_hoy=" + chats_hoy + ", chats_sin_comenzar=" + chats_sin_comenzar + "}";
    }
}

package proyecto.daw.anonygram.models.response;

/**
 * The Class MensajeStadisticsResponse.
 */
public class MensajeStadisticsResponse {

    /** The mensajes totales. */
    private int mensajes_totales;

    /** The mensajes activos. */
    private int mensajes_activos;

    /** The mensajes inactivos. */
    private int mensajes_inactivos;

    /** The mensajes hoy. */
    private int mensajes_hoy;
    
    

    /**
     * Instantiates a new mensaje stadistics response.
     */
    public MensajeStadisticsResponse() {
    }

    /**
     * Instantiates a new mensaje stadistics response.
     *
     * @param usuario_mas_mensajes
     *            the usuario mas mensajes
     * @param mensajes_totales
     *            the mensajes totales
     * @param mensajes_activos
     *            the mensajes activos
     * @param mensajes_inactivos
     *            the mensajes inactivos
     * @param mensajes_hoy
     *            the mensajes hoy
     */
    public MensajeStadisticsResponse(
        int mensajes_totales,
        int mensajes_activos,
        int mensajes_inactivos,
        int mensajes_hoy) {
        this.mensajes_totales = mensajes_totales;
        this.mensajes_activos = mensajes_activos;
        this.mensajes_inactivos = mensajes_inactivos;
        this.mensajes_hoy = mensajes_hoy;
    }

    /**
     * Gets the mensajes totales.
     *
     * @return the mensajes totales
     */
    public int getMensajes_totales() {
        return mensajes_totales;
    }

    /**
     * Sets the mensajes totales.
     *
     * @param mensajes_totales
     *            the new mensajes totales
     */
    public void setMensajes_totales(int mensajes_totales) {
        this.mensajes_totales = mensajes_totales;
    }

    /**
     * Gets the mensajes activos.
     *
     * @return the mensajes activos
     */
    public int getMensajes_activos() {
        return mensajes_activos;
    }

    /**
     * Sets the mensajes activos.
     *
     * @param mensajes_activos
     *            the new mensajes activos
     */
    public void setMensajes_activos(int mensajes_activos) {
        this.mensajes_activos = mensajes_activos;
    }

    /**
     * Gets the mensajes inactivos.
     *
     * @return the mensajes inactivos
     */
    public int getMensajes_inactivos() {
        return mensajes_inactivos;
    }

    /**
     * Sets the mensajes inactivos.
     *
     * @param mensajes_inactivos
     *            the new mensajes inactivos
     */
    public void setMensajes_inactivos(int mensajes_inactivos) {
        this.mensajes_inactivos = mensajes_inactivos;
    }

    /**
     * Gets the mensajes hoy.
     *
     * @return the mensajes hoy
     */
    public int getMensajes_hoy() {
        return mensajes_hoy;
    }

    /**
     * Sets the mensajes hoy.
     *
     * @param mensajes_hoy
     *            the new mensajes hoy
     */
    public void setMensajes_hoy(int mensajes_hoy) {
        this.mensajes_hoy = mensajes_hoy;
    }
}

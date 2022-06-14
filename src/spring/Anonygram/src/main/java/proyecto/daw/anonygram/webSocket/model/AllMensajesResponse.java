package proyecto.daw.anonygram.webSocket.model;

import java.util.ArrayList;

/**
 * The Class AllMensajesResponse.
 * 
 * @author Gonzalo Waack Carneado
 */
public class AllMensajesResponse {

    /** The id chat. */
    private Long idChat;

    /** The list mensajes. */
    private ArrayList<MensajeRequest> listMensajes;

    /**
     * Instantiates a new all mensajes response.
     */
    public AllMensajesResponse() {
    }

    /**
     * Instantiates a new all mensajes response.
     *
     * @param idChat
     *            the id chat
     * @param listMensajes
     *            the list mensajes
     */
    public AllMensajesResponse(
        Long idChat,
        ArrayList<MensajeRequest> listMensajes) {
        this.idChat = idChat;
        this.listMensajes = listMensajes;
    }

    /**
     * Gets the id chat.
     *
     * @return the id chat
     */
    public Long getIdChat() {
        return idChat;
    }

    /**
     * Sets the id chat.
     *
     * @param idChat
     *            the new id chat
     */
    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    /**
     * Gets the list mensajes.
     *
     * @return the list mensajes
     */
    public ArrayList<MensajeRequest> getListMensajes() {
        return listMensajes;
    }

    /**
     * Sets the list mensajes.
     *
     * @param listMensajes
     *            the new list mensajes
     */
    public void setListMensajes(ArrayList<MensajeRequest> listMensajes) {
        this.listMensajes = listMensajes;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "AllMensajesResponse [idChat=" + idChat + ", listMensajes=" + listMensajes + "]";
    }
}

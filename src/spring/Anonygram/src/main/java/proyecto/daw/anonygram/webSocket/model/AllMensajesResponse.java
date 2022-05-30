package proyecto.daw.anonygram.webSocket.model;

import java.util.ArrayList;

public class AllMensajesResponse {

    private Long idChat;

    private ArrayList<MensajeRequest> listMensajes;

    public AllMensajesResponse() {
    }

    public AllMensajesResponse(
        Long idChat,
        ArrayList<MensajeRequest> listMensajes) {
        this.idChat = idChat;
        this.listMensajes = listMensajes;
    }

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    public ArrayList<MensajeRequest> getListMensajes() {
        return listMensajes;
    }

    public void setListMensajes(ArrayList<MensajeRequest> listMensajes) {
        this.listMensajes = listMensajes;
    }

    @Override
    public String toString() {
        return "AllMensajesResponse [idChat=" + idChat + ", listMensajes=" + listMensajes + "]";
    }
    
    
    
}

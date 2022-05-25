package proyecto.daw.anonygram.webSocket.model;

import java.util.Date;

public class MensajeRequest {

    private String mensaje;

    private Integer usuario;

    private Integer chat;

    private Date timestamp;

    private boolean active = true;

    public MensajeRequest() {
    }

    public MensajeRequest(
        String message,
        Integer usuario,
        Integer chat,
        Date timestamp,
        boolean active) {
        this.mensaje = message;
        this.usuario = usuario;
        this.chat = chat;
        this.timestamp = timestamp;
        this.active = active;
    }

    public String getMessage() {
        return mensaje;
    }

    public void setMessage(String message) {
        this.mensaje = message;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getChat() {
        return chat;
    }

    public void setChat(Integer chat) {
        this.chat = chat;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "MensajeRequest [mensaje=" + mensaje + ", usuario=" + usuario + ", chat=" + chat + ", timestamp="
            + timestamp + ", active=" + active + "]";
    }
}

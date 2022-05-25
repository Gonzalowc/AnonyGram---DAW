package proyecto.daw.anonygram.webSocket.model;

public class MensajeResponse {

    private String mensaje;

    private Long usuario;

    private Long chat;

    private String timestamp;

    private boolean active = true;

    public MensajeResponse() {
    }

    public MensajeResponse(
        String message,
        Long usuario,
        Long chat,
        String timestamp,
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

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getChat() {
        return chat;
    }

    public void setChat(Long chat) {
        this.chat = chat;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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
        return "MensajeResponse [mensaje=" + mensaje + ", usuario=" + usuario + ", chat=" + chat
            + ", timestamp=" + timestamp + ", active=" + active + "]";
    }
}

package proyecto.daw.anonygram.webSocket.model;

public class MensajeResponse {

    private String mensaje;

    private Long id_usuario;

    private Long id_chat;

    private String timestamp;

    private boolean active = true;

    public MensajeResponse() {
    }

    public MensajeResponse(
        String mensaje,
        Long id_usuario,
        Long id_chat,
        String timestamp,
        boolean active) {
        this.mensaje = mensaje;
        this.id_usuario = id_usuario;
        this.id_chat = id_chat;
        this.timestamp = timestamp;
        this.active = active;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_chat() {
        return id_chat;
    }

    public void setId_chat(Long id_chat) {
        this.id_chat = id_chat;
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
}

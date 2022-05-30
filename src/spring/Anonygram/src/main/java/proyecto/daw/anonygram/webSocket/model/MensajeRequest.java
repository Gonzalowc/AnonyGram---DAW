package proyecto.daw.anonygram.webSocket.model;

import java.util.Date;

public class MensajeRequest implements Comparable<MensajeRequest>{

    private String mensaje;

    private Long id_usuario;

    private Long id_chat;

    private Date timestamp;

    private boolean active = true;

    public MensajeRequest() {
    }

    public MensajeRequest(
        String mensaje,
        Long id_usuario,
        Long id_chat,
        Date timestamp,
        boolean active) {
        super();
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
        return "MensajeRequest [mensaje=" + mensaje + ", usuario=" + id_usuario + ", chat=" + id_chat + ", timestamp="
            + timestamp + ", active=" + active + "]";
    }

    @Override
    public int compareTo(MensajeRequest o) {
        return o.timestamp.compareTo(this.timestamp);
    }
}

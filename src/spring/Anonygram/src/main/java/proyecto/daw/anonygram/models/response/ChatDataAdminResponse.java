package proyecto.daw.anonygram.models.response;

import java.sql.Blob;
import java.util.Date;

import proyecto.daw.anonygram.models.Chat;

/**
 * The Class ChatDataAdminResponse.
 */
public class ChatDataAdminResponse {

    /** The id chat. */
    private Long id_chat;

    /** The fecha creacion. */
    private Date fecha_creacion;

    /** The nombre chat creador. */
    private String nombre_chat_creador;

    /** The nombre chat respuesta. */
    private String nombre_chat_respuesta;

    /** The id usuario creador. */
    private Long id_usuario_creador;

    /** The id usuario respuesta. */
    private Long id_usuario_respuesta;

    /** The imagen. */
    private Blob imagen;

    /** The cantidad mensajes. */
    private Long cantidad_mensajes;

    /** The activo. */
    private boolean activo;

    /**
     * Instantiates a new chat data admin response.
     */
    public ChatDataAdminResponse() {
    }
    
    public ChatDataAdminResponse(Chat chat) {
        setActivo(chat.isActivo());
        setCantidad_mensajes(cantidadMensajes(chat));
        setFecha_creacion(chat.getFechaCreacion());
        setId_chat(chat.getId_chat());
        setId_usuario_creador(chat.getUsuarioCreador().getId_usuario());
        setId_usuario_respuesta(chat.getUsuarioRespuesta().getId_usuario());
        setImagen(chat.getImagen());
        setNombre_chat_creador(chat.getNombreChatCreador());
        setNombre_chat_respuesta(chat.getNombreChatRespuesta());
    }
    
    private static Long cantidadMensajes(Chat chat) {
        return Long.valueOf(chat.getMensajes().size());
    }
    /**
     * Gets the id chat.
     *
     * @return the id chat
     */
    public Long getId_chat() {
        return id_chat;
    }

    /**
     * Sets the id chat.
     *
     * @param id_chat the new id chat
     */
    public void setId_chat(Long id_chat) {
        this.id_chat = id_chat;
    }

    /**
     * Gets the fecha creacion.
     *
     * @return the fecha creacion
     */
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * Sets the fecha creacion.
     *
     * @param fecha_creacion the new fecha creacion
     */
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * Gets the nombre chat creador.
     *
     * @return the nombre chat creador
     */
    public String getNombre_chat_creador() {
        return nombre_chat_creador;
    }

    /**
     * Sets the nombre chat creador.
     *
     * @param nombre_chat_creador the new nombre chat creador
     */
    public void setNombre_chat_creador(String nombre_chat_creador) {
        this.nombre_chat_creador = nombre_chat_creador;
    }

    /**
     * Gets the nombre chat respuesta.
     *
     * @return the nombre chat respuesta
     */
    public String getNombre_chat_respuesta() {
        return nombre_chat_respuesta;
    }

    /**
     * Sets the nombre chat respuesta.
     *
     * @param nombre_chat_respuesta the new nombre chat respuesta
     */
    public void setNombre_chat_respuesta(String nombre_chat_respuesta) {
        this.nombre_chat_respuesta = nombre_chat_respuesta;
    }

    /**
     * Gets the id usuario creador.
     *
     * @return the id usuario creador
     */
    public Long getId_usuario_creador() {
        return id_usuario_creador;
    }

    /**
     * Sets the id usuario creador.
     *
     * @param id_usuario_creador the new id usuario creador
     */
    public void setId_usuario_creador(Long id_usuario_creador) {
        this.id_usuario_creador = id_usuario_creador;
    }

    /**
     * Gets the id usuario respuesta.
     *
     * @return the id usuario respuesta
     */
    public Long getId_usuario_respuesta() {
        return id_usuario_respuesta;
    }

    /**
     * Sets the id usuario respuesta.
     *
     * @param id_usuario_respuesta the new id usuario respuesta
     */
    public void setId_usuario_respuesta(Long id_usuario_respuesta) {
        this.id_usuario_respuesta = id_usuario_respuesta;
    }

    /**
     * Gets the imagen.
     *
     * @return the imagen
     */
    public Blob getImagen() {
        return imagen;
    }

    /**
     * Sets the imagen.
     *
     * @param imagen the new imagen
     */
    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    /**
     * Gets the cantidad mensajes.
     *
     * @return the cantidad mensajes
     */
    public Long getCantidad_mensajes() {
        return cantidad_mensajes;
    }

    /**
     * Sets the cantidad mensajes.
     *
     * @param cantidad_mensajes the new cantidad mensajes
     */
    public void setCantidad_mensajes(Long cantidad_mensajes) {
        this.cantidad_mensajes = cantidad_mensajes;
    }

    /**
     * Checks if is activo.
     *
     * @return true, if is activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Sets the activo.
     *
     * @param activo the new activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

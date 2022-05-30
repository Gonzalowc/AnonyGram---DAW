package proyecto.daw.anonygram.webSocket.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;

import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Mensaje;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatResponse.
 *
 * @author Gonzalo Waack Carneado
 */
public class ChatResponse implements Comparable<ChatResponse> {

    /** The id chat. */
    private Long id_chat;

    /** The fecha creacion. */
    private String fecha_creacion;

    /** The fecha ultimo mensaje. */
    private String fecha_ultimo_mensaje;

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

    /** The ultimo ensaje. */
    private String ultimo_mensaje;

    /**
     * Instantiates a new chat response.
     */
    public ChatResponse() {
    }

    /**
     * Instantiates a new chat response.
     *
     * @param chat
     *            the chat
     */
    public ChatResponse(
        Chat chat) {
        this.id_chat = chat.getId();
        this.fecha_creacion = chat.getFechaCreacion().toString();
        this.fecha_ultimo_mensaje = chat.getMensajes().size() > 0 ? new ArrayList<Mensaje>(chat.getMensajes())
            .get(chat.getMensajes().size() - 1).getTimestamp().toString() : new Date().toString();
        this.nombre_chat_creador = chat.getNombreChatCreador();
        this.nombre_chat_respuesta = chat.getNombreChatRespuesta();
        this.id_usuario_creador = chat.getUsuarioCreador().getId();
        this.id_usuario_respuesta = chat.getUsuarioRespuesta().getId();
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
     * @param id_chat
     *            the new id chat
     */
    public void setId_chat(Long id_chat) {
        this.id_chat = id_chat;
    }

    /**
     * Gets the fecha creacion.
     *
     * @return the fecha creacion
     */
    public String getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * Sets the fecha creacion.
     *
     * @param fecha_creacion
     *            the new fecha creacion
     */
    public void setFecha_creacion(String fecha_creacion) {
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
     * Gets the fecha ultimo mensaje.
     *
     * @return the fecha ultimo mensaje
     */
    public String getFecha_ultimo_mensaje() {
        return fecha_ultimo_mensaje;
    }

    /**
     * Sets the fecha ultimo mensaje.
     *
     * @param fecha_ultimo_mensaje
     *            the new fecha ultimo mensaje
     */
    public void setFecha_ultimo_mensaje(String fecha_ultimo_mensaje) {
        this.fecha_ultimo_mensaje = fecha_ultimo_mensaje;
    }

    /**
     * Sets the nombre chat creador.
     *
     * @param nombre_chat_creador
     *            the new nombre chat creador
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
     * @param nombre_chat_respuesta
     *            the new nombre chat respuesta
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
     * @param id_usuario_creador
     *            the new id usuario creador
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
     * @param id_usuario_respuesta
     *            the new id usuario respuesta
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
     * @param blob
     *            the new imagen
     */
    public void setImagen(Blob blob) {
        this.imagen = blob;
    }

    /**
     * Gets the ultimo ensaje.
     *
     * @return the ultimo ensaje
     */
    public String getUltimo_mensaje() {
        return ultimo_mensaje;
    }

    /**
     * Sets the ultimo ensaje.
     *
     * @param ultimo_ensaje
     *            the new ultimo ensaje
     */
    public void setUltimo_mensaje(String ultimo_ensaje) {
        this.ultimo_mensaje = ultimo_ensaje;
    }

    /**
     * Compare to.
     *
     * @param chat
     *            the chat
     * @return the int
     */
    @Override
    public int compareTo(ChatResponse chat) {
        return this.fecha_ultimo_mensaje.compareTo(chat.getFecha_ultimo_mensaje());
    }
}

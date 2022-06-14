package proyecto.daw.anonygram.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import proyecto.daw.anonygram.implementation.MensajeServiceImp;
import proyecto.daw.anonygram.implementation.UsuarioServiceImp;
import proyecto.daw.anonygram.models.Chat;
import proyecto.daw.anonygram.models.Mensaje;
import proyecto.daw.anonygram.models.Usuario;
import proyecto.daw.anonygram.models.response.MensajeStadisticsResponse;
import proyecto.daw.anonygram.utils.AnonygramUtils;
import proyecto.daw.anonygram.utils.TemporalEnum;
import proyecto.daw.anonygram.webSocket.model.AllMensajesResponse;
import proyecto.daw.anonygram.webSocket.model.MensajeRequest;

/**
 * The Class MensajeController.
 * 
 * @author Gonzalo Waack Carneado
 */
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class MensajeController {

    /** The usuario service. */
    @Autowired
    private UsuarioServiceImp usuarioService;

    /** The mensaje service. */
    @Autowired
    private MensajeServiceImp mensajeService;

    /**
     * Gets the all mensajes.
     *
     * @param idUsuario
     *            the id usuario
     * @return the all mensajes
     */
    @ResponseBody
    @GetMapping(value = "/mensaje/all",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<AllMensajesResponse>
        getAllMensajes(@RequestParam(required = true, name = "idUsuario") String idUsuario) {
        Usuario usuario = usuarioService.findByIdUsuario(Long.parseLong(idUsuario));
        if (usuario != null) {
            ArrayList<Chat> chats = new ArrayList<>(usuario.getChatsCreados());
            chats.addAll(new ArrayList<>(usuario.getChatsRespondidos()));
            ArrayList<AllMensajesResponse> response = new ArrayList<>();
            for (Chat chat : chats) {
                AllMensajesResponse mensajes = new AllMensajesResponse();
                mensajes.setIdChat(chat.getId_chat());
                ArrayList<MensajeRequest> mensajesRequest = new ArrayList<>();
                for (Mensaje mensaje : chat.getMensajes()) {
                    MensajeRequest mensajeRequest = new MensajeRequest();
                    mensajeRequest.setActive(mensaje.isActive());
                    mensajeRequest.setId_chat(mensaje.getChat().getId_chat());
                    mensajeRequest.setId_usuario(mensaje.getUsuario().getId());
                    mensajeRequest.setMensaje(mensaje.getMensaje());
                    mensajeRequest.setTimestamp(mensaje.getTimestamp());
                    mensajeRequest.setId_mensaje(mensaje.getId_mensaje());
                    mensajeRequest.setReported(mensaje.isReported());
                    mensajesRequest.add(mensajeRequest);
                    mensajes.setListMensajes(mensajesRequest);
                }
                response.add(mensajes);
            }
            return response;
        }
        return new ArrayList<>();
    }

    /**
     * Gets the mensaje stadistics by date.
     *
     * @param date
     *            the date
     * @return the mensaje stadistics by date
     */
    @ResponseBody
    @GetMapping(value = "/admin/mensaje/stadistics",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public MensajeStadisticsResponse
        getMensajeStadisticsByDate(@RequestParam(required = false, name = "date") String date) {
        List<Mensaje> listMensajes = mensajeService.getAllMensajes();
        MensajeStadisticsResponse response = new MensajeStadisticsResponse();
        LocalDate fecha = null;
        if (date != null) {
            fecha = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            listMensajes = filterMensajesByDate(listMensajes, fecha, TemporalEnum.MINOR);
        }
        response.setMensajes_totales(listMensajes.size());
        response.setMensajes_reportados(getMensajesReportados());
        response.setMensajes_activos(getMensajesActivos(listMensajes));
        response.setMensajes_inactivos(getMensajesInactivos(listMensajes));
        listMensajes = fecha != null ? filterMensajesByDate(listMensajes, fecha, TemporalEnum.SAME)
            : filterMensajesByDate(listMensajes, AnonygramUtils.convertToLocalDate(new Date()),
                TemporalEnum.SAME);
        response.setMensajes_hoy(listMensajes.size());
        return response;
    }

    /**
     * Filter mensajes by date.
     *
     * @param listMensajes
     *            the list mensajes
     * @param fecha
     *            the fecha
     * @param tempo
     *            the tempo
     * @return the list
     */
    private List<Mensaje> filterMensajesByDate(List<Mensaje> listMensajes, LocalDate fecha,
        TemporalEnum tempo) {
        List<Mensaje> response = new ArrayList<>();
        for (Mensaje mensaje : listMensajes) {
            LocalDate fechaChat = AnonygramUtils.convertToLocalDate(mensaje.getTimestamp());
            if (TemporalEnum.SAME.equals(tempo)) {
                if (AnonygramUtils.esMismaFecha(fechaChat, fecha)) {
                    response.add(mensaje);
                }
            } else if (TemporalEnum.MINOR.equals(tempo)) {
                if (AnonygramUtils.esAnteriorFecha(fechaChat, fecha)) {
                    response.add(mensaje);
                }
            }
        }
        return response;
    }

    /**
     * Gets the mensajes activos.
     *
     * @param listMensajes
     *            the list mensajes
     * @return the mensajes activos
     */
    private int getMensajesActivos(List<Mensaje> listMensajes) {
        int cantidad = 0;
        for (Mensaje mensaje : listMensajes) {
            if (mensaje.isActive()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Gets the mensajes inactivos.
     *
     * @param listMensajes
     *            the list mensajes
     * @return the mensajes inactivos
     */
    private int getMensajesInactivos(List<Mensaje> listMensajes) {
        int cantidad = 0;
        for (Mensaje mensaje : listMensajes) {
            if (!mensaje.isActive()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Gets the mensajes reportados.
     *
     * @return the mensajes reportados
     */
    private int getMensajesReportados() {
        return mensajeService.getAllByReported(true, true).size();
    }

    /**
     * Gets the mensaje reported.
     *
     * @return the mensaje reported
     */
    @ResponseBody
    @GetMapping(value = "/admin/mensaje/reported",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<MensajeRequest> getMensajeReported() {
        List<Mensaje> listMensajes = mensajeService.getAllByReported(true, true);
        List<MensajeRequest> listResponse = new ArrayList<>();
        for (Mensaje mensaje : listMensajes) {
            MensajeRequest response = new MensajeRequest();
            response.setActive(mensaje.isActive());
            response.setId_chat(mensaje.getChat().getId_chat());
            response.setId_usuario(mensaje.getUsuario().getId_usuario());
            response.setUsuario(mensaje.getUsuario().getUsuario());
            response.setMensaje(mensaje.getMensaje());
            response.setReported(mensaje.isReported());
            response.setTimestamp(mensaje.getTimestamp());
            response.setId_mensaje(mensaje.getId());
            listResponse.add(response);
        }
        return listResponse;
    }

    /**
     * Gets the mensaje banned.
     *
     * @return the mensaje banned
     */
    @ResponseBody
    @GetMapping(value = "/admin/mensaje/banned",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<MensajeRequest> getMensajeBanned() {
        List<Mensaje> listMensajes = mensajeService.getAllByReported(true, false);
        List<MensajeRequest> listResponse = new ArrayList<>();
        for (Mensaje mensaje : listMensajes) {
            MensajeRequest response = new MensajeRequest();
            response.setActive(mensaje.isActive());
            response.setId_chat(mensaje.getChat().getId_chat());
            response.setId_usuario(mensaje.getUsuario().getId_usuario());
            response.setUsuario(mensaje.getUsuario().getUsuario());
            response.setMensaje(mensaje.getMensaje());
            response.setReported(mensaje.isReported());
            response.setTimestamp(mensaje.getTimestamp());
            response.setId_mensaje(mensaje.getId());
            listResponse.add(response);
        }
        return listResponse;
    }

    /**
     * Confirm report.
     *
     * @param idMensaje
     *            the id mensaje
     * @return true, if successful
     */
    @ResponseBody
    @GetMapping(value = "/admin/mensaje/confirmReport",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean confirmReport(@RequestParam(required = true, name = "idMensaje") Long idMensaje) {
        Mensaje mensajeDB = mensajeService.findByIdMensaje(idMensaje);
        if (mensajeDB.isReported()) {
            mensajeDB.setActive(false);
            mensajeService.updateMensaje(mensajeDB);
            return true;
        }
        return false;
    }

    /**
     * Renoval message.
     *
     * @param idMensaje
     *            the id mensaje
     * @return true, if successful
     */
    @ResponseBody
    @GetMapping(value = "/admin/mensaje/renovalMessage",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean renovalMessage(@RequestParam(required = true, name = "idMensaje") Long idMensaje) {
        Mensaje mensajeDB = mensajeService.findByIdMensaje(idMensaje);
        if (mensajeDB.isReported()) {
            mensajeDB.setActive(true);
            mensajeService.updateMensaje(mensajeDB);
            return true;
        }
        return false;
    }

    /**
     * White message.
     *
     * @param idMensaje
     *            the id mensaje
     * @return true, if successful
     */
    @ResponseBody
    @GetMapping(value = "/admin/mensaje/whiteMessage",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean whiteMessage(@RequestParam(required = true, name = "idMensaje") Long idMensaje) {
        Mensaje mensajeDB = mensajeService.findByIdMensaje(idMensaje);
        if (mensajeDB.isReported()) {
            mensajeDB.setActive(true);
            mensajeDB.setReported(false);
            mensajeService.updateMensaje(mensajeDB);
            return true;
        }
        return false;
    }

    /**
     * Ban message.
     *
     * @param idMensaje
     *            the id mensaje
     * @param idUsuario
     *            the id usuario
     * @return true, if successful
     */
    @ResponseBody
    @GetMapping(value = "/mensaje/ban",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean banMessage(@RequestParam(required = true, name = "idMensaje") Long idMensaje,
        @RequestParam(required = true, name = "idUsuario") Long idUsuario) {
        System.out.println("banMessage");
        Mensaje mensajeDB = mensajeService.findByIdMensaje(idMensaje);
        if (mensajeDB.getChat().getUsuarioRespuesta().getId_usuario() == idUsuario
            || mensajeDB.getChat().getUsuarioCreador().getId_usuario() == idUsuario) {
            mensajeDB.setReported(true);
            mensajeService.updateMensaje(mensajeDB);
            return true;
        }
        return false;
    }

    /**
     * Change active message.
     *
     * @param idMensaje
     *            the id mensaje
     * @param idUsuario
     *            the id usuario
     * @return true, if successful
     */
    @ResponseBody
    @GetMapping(value = "/mensaje/changeActive",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean changeActiveMessage(@RequestParam(required = true, name = "idMensaje") Long idMensaje,
        @RequestParam(required = true, name = "idUsuario") Long idUsuario) {
        System.out.println("changeActive");
        Mensaje mensajeDB = mensajeService.findByIdMensaje(idMensaje);
        if (mensajeDB.getUsuario().getId_usuario() == idUsuario) {
            mensajeDB.setActive(!mensajeDB.isActive());
            mensajeService.updateMensaje(mensajeDB);
            return true;
        }
        return false;
    }
}

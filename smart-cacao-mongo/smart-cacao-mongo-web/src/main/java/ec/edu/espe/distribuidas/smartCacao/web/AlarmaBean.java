/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import ec.edu.espe.distribuidas.smartCacao.model.Alarma;
import ec.edu.espe.distribuidas.smartCacao.model.TipoActividad;
import ec.edu.espe.distribuidas.smartCacao.service.ActividadService;
import ec.edu.espe.distribuidas.smartCacao.service.AlarmaService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.bson.types.ObjectId;

/**
 *
 * @author TMET
 */
@Named
@ViewScoped
public class AlarmaBean extends BaseBean implements Serializable {

    private List<Alarma> alarmas;
    private Alarma alarma;
    private Alarma alarmaSel;
    private List<Actividad> actividades;
    private Actividad actividad;

    @Inject
    private AlarmaService alarmaService;

    @Inject
    private ActividadService actividadService;

    @PostConstruct
    public void init() {
        this.alarma = new Alarma();
        this.alarmas = this.alarmaService.obtenerTodos();
        this.actividad = new Actividad();
        this.actividades = this.actividadService.obtenerTodos();
    }

    @Override
    public void agregar() {
        this.alarma = new Alarma();
        this.alarmas = this.alarmaService.obtenerTodos();
        this.actividad = new Actividad();
        this.actividades = this.actividadService.obtenerTodos();
        super.agregar();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.alarma = new Alarma();
        //this.alarma.setCodigo(this.alarmaSel.getCodigo());
        this.alarma.setId(this.alarmaSel.getId());
        //this.alarma.setCodActividad(this.alarmaSel.getCodActividad());
        this.alarma.setActividad(this.alarmaSel.getActividad());
        //this.alarma.setCodTipoActividad(this.alarmaSel.getCodTipoActividad());
        this.alarma.setTipoActividad(this.alarmaSel.getTipoActividad());
        this.alarma.setDescripcion(this.alarmaSel.getDescripcion());
    }

    public void eliminar() {
        try {
            //this.alarmaService.eliminar(this.alarmaSel.getCodigo());
            this.alarmaService.eliminar(new ObjectId(this.alarmaSel.getId()));
            this.alarmas = this.alarmaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.alarmaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void cancelar() {
        super.reset();
        this.alarma = new Alarma();
        this.actividad = new Actividad();
    }

    public void guardar() {
        try {

            //this.alarma.setCodTipoActividad(getNombreActividad(alarma));
            this.alarma.setTipoActividad(getNombreActividad(alarma));

            if (this.enAgregar) {
                this.alarmaService.crear(this.alarma);
                FacesUtil.addMessageInfo("Se agrego la Alarma: " + this.alarma.getDescripcion());
            } else {
                this.alarmaService.modificar(alarma);
                FacesUtil.addMessageInfo("Se modific\u00f3 la Alarma con c\u00f3digo: " + this.alarma.getId());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.alarma = new Alarma();
        this.alarmas = this.alarmaService.obtenerTodos();
        this.actividad = new Actividad();
        this.actividades = this.actividadService.obtenerTodos();
    }

//    public String getNombreActividad(Alarma alarma) {
//        Actividad aux = new Actividad();
//        String nombre = "null";
//        for (int i = 0; i < actividades.size(); i++) {
//            aux = actividades.get(i);
//            if (aux.getActividadPK().getCodActividad() == alarma.getCodActividad()) {
//                nombre = aux.getActividadPK().getCodTipoActividad();
//            }
//        }
//        return nombre;
//    }
    public TipoActividad getNombreActividad(Alarma alarma) {
        Actividad aux = new Actividad();
        Actividad retorna = new Actividad();

        for (int i = 0; i < actividades.size(); i++) {
            aux = actividades.get(i);
            if (aux.getId() == alarma.getActividad().getId()) {
                retorna.setTipoActividad(aux.getTipoActividad());
            }
        }
        return retorna.getTipoActividad();
    }

    public List<Alarma> getAlarmas() {
        return alarmas;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    public Alarma getAlarmaSel() {
        return alarmaSel;
    }

    public void setAlarmaSel(Alarma alarmaSel) {
        this.alarmaSel = alarmaSel;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}

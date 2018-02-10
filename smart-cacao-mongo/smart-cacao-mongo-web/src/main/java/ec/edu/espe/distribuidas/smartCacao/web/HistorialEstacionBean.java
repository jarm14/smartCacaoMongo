/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Estacion;
import ec.edu.espe.distribuidas.smartCacao.model.HistorialEstacion;
import ec.edu.espe.distribuidas.smartCacao.service.EstacionService;
import ec.edu.espe.distribuidas.smartCacao.service.HistorialEstacionService;
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
public class HistorialEstacionBean extends BaseBean implements Serializable{
    
    private List<HistorialEstacion> historialesEstacion;
    private HistorialEstacion historialEstacion;
    private HistorialEstacion historialEstacionSel;
    private List<Estacion> estaciones;
    private Estacion estacion;
    
    @Inject
    private HistorialEstacionService historialEstacionService;
    
    @Inject
    private EstacionService estacionService;
    
    @PostConstruct
    public void init() {
        this.historialesEstacion = this.historialEstacionService.obtenerTodos();
        this.historialEstacion = new HistorialEstacion();
        this.estaciones = this.estacionService.obtenerTodos();
        this.estacion = new Estacion();
    }
    
    @Override
    public void agregar() {
        this.historialesEstacion = this.historialEstacionService.obtenerTodos();
        this.historialEstacion = new HistorialEstacion();
        this.estaciones = this.estacionService.obtenerTodos();
        this.estacion = new Estacion();
        super.agregar();
    }
    
    @Override
    public void modificar() {
        super.modificar();
        this.historialEstacion = new HistorialEstacion();
        this.historialEstacion.setCodigo(this.historialEstacionSel.getCodigo());
//        this.historialEstacion.setCodEstacion(this.historialEstacionSel.getCodEstacion());
//        this.historialEstacion.setCodMes(this.historialEstacionSel.getCodMes());
        this.historialEstacion.setId(this.historialEstacionSel.getId());
        this.historialEstacion.setEstacion(this.historialEstacionSel.getEstacion());
        this.historialEstacion.setMes(this.historialEstacionSel.getMes());
        this.historialEstacion.setAnio(this.historialEstacionSel.getAnio());
        this.historialEstacion.setFechaInicio(this.historialEstacionSel.getFechaInicio());
        this.historialEstacion.setFechaFinalizacion(this.historialEstacionSel.getFechaFinalizacion());
        this.historialEstacion.setNota(this.historialEstacionSel.getNota());
    }
    
    public void eliminar() {
        try {
            //this.historialEstacionService.eliminar(this.historialEstacionSel.getCodigo());
            this.historialEstacionService.eliminar(new ObjectId(this.historialEstacionSel.getId()));
            this.historialesEstacion = this.historialEstacionService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.historialEstacionSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }
    
    public void cancelar() {
        super.reset();
        this.historialEstacion = new HistorialEstacion();
        this.estacion = new Estacion();
    }
    
    public void guardar() {
        try {
            
            if (this.enAgregar) {
                this.historialEstacionService.crear(this.historialEstacion);
                FacesUtil.addMessageInfo("Se agrego el Historial: " + this.historialEstacion.getId());
            } else {
                this.historialEstacionService.modificar(historialEstacion);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Historial con c\u00f3digo: " + this.historialEstacion.getId());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.historialEstacion = new HistorialEstacion();
        this.historialesEstacion = this.historialEstacionService.obtenerTodos();
        this.estacion = new Estacion();
        this.estaciones = this.estacionService.obtenerTodos();
    }
    
    public String getNombre(HistorialEstacion historialEstacion) {
        Estacion aux = new Estacion();
        String nombre = "null";
        for (int i = 0; i < estaciones.size(); i++) {
            aux = estaciones.get(i);
            //if (aux.getEstacionPK().getCodEstacion().equals(historialEstacion.getCodEstacion())) {
            if (aux.getCodigo().equals(historialEstacion.getEstacion().getCodigo())) {
                nombre = aux.getNombre();
            }
        }
        return nombre;
    }
    
//    public Integer getEstacionMes(HistorialEstacion historialEstacion) {
//        Estacion aux = new Estacion();
//        Integer mes = 0;
//        for (int i = 0; i < estaciones.size(); i++) {
//            aux = estaciones.get(i);
//            if (aux.getEstacionPK().getCodEstacion().equals(historialEstacion.getCodEstacion())) {
//                mes = aux.getEstacionPK().getCodMes();
//            }
//        }
//        return mes;
//    }
    
//    public Integer getEstacionMes(HistorialEstacion historialEstacion) {
//        Estacion aux = new Estacion();
//        Integer mes = 0;
//        for (int i = 0; i < estaciones.size(); i++) {
//            aux = estaciones.get(i);
//            if (aux.getEstacionPK().getCodEstacion().equals(historialEstacion.getCodEstacion())) {
//                mes = aux.getEstacionPK().getCodMes();
//            }
//        }
//        return mes;
//    }

    public List<HistorialEstacion> getHistorialesEstacion() {
        return historialesEstacion;
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }

    public HistorialEstacion getHistorialEstacion() {
        return historialEstacion;
    }

    public void setHistorialEstacion(HistorialEstacion historialEstacion) {
        this.historialEstacion = historialEstacion;
    }

    public HistorialEstacion getHistorialEstacionSel() {
        return historialEstacionSel;
    }

    public void setHistorialEstacionSel(HistorialEstacion historialEstacionSel) {
        this.historialEstacionSel = historialEstacionSel;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
}

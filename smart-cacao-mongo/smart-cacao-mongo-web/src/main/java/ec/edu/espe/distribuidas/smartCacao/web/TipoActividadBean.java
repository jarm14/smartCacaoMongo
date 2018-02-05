/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.TipoActividad;
import ec.edu.espe.distribuidas.smartCacao.service.TipoActividadService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author TMET
 */
@Named
@ViewScoped
public class TipoActividadBean extends BaseBean implements Serializable {

    private List<TipoActividad> tiposActividad;
    private TipoActividad tipoActividad;
    private TipoActividad tipoActividadSel;

    @Inject
    private TipoActividadService tipoActividadService;

    @PostConstruct
    public void init() {
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        this.tipoActividad = new TipoActividad();
    }

    @Override
    public void agregar() {
        this.tipoActividad = new TipoActividad();
        super.agregar();
    }

    public void cancelar() {
        super.reset();
        this.tipoActividad = new TipoActividad();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.tipoActividad = new TipoActividad();
        this.tipoActividad.setCodigo(this.tipoActividadSel.getCodigo());
        this.tipoActividad.setNombre(this.tipoActividadSel.getNombre());
        this.tipoActividad.setDescripcion(this.tipoActividadSel.getDescripcion());
    }

    public void eliminar() {
        try {
            this.tipoActividadService.eliminar(this.tipoActividadSel.getCodigo());
            this.tiposActividad = this.tipoActividadService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.tipoActividadSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.tipoActividadService.crear(this.tipoActividad);
                FacesUtil.addMessageInfo("Se agrego el Tipo de Actividad: " + this.tipoActividad.getNombre());
            } else {
                this.tipoActividadService.modificar(tipoActividad);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Tipo de Actividad con c\u00f3digo: " + this.tipoActividad.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        
       super.reset();
       this.tipoActividad = new TipoActividad();
       this.tiposActividad = this.tipoActividadService.obtenerTodos();
    }

    public List<TipoActividad> getTiposActividad() {
        return tiposActividad;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public TipoActividad getTipoActividadSel() {
        return tipoActividadSel;
    }

    public void setTipoActividadSel(TipoActividad tipoActividadSel) {
        this.tipoActividadSel = tipoActividadSel;
    }
}

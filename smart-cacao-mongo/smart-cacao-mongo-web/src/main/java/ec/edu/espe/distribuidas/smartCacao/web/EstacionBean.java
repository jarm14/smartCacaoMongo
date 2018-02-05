/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Estacion;
//import ec.edu.espe.distribuidas.smartCacao.model.EstacionPK;
import ec.edu.espe.distribuidas.smartCacao.model.Mes;
import ec.edu.espe.distribuidas.smartCacao.service.EstacionService;
import ec.edu.espe.distribuidas.smartCacao.service.MesService;
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
public class EstacionBean extends BaseBean implements Serializable {

    private List<Mes> meses;
    private Mes mes;
    private List<Estacion> estaciones;
    private Estacion estacion;
    private Estacion estacionSel;
    //private EstacionPK estacionPK;

    @Inject
    private MesService mesService;

    @Inject
    private EstacionService estacionService;

    @PostConstruct
    public void init() {
        this.estaciones = this.estacionService.obtenerTodos();
        this.estacion = new Estacion();
        this.meses = this.mesService.obtenerTodos();
        this.mes = new Mes();
    }

    @Override
    public void agregar() {
        //this.estacionPK = new EstacionPK();
        this.estacion = new Estacion();
        this.mes = new Mes();
        this.meses = this.mesService.obtenerTodos();
        super.agregar();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.estacion = new Estacion();
        //this.estacion.setEstacionPK(this.estacionSel.getEstacionPK());
        //this.estacionPK = estacion.getEstacionPK();
        this.estacion.setCodigo(this.estacionSel.getCodigo());
        this.estacion.setMes(this.estacionSel.getMes());
        this.estacion.setNombre(this.estacionSel.getNombre());
        this.estacion.setDescripcion(this.estacionSel.getDescripcion());
    }

    public void eliminar() {
        try {
            //this.estacionService.eliminar(this.estacionSel.getEstacionPK());
            this.estacionService.eliminar(this.estacionSel.getCodigo());
            this.estaciones = this.estacionService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.estacionSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void cancelar() {
        super.reset();
        this.estacion = new Estacion();
        this.mes = new Mes();
        //this.estacionPK = new EstacionPK();
    }

    public void guardar() {
        try {
            //this.estacion.setEstacionPK(estacionPK);

            if (this.enAgregar) {
                this.estacionService.crear(this.estacion);
                FacesUtil.addMessageInfo("Se agrego la Estacion: " + this.estacion.getNombre());
            } else {

                this.estacionService.modificar(this.estacion);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Usuario con c\u00f3digo: " + this.estacion.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.estacion = new Estacion();
        //this.estacionPK = new EstacionPK();
        this.mes = new Mes();
        this.meses = this.mesService.obtenerTodos();
        this.estaciones = this.estacionService.obtenerTodos();
    }

    public Integer getIndex(Estacion estacion) {
        Mes aux = new Mes();
        Integer index = 0;
        for (int i = 0; i < meses.size(); i++) {
            aux = meses.get(i);
            if (aux.getId() == estacion.getMes().getId()) {
                index = i;
            }
        }
        return index;
    }

    public List<Mes> getMeses() {
        return meses;
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public Estacion getEstacionSel() {
        return estacionSel;
    }

    public void setEstacionSel(Estacion estacionSel) {
        this.estacionSel = estacionSel;
    }

//    public EstacionPK getEstacionPK() {
//        return estacionPK;
//    }
//
//    public void setEstacionPK(EstacionPK estacionPK) {
//        this.estacionPK = estacionPK;
//    }
}

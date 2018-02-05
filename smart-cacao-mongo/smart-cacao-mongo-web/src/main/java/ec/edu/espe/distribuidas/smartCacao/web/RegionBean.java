/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Estacion;
import ec.edu.espe.distribuidas.smartCacao.model.Mes;
import ec.edu.espe.distribuidas.smartCacao.model.Region;
import ec.edu.espe.distribuidas.smartCacao.service.EstacionService;
import ec.edu.espe.distribuidas.smartCacao.service.RegionService;
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
public class RegionBean extends BaseBean implements Serializable{

    private List<Region> regiones;
    private Region region;
    private Region regionSel;
    private List<Estacion> estaciones;
    private Estacion estacion;

    @Inject
    private RegionService regionService;

    @Inject
    private EstacionService estacionService;
    
    @PostConstruct
    public void init() {
        this.estaciones = this.estacionService.obtenerTodos();
        this.estacion = new Estacion();
        this.regiones = this.regionService.obtenerTodos();
        this.region = new Region();
    }

    @Override
    public void agregar() {
        this.estacion = new Estacion();
        this.region = new Region();
        this.estaciones = this.estacionService.obtenerTodos();
        super.agregar();
    }
    
    @Override
    public void modificar() {
        super.modificar();
        this.region = new Region();
        this.region.setCodigo(this.regionSel.getCodigo());
//        this.region.setCodEstacion(this.regionSel.getCodEstacion());
//        this.region.setCodMes(this.regionSel.getCodMes());
        this.region.setEstacion(this.regionSel.getEstacion());
        this.region.setMes(this.regionSel.getMes());
        this.region.setNombre(this.regionSel.getNombre());
    }
    
    public void eliminar() {
        try {
            this.regionService.eliminar(this.regionSel.getCodigo());
            this.regiones = this.regionService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.regionSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }
    
    public void cancelar() {
        super.reset();
        this.estacion = new Estacion();
        this.region = new Region();
    }
    
    public void guardar() {
        try {
            
            //this.region.setCodMes(getEstacionMes(region));
            this.region.setMes(getEstacionMes(region));
            if (this.enAgregar) {
                this.regionService.crear(this.region);
                FacesUtil.addMessageInfo("Se agrego la Region: " + this.region.getNombre());
            } else {
                this.regionService.modificar(region);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Usuario con c\u00f3digo: " + this.region.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.estacion = new Estacion();
        this.region = new Region();
        this.regiones = this.regionService.obtenerTodos();
        this.estaciones = this.estacionService.obtenerTodos();
    }
    
//    public String getEstacionNombre(Region region) {
//        Estacion aux = new Estacion();
//        String nombre = "null";
//        for (int i = 0; i < estaciones.size(); i++) {
//            aux = estaciones.get(i);
//            if (aux.getEstacionPK().getCodEstacion().equals(region.getCodEstacion())) {
//                nombre = aux.getNombre();
//            }
//        }
//        return nombre;
//    }
    
    public String getEstacionNombre(Region region) {
        Estacion aux = new Estacion();
        String nombre = "null";
        for (int i = 0; i < estaciones.size(); i++) {
            aux = estaciones.get(i);
            if (aux.getCodigo().equals(region.getEstacion().getCodigo())) {
                nombre = aux.getNombre();
            }
        }
        return nombre;
    }
    
//    public Integer getEstacionMes(Region region) {
//        Estacion aux = new Estacion();
//        Integer mes = 0;
//        for (int i = 0; i < estaciones.size(); i++) {
//            aux = estaciones.get(i);
//            if (aux.getEstacionPK().getCodEstacion().equals(region.getCodEstacion())) {
//                mes = aux.getEstacionPK().getCodMes();
//            }
//        }
//        return mes;
//    }
    public Mes getEstacionMes(Region region) {
        Estacion aux = new Estacion();
        Mes mes = new Mes();
        for (int i = 0; i < estaciones.size(); i++) {
            aux = estaciones.get(i);
            if (aux.getCodigo().equals(region.getEstacion().getCodigo())) {
                mes = aux.getMes();
            }
        }
        return mes;
    }

    public List<Region> getRegiones() {
        return regiones;
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getRegionSel() {
        return regionSel;
    }

    public void setRegionSel(Region regionSel) {
        this.regionSel = regionSel;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
}

/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Region;
import ec.edu.espe.distribuidas.smartCacao.model.Terreno;
//import ec.edu.espe.distribuidas.smartCacao.model.TerrenoPK;
import ec.edu.espe.distribuidas.smartCacao.model.TipoTerreno;
import ec.edu.espe.distribuidas.smartCacao.service.RegionService;
import ec.edu.espe.distribuidas.smartCacao.service.TerrenoService;
import ec.edu.espe.distribuidas.smartCacao.service.TipoTerrenoService;
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
public class TerrenoBean extends BaseBean implements Serializable{
    
    private List<Terreno> terrenos;
    private Terreno terreno;
    private Terreno terrenoSel;
    //private TerrenoPK terrenoPK;
    private List<TipoTerreno> tiposTerreno;
    private TipoTerreno tipoTerreno;
    private List<Region> regiones;
    private Region region;
    
    @Inject
    private TerrenoService terrenoService;
    
    @Inject 
    private TipoTerrenoService tipoTerrenoService;
    
    @Inject
    private RegionService regionService;
    
    @PostConstruct
    public void init() {
        this.terrenos = this.terrenoService.obtenerTodos();
        this.terreno = new Terreno();
        this.tiposTerreno = this.tipoTerrenoService.obtenerTodos();
        this.tipoTerreno = new TipoTerreno();
        this.regiones = this.regionService.obtenerTodos();
        this.region = new Region();
    }
    
    @Override
    public void agregar() {
        this.terreno = new Terreno();
        this.tipoTerreno = new TipoTerreno();
        //this.terrenoPK = new TerrenoPK();
        this.region = new Region();
        this.tiposTerreno = this.tipoTerrenoService.obtenerTodos();
        this.regiones = this.regionService.obtenerTodos();
        super.agregar();
    }
    
    @Override
    public void modificar() {
        super.modificar();
        this.terreno = new Terreno();
        //this.terrenoPK = new TerrenoPK();
        //this.terrenoPK = this.terrenoSel.getTerrenoPK();
        //this.terreno.setTerrenoPK(this.terrenoSel.getTerrenoPK());
        //this.terreno.setCodRegion(this.terrenoSel.getCodRegion());
        this.terreno.setCodigo(this.terrenoSel.getCodigo());
        this.terreno.setId(this.terrenoSel.getId());
        this.terreno.setTipoTerreno(this.terrenoSel.getTipoTerreno());
        this.terreno.setRegion(this.terrenoSel.getRegion());
        this.terreno.setDescripcion(this.terrenoSel.getDescripcion());
        this.terreno.setAncho(this.terrenoSel.getAncho());
        this.terreno.setLargo(this.terrenoSel.getLargo());
    }
    
    public void eliminar() {
        try {
            //this.terrenoService.eliminar(this.terrenoSel.getTerrenoPK());
            this.terrenoService.eliminar(new ObjectId(this.terrenoSel.getId()));
            this.terrenos = this.terrenoService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.terrenoSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }
    
    public void cancelar() {
        super.reset();
        this.terreno = new Terreno();
        this.tipoTerreno = new TipoTerreno();
        this.region = new Region();
    }
    
    public void guardar() {
        try {
            
            //this.terreno.setTerrenoPK(this.terrenoPK);

            if (this.enAgregar) {
                this.terrenoService.crear(this.terreno);
                FacesUtil.addMessageInfo("Se agrego el Terreno: " + this.terreno.getDescripcion());
            } else {
                this.terrenoService.modificar(terreno);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Terreno con c\u00f3digo: " + this.terreno.getId());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.terreno = new Terreno();
        //this.terrenoPK = new TerrenoPK();
        this.terrenos = this.terrenoService.obtenerTodos();
        this.tipoTerreno = new TipoTerreno();
        this.tiposTerreno = this.tipoTerrenoService.obtenerTodos();
        this.region = new Region();
        this.regiones = this.regionService.obtenerTodos();
    }
    
//    public String getNombreTipoTerr(Terreno terreno) {
//        TipoTerreno aux = new TipoTerreno();
//        String nombre = "null";
//        for (int i = 0; i < tiposTerreno.size(); i++) {
//            aux = tiposTerreno.get(i);
//            if (aux.getCodigo().equals(terreno.getTerrenoPK().getCodTipoTerreno())) {
//                nombre = aux.getNombre();
//            }
//        }
//        return nombre;
//    }
    
    public String getNombreTipoTerr(Terreno terreno) {
        TipoTerreno aux = new TipoTerreno();
        String nombre = "null";
        for (int i = 0; i < tiposTerreno.size(); i++) {
            aux = tiposTerreno.get(i);
            if (aux.getCodigo().equals(terreno.getTipoTerreno())) {
                nombre = aux.getNombre();
            }
        }
        return nombre;
    }
    
//    public String getNombreRegion(Terreno terreno) {
//        Region aux = new Region();
//        String nombre = "null";
//        for (int i = 0; i < regiones.size(); i++) {
//            aux = regiones.get(i);
//            if (aux.getCodigo().equals(terreno.getCodRegion())) {
//                nombre = aux.getNombre();
//            }
//        }
//        return nombre;
//    }

    public String getNombreRegion(Terreno terreno) {
        Region aux = new Region();
        String nombre = "null";
        for (int i = 0; i < regiones.size(); i++) {
            aux = regiones.get(i);
            if (aux.getCodigo().equals(terreno.getRegion())) {
                nombre = aux.getNombre();
            }
        }
        return nombre;
    }
    
    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public Terreno getTerrenoSel() {
        return terrenoSel;
    }

    public void setTerrenoSel(Terreno terrenoSel) {
        this.terrenoSel = terrenoSel;
    }

//    public TerrenoPK getTerrenoPK() {
//        return terrenoPK;
//    }
//
//    public void setTerrenoPK(TerrenoPK terrenoPK) {
//        this.terrenoPK = terrenoPK;
//    }

    public TipoTerreno getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(TipoTerreno tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Terreno> getTerrenos() {
        return terrenos;
    }

    public List<TipoTerreno> getTiposTerreno() {
        return tiposTerreno;
    }

    public List<Region> getRegiones() {
        return regiones;
    }
}

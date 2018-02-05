/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import ec.edu.espe.distribuidas.smartCacao.model.Terreno;
import ec.edu.espe.distribuidas.smartCacao.model.TipoTerreno;
import ec.edu.espe.distribuidas.smartCacao.service.CosechaService;
import ec.edu.espe.distribuidas.smartCacao.service.TerrenoService;
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
public class CosechaBean extends BaseBean implements Serializable{
    
    private List<Cosecha> cosechas;
    private Cosecha cosecha;
    private Cosecha cosechaSel;
    private List<Terreno> terrenos;
    private Terreno terreno;
    
    @Inject
    private CosechaService cosechaService;
    
    @Inject
    private TerrenoService terrenoService;
    
    @PostConstruct
    public void init() {
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
        this.terreno = new Terreno();
        this.terrenos = this.terrenoService.obtenerTodos();
    }
    
    @Override
    public void agregar() {
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
        this.terreno = new Terreno();
        this.terrenos = this.terrenoService.obtenerTodos();
        super.agregar();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.cosecha = new Cosecha();
//        this.cosecha.setCodigo(this.cosechaSel.getCodigo());
//        this.cosecha.setCodTerreno(this.cosechaSel.getCodTerreno());
//        this.cosecha.setCodTipoTerreno(this.cosechaSel.getCodTipoTerreno());
        this.cosecha.setId(this.cosechaSel.getId());
        this.cosecha.setTerreno(this.cosechaSel.getTerreno());
        this.cosecha.setTipoTerreno(this.cosechaSel.getTipoTerreno());
        this.cosecha.setFechaPlantacion(this.cosechaSel.getFechaPlantacion());
    }

    public void eliminar() {
        try {
            //this.cosechaService.eliminar(this.cosechaSel.getCodigo());
            this.cosechaService.eliminar(new ObjectId(this.cosechaSel.getId()));
            this.cosechas = this.cosechaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.cosechaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void cancelar() {
        super.reset();
        this.cosecha = new Cosecha();
        this.terreno = new Terreno();
    }

    public void guardar() {
        try {

            this.cosecha.setTipoTerreno(getTipoTerreno(cosecha));
            if (this.enAgregar) {
                this.cosechaService.crear(this.cosecha);
                FacesUtil.addMessageInfo("Se agrego la Cosecha: " + this.cosecha.getId());
                //this.cosechaService.generaActividad(this.cosecha);
            } else {
                this.cosechaService.modificar(cosecha);
                FacesUtil.addMessageInfo("Se modific\u00f3 la Cosecha con c\u00f3digo: " + this.cosecha.getId());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
        this.terreno = new Terreno();
        this.terrenos = this.terrenoService.obtenerTodos();
    }

//    public String getNombreTerreno(Cosecha cosecha) {
//        Terreno aux = new Terreno();
//        String nombre = "null";
//        for (int i = 0; i < terrenos.size(); i++) {
//            aux = terrenos.get(i);
//            if (aux.getTerrenoPK().getCodTerreno() == cosecha.getCodTerreno()) {
//                nombre = aux.getDescripcion();
//            }
//        }
//        return nombre;
//    }
    public String getNombreTerreno(Cosecha cosecha) {
        Terreno aux = new Terreno();
        String nombre = "null";
        for (int i = 0; i < terrenos.size(); i++) {
            aux = terrenos.get(i);
            if (aux.getId() == cosecha.getTerreno().getId()) {
                nombre = aux.getDescripcion();
            }
        }
        return nombre;
    }
    
//    public String getTipoTerreno(Cosecha cosecha) {
//        Terreno aux = new Terreno();
//        String nombre = "null";
//        for (int i = 0; i < terrenos.size(); i++) {
//            aux = terrenos.get(i);
//            if (aux.getTerrenoPK().getCodTerreno() == cosecha.getCodTerreno()) {
//                nombre = aux.getTerrenoPK().getCodTipoTerreno();
//            }
//        }
//        return nombre;
//    }
    
    public TipoTerreno getTipoTerreno(Cosecha cosecha) {
        Terreno aux = new Terreno();
        Terreno retorna = new Terreno();

        for (int i = 0; i < terrenos.size(); i++) {
            aux = terrenos.get(i);
            if (aux.getId() == cosecha.getTerreno().getId()) {
                retorna.setTipoTerreno(aux.getTipoTerreno());
            }
        }
        return retorna.getTipoTerreno();
    }

    public List<Cosecha> getCosechas() {
        return cosechas;
    }

    public List<Terreno> getTerrenos() {
        return terrenos;
    }

    public Cosecha getCosecha() {
        return cosecha;
    }

    public void setCosecha(Cosecha cosecha) {
        this.cosecha = cosecha;
    }

    public Cosecha getCosechaSel() {
        return cosechaSel;
    }

    public void setCosechaSel(Cosecha cosechaSel) {
        this.cosechaSel = cosechaSel;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
}

/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.TipoTerreno;
import ec.edu.espe.distribuidas.smartCacao.service.TipoTerrenoService;
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
public class TipoTerrenoBean extends BaseBean implements Serializable {

    private List<TipoTerreno> tiposTerreno;
    private TipoTerreno tipoTerreno;
    private TipoTerreno tipoTerrenoSel;

    @Inject
    private TipoTerrenoService tipoTerrenoService;

    @PostConstruct
    public void init() {
        this.tiposTerreno = this.tipoTerrenoService.obtenerTodos();
        this.tipoTerreno = new TipoTerreno();
    }

    @Override
    public void agregar() {
        this.tipoTerreno = new TipoTerreno();
        super.agregar();
    }

    public void cancelar() {
        super.reset();
        this.tipoTerreno = new TipoTerreno();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.tipoTerreno = new TipoTerreno();
        this.tipoTerreno.setCodigo(this.tipoTerrenoSel.getCodigo());
        this.tipoTerreno.setNombre(this.tipoTerrenoSel.getNombre());
        this.tipoTerreno.setDescripcion(this.tipoTerrenoSel.getDescripcion());
    }

    public void eliminar() {
        try {
            this.tipoTerrenoService.eliminar(this.tipoTerrenoSel.getCodigo());
            this.tiposTerreno = this.tipoTerrenoService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.tipoTerrenoSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.tipoTerrenoService.crear(this.tipoTerreno);
                FacesUtil.addMessageInfo("Se agrego el Tipo de Terreno: " + this.tipoTerreno.getNombre());
            } else {
                this.tipoTerrenoService.modificar(tipoTerreno);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Tipo de Terreno con c\u00f3digo: " + this.tipoTerreno.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.tipoTerreno = new TipoTerreno();
        this.tiposTerreno = this.tipoTerrenoService.obtenerTodos();
    }

    public List<TipoTerreno> getTiposTerreno() {
        return tiposTerreno;
    }

    public TipoTerreno getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(TipoTerreno tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public TipoTerreno getTipoTerrenoSel() {
        return tipoTerrenoSel;
    }

    public void setTipoTerrenoSel(TipoTerreno tipoTerrenoSel) {
        this.tipoTerrenoSel = tipoTerrenoSel;
    }
}

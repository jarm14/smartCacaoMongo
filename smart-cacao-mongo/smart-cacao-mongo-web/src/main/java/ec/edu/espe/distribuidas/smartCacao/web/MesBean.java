/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Mes;
import ec.edu.espe.distribuidas.smartCacao.service.MesService;
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
public class MesBean extends BaseBean implements Serializable {

    private List<Mes> meses;
    private Mes mes;
    private Mes mesSel;
    
    @Inject
    private MesService mesService;

    @PostConstruct
    public void init() {
        this.meses = this.mesService.obtenerTodos();
        this.mes = new Mes();
    }

    @Override
    public void agregar() {
        this.mes = new Mes();
        super.agregar();
    }

    public void cancelar() {
        super.reset();
        this.mes = new Mes();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.mes = new Mes();
        this.mes.setCodigo(this.mesSel.getCodigo());
        //this.mes.setId(this.mesSel.getId());
        this.mes.setNombre(this.mesSel.getNombre());
    }

    public void eliminar() {
        try {
            //this.mesService.eliminar(this.mesSel.getCodigo());
            this.mesService.eliminar(new ObjectId(this.mesSel.getId()));
            this.meses = this.mesService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.mesSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.mesService.crear(this.mes);
                FacesUtil.addMessageInfo("Se agrego el Mes: " + this.mes.getNombre());
            } else {
                this.mesService.modificar(mes);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Mes con c\u00f3digo: " + this.mes.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.mes = new Mes();
        this.meses = this.mesService.obtenerTodos();
    }

    public List<Mes> getMeses() {
        return meses;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Mes getMesSel() {
        return mesSel;
    }

    public void setMesSel(Mes mesSel) {
        this.mesSel = mesSel;
    }
}

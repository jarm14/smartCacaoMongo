/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.TipoUsuario;
import ec.edu.espe.distribuidas.smartCacao.service.TipoUsuarioService;
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
public class TipoUsuarioBean extends BaseBean implements Serializable {

    private List<TipoUsuario> tiposUsuario;
    private TipoUsuario tipoUsuario;
    private TipoUsuario tipoUsuarioSel;

    @Inject
    private TipoUsuarioService tipoUsuarioService;

    @PostConstruct
    public void init() {
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.tipoUsuario = new TipoUsuario();
    }

    @Override
    public void agregar() {
        this.tipoUsuario = new TipoUsuario();
        super.agregar();
    }

    public void cancelar() {
        super.reset();
        this.tipoUsuario = new TipoUsuario();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.tipoUsuario = new TipoUsuario();
        this.tipoUsuario.setCodigo(this.tipoUsuarioSel.getCodigo());
        this.tipoUsuario.setTipo(this.tipoUsuarioSel.getTipo());
        this.tipoUsuario.setDescripcion(this.tipoUsuarioSel.getDescripcion());
    }

    public void eliminar() {
        try {
            this.tipoUsuarioService.eliminar(new ObjectId(this.tipoUsuarioSel.getCodigo().toString()));
            this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.tipoUsuarioSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.tipoUsuarioService.crear(this.tipoUsuario);
                FacesUtil.addMessageInfo("Se agrego el Tipo de Usuario: " + this.tipoUsuario.getDescripcion());
            } else {
                this.tipoUsuarioService.modificar(tipoUsuario);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Tipo de Usuario con c\u00f3digo: " + this.tipoUsuario.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.tipoUsuario = new TipoUsuario();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuario getTipoUsuarioSel() {
        return tipoUsuarioSel;
    }

    public void setTipoUsuarioSel(TipoUsuario tipoUsuarioSel) {
        this.tipoUsuarioSel = tipoUsuarioSel;
    }
}

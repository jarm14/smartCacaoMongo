/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.TipoUsuario;
import ec.edu.espe.distribuidas.smartCacao.model.Usuario;
import ec.edu.espe.distribuidas.smartCacao.service.TipoUsuarioService;
import ec.edu.espe.distribuidas.smartCacao.service.UsuarioService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
public class UsuarioBean extends BaseBean implements Serializable {

    private List<TipoUsuario> tiposUsuario;
    private TipoUsuario tipoUsuario;
    private List<Usuario> usuarios;
    private Usuario usuario;
    private Usuario usuarioSel; 
    private Integer index;
    private ArrayList<String> listaTipoU;

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private TipoUsuarioService tipoUsuarioService;

    @PostConstruct
    public void init() {
        this.usuarios = this.usuarioService.obtenerTodos();
        this.usuario = new Usuario();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.tipoUsuario = new TipoUsuario();
    }

    @Override
    public void agregar() {
        this.usuario = new Usuario();
        this.tipoUsuario = new TipoUsuario();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.listaTipoU = new ArrayList<>();
        TipoUsuario aux = new TipoUsuario();

        for (int i = 0; i < tiposUsuario.size(); i++) {
            aux = tiposUsuario.get(i);
            listaTipoU.add(aux.getDescripcion());
        }
        super.agregar();
    }

    public void cancelar() {
        super.reset();
        this.usuario = new Usuario();
        this.tipoUsuario = new TipoUsuario();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.tipoUsuario = new TipoUsuario();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.listaTipoU = new ArrayList<>();
        TipoUsuario aux = new TipoUsuario();

        for (int i = 0; i < tiposUsuario.size(); i++) {
            aux = tiposUsuario.get(i);
            listaTipoU.add(aux.getDescripcion());
        }

        this.usuario = new Usuario();
        //this.usuario.setCodigo(this.usuarioSel.getCodigo());
        //this.usuario.setCodTipoUsuario(this.usuarioSel.getCodTipoUsuario());
        this.usuario.setId(this.usuarioSel.getId());
        this.usuario.setTipoUsuario(this.usuarioSel.getTipoUsuario());
        this.usuario.setNombre(this.usuarioSel.getNombre());
        this.usuario.setApellido(this.usuarioSel.getApellido());
        this.usuario.setPassword(this.usuarioSel.getPassword());
        this.usuario.setTelefono(this.usuarioSel.getTelefono());
        this.usuario.setEmail(this.usuarioSel.getEmail());
    }

    @Override
    public void detalles() {
        super.detalles();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.listaTipoU = new ArrayList<>();
        TipoUsuario aux = new TipoUsuario();

        for (int i = 0; i < tiposUsuario.size(); i++) {
            aux = tiposUsuario.get(i);
            listaTipoU.add(aux.getDescripcion());
        }

        this.usuario = new Usuario();
        //this.usuario.setCodigo(this.usuarioSel.getCodigo());
        //this.usuario.setCodTipoUsuario(this.usuarioSel.getCodTipoUsuario());
        this.usuario.setId(this.usuarioSel.getId());
        this.usuario.setTipoUsuario(this.usuarioSel.getTipoUsuario());
        this.usuario.setNombre(this.usuarioSel.getNombre());
        this.usuario.setApellido(this.usuarioSel.getApellido());
        this.usuario.setPassword(this.usuarioSel.getPassword());
        this.usuario.setTelefono(this.usuarioSel.getTelefono());
        this.usuario.setEmail(this.usuarioSel.getEmail());
    }

    public void eliminar() {
        try {
            //this.usuarioService.eliminar(this.usuarioSel.getCodigo());
            this.usuarioService.eliminar(new ObjectId(this.usuarioSel.getId()));
            this.usuarios = this.usuarioService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.usuarioSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void guardar() {
        try {
            //this.usuario.setCodTipoUsuario(tiposUsuario.get(getIdTipoU(this.tipoUsuario.getDescripcion())));

            if (this.enAgregar) {
                this.usuarioService.crear(this.usuario);
                FacesUtil.addMessageInfo("Se agrego el Usuario: " + this.usuario.getNombre());
            } else {
                this.usuarioService.modificar(usuario);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Usuario con c\u00f3digo: " + this.usuario.getId());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.usuario = new Usuario();
        this.tipoUsuario = new TipoUsuario();
        this.tiposUsuario = this.tipoUsuarioService.obtenerTodos();
        this.usuarios = this.usuarioService.obtenerTodos();
    }

    public List<String> getListaTiposU() {
        return listaTipoU;
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(Usuario usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

//    public Integer getIndex(Usuario usuario) {
//        TipoUsuario aux = new TipoUsuario();
//        for (int i = 0; i < tiposUsuario.size(); i++) {
//            aux = tiposUsuario.get(i);
//            if (aux.getCodigo() == usuario.getCodTipoUsuario().getCodigo()) {
//                index = i;
//            }
//        }
//        return index;
//    }
    
    public Integer getIndex(Usuario usuario) {
        TipoUsuario aux = new TipoUsuario();
        for (int i = 0; i < tiposUsuario.size(); i++) {
            aux = tiposUsuario.get(i);
            if (aux.getCodigo() == usuario.getTipoUsuario().getCodigo()) {
                index = i;
            }
        }
        return index;
    }

    public Integer getIdTipoU(String descripcion) {
        Integer id = 0;
        TipoUsuario aux = new TipoUsuario();
        for (int i = 0; i < tiposUsuario.size(); i++) {
            aux = tiposUsuario.get(i);
            if (aux.getDescripcion().equalsIgnoreCase(descripcion)) {
                id = i;
            }
        }
        return id;
    }
}

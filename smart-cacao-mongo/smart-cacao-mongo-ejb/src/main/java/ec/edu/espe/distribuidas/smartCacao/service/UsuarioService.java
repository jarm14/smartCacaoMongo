/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Usuario;
import ec.edu.espe.distribuidas.smartCacao.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.bson.types.ObjectId;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class UsuarioService {

    @EJB
    MongoPersistence mp;
    private UsuarioDAO usuarioFacade;

    @PostConstruct
    public void init() {

        this.usuarioFacade = new UsuarioDAO(Usuario.class, mp.context());
    }

    public List<Usuario> obtenerTodos() {
        return this.usuarioFacade.find().asList();
    }

    public Usuario obtenerPorCodigo(ObjectId codigo) {
        return this.usuarioFacade.get(codigo);
    }

    public void crear(Usuario usuario) {
        this.usuarioFacade.save(usuario);
    }

    public void modificar(Usuario usuario) {
        this.usuarioFacade.save(usuario);
    }

    public void eliminar(ObjectId codigo) {
        Usuario usuario = this.usuarioFacade.get(codigo);
        this.usuarioFacade.delete(usuario);
    }
}

/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.TipoUsuarioDAO;
import ec.edu.espe.distribuidas.smartCacao.model.TipoUsuario;
import ec.edu.espe.distribuidas.smartCacao.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.bson.types.ObjectId;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class TipoUsuarioService {

    @EJB
    MongoPersistence mp;
    private TipoUsuarioDAO tipoUsuarioFacade;

    @PostConstruct
    public void init() {

        this.tipoUsuarioFacade = new TipoUsuarioDAO(TipoUsuario.class, mp.context());
    }

    public List<TipoUsuario> obtenerTodos() {
        return this.tipoUsuarioFacade.find().asList();
    }

    public TipoUsuario obtenerPorCodigo(ObjectId codigo) {
        return this.tipoUsuarioFacade.get(codigo);
    }

    public void crear(TipoUsuario tipoUsuario) {
        this.tipoUsuarioFacade.save(tipoUsuario);
    }

    public void modificar(TipoUsuario tipoUsuario) {
        this.tipoUsuarioFacade.save(tipoUsuario);
    }

    public void eliminar(ObjectId codigo) {
        TipoUsuario tipoUsuario = this.tipoUsuarioFacade.get(codigo);
        this.tipoUsuarioFacade.delete(tipoUsuario);
    }
}

/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.TipoTerrenoDAO;
import ec.edu.espe.distribuidas.smartCacao.model.TipoTerreno;
import ec.edu.espe.distribuidas.smartCacao.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class TipoTerrenoService {

    @EJB
    MongoPersistence mp;
    private TipoTerrenoDAO tipoTerrenoFacade;

    @PostConstruct
    public void init() {

        this.tipoTerrenoFacade = new TipoTerrenoDAO(TipoTerreno.class, mp.context());
    }

    public List<TipoTerreno> obtenerTodos() {
        return this.tipoTerrenoFacade.find().asList();
    }

    public TipoTerreno obtenerPorCodigo(String codigo) {
        return this.tipoTerrenoFacade.findOne("codigo", codigo);
    }

    public void crear(TipoTerreno tipoTerreno) {
        this.tipoTerrenoFacade.save(tipoTerreno);
    }

    public void modificar(TipoTerreno tipoTerreno) {
        this.tipoTerrenoFacade.save(tipoTerreno);
    }

    public void eliminar(String codigo) {
        TipoTerreno tipoTerreno = this.tipoTerrenoFacade.findOne("codigo", codigo);
        this.tipoTerrenoFacade.delete(tipoTerreno);
    }
}

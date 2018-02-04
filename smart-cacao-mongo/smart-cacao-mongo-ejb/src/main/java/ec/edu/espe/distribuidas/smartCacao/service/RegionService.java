/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.RegionDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Region;
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
public class RegionService {

    @EJB
    MongoPersistence mp;
    private RegionDAO regionFacade;

    @PostConstruct
    public void init() {

        this.regionFacade = new RegionDAO(Region.class, mp.context());
    }

    public List<Region> obtenerTodos() {
        return this.regionFacade.find().asList();
    }

    public Region obtenerPorCodigo(String codigo) {
        return this.regionFacade.findOne("codigo", codigo);
    }

    public void crear(Region region) {
        this.regionFacade.save(region);
    }

    public void modificar(Region region) {
        this.regionFacade.save(region);
    }

    public void eliminar(String codigo) {
        Region region = this.regionFacade.findOne("codigo", codigo);
        this.regionFacade.delete(region);
    }
}

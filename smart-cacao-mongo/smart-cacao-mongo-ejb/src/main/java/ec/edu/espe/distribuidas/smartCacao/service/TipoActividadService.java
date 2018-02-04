/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.TipoActividadDAO;
import ec.edu.espe.distribuidas.smartCacao.model.TipoActividad;
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
public class TipoActividadService {

    @EJB
    MongoPersistence mp;
    private TipoActividadDAO tipoActividadFacade;

    @PostConstruct
    public void init() {

        this.tipoActividadFacade = new TipoActividadDAO(TipoActividad.class, mp.context());
    }

    public List<TipoActividad> obtenerTodos() {
        return this.tipoActividadFacade.find().asList();
    }

    public TipoActividad obtenerPorCodigo(String codigo) {
        return this.tipoActividadFacade.findOne("codigo", codigo);
    }

    public void crear(TipoActividad tipoActividad) {
        this.tipoActividadFacade.save(tipoActividad);
    }

    public void modificar(TipoActividad tipoActividad) {
        this.tipoActividadFacade.save(tipoActividad);
    }

    public void eliminar(String codigo) {
        TipoActividad tipoActividad = this.tipoActividadFacade.findOne("codigo", codigo);
        this.tipoActividadFacade.delete(tipoActividad);
    }
}

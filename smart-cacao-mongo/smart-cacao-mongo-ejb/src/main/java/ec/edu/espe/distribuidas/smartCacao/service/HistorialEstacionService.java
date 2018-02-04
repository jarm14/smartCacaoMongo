/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.HistorialEstacionDAO;
import ec.edu.espe.distribuidas.smartCacao.model.HistorialEstacion;
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
public class HistorialEstacionService {

    @EJB
    MongoPersistence mp;
    private HistorialEstacionDAO historialEstacionFacade;

    @PostConstruct
    public void init() {

        this.historialEstacionFacade = new HistorialEstacionDAO(HistorialEstacion.class, mp.context());
    }

    public List<HistorialEstacion> obtenerTodos() {
        return this.historialEstacionFacade.find().asList();
    }

    public HistorialEstacion obtenerPorCodigo(ObjectId codigo) {
        return this.historialEstacionFacade.get(codigo);
    }

    public void crear(HistorialEstacion historalEstacion) {
        this.historialEstacionFacade.save(historalEstacion);
    }

    public void modificar(HistorialEstacion historialEstacion) {
        this.historialEstacionFacade.save(historialEstacion);
    }

    public void eliminar(ObjectId codigo) {
        HistorialEstacion historialEstacion = this.historialEstacionFacade.get(codigo);
        this.historialEstacionFacade.delete(historialEstacion);
    }
}

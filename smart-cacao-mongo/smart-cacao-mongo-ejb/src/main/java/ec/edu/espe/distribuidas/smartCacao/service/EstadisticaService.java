/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.EstadisticaDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
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
public class EstadisticaService {

    @EJB
    MongoPersistence mp;
    private EstadisticaDAO estadisticaFacade;

    @PostConstruct
    public void init() {

        this.estadisticaFacade = new EstadisticaDAO(Estadistica.class, mp.context());
    }

    public List<Estadistica> obtenerTodos() {
        return this.estadisticaFacade.find().asList();
    }

    public Estadistica obtenerPorCodigo(ObjectId codigo) {
        return this.estadisticaFacade.get(codigo);
    }

//    public List<Estadistica> obtenerPorCosecha(Integer codigo) {
//        return this.estadisticaFacade.findByCosecha(codigo);
//    }

    public void crear(Estadistica estadistica) {
        this.estadisticaFacade.save(estadistica);
    }

    public void modificar(Estadistica estadistica) {
        this.estadisticaFacade.save(estadistica);
    }

    public void eliminar(ObjectId codigo) {
        Estadistica estadistica = this.estadisticaFacade.get(codigo);
        this.estadisticaFacade.delete(estadistica);
    }
}
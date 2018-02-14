/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.CosechaDAO;
import ec.edu.espe.distribuidas.smartCacao.dao.EstadisticaDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
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

    public List<Estadistica> obtenerPorCosecha(String value){
        return this.estadisticaFacade.find().asList();
    }

    public void crear(Estadistica estadistica) {
        List<Estadistica> aux = this.estadisticaFacade.find().asList();
        Integer codigo;
        if(aux.isEmpty())
        {
            codigo=1;
        }
        else{
        Integer count = aux.size();
        Estadistica last = aux.get(count-1);
        codigo = last.getCodigo()+1;
        }
        estadistica.setCodigo(codigo);
        this.estadisticaFacade.save(estadistica);
    }

    public void modificar(Estadistica estadistica) {
        Estadistica aux = this.estadisticaFacade.findOne("codigo", estadistica.getCodigo());
        estadistica.setId(aux.getId());
        this.estadisticaFacade.save(estadistica);
    }

    public void eliminar(ObjectId codigo) {
        Estadistica estadistica = this.estadisticaFacade.get(codigo);
        this.estadisticaFacade.delete(estadistica);
    }
}

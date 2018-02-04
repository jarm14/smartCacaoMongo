/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.AlarmaDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Alarma;
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
public class AlarmaService {

    @EJB
    private MongoPersistence mp;
    private AlarmaDAO alarmaFacade;
    
    @PostConstruct
    public void init(){
    
        this.alarmaFacade = new AlarmaDAO(Alarma.class, mp.context());
    }

    public List<Alarma> obtenerTodos() {
        return this.alarmaFacade.find().asList();
    }

    public Alarma obtenerPorCodigo(ObjectId codigo) {
        return this.alarmaFacade.get(codigo);
    }

    public void crear(Alarma alarma) {
        this.alarmaFacade.save(alarma);
    }

    public void modificar(Alarma alarma) {
        this.alarmaFacade.save(alarma);
    }

    public void eliminar(ObjectId codigo) {
        Alarma alarma = this.alarmaFacade.get(codigo);
        this.alarmaFacade.delete(alarma);
    }
}

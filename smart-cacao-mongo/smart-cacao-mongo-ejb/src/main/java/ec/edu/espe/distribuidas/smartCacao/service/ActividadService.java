/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.ActividadDAO;
import ec.edu.espe.distribuidas.smartCacao.dao.CosechaDAO;
import ec.edu.espe.distribuidas.smartCacao.enums.ActividadEnum;
import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
import ec.edu.espe.distribuidas.smartCacao.mongo.MongoPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class ActividadService {

    @EJB
    private MongoPersistence mp;

    private ActividadDAO actividadFacade;
    //private CosechaDAO cosechaFacade;
    
    //@EJB    
    //private CosechaService cosechaService;

    @PostConstruct
    public void init() {

        this.actividadFacade = new ActividadDAO(Actividad.class, mp.context());
        //this.cosechaFacade = new CosechaDAO(Cosecha.class, mp.context());
    }

    public List<Actividad> obtenerTodos() {
        return this.actividadFacade.find().asList();
    }

    public Actividad obtenerPorCodigo(ObjectId id) {
        return this.actividadFacade.get(id);
    }

    public void crear(Actividad actividad) {
        List<Actividad> aux = this.actividadFacade.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 0;
        } else {
            Integer count = aux.size();
            Actividad last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        actividad.setCodigo(codigo);
        this.actividadFacade.save(actividad);
    }

    public void modificar(Actividad actividad) {
        Actividad aux = this.actividadFacade.findOne("codigo", actividad.getCodigo());
        actividad.setId(aux.getId());
        this.actividadFacade.save(actividad);
    }

    public void eliminar(ObjectId codigo) {
        Actividad actividad = this.actividadFacade.get(codigo);
        this.actividadFacade.delete(actividad);
    }    
}

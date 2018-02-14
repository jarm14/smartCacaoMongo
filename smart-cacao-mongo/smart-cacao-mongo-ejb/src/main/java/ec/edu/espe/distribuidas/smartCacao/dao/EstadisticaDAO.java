/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author TMET
 */
public class EstadisticaDAO extends BasicDAO<Estadistica, ObjectId> {

    public EstadisticaDAO(Class<Estadistica> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    /*public List<Estadistica> findByCosecha(Integer codCosecha) {
        
        Query qry = this.em.createQuery("SELECT obj FROM Estadistica obj WHERE obj.codCosecha = ?1");
        qry.setParameter(1, codCosecha);
        return qry.getResultList();
    }*/
}

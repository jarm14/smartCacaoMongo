/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author TMET
 */
public class CosechaDAO extends BasicDAO<Cosecha, ObjectId> {

    public CosechaDAO(Class<Cosecha> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }

//    public List<Cosecha> findByTerreno(Integer codTerreno) {
//        Query qry = this.em.createQuery("SELECT obj FROM Cosecha obj WHERE obj.terreno.terrenoPK.codTerreno = ?1");
//        qry.setParameter(1, codTerreno);
//        return qry.getResultList();
//    }
}

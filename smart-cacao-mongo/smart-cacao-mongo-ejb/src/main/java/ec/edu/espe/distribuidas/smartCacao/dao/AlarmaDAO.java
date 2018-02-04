/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Alarma;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;


/**
 *
 * @author TMET
 */
public class AlarmaDAO extends BasicDAO<Alarma, ObjectId> {

    public AlarmaDAO(Class<Alarma> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }

//    public List<Alarma> getByActividad(Integer codActividad) {
//        Query qry = this.em.createQuery("SELECT obj FROM Alarma obj WHERE obj.actividad.actividadPK.codActividad = ?1");
//        qry.setParameter(1, codActividad);
//        return qry.getResultList();
//    }
}

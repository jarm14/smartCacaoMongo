/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author TMET
 */
public class ActividadDAO extends BasicDAO<Actividad, ObjectId> {

    public ActividadDAO(Class<Actividad> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }

//    public List<Actividad> findByCosechaTipo(String codTipoActividad, Integer codCosecha) {
//        Query qry = this.em.createQuery("SELECT obj FROM Actividad obj WHERE obj.actividadPK.codTipoActividad = ?1 AND obj.codCosecha = ?2");
//        qry.setParameter(1, codTipoActividad);
//        qry.setParameter(2, codCosecha);
//        return qry.getResultList();
//    }
//
//    public List<Actividad> getByDate(Date date) {
//        Query qry = this.em.createQuery("SELECT obj FROM Actividad obj WHERE obj.fechaUltimaEjecucion = ?1 AND obj.estado LIKE 'NRE'");
//        qry.setParameter(1,date);
//        return qry.getResultList();
//    }
}

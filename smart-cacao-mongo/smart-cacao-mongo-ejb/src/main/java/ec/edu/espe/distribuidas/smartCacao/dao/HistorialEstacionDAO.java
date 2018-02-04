/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.HistorialEstacion;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author joel
 */
public class HistorialEstacionDAO extends BasicDAO<HistorialEstacion, ObjectId> {

    public HistorialEstacionDAO(Class<HistorialEstacion> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}

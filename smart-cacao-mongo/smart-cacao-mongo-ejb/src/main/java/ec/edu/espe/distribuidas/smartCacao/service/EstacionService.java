/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.EstacionDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Estacion;
import ec.edu.espe.distribuidas.smartCacao.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class EstacionService {
    
    @EJB
    private MongoPersistence mp;
    private EstacionDAO estacionFacade;
    
    @PostConstruct
    public void init() {

        this.estacionFacade = new EstacionDAO(Estacion.class, mp.context());
    }
    
    public List<Estacion> obtenerTodos()
    {
        return this.estacionFacade.find().asList();
    }
    
    public Estacion obtenerPorCodigo(String codigo)
    {
        return this.estacionFacade.findOne("codigo",codigo);
    }
    
    public void crear(Estacion estacion)
    {
        this.estacionFacade.save(estacion);
    }
    
    public void modificar(Estacion estacion)
    {
        this.estacionFacade.save(estacion);
    }
    
    public void eliminar(String codigo)
    {
        Estacion estacion = this.estacionFacade.findOne("codigo",codigo);
        this.estacionFacade.delete(estacion);
    }
}

/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.MesDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Mes;
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
public class MesService {

    @EJB
    MongoPersistence mp;
    private MesDAO mesFacade;

    @PostConstruct
    public void init() {

        this.mesFacade = new MesDAO(Mes.class, mp.context());
    }

    public List<Mes> obtenerTodos() {
        return this.mesFacade.find().asList();
    }

    public Mes obtenerPorCodigo(ObjectId codigo) {
        return this.mesFacade.get(codigo);
    }

    public void crear(Mes mes) {
        
        List<Mes> aux = this.mesFacade.find().asList();
        Integer codigo;
        if(aux.isEmpty())
        {
            codigo=1;
        }
        else{
        Integer count = aux.size();
        Mes last = aux.get(count-1);
        codigo = last.getCodigo()+1;
        }
        mes.setCodigo(codigo);
        this.mesFacade.save(mes);
    }

    public void modificar(Mes mes) {
        Mes aux = this.mesFacade.findOne("codigo", mes.getCodigo());
        mes.setId(aux.getId());
        this.mesFacade.save(mes);
    }

    public void eliminar(ObjectId codigo) {
        Mes mes = this.mesFacade.get(codigo);
        System.out.println(mes.getNombre());
        this.mesFacade.delete(mes);
    }
}


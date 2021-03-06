/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.TerrenoDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Terreno;
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
public class TerrenoService {

    @EJB
    MongoPersistence mp;
    private TerrenoDAO terrenoFacade;

    @PostConstruct
    public void init() {

        this.terrenoFacade = new TerrenoDAO(Terreno.class, mp.context());
    }

    public List<Terreno> obtenerTodos() {
        return this.terrenoFacade.find().asList();
    }

    public Terreno obtenerPorCodigo(ObjectId codigo) {
        return this.terrenoFacade.get(codigo);
    }

    public void crear(Terreno terreno) {
        List<Terreno> aux = this.terrenoFacade.find().asList();
        Integer codigo;
        if(aux.isEmpty())
        {
            codigo=1;
        }
        else{
        Integer count = aux.size();
        Terreno last = aux.get(count-1);
        codigo = last.getCodigo()+1;
        }
        terreno.setCodigo(codigo);
        this.terrenoFacade.save(terreno);
    }

    public void modificar(Terreno terreno) {
        Terreno aux = this.terrenoFacade.findOne("codigo", terreno.getCodigo());
        terreno.setId(aux.getId());
        this.terrenoFacade.save(terreno);
    }

    public void eliminar(ObjectId codigo) {
        Terreno terreno = this.terrenoFacade.get(codigo);
        this.terrenoFacade.delete(terreno);
    }
}

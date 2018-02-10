/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.CosechaDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
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
public class CosechaService {

    @EJB
    private MongoPersistence mp;
    private ActividadService actividadService;
    private CosechaDAO cosechaFacade;

    @PostConstruct
    public void init(){
    
        this.actividadService = new ActividadService();
        this.cosechaFacade = new CosechaDAO(Cosecha.class, mp.context());
    }
    public List<Cosecha> obtenerTodos() {
        return this.cosechaFacade.find().asList();
    }

    public Cosecha obtenerPorCodigo(ObjectId codigo) {
        return this.cosechaFacade.get(codigo);
    }

    public void crear(Cosecha cosecha) {
        List<Cosecha> aux = this.cosechaFacade.find().asList();
        Integer codigo;
        if(aux.isEmpty())
        {
            codigo=1;
        }
        else{
        Integer count = aux.size();
        Cosecha last = aux.get(count-1);
        codigo = last.getCodigo()+1;
        }
        cosecha.setCodigo(codigo);
        this.cosechaFacade.save(cosecha);
    }

    public void modificar(Cosecha cosecha) {
        Cosecha aux = this.cosechaFacade.findOne("codigo", cosecha.getCodigo());
        cosecha.setId(aux.getId());
        this.cosechaFacade.save(cosecha);
    }

    public void eliminar(ObjectId codigo) {
        Cosecha cosecha = this.cosechaFacade.get(codigo);
        this.cosechaFacade.delete(cosecha);
    }

//    public void generaActividad(Cosecha cosecha) {
//        Actividad actividad = new Actividad();
//        ActividadPK actividadPK = new ActividadPK();
//        Alarma alarma = new Alarma();
//        Date cal = cosecha.getFechaPlantacion();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(cal);
//        calendar.add(Calendar.DAY_OF_YEAR, 1);
//
//        if (cosecha.getCodTipoTerreno().equals("NUR")) {
//            //Creacion de actividad tipo riego
//            actividadPK.setCodTipoActividad("RIE");
//            actividad.setActividadPK(actividadPK);
//            actividad.setCodCosecha(cosecha.getCodigo());
//            actividad.setFechaUltimaEjecucion(calendar.getTime());
//            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
//            actividad.setEstado(ActividadEnum.NRE);
//            actividadService.crear(actividad);
//            //Creacion de actividad tipo cambio de terreno
//            actividad = new Actividad();
//            actividadPK = new ActividadPK();
//            actividadPK.setCodTipoActividad("CAM");
//            actividad.setActividadPK(actividadPK);
//            actividad.setCodCosecha(cosecha.getCodigo());
//            calendar.add(Calendar.MONTH, 7);
//            actividad.setFechaUltimaEjecucion(calendar.getTime());
//            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
//            actividad.setEstado(ActividadEnum.NRE);
//            actividadService.crear(actividad);
//        } else {
//            //Creacion de actividad tipo riego
//            actividad = new Actividad();
//            actividadPK = new ActividadPK();
//            actividadPK.setCodTipoActividad("RIE");
//            actividad.setActividadPK(actividadPK);
//            actividad.setCodCosecha(cosecha.getCodigo());
//            actividad.setFechaUltimaEjecucion(calendar.getTime());
//            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
//            actividad.setEstado(ActividadEnum.NRE);
//            actividadService.crear(actividad);
//            //Creacion de actividad tipo Deshierbado
//            actividad = new Actividad();
//            actividadPK = new ActividadPK();
//            actividadPK.setCodTipoActividad("DES");
//            actividad.setActividadPK(actividadPK);
//            actividad.setCodCosecha(cosecha.getCodigo());
//            calendar.add(Calendar.MONTH, 4);
//            actividad.setFechaUltimaEjecucion(calendar.getTime());
//            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
//            actividad.setEstado(ActividadEnum.NRE);
//            actividadService.crear(actividad);
//            //Creacion de actividad tipo Deshierbado
//            actividad = new Actividad();
//            actividadPK = new ActividadPK();
//            actividadPK.setCodTipoActividad("COS");
//            actividad.setActividadPK(actividadPK);
//            actividad.setCodCosecha(cosecha.getCodigo());
//            calendar.add(Calendar.MONTH, 6);
//            actividad.setFechaUltimaEjecucion(calendar.getTime());
//            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
//            actividad.setEstado(ActividadEnum.NRE);
//            actividadService.crear(actividad);
//        }
//    }
}

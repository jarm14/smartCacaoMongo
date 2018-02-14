/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.enums.ActividadEnum;
import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
import ec.edu.espe.distribuidas.smartCacao.model.TipoActividad;
import ec.edu.espe.distribuidas.smartCacao.service.ActividadService;
import ec.edu.espe.distribuidas.smartCacao.service.CosechaService;
import ec.edu.espe.distribuidas.smartCacao.service.TipoActividadService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.bson.types.ObjectId;

/**
 *
 * @author TMET
 */
@Named
@ViewScoped
public class ActividadBean extends BaseBean implements Serializable {

    private List<Actividad> actividades;
    private List<Actividad> actividadesDia;
    private Actividad actividad;
    private Actividad actividadSel;
    private TipoActividad tipoActividad;
    private List<TipoActividad> tiposActividad;
    //private ActividadPK actividadPK;
    private List<Cosecha> cosechas;
    private Cosecha cosecha;

    @Inject
    private ActividadService actividadService;

    @Inject
    private TipoActividadService tipoActividadService;

    @Inject
    CosechaService cosechaService;

    @PostConstruct
    public void init() {
        this.actividades = this.actividadService.obtenerTodos();
        this.actividad = new Actividad();
        this.tipoActividad = new TipoActividad();
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
        this.getActividadDia();
    }

    @Override
    public void agregar() {
        this.actividad = new Actividad();
        this.tipoActividad = new TipoActividad();
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        // this.actividadPK = new ActividadPK();
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
        super.agregar();
    }

    public void cancelar() {
        super.reset();
        this.actividad = new Actividad();
        this.tipoActividad = new TipoActividad();
        this.cosechas = this.cosechaService.obtenerTodos();
        // this.actividadPK = new ActividadPK();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.actividad = new Actividad();
        //this.actividadPK = new ActividadPK();
        this.actividad.setCodigo(this.actividadSel.getCodigo());
        this.tipoActividad = new TipoActividad();
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
        //this.actividad.setActividadPK(this.actividadSel.getActividadPK());
        this.actividad.setTipoActividad(this.actividadSel.getTipoActividad());
        //this.actividad.setCodCosecha(this.actividadSel.getCodCosecha());
        this.actividad.setCosecha(this.actividadSel.getCosecha());
        this.actividad.setNota(this.actividadSel.getNota());
        this.actividad.setFechaUltimaEjecucion(this.actividadSel.getFechaUltimaEjecucion());
        this.actividad.setEstado(this.actividadSel.getEstado());
    }

    public void eliminar() {
        try {
//            this.actividadService.eliminar(this.actividadSel.getActividadPK());
            this.actividadService.eliminar(new ObjectId(this.actividadSel.getId()));
            this.actividades = this.actividadService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.actividadSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void guardar() {
        try {

            if (this.enAgregar) {
                this.actividadService.crear(this.actividad);
                FacesUtil.addMessageInfo("Se agrego la Actividad: " + getActividadNombre(this.actividad));
            } else {
                this.actividadService.modificar(this.actividad);
                FacesUtil.addMessageInfo("Se modific\u00f3 la Actividad con c\u00f3digo: " + this.actividad.getId());
            }

        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.actividad = new Actividad();
        //this.actividadPK = new ActividadPK();
        this.tipoActividad = new TipoActividad();
        this.cosecha = new Cosecha();
        this.actividades = this.actividadService.obtenerTodos();
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        this.cosechas = this.cosechaService.obtenerTodos();

    }

    public String getActividadNombre(Actividad actividad) {
        String nombre = "null";
        TipoActividad aux = new TipoActividad();
        for (int i = 0; i < tiposActividad.size(); i++) {
            aux = tiposActividad.get(i);
            //if (aux.getCodigo().equals(actividad.getActividadPK().getCodTipoActividad())) {
            if (aux.getCodigo().equals(actividad.getTipoActividad())) {
                nombre = aux.getNombre();
            }
        }
        return nombre;
    }
    
    public String getEstadoNombre(Actividad actividad) {
        String nombre = "null";
        TipoActividad aux = new TipoActividad();
        for (int i = 0; i < tiposActividad.size(); i++) {
            aux = tiposActividad.get(i);
            //if (aux.getCodigo().equals(actividad.getActividadPK().getCodTipoActividad())) {
            if (aux.getCodigo().equals(actividad.getTipoActividad())) {
                nombre = aux.getNombre();
            }
        }
        return nombre;
    }

    
    
    
    public List<Actividad> getActividadDia() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        
        System.out.println("Calendar:" + cal.getTime());
        this.actividadesDia = new ArrayList<Actividad>();
        
        for(Actividad co: this.actividades){
            System.out.println("Fecha: "+co.getFechaUltimaEjecucion());
            if(co.getFechaUltimaEjecucion().toString().equals(cal.getTime().toString())&&!co.getEstado().toString().equals("REA")){
                System.out.println(co.getEstado());
                System.out.println("Hola");
                this.actividadesDia.add(co);
            }
        }
        //this.actividades = ;
        return actividadesDia;
    }

    public void realizarActividad() {

        //this.actividad.setActividadPK(actividadSel.getId());
        this.actividad = new Actividad();
        this.actividad.setId(actividadSel.getId());
        //this.actividad.setCodCosecha(actividadSel.getCodCosecha());
        this.actividad.setCodigo(actividadSel.getCodigo());
        this.actividad.setCosecha(String.valueOf(actividadSel.getCosecha()));
        this.actividad.setTipoActividad(actividadSel.getTipoActividad());
        this.actividad.setEstado(actividadSel.getEstado());
        this.actividad.setFechaUltimaEjecucion(this.actividadSel.getFechaUltimaEjecucion());
        this.actividad.setNota(this.actividadSel.getNota());
        this.actividadSel = null;
        this.realizaActividadd(actividad);
        this.actividades = this.actividadService.obtenerTodos();
        this.getActividadDia();
        //this.actividadService.realizaActividad(actividad);
        
    }
    
    public void realizaActividadd(Actividad actividad) {
        //ActividadPK actividadPK = new ActividadPK();
        //actividadPK = actividad.getActividadPK();
        Cosecha cose = new Cosecha();
        Date cal = actividad.getFechaUltimaEjecucion();
        Calendar calendar = Calendar.getInstance();
        Calendar calendarDia = Calendar.getInstance();
        calendarDia.setTime(cal);
        calendarDia.add(Calendar.DAY_OF_YEAR, 15);
        calendar.setTime(cal);
        Calendar calendarMes = Calendar.getInstance();
        calendarMes.setTime(cal);
        calendarMes.add(Calendar.MONTH, 7);
        //cosecha = cosechaService.buscarPorCodigo(actividad.getCosecha());
        //cosecha = this.cosechaFacade.findOne("codigo", actividad.getCosecha());
        
        System.out.println(actividad.getNota());
        //System.out.println(cosecha.getCodigo());
        
        for(Cosecha co: this.cosechas){
            if(co.getCodigo().toString().equals(actividad.getCosecha())){
                cose = co;
            }
        }
        
        System.out.println(cose.getCodigo());
        System.out.println(cose.getFechaPlantacion());
        
        if (actividad.getTipoActividad().equals("CAM")) {
            //Creacion de actividad tipo riego
            actividad.setEstado(ActividadEnum.REA);
            this.actividadService.modificar(actividad);
            cose.setTipoTerreno("PRO");
            this.cosechaService.modificar(cose);
            actividad = new Actividad();
            //actividadPK = new ActividadPK();
            actividad.setTipoActividad("RIE");
            //actividad.setActividadPK();
            actividad.setCosecha(cose.getCodigo().toString());
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cose.getCodigo() + ", Terreno: " + cose.getTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            this.actividadService.crear(actividad);
            //Creacion de actividad tipo Deshierbado
            actividad = new Actividad();
            //actividadPK = new ActividadPK();
            actividad.setTipoActividad("DES");
            //actividad.setActividadPK(actividadPK);
            actividad.setCosecha(cose.getCodigo().toString());
            calendar.add(Calendar.MONTH, 4);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cose.getCodigo() + ", Terreno: " + cose.getTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            this.actividadService.crear(actividad);
            //Creacion de actividad tipo Cosecha
            actividad = new Actividad();
            //actividadPK = new ActividadPK();
            actividad.setTipoActividad("COS");
            //actividad.setActividadPK(actividadPK);
            actividad.setCosecha(cose.getCodigo().toString());
            calendar.add(Calendar.YEAR, 3);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cose.getCodigo() + ", Terreno: " + cose.getTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            this.actividadService.crear(actividad);
        } else if (cose.getTipoTerreno().equals("NUR")) {
            if (actividad.getTipoActividad().equals("RIE") && calendar.before(calendarDia)) {
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                this.actividadService.modificar(actividad);
            } else if (actividad.getTipoActividad().equals("RIE") && calendar.before(calendarMes)) {
                calendar.add(Calendar.DAY_OF_YEAR, 2);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                this.actividadService.modificar(actividad);
            } else if (actividad.getTipoActividad().equals("RIE") && calendar.after(calendarMes)) {
                actividad.setEstado(ActividadEnum.REA);
                this.actividadService.modificar(actividad);
            }
        } else if (cose.getTipoTerreno().equals("PRO")) {
            if (actividad.getTipoActividad().equals("RIE")) {
                calendar.add(Calendar.DAY_OF_YEAR, 4);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                this.actividadService.modificar(actividad);
            } else if (actividad.getTipoActividad().equals("COS")) {
                calendar.add(Calendar.MONTH, 6);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                this.actividadService.modificar(actividad);
                Estadistica estadistica = new Estadistica();
                estadistica.setCosecha(cose.getCodigo().toString());
            } else if (actividad.getTipoActividad().equals("DES")) {
                calendar.add(Calendar.MONTH, 4);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                this.actividadService.modificar(actividad);
            }
        }
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Actividad getActividadSel() {
        return actividadSel;
    }

    public void setActividadSel(Actividad actividadSel) {
        this.actividadSel = actividadSel;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public List<TipoActividad> getTiposActividad() {
        return tiposActividad;
    }

//    public ActividadPK getActividadPK() {
//        return actividadPK;
//    }
//
//    public void setActividadPK(ActividadPK actividadPK) {
//        this.actividadPK = actividadPK;
//    }

    public List<Cosecha> getCosechas() {
        return cosechas;
    }

    public Cosecha getCosecha() {
        return cosecha;
    }

    public void setCosecha(Cosecha cosecha) {
        this.cosecha = cosecha;
    }

    public List<Actividad> getActividadesDia() {
        return actividadesDia;
    }
    
    
}

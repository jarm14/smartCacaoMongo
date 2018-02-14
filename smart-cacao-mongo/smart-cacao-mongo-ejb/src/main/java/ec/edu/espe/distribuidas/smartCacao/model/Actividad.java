/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import ec.edu.espe.distribuidas.smartCacao.enums.ActividadEnum;
import ec.edu.espe.distribuidas.smartCacao.mongo.BaseEntity;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author TMET
 */
@Entity(noClassnameStored = true, value = "actividad")
public class Actividad extends BaseEntity {

    private Integer codigo;
    //@Reference
    private String tipoActividad;
    private String nota;
    private Date fechaUltimaEjecucion;
    private ActividadEnum estado;
    //@Reference
    private String cosecha;

    public Actividad() {
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFechaUltimaEjecucion() {
        return fechaUltimaEjecucion;
    }

    public void setFechaUltimaEjecucion(Date fechaUltimaEjecucion) {
        this.fechaUltimaEjecucion = fechaUltimaEjecucion;
    }

    public ActividadEnum getEstado() {
        return estado;
    }

    public void setEstado(ActividadEnum estado) {
        this.estado = estado;
    }

    public String getCosecha() {
        return cosecha;
    }

    public void setCosecha(String cosecha) {
        this.cosecha = cosecha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Actividad{" + "codigo=" + codigo + ", tipoActividad=" + tipoActividad + ", nota=" + nota + ", fechaUltimaEjecucion=" + fechaUltimaEjecucion + ", estado=" + estado + ", cosecha=" + cosecha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.id != null ? super.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }
}

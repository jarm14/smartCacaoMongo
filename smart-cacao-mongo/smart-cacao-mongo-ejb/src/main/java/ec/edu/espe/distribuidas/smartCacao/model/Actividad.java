/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import ec.edu.espe.distribuidas.smartCacao.enums.ActividadEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "ACTIVIDAD")
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @EmbeddedId
    protected ActividadPK actividadPK;
    @Column(name = "NOTA", length = 512)
    private String nota;
    
    @Column(name = "FECHA_ULTIMA_EJECUCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaEjecucion;
    
   @Enumerated(EnumType.STRING)
    private ActividadEnum estado;
    
    @Column(name = "COD_COSECHA")
    private Integer codCosecha;

    public Actividad() {
    }

    public Actividad(ActividadPK actividadPK) {
        this.actividadPK = actividadPK;
    }

    public Actividad(ActividadPK actividadPK, Date fechaUltimaEjecucion, ActividadEnum estado) {
        this.actividadPK = actividadPK;
        this.fechaUltimaEjecucion = fechaUltimaEjecucion;
        this.estado = estado;
    }

    public Actividad(int codActividad, String codTipoActividad) {
        this.actividadPK = new ActividadPK(codActividad, codTipoActividad);
    }

    public ActividadPK getActividadPK() {
        return actividadPK;
    }

    public void setActividadPK(ActividadPK actividadPK) {
        this.actividadPK = actividadPK;
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

    public Integer getCodCosecha() {
        return codCosecha;
    }

    public void setCodCosecha(Integer codCosecha) {
        this.codCosecha = codCosecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadPK != null ? actividadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actividadPK == null && other.actividadPK != null) || (this.actividadPK != null && !this.actividadPK.equals(other.actividadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Actividad[ actividadPK=" + actividadPK + " ]";
    }   
}

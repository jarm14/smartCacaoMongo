/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author TMET
 */
@Embeddable
public class ActividadPK implements Serializable {

    @Column(name = "COD_ACTIVIDAD", nullable = false)
    private int codActividad;
    
    @Column(name = "COD_TIPO_ACTIVIDAD", length = 10, nullable = false)
    private String codTipoActividad;

    public ActividadPK() {
    }

    public ActividadPK(int codActividad, String codTipoActividad) {
        this.codActividad = codActividad;
        this.codTipoActividad = codTipoActividad;
    }

    public int getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(int codActividad) {
        this.codActividad = codActividad;
    }

    public String getCodTipoActividad() {
        return codTipoActividad;
    }

    public void setCodTipoActividad(String codTipoActividad) {
        this.codTipoActividad = codTipoActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codActividad;
        hash += (codTipoActividad != null ? codTipoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadPK)) {
            return false;
        }
        ActividadPK other = (ActividadPK) object;
        if (this.codActividad != other.codActividad) {
            return false;
        }
        if ((this.codTipoActividad == null && other.codTipoActividad != null) || (this.codTipoActividad != null && !this.codTipoActividad.equals(other.codTipoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.ActividadPK[ codActividad=" + codActividad + ", codTipoActividad=" + codTipoActividad + " ]";
    } 
}

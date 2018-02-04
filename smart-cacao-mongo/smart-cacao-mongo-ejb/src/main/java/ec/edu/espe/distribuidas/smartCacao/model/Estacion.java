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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "ESTACION")
public class Estacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EstacionPK estacionPK;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 512)
    private String descripcion;

    public Estacion() {
    }

    public Estacion(EstacionPK estacionPK) {
        this.estacionPK = estacionPK;
    }

    public Estacion(EstacionPK estacionPK, String nombre) {
        this.estacionPK = estacionPK;
        this.nombre = nombre;
    }

    public Estacion(String codEstacion, int codMes) {
        this.estacionPK = new EstacionPK(codEstacion, codMes);
    }

    public EstacionPK getEstacionPK() {
        return estacionPK;
    }

    public void setEstacionPK(EstacionPK estacionPK) {
        this.estacionPK = estacionPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estacionPK != null ? estacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacion)) {
            return false;
        }
        Estacion other = (Estacion) object;
        if ((this.estacionPK == null && other.estacionPK != null) || (this.estacionPK != null && !this.estacionPK.equals(other.estacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Estacion[ estacionPK=" + estacionPK + " ]";
    }
}

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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "ALARMA")
public class Alarma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ALARMA", nullable = false)
    private Integer codigo;

    @Column(name = "DESCRIPCION", length = 512)
    private String descripcion;

    @Column(name = "COD_ACTIVIDAD")
    private Integer codActividad;
    
    @Column(name = "COD_TIPO_ACTIVIDAD", length = 10)
    private String codTipoActividad;

    public Alarma() {
    }

    public Alarma(Integer codAlarma) {
        this.codigo = codAlarma;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codAlarma) {
        this.codigo = codAlarma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(Integer actividad) {
        this.codActividad = actividad;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alarma)) {
            return false;
        }
        Alarma other = (Alarma) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Alarma[ codAlarma=" + codigo + " ]";
    }
}

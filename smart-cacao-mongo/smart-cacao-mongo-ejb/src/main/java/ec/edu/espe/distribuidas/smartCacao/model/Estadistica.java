/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import ec.edu.espe.distribuidas.smartCacao.mongo.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author TMET
 */
@Entity(noClassnameStored = true, value = "estadistica")
public class Estadistica extends BaseEntity {

    private Integer codigo;
    private Date fechaUltimaCosecha;
    private BigDecimal numeroArboles;
    private BigDecimal totalKilos;
    //@Reference
    private String cosecha;

    public Estadistica() {
    }

    public Date getFechaUltimaCosecha() {
        return fechaUltimaCosecha;
    }

    public void setFechaUltimaCosecha(Date fechaUltimaCosecha) {
        this.fechaUltimaCosecha = fechaUltimaCosecha;
    }

    public BigDecimal getNumeroArboles() {
        return numeroArboles;
    }

    public void setNumeroArboles(BigDecimal numeroArboles) {
        this.numeroArboles = numeroArboles;
    }

    public BigDecimal getTotalKilos() {
        return totalKilos;
    }

    public void setTotalKilos(BigDecimal totalKilos) {
        this.totalKilos = totalKilos;
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
        return "Estadistica{" + "codigo=" + codigo + ", fechaUltimaCosecha=" + fechaUltimaCosecha + ", numeroArboles=" + numeroArboles + ", totalKilos=" + totalKilos + ", cosecha=" + cosecha + '}';
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
        if (!(object instanceof Estadistica)) {
            return false;
        }
        Estadistica other = (Estadistica) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }
}

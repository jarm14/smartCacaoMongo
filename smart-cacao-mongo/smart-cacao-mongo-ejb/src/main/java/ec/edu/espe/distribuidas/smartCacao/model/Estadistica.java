/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "ESTADISTICA")
public class Estadistica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ESTADISTICA", nullable = false)
    private Integer codigo;

    @Column(name = "FECHA_ULTIMA_COSECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaCosecha;

    @Column(name = "NUMERO_ARBOLES", precision = 5, scale = 0, nullable = false)
    private BigDecimal numeroArboles;

    @Column(name = "TOTAL_KILOS", precision = 8, scale = 2, nullable = false)
    private BigDecimal totalKilos;

    @Column(name = "COD_COSECHA")
    private Integer codCosecha;

    public Estadistica() {
    }

    public Estadistica(Integer codEstadistica) {
        this.codigo = codEstadistica;
    }

    public Estadistica(Integer codEstadistica, Date fechaUltimaCosecha, BigDecimal numeroArboles, BigDecimal totalKilos) {
        this.codigo = codEstadistica;
        this.fechaUltimaCosecha = fechaUltimaCosecha;
        this.numeroArboles = numeroArboles;
        this.totalKilos = totalKilos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codEstadistica) {
        this.codigo = codEstadistica;
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

    public Integer getCodCosecha() {
        return codCosecha;
    }

    public void setCodCosecha(Integer codCosecha) {
        this.codCosecha = codCosecha;
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
        if (!(object instanceof Estadistica)) {
            return false;
        }
        Estadistica other = (Estadistica) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Estadistica[ codEstadistica=" + codigo + " ]";
    }
}

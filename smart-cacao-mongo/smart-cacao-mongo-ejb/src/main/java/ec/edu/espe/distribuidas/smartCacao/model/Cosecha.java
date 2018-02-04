/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
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
@Table(name = "COSECHA")
public class Cosecha implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COSECHA", nullable = false)
    private Integer codigo;

    @Column(name = "FECHA_PLANTACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPlantacion;

    @Column(name = "COD_TERRENO", nullable = false)
    private Integer codTerreno;
    
    @Column(name = "COD_TIPO_TERRENO", length = 10, nullable = false)
    private String codTipoTerreno;

    public Cosecha() {
    }

    public Cosecha(Integer codCosecha) {
        this.codigo = codCosecha;
    }

    public Cosecha(Integer codCosecha, Date fechaPlantacion) {
        this.codigo = codCosecha;
        this.fechaPlantacion = fechaPlantacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codCosecha) {
        this.codigo = codCosecha;
    }

    public Date getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(Date fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public Integer getCodTerreno() {
        return codTerreno;
    }

    public void setCodTerreno(Integer terreno) {
        this.codTerreno = terreno;
    }

    public String getCodTipoTerreno() {
        return codTipoTerreno;
    }

    public void setCodTipoTerreno(String codTipoTerreno) {
        this.codTipoTerreno = codTipoTerreno;
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
        if (!(object instanceof Cosecha)) {
            return false;
        }
        Cosecha other = (Cosecha) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Cosecha[ codCosecha=" + codigo + " ]";
    }  
}

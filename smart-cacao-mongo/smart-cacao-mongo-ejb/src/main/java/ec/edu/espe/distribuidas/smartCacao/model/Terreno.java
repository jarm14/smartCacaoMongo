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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "TERRENO")
public class Terreno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TerrenoPK terrenoPK;

    @Column(name = "DESCRIPCION", length = 512)
    private String descripcion;

    @Column(name = "ANCHO", precision = 8, scale = 2, nullable = false)
    private BigDecimal ancho;

    @Column(name = "LARGO", precision = 8, scale = 2, nullable = false)
    private BigDecimal largo;

    @Column(name = "COD_REGION", length = 10, nullable = false)
    private String codRegion;

    public Terreno() {
    }

    public Terreno(TerrenoPK terrenoPK) {
        this.terrenoPK = terrenoPK;
    }

    public Terreno(TerrenoPK terrenoPK, BigDecimal ancho, BigDecimal largo) {
        this.terrenoPK = terrenoPK;
        this.ancho = ancho;
        this.largo = largo;
    }

    public Terreno(int codTerreno, String codTipoTerreno) {
        this.terrenoPK = new TerrenoPK(codTerreno, codTipoTerreno);
    }

    public TerrenoPK getTerrenoPK() {
        return terrenoPK;
    }

    public void setTerrenoPK(TerrenoPK terrenoPK) {
        this.terrenoPK = terrenoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal largo) {
        this.largo = largo;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (terrenoPK != null ? terrenoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terreno)) {
            return false;
        }
        Terreno other = (Terreno) object;
        if ((this.terrenoPK == null && other.terrenoPK != null) || (this.terrenoPK != null && !this.terrenoPK.equals(other.terrenoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Terreno[ terrenoPK=" + terrenoPK + " ]";
    }
}

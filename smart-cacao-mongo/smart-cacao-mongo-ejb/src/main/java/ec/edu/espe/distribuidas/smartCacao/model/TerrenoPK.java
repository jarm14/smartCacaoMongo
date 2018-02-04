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
public class TerrenoPK implements Serializable {

    @Column(name = "COD_TERRENO", nullable = false)
    private int codTerreno;

    @Column(name = "COD_TIPO_TERRENO", length = 10, nullable = false)
    private String codTipoTerreno;

    public TerrenoPK() {
    }

    public TerrenoPK(int codTerreno, String codTipoTerreno) {
        this.codTerreno = codTerreno;
        this.codTipoTerreno = codTipoTerreno;
    }

    public int getCodTerreno() {
        return codTerreno;
    }

    public void setCodTerreno(int codTerreno) {
        this.codTerreno = codTerreno;
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
        hash += (int) codTerreno;
        hash += (codTipoTerreno != null ? codTipoTerreno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TerrenoPK)) {
            return false;
        }
        TerrenoPK other = (TerrenoPK) object;
        if (this.codTerreno != other.codTerreno) {
            return false;
        }
        if ((this.codTipoTerreno == null && other.codTipoTerreno != null) || (this.codTipoTerreno != null && !this.codTipoTerreno.equals(other.codTipoTerreno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.TerrenoPK[ codTerreno=" + codTerreno + ", codTipoTerreno=" + codTipoTerreno + " ]";
    }
}

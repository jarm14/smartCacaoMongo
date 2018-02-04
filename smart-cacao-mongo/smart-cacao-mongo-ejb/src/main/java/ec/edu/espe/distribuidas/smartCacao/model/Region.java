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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "REGION")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_REGION", length = 10, nullable = false)
    private String codigo;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "COD_ESTACION", length = 10)
    private String codEstacion;

    @Column(name = "COD_MES", length = 10)
    private Integer codMes;

    public Region() {
    }

    public Region(String codRegion) {
        this.codigo = codRegion;
    }

    public Region(String codRegion, String nombre) {
        this.codigo = codRegion;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codRegion) {
        this.codigo = codRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodEstacion() {
        return codEstacion;
    }

    public Integer getCodMes() {
        return codMes;
    }

    public void setCodMes(Integer codMes) {
        this.codMes = codMes;
    }

    public void setCodEstacion(String estacion) {
        this.codEstacion = estacion;
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
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Region[ codRegion=" + codigo + " ]";
    }
}

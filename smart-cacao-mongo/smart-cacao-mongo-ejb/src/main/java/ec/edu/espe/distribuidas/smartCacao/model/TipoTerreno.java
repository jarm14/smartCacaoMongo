/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import ec.edu.espe.distribuidas.smartCacao.mongo.BaseEntity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

/**
 *
 * @author TMET
 */
//@Embedded
@Entity(noClassnameStored = true, value = "tipoTerreno")
public class TipoTerreno extends BaseEntity {

    @Indexed(options = @IndexOptions(name = "tipoTerreno_codigoUIdx", unique = true))
    private String codigo;
    private String nombre;
    private String descripcion;

    public TipoTerreno() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codTipoTerreno) {
        this.codigo = codTipoTerreno;
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
    public String toString() {
        return "TipoTerreno{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
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
        if (!(object instanceof TipoTerreno)) {
            return false;
        }
        TipoTerreno other = (TipoTerreno) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }
}

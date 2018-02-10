/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import ec.edu.espe.distribuidas.smartCacao.enums.TipoUsuarioEnum;
import ec.edu.espe.distribuidas.smartCacao.mongo.BaseEntity;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author TMET
 */
@Embedded
public class TipoUsuario extends BaseEntity {

    private Integer codigo;
    private TipoUsuarioEnum tipo;
    private String descripcion;

    public TipoUsuario() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codTipoUsuario) {
        this.codigo = codTipoUsuario;
    }

    public TipoUsuarioEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuarioEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "codigo=" + codigo + ", tipo=" + tipo + ", descripcion=" + descripcion + '}';
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
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }
}

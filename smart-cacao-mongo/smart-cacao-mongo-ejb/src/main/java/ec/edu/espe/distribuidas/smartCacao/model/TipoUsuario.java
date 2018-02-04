/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import ec.edu.espe.distribuidas.smartCacao.enums.TipoUsuarioEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TIPO_USUARIO", nullable = false)
    private Integer codigo;

    @Enumerated(EnumType.STRING)
    private TipoUsuarioEnum tipo;

    @Column(name = "DESCRIPCION", length = 512, nullable = false)
    private String descripcion;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer codTipoUsuario) {
        this.codigo = codTipoUsuario;
    }

    public TipoUsuario(Integer codTipoUsuario, TipoUsuarioEnum tipo, String descripcion) {
        this.codigo = codTipoUsuario;
        this.tipo = tipo;
        this.descripcion = descripcion;
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
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.TipoUsuario[ codTipoUsuario=" + codigo + " ]";
    }
}

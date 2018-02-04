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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codigo;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", length = 100, nullable = false)
    private String apellido;

    @Column(name = "PASSWORD", length = 512, nullable = false)
    private String password;

    @Column(name = "TELEFONO", length = 14, nullable = false)
    private String telefono;

    @Column(name = "EMAIL", length = 256, nullable = false)
    private String email;

    @JoinColumn(name = "COD_TIPO_USUARIO", referencedColumnName = "COD_TIPO_USUARIO")
    @ManyToOne
    private TipoUsuario codTipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer codUsuario) {
        this.codigo = codUsuario;
    }

    public Usuario(Integer codUsuario, String nombre, String apellido, String password, String telefono, String email) {
        this.codigo = codUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codUsuario) {
        this.codigo = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public void setCodTipoUsuario(TipoUsuario codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Usuario[ codUsuario=" + codigo + " ]";
    }
}

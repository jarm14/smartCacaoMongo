/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Usuario;
import ec.edu.espe.distribuidas.smartCacao.service.AutenticacionService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class IndexBean implements Serializable{
    
    private String email;
    private String clave;
    
    @Inject
    private AutenticacionService autenticacionService;
    @Inject 
    private UsuarioSesionBean usuarioSessionBean;
    
    public String login() {
        Usuario usuario = this.autenticacionService.login(this.email, this.clave);
        if (usuario!=null) {
            this.usuarioSessionBean.setUsuario(usuario);
            return "menu";
        } else {
            FacesUtil.addMessageError(null, "Los datos ingresados son incorrectos");
            return "index";
        }
    }
    
    public String logout() {
        this.usuarioSessionBean.setUsuario(null);
        return "index";
    }

    public String getCodigoUsuario() {
        return email;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.email = codigoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
}

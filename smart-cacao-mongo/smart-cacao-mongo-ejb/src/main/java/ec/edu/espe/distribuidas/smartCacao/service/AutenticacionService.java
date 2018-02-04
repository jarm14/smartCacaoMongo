/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.smartCacao.model.Usuario;
import ec.edu.espe.distribuidas.smartCacao.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author TMET
 */
@LocalBean
@Stateless
public class AutenticacionService {
    
    @EJB
    private MongoPersistence mp;
    private UsuarioDAO usuarioFacade;
    
    @PostConstruct
    public void init() {

        this.usuarioFacade = new UsuarioDAO(Usuario.class, mp.context());
    }
    
    public Usuario login(String email, String clave) {
        List<Usuario> usuarios = this.usuarioFacade.find().asList();
        
        Usuario usuario = new Usuario();
        Usuario aux;
        
        for(int i = 0; i<usuarios.size(); i++)
        {
            aux = new Usuario();
            aux= usuarios.get(i);
            if(aux.getEmail().equals(email))
            {
                usuario = aux;
            }
        }
            
        if (usuario!=null && usuario.getPassword().equals(clave)) {
            return usuario;
        } else {
            return null;
        }
    }
}

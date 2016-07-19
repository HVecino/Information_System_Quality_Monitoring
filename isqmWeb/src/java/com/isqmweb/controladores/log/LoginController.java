/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.controladores.log;

import com.isqmweb.entities.Usuario;
import com.isqmweb.factories.UsuarioFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ferchito
 */
@Named(value = "loginController1")
@RequestScoped
public class LoginController {
    
    @EJB
    private UsuarioFacade uFacade;
    private String documento;
    private String contrasena;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
     public String iniciarSesion(){
        String url = "";
        Usuario u = uFacade.login(documento, contrasena);
        if(u != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogin", u);
            url = "protegido/index.xhtml";
        } else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!!!", "Documento y/o contraseña no son validas.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        return url;
    }

}

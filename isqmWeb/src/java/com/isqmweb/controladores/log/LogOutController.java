/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.controladores.log;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ferchito
 */
@Named(value = "logOutController")
@RequestScoped
public class LogOutController {

    /**
     * Creates a new instance of LogOutController
     */
    public LogOutController() {
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioLogin");
        String path = FacesContext.getCurrentInstance().
                getExternalContext().getRequestContextPath();
        return path + "/isqmWeb/faces/login.xhtml";
    }
    
}

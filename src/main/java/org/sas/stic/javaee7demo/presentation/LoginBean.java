/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Controlador para login
 * @author angelmiralles
 */
@ManagedBean
@RequestScoped
public class LoginBean extends BaseBean implements Serializable {
    
    /**
     * Metodo para autenticar
     * @return 
     */
    public String authentication(){
        try {
            // Inyectamos spring security en contexto
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
            dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}

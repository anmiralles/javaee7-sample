package org.sas.stic.javaee7demo.presentation;

import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.sas.stic.javaee7demo.business.security.boundary.Users;
import org.sas.stic.javaee7demo.business.security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author angelmiralles
 */
public class BaseBean implements Serializable {
    
    /**
    * Constants
    */
    protected final ResourceBundle msg = ResourceBundle.getBundle("messages");
    protected final ResourceBundle rsc = ResourceBundle.getBundle("images");
    
    @Inject
    private Users users;
    
    /**
     * Metodo para obtener usuario logado
     * @return 
     */
    public User getUser() {
        String strUser;
        User u = new User();

        try{
            if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails){
                // Recojemos objeto spring security
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();			

                // Usuario logado
                strUser = ((UserDetails)principal).getUsername();

                // Consultamos bbdd
                u = users.findByUser(strUser);
            } else {
                u = null;
            }
        } catch(Exception e){
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return u;
    }
    
    /**
     * Metodo para obtener permiso asociado al usuario
     * @return 
     */
    public String getRole(){
        String strRole="";
        Collection<GrantedAuthority> lstPersmissions;

        try{
            if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails){
                // Recojemos objeto spring security
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();			

                // Roles asignados
                lstPersmissions = (Collection<GrantedAuthority>)((UserDetails)principal).getAuthorities();
                
                strRole = lstPersmissions.toString();
                
            } 
        } catch(Exception e){
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return strRole;
    }
    
    /**
     * Metodo para obtener el contexto de jsf
     * @return 
     */
    public FacesContext getFacesContext() {
            return FacesContext.getCurrentInstance();
    }
    
    /**
    * Metodo para obtener ELResolver
    * @return
    */
    public ELResolver getELResolver(){
           return getFacesContext().getELContext().getELResolver();
    }
    
    /**
     * Metodo para cambiar idioma
     * @param event 
     */
    public void changeLocale(ActionEvent event) {
        // Obtenemos el idioma seleccionado
        Locale locale = new Locale(getParameter("locale"));
        
        getFacesContext().getViewRoot().setLocale(locale);
        
    }
    
    /**
     * Metodo para obtener parametro del request
     * @param name
     * @return 
     */
    public String getParameter(String name) {
            return getRequest().getParameter(name);
    }
    
    /**
     * Metodo para obtener contexto request
     * @return 
     */
    public HttpServletRequest getRequest() {
            return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }
    
    /**
     * Metodo para cerra sesion
     * @return 
     */
    public String closeSession() {
        // Eliminamos sesion
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        // Eliminamos seguridad
        SecurityContextHolder.clearContext();

        // Mensaje avisando a usuario
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, this.msg.getString("info_cerrar_sesion_ok"), null));
        
        return "login";
    }
}

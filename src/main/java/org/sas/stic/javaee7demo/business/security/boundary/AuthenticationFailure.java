package org.sas.stic.javaee7demo.business.security.boundary;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * Clase para manejar fallo de autenticacion
 * @author angelmiralles
 */
public class AuthenticationFailure implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		
            request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, ex);
		
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"error de logado", null));
            response.sendRedirect("/javaee7-sample/faces/pages/login/login.xhtml");
	}

}

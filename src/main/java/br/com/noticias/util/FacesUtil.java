package br.com.noticias.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	public static void addErrorMessage(String message) {
		apresentarMensagem(FacesMessage.SEVERITY_ERROR, message);
	}
	
	public static void addInfoMessage(String message) {
		apresentarMensagem(FacesMessage.SEVERITY_INFO, message);
	}
	
	public static void addWarnMessage(String message) {
		apresentarMensagem(FacesMessage.SEVERITY_WARN, message);
	}
	
	private static void apresentarMensagem(Severity severity, String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(severity, message, message));
	}
	
}
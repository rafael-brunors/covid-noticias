package br.com.noticias.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

@Scope(WebApplicationContext.SCOPE_REQUEST)
@Controller
public class FormatDateBean implements Serializable {
	private static final long serialVersionUID = -8302941175524602658L;

	/**
	 * Formato: dd/MM/yyyy HH:mm:ss
	 */
	public String format(LocalDateTime date) {
		if(date != null)
			return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

		return null;
	}
	
}
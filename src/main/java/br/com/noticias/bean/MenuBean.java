package br.com.noticias.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import br.com.noticias.enun.Pagina;

@Scope(WebApplicationContext.SCOPE_REQUEST)
@Controller
public class MenuBean implements Serializable {
	
	private static final long serialVersionUID = 1618675730611836625L;
	
	private Pagina index = Pagina.INDEX;
	private Pagina noticias = Pagina.NOTICIAS;
	private Pagina cadastroNoticiasLista = Pagina.CADASTRO_NOTICIAS_LISTA;
	
	public Pagina getIndex() {
		return index;
	}

	public Pagina getNoticias() {
		return noticias;
	}

	public Pagina getCadastroNoticiasLista() {
		return cadastroNoticiasLista;
	}

}

package br.com.noticias.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import br.com.noticias.enun.Pagina;
import br.com.noticias.model.Noticia;
import br.com.noticias.service.NoticiaService;

@Scope(WebApplicationContext.SCOPE_REQUEST)
@Controller
public class CadastroNoticiaListaBean implements Serializable {
	
	private static final long serialVersionUID = -1360634057798561387L;

	private List<Noticia> noticias;
	private List<Noticia> filtradas;
	
	@Autowired
	private NoticiaService noticiaService;
	
	@PostConstruct
	public void init() {
		noticias = noticiaService.findAll();
	}
	
	public String navegarParaCadastro() {
		return Pagina.CADASTRO_NOTICIAS.getDiretorio();
	}
	
	public List<Noticia> getNoticias() {
		return noticias;
	}

	public List<Noticia> getFiltradas() {
		return filtradas;
	}

	public void setFiltradas(List<Noticia> filtradas) {
		this.filtradas = filtradas;
	}

}

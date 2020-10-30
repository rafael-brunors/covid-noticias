package br.com.noticias.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import br.com.noticias.enun.Pagina;
import br.com.noticias.model.Noticia;
import br.com.noticias.service.NoticiaService;
import br.com.noticias.util.FacesUtil;
import br.com.noticias.util.MensagemUtil;

@Scope(WebApplicationContext.SCOPE_REQUEST)
@Controller
public class CadastroNoticiaBean implements Serializable {
	
	private static final long serialVersionUID = -1360634057798561387L;

	private Noticia noticia;
	
	@Autowired
	private NoticiaService noticiaService;
	
	@PostConstruct
	private void init() {
		String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		
		if(param != null)
			param = param.replaceAll("[^0-9]", "");
		
		if(StringUtils.isNotBlank(param))
			noticia = noticiaService.findById(Integer.parseInt(param));
		else
			noticia = new Noticia();
	}
	
	public String salvar() {
		int id = noticia.getId();
		noticiaService.saveOrUpdate(noticia);
		init();
		if(id == 0) {
			init();
			FacesUtil.addInfoMessage(MensagemUtil.getMensagem("info_salvo"));
			return null;
		} else
			return navegarParaLista();
	}
	
	public String excluir() {
		noticiaService.delete(noticia);
		return navegarParaLista();
	}
	
	public String navegarParaLista() {
		return Pagina.CADASTRO_NOTICIAS_LISTA.getDiretorio() + "?faces-redirect=true";
	}
	
	public Noticia getNoticia() {
		return noticia;
	}
	
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
}

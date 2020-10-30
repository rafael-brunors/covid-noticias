package br.com.noticias.enun;

public enum Pagina {
	
	INDEX("Página Inicial", "/index.xhtml", "index.xhtml"),
	CADASTRO_NOTICIAS_LISTA("Notícias", "/sistema/CadastroNoticiaLista.xhtml", "CadastroNoticiaLista.xhtml"),
	CADASTRO_NOTICIAS("Cadastro de Notícias", "/sistema/CadastroNoticia.xhtml", "CadastroNoticia.xhtml"),
	NOTICIAS("Notícias", "/sistema/Noticias.xhtml", "Noticias.xhtml");
	
	private String nome;
	private String diretorio;
	private String pagina;
	
	private Pagina(String nome, String diretorio, String pagina) {
		this.nome = nome;
		this.diretorio = diretorio;
		this.pagina = pagina;
	}

	public String getNome() {
		return nome;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public String getPagina() {
		return pagina;
	}
	
}

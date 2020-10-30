package br.com.noticias.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.noticias.enun.Pagina;

@Configuration
@EnableAutoConfiguration
public class ApplicationConfig extends WebMvcConfigurerAdapter  {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("forward:" + Pagina.INDEX.getDiretorio());
	}
}

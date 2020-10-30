package br.com.noticias;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CovidNoticiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidNoticiasApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> jsfServletRegistration(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

		// FacesServlet registration
		ServletRegistrationBean<FacesServlet> srb = new ServletRegistrationBean<>();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList("*.xhtml"));
		srb.setLoadOnStartup(1);
		return srb;
	}

	@Bean
	public ServletContextInitializer initializer() {
		return new ServletContextInitializer() {

			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.setInitParameter("primefaces.THEME", "bootstrap");
			}
		};
	}

}

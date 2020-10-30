package br.com.noticias.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noticias.model.Noticia;
import br.com.noticias.repository.NoticiaRepository;

@Service
public class NoticiaService {
	
	@Autowired
	private NoticiaRepository noticiaRepository;
	
	public Noticia saveOrUpdate(Noticia model) {
		if(model.getId() == 0)
			model.setDataCriacao(LocalDateTime.now());
		else {
			Noticia modelBD = findById(model.getId());
			model.setDataCriacao(modelBD.getDataCriacao());
			model.setDataAtualizacao(LocalDateTime.now());
		}
		
		return noticiaRepository.save(model);
	}
	
	public List<Noticia> findAll() {
		return noticiaRepository.findAll();
	}

	public Noticia findById(Integer id) {
		Optional<Noticia> noticia = noticiaRepository.findById(id);
		if(noticia.isPresent())
			return noticia.get();
		else
			return new Noticia();
	}

	public void delete(Noticia noticia) {
		noticiaRepository.delete(noticia);
	}
}

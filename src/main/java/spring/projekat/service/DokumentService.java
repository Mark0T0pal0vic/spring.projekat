package spring.projekat.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.projekat.model.Dokument;
import spring.projekat.repository.DokumentRepository;


@Service
@Transactional
public class DokumentService {

	@Autowired
	DokumentRepository dokumentRepository;
	
	@Autowired
	Stavka_DokumentaService sdService;
	
	public Iterable<Dokument> findAll(){
		return dokumentRepository.findAll();
	}
	
	public Dokument findOne(Long id) {
		return dokumentRepository.findById(id).orElse(null);
	}
	
	public Dokument save(Dokument dokument) {
		return dokumentRepository.save(dokument);
	}
	
	public void remove(Long id) {
		if (sdService.findByDokumentId(id).isEmpty()) {
			dokumentRepository.deleteById(id);
		}
	
	}
}

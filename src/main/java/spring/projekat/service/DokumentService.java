package spring.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.projekat.model.Dokument;
import spring.projekat.repository.DokumentRepository;

@Service
public class DokumentService {

	@Autowired
	DokumentRepository dokumentRepository;
	
	@Autowired
	Stavka_DokumentaService sdService;
	
	public List<Dokument> findAll(){
		return dokumentRepository.findAll();
	}
	
	public Dokument findOne(Long id) {
		return dokumentRepository.findById(id).orElse(null);
	}
	
	public Dokument save(Dokument dokument) {
		return dokumentRepository.save(dokument);
	}
	
	public void remove(Long id) {
		//dozvoliti brisanje predmeta koji nemaju Stavka_Dokumenta!!!!
		if (sdService.findByDokumentId(id).isEmpty()) {
			dokumentRepository.deleteById(id);
		}
		
	}
	
}

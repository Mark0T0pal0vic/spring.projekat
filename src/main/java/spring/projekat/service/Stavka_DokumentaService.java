package spring.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.projekat.model.Stavka_Dokumenta;
import spring.projekat.repository.Stavka_DokumentaRepository;

@Service
public class Stavka_DokumentaService {
	
	
	@Autowired
	Stavka_DokumentaRepository sdRepository;
	
	public List<Stavka_Dokumenta> findAll(){
		return sdRepository.findAll();
	}
	
	public Stavka_Dokumenta findOne(Long id) {
		return sdRepository.findById(id).orElse(null);
	}
	
	public Stavka_Dokumenta save(Stavka_Dokumenta sd) {
		return sdRepository.save(sd);
	}
	
	public void remove(Long id) {
		sdRepository.deleteById(id);
	}
	
	public List<Stavka_Dokumenta> findByRobaId(Long robaId){
		return sdRepository.findByRobaId(robaId);
	}
	
	public List<Stavka_Dokumenta> findByDokumentId(Long dokumentId){
		return sdRepository.findByRobaId(dokumentId);
	}
}

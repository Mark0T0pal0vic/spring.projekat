package spring.projekat.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.projekat.model.Roba;
import spring.projekat.repository.RobaRepository;

@Service
@Transactional
public class RobaService {

	
	@Autowired
	RobaRepository robaRepository;
	
	@Autowired
	Stavka_DokumentaService sdService;
	
	public Iterable<Roba> findAll(){
		return robaRepository.findAll();
	}
	
	public Roba findOne(Long id) {
		return robaRepository.findById(id).orElse(null);
	}
	
	public Roba save(Roba roba) {
		return robaRepository.save(roba);
	}
	
	public void remove(Long id) {
		if (sdService.findByRobaId(id).isEmpty()) {
			robaRepository.deleteById(id);
		}
		
	}
}

package spring.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.projekat.model.Roba;
import spring.projekat.repository.RobaRepository;

@Service
public class RobaService {

	//NIJE ZAVRSENO!!!!!
	@Autowired
	RobaRepository robaRepository;
	
	public List<Roba> findAll(){
		return robaRepository.findAll();
	}
	
	public Roba findOne(Long id) {
		return robaRepository.findById(id).orElse(null);
	}
	
	public Roba save(Roba roba) {
		return robaRepository.save(roba);
	}
	
	public void remove(Long id) {
		//dozvoliti brisanje predmeta koji nemaju Stavka_Dokumenta!!!!
		robaRepository.deleteById(id);
	}
}

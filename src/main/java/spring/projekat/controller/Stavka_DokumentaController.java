package spring.projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import spring.projekat.model.Dokument;
import spring.projekat.model.Roba;
import spring.projekat.model.Stavka_Dokumenta;
import spring.projekat.service.DokumentService;
import spring.projekat.service.RobaService;
import spring.projekat.service.Stavka_DokumentaService;

@RestController
@RequestMapping("/api/")
public class Stavka_DokumentaController {

	@Autowired
	Stavka_DokumentaService sdService;
	
	@Autowired
	RobaService robaService;
	
	@Autowired
	DokumentService dokumentService;
	
	//GET/ALL
	@GetMapping(value = "stavkaDokumentas", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Stavka_Dokumenta>> getAllStavkaDokuments(){
		Iterable<Stavka_Dokumenta> sds = sdService.findAll();
		
		return new ResponseEntity<>(sds, HttpStatus.OK);
	}
	
	//GET/ONE
	@GetMapping(value = "stavkaDokumenta/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Stavka_Dokumenta> getStavkaDokumenta(@PathVariable Long id) {
		Stavka_Dokumenta sd = sdService.findOne(id);

		return new ResponseEntity<>(sd, HttpStatus.OK);
	}

	//POST
	@PostMapping(value = "stavkaDokumentas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stavka_Dokumenta> create(@RequestBody Stavka_Dokumenta sd) {
		
		Roba roba = robaService.findOne(sd.getRoba().getId());
		//Dokument dokument = dokumentService.findOne(sd.getDokument().getId());
		
		Stavka_Dokumenta newSD = new Stavka_Dokumenta(sd.getId(), sd.getKolicina(), sd.getCena(), sd.getDokument(), roba);
		
		Stavka_Dokumenta retVal = sdService.save(newSD);
		
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	//PUT
	@PutMapping(value = "stavkaDokumenta/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stavka_Dokumenta> update(@PathVariable Long id,
			@RequestBody Stavka_Dokumenta stavkaDokumenta) {
		stavkaDokumenta.setId(id);
		Stavka_Dokumenta retVal = sdService.save(stavkaDokumenta);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	//DELETE
	@DeleteMapping(value = "stavkaDokumenta/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Stavka_Dokumenta sd = sdService.findOne(id);
		if (sd != null) {
			sdService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//GET/ROBAID
	@GetMapping(value = "roba/{robaId}/stavkaDokumentas")
	public ResponseEntity<List<Stavka_Dokumenta>> findRobaStavkaDokumentas(@PathVariable Long robaId) {
		List<Stavka_Dokumenta> sds = sdService.findByRobaId(robaId);
		
		return new ResponseEntity<>(sds, HttpStatus.OK); 
	}
	
	//GET/DOKUMENTID
	@GetMapping(value = "dokument/{dokumentId}/stavkaDokumentas")
	public ResponseEntity<List<Stavka_Dokumenta>> findDokumentStavkaDokumentas(@PathVariable Long dokumentId) {
		List<Stavka_Dokumenta> sds = sdService.findByDokumentId(dokumentId);
		
		return new ResponseEntity<>(sds, HttpStatus.OK); 
	}
}

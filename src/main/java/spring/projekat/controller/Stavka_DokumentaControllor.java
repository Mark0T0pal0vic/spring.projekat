package spring.projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import spring.projekat.model.Stavka_Dokumenta;
import spring.projekat.service.Stavka_DokumentaService;

@RestController
public class Stavka_DokumentaControllor {

	//PUT????
	@Autowired
	Stavka_DokumentaService sdService;
	
	
	//GET/ALL
	@RequestMapping(value = "api/stavkaDokumentas", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Stavka_Dokumenta>> getAllStavkaDokuments(){
		List<Stavka_Dokumenta> sds = sdService.findAll();
		
		return new ResponseEntity<>(sds, HttpStatus.OK);
	}
	
	//GET/ONE
	@RequestMapping(value = "api/stavkaDokumenta/{id}", method = RequestMethod.GET)
	public ResponseEntity<Stavka_Dokumenta> getExam(@PathVariable Long id) {
		Stavka_Dokumenta sd = sdService.findOne(id);

		return new ResponseEntity<>(sd, HttpStatus.OK);
	}

	//POST
	@RequestMapping(value = "api/stavkaDokumentas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stavka_Dokumenta> create(@RequestBody Stavka_Dokumenta sd) {
		Stavka_Dokumenta retVal = sdService.save(sd);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	//DELETE
	@RequestMapping(value = "api/stavkaDokumentas/{id}", method = RequestMethod.DELETE)
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
	@RequestMapping(value = "api/robas/{robaId}/stavkaDokumentas", method = RequestMethod.GET)
	public ResponseEntity<List<Stavka_Dokumenta>> findRobaStavkaDokumentas(@PathVariable Long robaId) {
		List<Stavka_Dokumenta> sds = sdService.findByRobaId(robaId);
		
		return new ResponseEntity<>(sds, HttpStatus.OK); 
	}
	
	//GET/DOKUMENTID
	@RequestMapping(value = "api/dokuments/{dokumentId}/stavkaDokumentas", method = RequestMethod.GET)
	public ResponseEntity<List<Stavka_Dokumenta>> findDokumentStavkaDokumentas(@PathVariable Long dokumentId) {
		List<Stavka_Dokumenta> sds = sdService.findByDokumentId(dokumentId);
		
		return new ResponseEntity<>(sds, HttpStatus.OK); 
	}
}

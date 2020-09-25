package spring.projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import spring.projekat.model.Dokument;
import spring.projekat.service.DokumentService;

@RestController
public class DokumentControllor {

	
	@Autowired
	DokumentService dokumentService;
	
	
	
	@RequestMapping(value = "api/dokuments", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Dokument>> getAllDokuments(){
		List<Dokument> dokuments = dokumentService.findAll();
		
		return new ResponseEntity<>(dokuments, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/dokument/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Dokument> getDokument(@PathVariable Long id){
		Dokument dokument = dokumentService.findOne(id);
		
		return new ResponseEntity<>(dokument, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/dokuments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dokument> create(@RequestBody Dokument dokument) {
		Dokument retVal = dokumentService.save(dokument);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "api/dokuments/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dokument> update(@PathVariable Long id,
			@RequestBody Dokument dokument) {
		dokument.setId(id);
		Dokument retVal = dokumentService.save(dokument);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/dokuments/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Dokument dokument = dokumentService.findOne(id);
		if (dokument != null) {
			dokumentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

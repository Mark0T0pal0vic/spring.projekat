package spring.projekat.controller;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import spring.projekat.model.Dokument;
import spring.projekat.model.Roba;
import spring.projekat.model.Stavka_Dokumenta;
import spring.projekat.service.DokumentService;
import spring.projekat.service.RobaService;
import spring.projekat.service.Stavka_DokumentaService;

@RestController
@RequestMapping("/api/")
public class DokumentController {

	
	@Autowired
	DokumentService dokumentService;	
	
	@Autowired
	Stavka_DokumentaService sds;
	
	@Autowired
	RobaService robaService;
	
	//GET/ALL
	@ApiOperation(value = "Pronalazi sva dokumenta")
	@GetMapping(value = "dokuments", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Dokument>> getAllDokuments(){
		Iterable<Dokument> dokuments = dokumentService.findAll();
		
		return new ResponseEntity<>(dokuments, HttpStatus.OK);
	}
	
	//GET/ONE
	@ApiOperation(value = "Pronalazi dokumenta po id-u", notes = "Pomocu id-a pronalazi odredjeni dokument")
	@GetMapping(value = "dokument/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Dokument> getDokument(@PathVariable Long id){
		Dokument dokument = dokumentService.findOne(id);
		
		return new ResponseEntity<>(dokument, HttpStatus.OK);
	}
	
	//POST
	@PostMapping(value = "dokuments", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dokument> create(@RequestBody Dokument dokument) {			
		
		Dokument retVal = dokumentService.save(dokument);
		
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	
	//PUT
	@PutMapping(value = "dokument/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dokument> update(@PathVariable Long id,
			@RequestBody Dokument dokument) {
		dokument.setId(id);
		Dokument retVal = dokumentService.save(dokument);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	//DELETE
	@DeleteMapping(value = "dokument/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Dokument dokument = dokumentService.findOne(id);
		if (dokument != null) {
			if(dokument.getStavkaDokumenta().isEmpty()) {
				dokumentService.remove(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

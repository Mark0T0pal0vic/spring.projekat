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

import io.swagger.annotations.ApiOperation;
import spring.projekat.model.Dokument;
import spring.projekat.service.DokumentService;

@RestController
public class DokumentController {

	
	@Autowired
	DokumentService dokumentService;	
	
	//GET/ALL
	@ApiOperation(value = "Pronalazi sva dokumenta")
	@RequestMapping(value = "api/dokuments", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Dokument>> getAllDokuments(){
		List<Dokument> dokuments = dokumentService.findAll();
		
		return new ResponseEntity<>(dokuments, HttpStatus.OK);
	}
	
	//GET/ONE
	@ApiOperation(value = "Pronalazi dokumenta po id-u", notes = "Pomocu id-a pronalazi odredjeni dokument")
	@RequestMapping(value = "api/dokument/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Dokument> getDokument(@PathVariable Long id){
		Dokument dokument = dokumentService.findOne(id);
		
		return new ResponseEntity<>(dokument, HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(value = "api/dokuments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dokument> create(@RequestBody Dokument dokument) {
		Dokument retVal = dokumentService.save(dokument);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	
	//PUT
	@RequestMapping(value = "api/dokuments/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dokument> update(@PathVariable Long id,
			@RequestBody Dokument dokument) {
		dokument.setId(id);
		Dokument retVal = dokumentService.save(dokument);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	//DELETE
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
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

import spring.projekat.model.Roba;
import spring.projekat.service.RobaService;



@RestController
public class RobaControllor {

	@Autowired
	RobaService robaService;
	
	
	//GET/ALL
	@RequestMapping(value = "api/robas", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Roba>> getAllRobas(){
		List<Roba> robas = robaService.findAll();
		
		return new ResponseEntity<>(robas, HttpStatus.OK);
	}
	
	//GET/ONE
	@RequestMapping(value = "api/roba/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Roba> getRoba(@PathVariable Long id){
		Roba roba = robaService.findOne(id);
		
		return new ResponseEntity<>(roba, HttpStatus.OK);
	}
	
	
	//POST
	@RequestMapping(value = "api/robas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Roba> create(@RequestBody Roba roba) {
		Roba retVal = robaService.save(roba);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	
	//PUT
	@RequestMapping(value = "api/robas/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Roba> update(@PathVariable Long id,
			@RequestBody Roba roba) {
		roba.setId(id);
		Roba retVal = robaService.save(roba);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	//DELETE
	@RequestMapping(value = "api/robas/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Roba roba = robaService.findOne(id);
		if (roba != null) {
			robaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

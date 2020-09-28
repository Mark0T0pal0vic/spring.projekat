package spring.projekat.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import spring.projekat.model.Roba;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RobaRestControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	//Testira GetById iz tabele t_roba
	@Test
	public void GetRobaByIdTest() {
		
		ResponseEntity<Roba> response = testRestTemplate.getForEntity("/api/roba/1", Roba.class);
		
		 assertEquals(1, response.getBody().getId());
		 assertEquals("ROBA_TEST", response.getBody().getNaziv());
		 
		 
	}
	
	//Testiranje POST metode u tabelu t_roba
	@Test
	public void saveRoba() {
		
		Roba roba = new Roba();
		roba.setNaziv("ROBA_TEST");
		
		HttpEntity<Roba> request = new HttpEntity<>(roba);
		
		ResponseEntity<Roba> response = testRestTemplate.postForEntity("/api/robas", request, Roba.class);
		
		assertNotNull(response.getBody().getId());
		assertEquals("ROBA_TEST", response.getBody().getNaziv());
	}
}

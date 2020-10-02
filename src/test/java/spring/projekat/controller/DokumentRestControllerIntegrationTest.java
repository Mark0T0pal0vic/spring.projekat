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

import spring.projekat.model.Dokument;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DokumentRestControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	//Testira GetById iz tabele dokument
	@Test
	public void GetDokumentByIdTest() {
		
		ResponseEntity<Dokument> response = testRestTemplate.getForEntity("/api/dokument/1", Dokument.class);
		
		 assertEquals(1, response.getBody().getId());
		 assertEquals("DOKUMENT_TEST", response.getBody().getNaziv());
		 assertEquals(1000.0, response.getBody().getIznos());
		 
		 
	}
	
	//Testiranje POST metode u tabelu roba
	@Test
	public void saveDokument() {
		
		Dokument dokument = new Dokument();
		dokument.setNaziv("DOKUMENT_TEST");
		dokument.setIznos(1000.0);
		
		
		HttpEntity<Dokument> request = new HttpEntity<>(dokument);
		
		ResponseEntity<Dokument> response = testRestTemplate.postForEntity("/api/dokuments", request, Dokument.class);
		
		assertNotNull(response.getBody().getId());
		assertEquals("DOKUMENT_TEST", response.getBody().getNaziv());
		assertEquals(1000.0, response.getBody().getIznos());
	}
}

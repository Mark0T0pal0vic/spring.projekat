package spring.projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(catalog = "spring.projekat", name="stavka_dokumenta")
public class Stavka_Dokumenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private int kolicina;
	
	@Column(nullable=false)
	private double cena;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Dokument dokument;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Roba roba;
	

	public Stavka_Dokumenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stavka_Dokumenta(long id, int kolicina, double cena, Dokument dokument, Roba roba) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.cena = cena;
		this.dokument = dokument;
		this.roba = roba;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	public Roba getRoba() {
		return roba;
	}

	public void setRoba(Roba roba) {
		this.roba = roba;
	}


	
	
}

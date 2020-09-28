package spring.projekat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "spring.projekat", name="dokument")
public class Dokument {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=255)
	private String naziv;
	
	@Column(nullable=false)
	private double iznos;
	
	
	@OneToMany(mappedBy="dokument", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Stavka_Dokumenta> stavkaDokumenta = new HashSet<Stavka_Dokumenta>();

	public Dokument(long id, String naziv, double iznos) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.iznos = iznos;
	}

	public Dokument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public Set<Stavka_Dokumenta> getStavkaDokumenta() {
		return stavkaDokumenta;
	}

	public void setStavkaDokumenta(Set<Stavka_Dokumenta> stavkaDokumenta) {
		this.stavkaDokumenta = stavkaDokumenta;
	}
	
}

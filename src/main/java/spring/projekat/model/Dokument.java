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
@Table(catalog = "spring.projekat", name="t_dokument")
public class Dokument {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=255)
	private String name;
	
	@Column(nullable=false)
	private double price;
	
	
	@OneToMany(mappedBy="dokument", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Stavka_Dokumenta> stavkaDokumenta = new HashSet<Stavka_Dokumenta>();

	public Dokument(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Stavka_Dokumenta> getStavkaDokumenta() {
		return stavkaDokumenta;
	}

	public void setStavkaDokumenta(Set<Stavka_Dokumenta> stavkaDokumenta) {
		this.stavkaDokumenta = stavkaDokumenta;
	}
	
}

package spring.projekat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Roba {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=255)
	private String name;
	
	@OneToMany(mappedBy="roba")
	private Set<Stavka_Dokumenta> stavkaDokumenta = new HashSet<Stavka_Dokumenta>();

	public Roba(long id, String name, Set<Stavka_Dokumenta> stavkaDokumenta) {
		super();
		this.id = id;
		this.name = name;
		this.stavkaDokumenta = stavkaDokumenta;
	}

	public Roba() {
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

	public Set<Stavka_Dokumenta> getStavkaDokumenta() {
		return stavkaDokumenta;
	}

	public void setStavkaDokumenta(Set<Stavka_Dokumenta> stavkaDokumenta) {
		this.stavkaDokumenta = stavkaDokumenta;
	}
	
	
	
}

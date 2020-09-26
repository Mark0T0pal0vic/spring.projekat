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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(catalog = "spring.projekat", name="t_roba")
public class Roba {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=255)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="roba", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Stavka_Dokumenta> stavkaDokumenta = new HashSet<Stavka_Dokumenta>();

	public Roba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roba(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

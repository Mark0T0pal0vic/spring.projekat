package spring.projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Stavka_Dokumenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false)
	private double price;
	
	@ManyToOne
	private Dokument dokumentId;
	
	@ManyToOne
	private Roba robaId;

	public Stavka_Dokumenta(long id, int quantity, double price, Dokument dokumentId, Roba robaId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.dokumentId = dokumentId;
		this.robaId = robaId;
	}

	public Stavka_Dokumenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Dokument getDokumentId() {
		return dokumentId;
	}

	public void setDokumentId(Dokument dokumentId) {
		this.dokumentId = dokumentId;
	}

	public Roba getRobaId() {
		return robaId;
	}

	public void setRobaId(Roba robaId) {
		this.robaId = robaId;
	}
	
	
}

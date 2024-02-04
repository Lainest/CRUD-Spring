package it.corso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "prodotti")
public class Prodotto {
	
	@Id //specifica che è una chiava primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//stabilisce gestione chiave,se ne occupa il db
	private int id;
	
	@Pattern(regexp = "[a-zA-Z0-9\\s]{1,45}", message = "Caratteri non ammessi")
	@Column(name = "descrizione")
	private String descrizione;
	
	@Digits(integer = 5, fraction = 2, message = "Prezzo non valido")
	@Column(name = "prezzo")
	private double prezzo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}

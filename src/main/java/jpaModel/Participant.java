package jpaModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Participant")
public class Participant implements Serializable{


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String nom;
	@Column(nullable=false)
	private String prenom;
	@Column(nullable=false)
	private String mail;


	private String prefAlim;

	private String allergies;
	
	
	public Participant() {
		
	}

	public Participant(String nom, String prenom, String mail) {
		this.nom=nom;
		this.prenom=prenom;
		this.mail=mail;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getPrefAlim() {
		return prefAlim;
	}

	public void setPrefAlim(String prefAlim) {
		this.prefAlim = prefAlim;
	}
	
	public String toString() {
		
		return this.getNom() + " "+ this.getPrenom()+ " "+ this.getMail();
	}


}

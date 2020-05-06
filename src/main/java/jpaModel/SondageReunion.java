package jpaModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SondageReunion implements Serializable{


	private static final long serialVersionUID = 1L;

	private String resume;
	private String intitule;

	private boolean isValid;
	@Id
	@GeneratedValue
	private Long id;

	private String url;

	public SondageReunion() {

		this.setUrl("/"+ String.valueOf(id));
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany()
	private List<Reponse> reponse;	

	@OneToMany(mappedBy="sondageReunion")
	private List<Proposition> propositions;	

	@OneToOne(mappedBy="sondageReunion")
	private Proposition resultat;



	public SondageReunion(String resume, String intitule) {
		super();

		this.setResume(resume);
		this.setIntitule(intitule);

	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Reponse> getReponse() {
		return reponse;
	}

	public void setReponse(List<Reponse> reponse) {
		this.reponse = reponse;
	}

	public boolean isValid() {
		return isValid;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	public Proposition getResultat() {
		return resultat;
	}

	public void setResultat(Proposition resultat) {
		this.resultat = resultat;
	}



	public void validReunion(Proposition proposition) {
		
		for (Proposition prop : propositions) {
			if (prop.isPropositionAcceptee()) {
				throw new Error("A Proposition already accepted");
			}
				
		}
		
		proposition.setPropositionAcceptee(true);
		setResultat(proposition);
		

	}



}

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDepart;
	private String nomDepart;

	
	public Long getIdDepart() {
		return idDepart;
	}
	public void setIdDepart(Long idDepart) {
		this.idDepart = idDepart;
	}
	public String getNomDepart() {
		return nomDepart;
	}
	public void setNomDepart(String nomDepart) {
		this.nomDepart = nomDepart;
	}
	
	public Departement() {
		super();
	}
	
	public Departement(String nomDepart) {
		
		this.nomDepart=nomDepart;
	}
	
	

}

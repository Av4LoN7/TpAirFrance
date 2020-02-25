package tpAirFrance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(unique = true, nullable = false)
	private String numResa;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String prenom;
	
	@Column(nullable = false)
	private int age;
	
	@ManyToOne
	private Vol vol;

	/**
	 * default constructor
	 */
	public Reservation() {
		this.id = null;
		this.numResa = null;
		this.nom = null;
		this.prenom = null;
		this.age = 0;
	}
	
	/**
	 * Constructor with arguments
	 * @param id
	 * @param numResa
	 * @param nom
	 * @param prenom
	 * @param age
	 */
	public Reservation(Long id, String numResa, String nom, String prenom, int age) {
		this.id = id;
		this.numResa = numResa;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumResa() {
		return numResa;
	}

	public void setNumResa(String numResa) {
		this.numResa = numResa;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}

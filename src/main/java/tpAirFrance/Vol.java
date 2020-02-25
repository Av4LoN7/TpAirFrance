package tpAirFrance;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Vol {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String numVol;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private Avion typeAvion;
	
	@Column(nullable = false)
	private int numPlace;
	
	@Column(nullable = false)
	private String villeDep;
	
	@Column(nullable = false)
	private String villeArr;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@OneToMany(mappedBy = "vol")
	private List<Reservation> reservation;
	
	/**
	 * defaut constructor
	 */
	public Vol() {
		this.id = null;
		this.numVol = null;
		this.typeAvion = null;
		this.numPlace = 0;
		this.villeDep = null;
		this.villeArr = null;
		this.date = null;
	}
	

	/**
	 * Constructor with arguments
	 * @param id
	 * @param numVol
	 * @param typeAvion
	 * @param numPlace
	 * @param villeDep
	 * @param villeArr
	 * @param date
	 */
	public Vol(Long id, String numVol, Avion typeAvion, int numPlace, String villeDep, String villeArr, LocalDate date) {
		this.id = id;
		this.numVol = numVol;
		this.typeAvion = typeAvion;
		this.numPlace = numPlace;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.date = date;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getNumVol() {
		return numVol;
	}


	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}


	public List<Reservation> getReservation() {
		return reservation;
	}


	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	public Avion getTypeAvion() {
		return typeAvion;
	}


	public void setTypeAvion(Avion typeAvion) {
		this.typeAvion = typeAvion;
	}


	public int getNumPlace() {
		return numPlace;
	}


	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}


	public String getVilleDep() {
		return villeDep;
	}


	public void setVilleDep(String villeDep) {
		this.villeDep = villeDep;
	}


	public String getVilleArr() {
		return villeArr;
	}


	public void setVilleArr(String villeArr) {
		this.villeArr = villeArr;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
	

}

package dao;

import javax.persistence.EntityManager;

import model.DatabaseHelper;
import tpAirFrance.Reservation;
import tpAirFrance.Vol;

public class ReservationDAO {
	
	public void createResaDB() {
		
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Vol volTest = em.find(Vol.class, 1L);
		
		Reservation resa1 = new Reservation();
		Reservation resa2 = new Reservation();
		Reservation resa3 = new Reservation();
		Reservation resa4 = new Reservation();
		
		resa1.setNom("Rogers");
		resa2.setNom("Beranrd");
		resa3.setNom("Crest");
		resa4.setNom("Dupont");
		
		resa1.setPrenom("Steve");
		resa2.setPrenom("Julien");
		resa3.setPrenom("Olivia");
		resa4.setPrenom("Jean");
		
		resa1.setAge(35);
		resa2.setAge(25);
		resa3.setAge(28);
		resa4.setAge(19);
		
		em.persist(resa1);
		em.persist(resa2);
		em.persist(resa3);
		em.persist(resa4);
		
		resa1.setNumResa(volTest.getNumVol() + "-" + resa1.getId());
		resa2.setNumResa(volTest.getNumVol() + "-" + resa2.getId());
		resa3.setNumResa(volTest.getNumVol() + "-" + resa3.getId());
		resa4.setNumResa(volTest.getNumVol() + "-" + resa4.getId());
		
		em.persist(volTest);
		
		DatabaseHelper.commitTxAndClose(em);
		
	}

}

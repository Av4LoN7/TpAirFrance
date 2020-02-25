package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.DatabaseHelper;
import tpAirFrance.Avion;
import tpAirFrance.Vol;

public class VolDAO {
	
	public void createVolDB() {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		Vol vol1 = new Vol();
		Vol vol2 = new Vol();
		Vol vol3 = new Vol();
		Vol vol4 = new Vol();
		
		vol1.setNumVol("0001");
		vol2.setNumVol("0002");
		vol3.setNumVol("0003");
		vol4.setNumVol("0004");
		
		vol1.setNumPlace(1500);
		vol2.setNumPlace(1000);
		vol3.setNumPlace(1550);
		vol4.setNumPlace(1500);
		
		vol1.setTypeAvion(Avion.A330);
		vol2.setTypeAvion(Avion.A340);
		vol3.setTypeAvion(Avion.A380);
		vol4.setTypeAvion(Avion.B747);
		
		vol1.setVilleArr("Paris");
		vol2.setVilleArr("Toulouse");
		vol3.setVilleArr("Ajacio");
		vol4.setVilleArr("Milan");
		
		vol1.setVilleDep("Montpellier");
		vol2.setVilleDep("Montpellier");
		vol3.setVilleDep("Montpellier");
		vol4.setVilleDep("Montpellier");
		
		vol1.setDate(LocalDate.now());
		vol2.setDate(LocalDate.now());
		vol3.setDate(LocalDate.now());
		vol4.setDate(LocalDate.now());
		
		em.persist(vol1);
		em.persist(vol2);
		em.persist(vol3);
		em.persist(vol4);
		
		DatabaseHelper.commitTxAndClose(em);	
	}
	
	public boolean findVol(String str) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Vol> query = em.createQuery("FROM Vol v WHERE v.numVol =:num", Vol.class);
		query.setParameter("num", str.trim());
		
		try {
			query.getSingleResult();
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<Vol> getAllVol(){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Vol> query = em.createQuery("FROM Vol v", Vol.class);
		List<Vol> listTemp = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return listTemp;
	}
	
	public void createAVol(String numVol, String typeAv, int numPlace, String villeD, String villeA, LocalDate dateV) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Vol vol = new Vol();
		vol.setNumVol(numVol);
		vol.setTypeAvion(Avion.valueOf(typeAv));
		vol.setNumPlace(numPlace);
		vol.setVilleDep(villeD);
		vol.setVilleArr(villeA);
		vol.setDate(dateV);
		em.persist(vol);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public List<Vol> findVolByNumber(String arg){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		List<Vol> volTemp = null;
		TypedQuery<Vol>query = em.createQuery("FROM Vol v WHERE v.numVol=:num", Vol.class);
		query.setParameter("num", arg);
		return query.getResultList();
		
	}

}

package com.ati.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ati.model.Firewall;



public class FirewallDAO {
	private EntityManager entityManager;
	protected EntityManager getEntityManager() {
		if (entityManager == null) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("GEC");
		 entityManager = emf.createEntityManager();}
					
		return entityManager;
	}
	
	public int insert(Firewall u) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(u);
			getEntityManager().getTransaction().commit();
			getEntityManager().clear();
			res=1;
		} catch (Exception e) {
			
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return res;
	}


	
	
	

	public int delete(int num) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			Firewall u = getEntityManager().find(Firewall.class,num); 
			getEntityManager().remove(u);
			getEntityManager().getTransaction().commit();
			res=1;
		} catch (Exception e) {
			
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return res;
	}
	
	
	public int update(int num) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			Firewall u = getEntityManager().find(Firewall.class,num); 
			getEntityManager().merge(u);
			getEntityManager().getTransaction().commit();
			getEntityManager().clear();
			res=1;
		} catch (Exception e) {
			
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return res;
	}
	
	public List<Firewall> selectAll() {
		 Query query = getEntityManager().createNamedQuery("Firewall.findAll");
		@SuppressWarnings("unchecked")
		List<Firewall> liste=query.getResultList();
		
		return liste;
	}
}

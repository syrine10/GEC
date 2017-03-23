package com.ati.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ati.model.Serveur;



public class ServeurDAO {
	private EntityManager entityManager;
	protected EntityManager getEntityManager() {
		if (entityManager == null) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("GEC");
		 entityManager = emf.createEntityManager();}
					
		return entityManager;
	}
	
	public int insert(Serveur u) {
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
			Serveur u = getEntityManager().find(Serveur.class,num); 
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
			Serveur u = getEntityManager().find(Serveur.class,num); 
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
	
	public List<Serveur> selectAll() {
		 Query query = getEntityManager().createNamedQuery("Serveur.findAll");
		@SuppressWarnings("unchecked")
		List<Serveur> liste=query.getResultList();
		
		return liste;
	}
}

package com.ati.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ati.model.Client;
import com.ati.model.Datacenter;

public class ClientDAO {

	private EntityManager entityManager;
	protected EntityManager getEntityManager() {
		if (entityManager == null) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("GEC");
		 entityManager = emf.createEntityManager();}
					
		return entityManager;
	}
	
	public int insert(Client u) {
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
			Client u = getEntityManager().find(Client.class,num); 
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
			Client u = getEntityManager().find(Client.class,num); 
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
	
	public List<Client> selectAll() {
		 Query query = getEntityManager().createNamedQuery("Client.findAll");
		@SuppressWarnings("unchecked")
		List<Client> liste=query.getResultList();
		
		return liste;
	}
}

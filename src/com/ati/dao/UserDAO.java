package com.ati.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ati.cryptage.CipherAES;
import com.ati.model.User;


public class UserDAO {
	
	private EntityManager entityManager;
	protected EntityManager getEntityManager() {
		if (entityManager == null) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("GEC");
		 entityManager = emf.createEntityManager();}
					
		return entityManager;
	}
	public int insert(User u) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			

			u.setPassword(CipherAES.crypt(u.getPassword()));
			getEntityManager().persist(u);
			getEntityManager().getTransaction().commit();
			getEntityManager().clear();
			res=1;
		} catch (Exception e) {
			
			e.printStackTrace();
			if(getEntityManager().getTransaction().isActive())
			getEntityManager().getTransaction().rollback();
		
		}
		
		return res;
	}


	
	
	

	public int delete(int num) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			User u = getEntityManager().find(User.class,num); 
			getEntityManager().remove(u);
			getEntityManager().getTransaction().commit();
			getEntityManager().clear();
			res=1;
		} catch (Exception e) {
			
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return res;
	}
	
	
	
	public int update(User u) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			
			System.out.println("user : update "+u.toString());
			//u.setPwd(crypt(u.getPwd()));
			System.out.println(u.getPassword());
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
	public int updateUser(User u) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			//getEntityManager().find(u.getClass(), u.getId());
			Query q=getEntityManager().createNativeQuery("update user e set e.login='"+u.getLogin()+"' ,e.nom='"+u.getNom()+"' ,e.prenom='"+u.getPrenom()+"' ,e.adresse='"+u.getAdresse()+"' ,e.role='"+u.getRole()+"' where e.id= "+u.getId());
			res=q.executeUpdate();
			getEntityManager().getTransaction().commit();
			getEntityManager().clear();
			res=1;
		} catch (Exception e) {
			
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return res;
	}
	
	public int updatePassword(User u) {
        int res=0;
		try {
			getEntityManager().getTransaction().begin();
			//getEntityManager().find(u.getClass(), u.getId());
			u.setPassword(CipherAES.crypt(u.getPassword()));
			Query q=getEntityManager().createNativeQuery("update user e set e.password='"+u.getPassword()+"' where e.id= "+u.getId());
			res=q.executeUpdate();
			getEntityManager().getTransaction().commit();
			
			res=1;
		} catch (Exception e) {
			
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return res;
	}
	
	public List<User> selectAll() {
		 Query query = getEntityManager().createNamedQuery("User.findAll");
		@SuppressWarnings("unchecked")
		List<User> liste=query.getResultList();
		getEntityManager().clear();
		return liste;
	}
	
	 
	 public User login(String login, String password, String type){
		 try {
	        
       User User = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.login ='"+login+"' AND u.password ='"+ CipherAES.crypt(password)+"' AND u.role ='"+type+"'").getSingleResult();
            
       if (User != null){
    	   System.out.println("i found him");
           return User;
       }		       
        		            
        } catch (NoResultException e) {
        	System.out.println("pas de resultat");
        	return null;
        }
        catch(Exception e){
        	
        	e.getStackTrace();
        	return null;
        }
        return null;
	 }
	  
}

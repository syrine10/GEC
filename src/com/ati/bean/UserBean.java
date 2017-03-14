package com.ati.bean;
import java.io.Serializable;



import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.ati.dao.UserDAO;
import com.ati.model.User;
import com.ati.session.UtilSession;

@ViewScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private User utilisateur=new User();
	private UserDAO userdao=new UserDAO();
	private String newPwd=new String();
	private List<User>listeUser=new ArrayList<User>();
	
	
	
	
	 public List<User> getListeUser() {
		 listeUser=userdao.selectAll();
		return listeUser;
	}


	 public void clear(){
		 utilisateur=new User();
	 }

	public void setListeUser(List<User> listeUser) {
		this.listeUser = listeUser;
	}




	public String getNewPwd() {
		return newPwd;
	}




	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}


public void supprimer(){
		
		if(userdao.delete(utilisateur.getId())==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Suppression", "Suppression non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression", "Suppression effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }

   }

	public void runTest() {
	        Runtime r = Runtime.getRuntime();
	        Process p = null;
	        try {
	            String s = "c:\\JEE\\putty.exe";
	            p = r.exec(s);
	           
	           
	        } catch (Exception e) {
	            System.out.println("error===" + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	
	
	

	public String loginProject() {
		
        User result = userdao.login(utilisateur.getLogin(), utilisateur.getPassword(), utilisateur.getRole());
        if (result!=null && utilisateur.getRole().equals("administrateur")) {
            // get Http Session and store username
        	HttpSession  session = UtilSession.getSession();
        	
        		utilisateur=result;
        		if(!utilisateur.getPassword().equalsIgnoreCase(result.getPassword())){
           		 utilisateur.setPassword(result.getPassword());
           	}
            System.out.println("user login : "+utilisateur);
            
            if (session==null)
    		{
    		System.out.println("session is null");
    		}
           session.setAttribute("username", utilisateur.getLogin());
           session.setAttribute("userid", utilisateur.getId());
           System.out.println(" idd 1 : "+utilisateur.getId());
        //   System.out.println("idd 1 : "+UtilSession.getUserId().toString());
           System.out.println("idd 2 : "+session.getId());
           System.out.println("idd 3 : "+session.getAttribute("userid"));
            return "/mapp.xhtml";
        }
        else if (result!=null && utilisateur.getRole().equals("comptoir")) {
            // get Http Session and store username
            HttpSession session = UtilSession.getSession();
            session.setAttribute("username", utilisateur.getLogin());
 
            return "/mapp.xhtml";
        }
        else {
 
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Mot de passe incorrect!", "Please Try Again!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "/Authentification.xhtml";
        }
    }
 
    public String logout() {
      HttpSession session = UtilSession.getSession();
      session.invalidate();
   
      return "Authentification";
   }

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public void modifier() {
		System.out.println("user : modif "+utilisateur.toString());
		if (userdao.updateUser(utilisateur) == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Modification", "Modification non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Modification", "Modification effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			
		}
			
	}
	public void modifierPwd(){
		if(!utilisateur.getPassword().equals(newPwd)){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Mot de passe incorrect !"));
			return;
		}
		if((utilisateur.getPassword().equals(newPwd))&& userdao.updatePassword(utilisateur)==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Modification", "Modification non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Modification effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }
	}
	
	
	public void insert() {

		try {

			
			if (userdao.insert(utilisateur) == 0) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_WARN, "Ajout",
						"Ajout non effectuée!");
				RequestContext.getCurrentInstance()
						.showMessageInDialog(message);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Ajout", "Ajout effectuée.");
				RequestContext.getCurrentInstance()
						.showMessageInDialog(message);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	public void resetModel() { 
	    if (!FacesContext.getCurrentInstance().isPostback()) {
	        //client = null;
	    	FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	    }
	}
	
/*public static void main(String []args){
	MBUser mb=new MBUser();
	UserDAO userdao=new UserDAO();
	mb.setUtilisateur(userdao.selectAll().get(3));
	mb.utilisateur.setPwd("456");
	//mb.modifier();
	mb.loginProject();
	//String id=UtilSession.getUserId();
	
}*/
}

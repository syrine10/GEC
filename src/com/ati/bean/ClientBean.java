package com.ati.bean;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;



import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.ati.dao.ClientDAO;
import com.ati.dao.DataCenterDAO;
import com.ati.model.Client;
import com.ati.model.Datacenter;
@ViewScoped
public class ClientBean {

	private static final long serialVersionUID = 1L;
	private Client client=new Client();
	private List<Client> selectedClient =new ArrayList<Client>();
     private List<Client> listeClient=new ArrayList<Client>();
 	private ClientDAO daoClient =new ClientDAO();
	
 	/*
 	 * new comment from syrine tajouri
 	 */
 	
	public List<Client> getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(List<Client> selectedClient) {
		this.selectedClient = selectedClient;
	}

	public ClientBean() {
		super();
		// TODO Auto-generated constructor stub
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListeClient() {
		listeClient=daoClient.selectAll();
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public void insert(){
		if(daoClient.insert(client)==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Ajout", "Ajout non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			
			
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout", "Ajout effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }
		//reset();
   }
	
	public void resetModel() { 
	    if (!FacesContext.getCurrentInstance().isPostback()) {
	        //client = null;
	    	FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	    }
	}
	
	
	 
	public void supprimer(){
		
		if(daoClient.delete(client.getId())==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Suppression", "Suppression non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression", "Suppression effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }

   }
	public void modifier(){
		if(daoClient.update(client.getId())==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Modification", "Modification non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Modification effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }

   }
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Client Selected", ((Client) event.getObject()).getNom());
       
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
}

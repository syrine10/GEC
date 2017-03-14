package com.ati.bean;

import java.applet.Applet;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.ati.dao.DataCenterDAO;
import com.ati.model.Datacenter;

@ViewScoped
public class DataCenterBean {
	
	private static final long serialVersionUID = 1L;
	private Datacenter u=new Datacenter();
     private List<Datacenter> listeDataCenter=new ArrayList<Datacenter>();
 	private DataCenterDAO daoDataCenter =new DataCenterDAO();
	
	

	public static String toJavascriptArray(List<String> arr){
 	    StringBuffer sb = new StringBuffer();
 	    sb.append("[");
 	    for(int i=0; i<arr.size(); i++){
 	        sb.append("\"").append(arr.get(i)).append("\"");
 	        if(i+1 < arr.size()){
 	            sb.append(",");
 	        }
 	    }
 	    sb.append("]");
 	    return sb.toString();
 	}
	

	public DataCenterBean() throws HeadlessException {
		super();
	}

	public Datacenter getU() {
		return u;
	}

	public void setU(Datacenter u) {
		this.u = u;
	}

	public List<Datacenter> getListeDataCenter() {
		listeDataCenter=daoDataCenter.selectAll();
		return listeDataCenter;
	}

	public void setListeDataCenter(List<Datacenter> listeDataCenter) {
		this.listeDataCenter = listeDataCenter;
	}

	public DataCenterDAO getDaoDataCenter() {
		return daoDataCenter;
	}

	public void setDaoDataCenter(DataCenterDAO daoDataCenter) {
		this.daoDataCenter = daoDataCenter;
	}

	public void insert(){
		if(daoDataCenter.insert(u)==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Ajout", "Ajout non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout", "Ajout effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }

   }

	public void supprimer(){
		
		if(daoDataCenter.delete(u.getId())==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Suppression", "Supp non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression", "Supp effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }

   }
	public void modifier(){
		if(daoDataCenter.update(u.getId())==0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Modification", "Modif non effectuée!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification", "Modif effectuée.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
	   }

   }
	public void resetModel() { 
	    if (!FacesContext.getCurrentInstance().isPostback()) {
	        //client = null;
	    	FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	    }
	}
/*public static void main(String []args){
	DataCenterBean dt= new DataCenterBean();
	System.out.println("latitude "+dt.getListeLatitude());
	System.out.println("longitude"+dt.getListeLongitude());
}*/
}

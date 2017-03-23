package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adresse;

	private int codePostale;

	private String contact;

	private String contrat;

	private int fax;

	private String nom;

	private int reference;

	private int telephone;

	private String type;

	private String typePrestation;

	private String ville;

	//bi-directional many-to-one association to Port
	@OneToMany(mappedBy="client")
	private List<Port> ports;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostale() {
		return this.codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContrat() {
		return this.contrat;
	}

	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

	public int getFax() {
		return this.fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getReference() {
		return this.reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypePrestation() {
		return this.typePrestation;
	}

	public void setTypePrestation(String typePrestation) {
		this.typePrestation = typePrestation;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Port> getPorts() {
		return this.ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	public Port addPort(Port port) {
		getPorts().add(port);
		port.setClient(this);

		return port;
	}

	public Port removePort(Port port) {
		getPorts().remove(port);
		port.setClient(null);

		return port;
	}

}
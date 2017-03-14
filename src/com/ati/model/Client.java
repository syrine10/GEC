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

	private String nom;

	//bi-directional many-to-many association to Datacenter
	@ManyToMany
	@JoinTable(
		name="clidata"
		, joinColumns={
			@JoinColumn(name="idClient")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idData")
			}
		)
	private List<Datacenter> datacenters;

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

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Datacenter> getDatacenters() {
		return this.datacenters;
	}

	public void setDatacenters(List<Datacenter> datacenters) {
		this.datacenters = datacenters;
	}

}
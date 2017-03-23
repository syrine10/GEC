package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the datacenter database table.
 * 
 */
@Entity
@NamedQuery(name="Datacenter.findAll", query="SELECT d FROM Datacenter d")
public class Datacenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adresse;

	private double latitude;

	private double longitude;

	private String nom;

	//bi-directional many-to-one association to Equipement
	@OneToMany(mappedBy="datacenter")
	private List<Equipement> equipements;

	public Datacenter() {
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

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Equipement> getEquipements() {
		return this.equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public Equipement addEquipement(Equipement equipement) {
		getEquipements().add(equipement);
		equipement.setDatacenter(this);

		return equipement;
	}

	public Equipement removeEquipement(Equipement equipement) {
		getEquipements().remove(equipement);
		equipement.setDatacenter(null);

		return equipement;
	}

}
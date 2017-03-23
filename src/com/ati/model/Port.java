package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the port database table.
 * 
 */
@Entity
@NamedQuery(name="Port.findAll", query="SELECT p FROM Port p")
public class Port implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String capacite;

	private String ip;

	private String type;

	private String typeModule;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;

	//bi-directional many-to-one association to Equipement
	@ManyToOne
	@JoinColumn(name="idEquip")
	private Equipement equipement;

	public Port() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCapacite() {
		return this.capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeModule() {
		return this.typeModule;
	}

	public void setTypeModule(String typeModule) {
		this.typeModule = typeModule;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Equipement getEquipement() {
		return this.equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

}
package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the equipementinarm database table.
 * 
 */
@Entity
@NamedQuery(name="Equipementinarm.findAll", query="SELECT e FROM Equipementinarm e")
public class Equipementinarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquip;

	private String ip;

	private String marque;

	//bi-directional many-to-one association to Armoire
	@ManyToOne
	@JoinColumn(name="idArm")
	private Armoire armoire;

	//bi-directional one-to-one association to Equipement
	@OneToOne
	@JoinColumn(name="idEquip")
	private Equipement equipement;

	//bi-directional one-to-one association to Firewall
	@OneToOne(mappedBy="equipementinarm")
	private Firewall firewall;

	//bi-directional one-to-one association to Routeur
	@OneToOne(mappedBy="equipementinarm")
	private Routeur routeur;

	//bi-directional one-to-one association to Serveur
	@OneToOne(mappedBy="equipementinarm")
	private Serveur serveur;

	//bi-directional one-to-one association to Switch
	@OneToOne(mappedBy="equipementinarm")
	private Switch switch1;

	public Equipementinarm() {
	}

	public int getIdEquip() {
		return this.idEquip;
	}

	public void setIdEquip(int idEquip) {
		this.idEquip = idEquip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Armoire getArmoire() {
		return this.armoire;
	}

	public void setArmoire(Armoire armoire) {
		this.armoire = armoire;
	}

	public Equipement getEquipement() {
		return this.equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public Firewall getFirewall() {
		return this.firewall;
	}

	public void setFirewall(Firewall firewall) {
		this.firewall = firewall;
	}

	public Routeur getRouteur() {
		return this.routeur;
	}

	public void setRouteur(Routeur routeur) {
		this.routeur = routeur;
	}

	public Serveur getServeur() {
		return this.serveur;
	}

	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}

	public Switch getSwitch() {
		return this.switch1;
	}

	public void setSwitch(Switch switch1) {
		this.switch1 = switch1;
	}

}
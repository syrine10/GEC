package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the serveur database table.
 * 
 */
@Entity
@NamedQuery(name="Serveur.findAll", query="SELECT s FROM Serveur s")
public class Serveur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipInArm;

	private String capaciteStockage;

	private int cpu;

	private int memoire;

	private String nom;

	private String taille;

	//bi-directional one-to-one association to Equipementinarm
	@OneToOne
	@JoinColumn(name="idEquipInArm")
	private Equipementinarm equipementinarm;

	public Serveur() {
	}

	public int getIdEquipInArm() {
		return this.idEquipInArm;
	}

	public void setIdEquipInArm(int idEquipInArm) {
		this.idEquipInArm = idEquipInArm;
	}

	public String getCapaciteStockage() {
		return this.capaciteStockage;
	}

	public void setCapaciteStockage(String capaciteStockage) {
		this.capaciteStockage = capaciteStockage;
	}

	public int getCpu() {
		return this.cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getMemoire() {
		return this.memoire;
	}

	public void setMemoire(int memoire) {
		this.memoire = memoire;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTaille() {
		return this.taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public Equipementinarm getEquipementinarm() {
		return this.equipementinarm;
	}

	public void setEquipementinarm(Equipementinarm equipementinarm) {
		this.equipementinarm = equipementinarm;
	}

}
package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the routeur database table.
 * 
 */
@Entity
@NamedQuery(name="Routeur.findAll", query="SELECT r FROM Routeur r")
public class Routeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipInArm;

	private String nom;

	private String type;

	//bi-directional one-to-one association to Equipementinarm
	@OneToOne
	@JoinColumn(name="idEquipInArm")
	private Equipementinarm equipementinarm;

	public Routeur() {
	}

	public int getIdEquipInArm() {
		return this.idEquipInArm;
	}

	public void setIdEquipInArm(int idEquipInArm) {
		this.idEquipInArm = idEquipInArm;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Equipementinarm getEquipementinarm() {
		return this.equipementinarm;
	}

	public void setEquipementinarm(Equipementinarm equipementinarm) {
		this.equipementinarm = equipementinarm;
	}

}
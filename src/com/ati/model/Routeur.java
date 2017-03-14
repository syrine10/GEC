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
	private int id;

	private String nom;

	//bi-directional one-to-one association to Equipementinarm
	@OneToOne
	@JoinColumn(name="idEquipInArm")
	private Equipementinarm equipementinarm;

	public Routeur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Equipementinarm getEquipementinarm() {
		return this.equipementinarm;
	}

	public void setEquipementinarm(Equipementinarm equipementinarm) {
		this.equipementinarm = equipementinarm;
	}

}
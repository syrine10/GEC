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
	private int id;

	private String nom;

	//bi-directional one-to-one association to Equipementinarm
	@OneToOne
	@JoinColumn(name="idEquipInArm")
	private Equipementinarm equipementinarm;

	public Serveur() {
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
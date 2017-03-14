package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the onduleur database table.
 * 
 */
@Entity
@NamedQuery(name="Onduleur.findAll", query="SELECT o FROM Onduleur o")
public class Onduleur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	//bi-directional one-to-one association to Equipementoutarm
	@OneToOne
	@JoinColumn(name="idEquipOutArm")
	private Equipementoutarm equipementoutarm;

	public Onduleur() {
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

	public Equipementoutarm getEquipementoutarm() {
		return this.equipementoutarm;
	}

	public void setEquipementoutarm(Equipementoutarm equipementoutarm) {
		this.equipementoutarm = equipementoutarm;
	}

}
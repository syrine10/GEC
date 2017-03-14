package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the equipementoutarm database table.
 * 
 */
@Entity
@NamedQuery(name="Equipementoutarm.findAll", query="SELECT e FROM Equipementoutarm e")
public class Equipementoutarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquip;

	//bi-directional one-to-one association to Equipement
	@OneToOne(mappedBy="equipementoutarm")
	private Equipement equipement;

	//bi-directional one-to-one association to Onduleur
	@OneToOne(mappedBy="equipementoutarm")
	private Onduleur onduleur;

	//bi-directional one-to-one association to Camera
	@OneToOne(mappedBy="equipementoutarm")
	private Camera camera;

	//bi-directional one-to-one association to Tiroirfo
	@OneToOne(mappedBy="equipementoutarm")
	private Tiroirfo tiroirfo;

	public Equipementoutarm() {
	}

	public int getIdEquip() {
		return this.idEquip;
	}

	public void setIdEquip(int idEquip) {
		this.idEquip = idEquip;
	}

	public Equipement getEquipement() {
		return this.equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public Onduleur getOnduleur() {
		return this.onduleur;
	}

	public void setOnduleur(Onduleur onduleur) {
		this.onduleur = onduleur;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Tiroirfo getTiroirfo() {
		return this.tiroirfo;
	}

	public void setTiroirfo(Tiroirfo tiroirfo) {
		this.tiroirfo = tiroirfo;
	}

}
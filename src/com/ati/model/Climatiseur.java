package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the climatiseur database table.
 * 
 */
@Entity
@NamedQuery(name="Climatiseur.findAll", query="SELECT c FROM Climatiseur c")
public class Climatiseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipOutArm;

	private int btu;

	private String marque;

	//bi-directional one-to-one association to Equipementoutarm
	@OneToOne
	@JoinColumn(name="idEquipOutArm")
	private Equipementoutarm equipementoutarm;

	public Climatiseur() {
	}

	public int getIdEquipOutArm() {
		return this.idEquipOutArm;
	}

	public void setIdEquipOutArm(int idEquipOutArm) {
		this.idEquipOutArm = idEquipOutArm;
	}

	public int getBtu() {
		return this.btu;
	}

	public void setBtu(int btu) {
		this.btu = btu;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Equipementoutarm getEquipementoutarm() {
		return this.equipementoutarm;
	}

	public void setEquipementoutarm(Equipementoutarm equipementoutarm) {
		this.equipementoutarm = equipementoutarm;
	}

}
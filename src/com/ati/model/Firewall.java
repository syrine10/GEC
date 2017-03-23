package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the firewall database table.
 * 
 */
@Entity
@NamedQuery(name="Firewall.findAll", query="SELECT f FROM Firewall f")
public class Firewall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipInArm;

	private String taille;

	private String type;

	//bi-directional one-to-one association to Equipementinarm
	@OneToOne
	@JoinColumn(name="idEquipInArm")
	private Equipementinarm equipementinarm;

	public Firewall() {
	}

	public int getIdEquipInArm() {
		return this.idEquipInArm;
	}

	public void setIdEquipInArm(int idEquipInArm) {
		this.idEquipInArm = idEquipInArm;
	}

	public String getTaille() {
		return this.taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
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
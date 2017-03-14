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

	public Equipement getEquipement() {
		return this.equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

}
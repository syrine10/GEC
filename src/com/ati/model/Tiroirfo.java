package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tiroirfo database table.
 * 
 */
@Entity
@NamedQuery(name="Tiroirfo.findAll", query="SELECT t FROM Tiroirfo t")
public class Tiroirfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional one-to-one association to Equipementoutarm
	@OneToOne
	@JoinColumn(name="idEquipOutArm")
	private Equipementoutarm equipementoutarm;

	public Tiroirfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipementoutarm getEquipementoutarm() {
		return this.equipementoutarm;
	}

	public void setEquipementoutarm(Equipementoutarm equipementoutarm) {
		this.equipementoutarm = equipementoutarm;
	}

}
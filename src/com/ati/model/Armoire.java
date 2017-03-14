 package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the armoire database table.
 * 
 */
@Entity
@NamedQuery(name="Armoire.findAll", query="SELECT a FROM Armoire a")
public class Armoire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Equipementinarm
	@OneToMany(mappedBy="armoire")
	private List<Equipementinarm> equipementinarms;

	public Armoire() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Equipementinarm> getEquipementinarms() {
		return this.equipementinarms;
	}

	public void setEquipementinarms(List<Equipementinarm> equipementinarms) {
		this.equipementinarms = equipementinarms;
	}

	public Equipementinarm addEquipementinarm(Equipementinarm equipementinarm) {
		getEquipementinarms().add(equipementinarm);
		equipementinarm.setArmoire(this);

		return equipementinarm;
	}

	public Equipementinarm removeEquipementinarm(Equipementinarm equipementinarm) {
		getEquipementinarms().remove(equipementinarm);
		equipementinarm.setArmoire(null);

		return equipementinarm;
	}

}
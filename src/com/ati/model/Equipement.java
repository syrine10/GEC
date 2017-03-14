package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipement database table.
 * 
 */
@Entity
@NamedQuery(name="Equipement.findAll", query="SELECT e FROM Equipement e")
public class Equipement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Datacenter
	@ManyToOne
	@JoinColumn(name="idData")
	private Datacenter datacenter;

	//bi-directional many-to-one association to Port
	@OneToMany(mappedBy="equipement")
	private List<Port> ports;

	//bi-directional one-to-one association to Equipementoutarm
	@OneToOne
	@JoinColumn(name="id")
	private Equipementoutarm equipementoutarm;

	//bi-directional one-to-one association to Equipementinarm
	@OneToOne
	@JoinColumn(name="id")
	private Equipementinarm equipementinarm;

	public Equipement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Datacenter getDatacenter() {
		return this.datacenter;
	}

	public void setDatacenter(Datacenter datacenter) {
		this.datacenter = datacenter;
	}

	public List<Port> getPorts() {
		return this.ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	public Port addPort(Port port) {
		getPorts().add(port);
		port.setEquipement(this);

		return port;
	}

	public Port removePort(Port port) {
		getPorts().remove(port);
		port.setEquipement(null);

		return port;
	}

	public Equipementoutarm getEquipementoutarm() {
		return this.equipementoutarm;
	}

	public void setEquipementoutarm(Equipementoutarm equipementoutarm) {
		this.equipementoutarm = equipementoutarm;
	}

	public Equipementinarm getEquipementinarm() {
		return this.equipementinarm;
	}

	public void setEquipementinarm(Equipementinarm equipementinarm) {
		this.equipementinarm = equipementinarm;
	}

}
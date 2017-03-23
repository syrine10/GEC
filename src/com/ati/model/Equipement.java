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

	private String nom;

	private int numSerie;

	private byte stock;

	//bi-directional many-to-one association to Datacenter
	@ManyToOne
	@JoinColumn(name="idData")
	private Datacenter datacenter;

	//bi-directional one-to-one association to Equipementinarm
	@OneToOne(mappedBy="equipement")
	private Equipementinarm equipementinarm;

	//bi-directional one-to-one association to Equipementoutarm
	@OneToOne(mappedBy="equipement")
	private Equipementoutarm equipementoutarm;

	//bi-directional many-to-one association to Port
	@OneToMany(mappedBy="equipement")
	private List<Port> ports;

	public Equipement() {
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

	public int getNumSerie() {
		return this.numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public byte getStock() {
		return this.stock;
	}

	public void setStock(byte stock) {
		this.stock = stock;
	}

	public Datacenter getDatacenter() {
		return this.datacenter;
	}

	public void setDatacenter(Datacenter datacenter) {
		this.datacenter = datacenter;
	}

	public Equipementinarm getEquipementinarm() {
		return this.equipementinarm;
	}

	public void setEquipementinarm(Equipementinarm equipementinarm) {
		this.equipementinarm = equipementinarm;
	}

	public Equipementoutarm getEquipementoutarm() {
		return this.equipementoutarm;
	}

	public void setEquipementoutarm(Equipementoutarm equipementoutarm) {
		this.equipementoutarm = equipementoutarm;
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

}
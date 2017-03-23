package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the camera database table.
 * 
 */
@Entity
@NamedQuery(name="Camera.findAll", query="SELECT c FROM Camera c")
public class Camera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipOutArm;

	private String ip;

	private String marque;

	private int resolution;

	//bi-directional one-to-one association to Equipementoutarm
	@OneToOne
	@JoinColumn(name="idEquipOutArm")
	private Equipementoutarm equipementoutarm;

	public Camera() {
	}

	public int getIdEquipOutArm() {
		return this.idEquipOutArm;
	}

	public void setIdEquipOutArm(int idEquipOutArm) {
		this.idEquipOutArm = idEquipOutArm;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getResolution() {
		return this.resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public Equipementoutarm getEquipementoutarm() {
		return this.equipementoutarm;
	}

	public void setEquipementoutarm(Equipementoutarm equipementoutarm) {
		this.equipementoutarm = equipementoutarm;
	}

}
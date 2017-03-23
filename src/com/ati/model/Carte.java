package com.ati.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carte database table.
 * 
 */
@Entity
@NamedQuery(name="Carte.findAll", query="SELECT c FROM Carte c")
public class Carte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int idRouteur;

	public Carte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRouteur() {
		return this.idRouteur;
	}

	public void setIdRouteur(int idRouteur) {
		this.idRouteur = idRouteur;
	}

}
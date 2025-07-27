package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Categoria extends Model {

	public String categoria;
	
	public Categoria() {
		
	}

	public Categoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return categoria;
	}

}

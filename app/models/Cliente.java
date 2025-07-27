package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Cliente extends Model {
	public String nomeCliente;
	public String email;

	@Enumerated(EnumType.STRING)
	public Status status; 
	
	public Cliente() {

	}

	public Cliente(String nomeCliente, String email) {
		this.nomeCliente = nomeCliente;
		this.email = email;
	}
}
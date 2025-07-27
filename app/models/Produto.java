package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Produto extends Model {
	public String nomeProduto;
	public double preco;
	
	@ManyToOne
	public Categoria categoria;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	public Produto() {
		this.status = Status.ATIVO;
	}
	public Produto(String nomeProduto, double preco) {
		this.nomeProduto = nomeProduto;
		this.preco = preco;
	}

}

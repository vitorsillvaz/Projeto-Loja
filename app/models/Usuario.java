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

import play.data.validation.Email;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Usuario extends Model {
	@Required
	@MinSize(10)
	public String nome;

	
	@Required
	@Email
	public String email;

	@Required
	@MinSize(6)
	public String senha;
	
	@Enumerated(EnumType.STRING)
	public Perfil perfil;
	
	@Enumerated(EnumType.STRING)
	public Status status;

	public Usuario() {
		this.status = Status.ATIVO;
		this.perfil = Perfil.ASSISTENTE;
	}
}

package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Produto extends Model {

    @Required
    public String nomeProduto;

    @Required
    @Min(1)
    public double preco;

    @ManyToOne
    public Categoria categoria;

    @Enumerated(EnumType.STRING)
    public Status status;

    public Blob foto;
    public String photofileName;

    public Produto() {
        this.status = Status.ATIVO;
    }

    public Produto(String nomeProduto, double preco) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.status = Status.ATIVO;
    }
}

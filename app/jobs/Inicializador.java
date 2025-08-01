package jobs;

import java.util.Date;

import models.Categoria;
import models.Produto;
import models.Status;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
	@Override
	public void doJob() throws Exception {
		if (Categoria.count() == 0) {
			Categoria proteina = new Categoria("Proteina");
			proteina.save();
			
			Categoria creatina = new Categoria("Creatina");
			creatina.save();
			
			Categoria vitamina = new Categoria("Vitaminas");
			vitamina.save();
			
			Categoria pretreino = new Categoria("Pré-treino");
			pretreino.save();
			
			Categoria postreino = new Categoria("Pós-treino");
			postreino.save();
			
			Produto p1 = new Produto();
			p1.nomeProduto = "Whey Protein Concentrado";
			p1.preco = 124.90;
			p1.categoria = proteina;
			p1.status = Status.ATIVO;
			p1.save();
			
			Produto p2 = new Produto();
			p2.nomeProduto = "Pré-treino Insanity 300g";
			p2.preco = 99.90;
			p2.categoria = pretreino;
			p2.status = Status.ATIVO;
			p2.save();
			
			Produto p3 = new Produto();
			p3.nomeProduto = "Multivitamínico (120 cáps)";
			p3.preco = 47.90;
			p3.categoria = vitamina;
			p3.status = Status.ATIVO;
			p3.save();
			
			Produto p4 = new Produto();
			p4.nomeProduto = "Creatina Monohidratada 250g";
			p4.preco = 64.90;
			p4.categoria = creatina;
			p4.status = Status.ATIVO;
			p4.save();
			
			Produto p5 = new Produto();
			p5.nomeProduto = "Rice Protein 1kg (COM SABOR) ";
			p5.preco = 89.90;
			p5.categoria = postreino;
			p5.status = Status.ATIVO;
			p5.save();
		}
			
			
	}

}

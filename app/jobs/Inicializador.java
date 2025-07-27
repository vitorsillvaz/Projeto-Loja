package jobs;

import java.util.Date;

import models.Categoria;
import models.Produto;
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
			p1.save();
		}
			
			
	}

}

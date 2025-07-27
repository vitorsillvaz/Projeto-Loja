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
			
			Produto p1 = new Produto();
			p1.nomeProduto = "João da Silva";
			p1.preco = 153.0;
			p1.categoria = proteina;
			p1.save();
		}
			
			
	}

}

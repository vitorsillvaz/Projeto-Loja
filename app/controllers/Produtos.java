package controllers;
import play.*;
import play.mvc.*;
import java.util.List;
import java.util.*;

import models.Categoria;
import models.Produto;
import models.Status;
import security.Administrador;

@With(Seguranca.class)
public class Produtos extends Controller {

	@Administrador
	public static void form() {
		List<Categoria> categorias = Categoria.findAll();
		render(categorias);
	}

	public static void listar(String termo) {
		List<Produto> produtos = null;
		if (termo == null) {
			produtos = Produto.find("status <> ?1", Status.INATIVO).fetch();
		} else {
			produtos = Produto.find("(lower(nomeProduto) like ?1 " + "or lower(categoria.categoria) like ?1) and status <> ?2",
					"%" + termo.toLowerCase() + "%", Status.INATIVO).fetch();
		}
		render(produtos, termo);
	}

	public static void detalhar(Produto produto) {
		render(produto);
	}
	@Administrador
	public static void editar(Long id) {
		Produto p = Produto.findById(id);
		List<Categoria> categorias = Categoria.findAll();

		renderTemplate("Produtos/form.html", p, categorias);
	}
	@Administrador
	public static void salvar(Produto produto) {
		
		produto.save();
		detalhar(produto);

	}
	@Administrador
	public static void remover(Long id) {
		Produto produto = Produto.findById(id);
		produto.status = Status.INATIVO;
		produto.save();
		listar(null);
	}
}
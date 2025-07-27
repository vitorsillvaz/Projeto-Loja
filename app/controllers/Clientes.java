package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Clientes extends Controller {

	public static void form() {
		render();
	}

	public static void listar(String termo) {
		List<Cliente> clientes = null;
		if (termo == null) {
			clientes = Cliente.find("status <> ?1", Status.INATIVO).fetch();

		} else {
			clientes = Cliente.find("(lower(nomeCliente) like ?1 " 
		                + "or lower(email) like ?1) and status <> ?2",
					"%" + termo.toLowerCase() + "%", Status.INATIVO).fetch();
		}

		render(clientes, termo);
	}

	public static void detalhar(Cliente cliente) {
		render(cliente);
	}

	public static void editar(Long id) {
		Cliente c = Cliente.findById(id);

		renderTemplate("Clientes/form.html", c);
	}

	public static void salvar(Cliente cliente) {
		if (cliente.nomeCliente != null) {
			cliente.nomeCliente = cliente.nomeCliente.toUpperCase();
		}
		if (cliente.email != null) {
			cliente.email = cliente.email;
		}
		cliente.save();
		detalhar(cliente);
	}

	public static void remover(long id) {
		Cliente cliente = Cliente.findById(id);
		cliente.status = Status.INATIVO;
		cliente.save();
		listar(null);
	}
}
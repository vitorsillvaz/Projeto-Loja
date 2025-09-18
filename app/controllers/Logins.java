package controllers;

import play.*;
import play.libs.Crypto;
import play.mvc.*;

import java.util.*;

import models.Usuario;
 
public class Logins extends Controller {

	public static void form() {
		render();
	}
	
	public static void logar(String email, String senha) {
		Usuario usu = Usuario.find("email = ?1 and senha = ?2",
				email, senha).first();

		if (usu == null) {
			flash.error("Login ou senha inválidos");
			form();
		} else {
			session.put("usuarioLogado", usu.email);
			flash.success("Logado com sucesso!");
			Produtos.listar(null);
		}
	}

	public static void sair() {
		session.clear();
		flash.success("Você saiu do sistema!");
		form();
	}
}
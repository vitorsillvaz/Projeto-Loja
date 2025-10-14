package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Usuario;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

public class Usuarios extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void salvar(Usuario usuario) {
		
		// Verifica se o nome está vazio
		if(usuario.nome == null || usuario.nome.trim().isEmpty() || usuario.senha.length() < 8) {
			flash.error("Por favor, informe seu nome completo!");
			form();
			return;
		}
		// Verifica se o e-mail contém "@"
	    if (usuario.email == null || !usuario.email.contains("@" + ".com")) {
	        flash.error("O e-mail inválido!");
	        form();
	        return;
	    }
		// Verifica se a senha tem pelo menos 6 caracteres
	    if (usuario.senha == null || usuario.senha.length() < 6) {
	        flash.error("A senha deve ter pelo menos 6 caracteres!");
	        form();
	        return;
	    }
	    
		usuario.save();
		flash.success("Usuário cadastrado!");
		form();
		

	}
}

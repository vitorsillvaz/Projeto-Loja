package controllers;

import play.*;
import play.libs.Crypto;
import play.mvc.*;

import java.util.*;

import models.Usuario;

public class Login extends Controller {

	public static void teste() {
		Usuario u = new Usuario();
		u.nome = "admin";
		u.email = "admin@admin.com";
		u.senha = "12345";
		u.save();
		
		form();
	}
	
	public static void form() {
		render();
	}

	public static void logar(String email, String senha) {
		
		Usuario usu = Usuario.find("email = ?1 and senha = ?2", email, Crypto.passwordHash(senha)).first();

		if (usu == null) {
			form();
		} else {
           session.put("usuario.email", usu.email);
           
           Usuarios.form();
		}
	}
	public static void sair() {
		session.clear();
		Login.form();
	}
}
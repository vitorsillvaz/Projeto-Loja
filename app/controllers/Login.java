package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.Usuario;

public class Login extends Controller {

	public static void form() {
		render();
	}

	public static void logar(String email, String senha) {
		Usuario usu = Usuario.find("email = ?1 and senha = ?2", email, senha).first();

		if (usu == null) {
			form();
		} else {
           session.put("usuario.email", usu.email);
           
           Usuarios.listar();
		}
	}
}
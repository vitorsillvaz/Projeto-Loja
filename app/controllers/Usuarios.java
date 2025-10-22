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

	public static void salvar(@Valid Usuario usuario) {
		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			form();
		}

		usuario.save();
		flash.success("Usuário cadastrado!");
		Logins.form();
  
	}
}

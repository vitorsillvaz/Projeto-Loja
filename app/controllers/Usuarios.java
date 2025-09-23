package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Usuario;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;
import security.Administrador;

@With(Seguranca.class)
public class Usuarios extends Controller {
	
	@Administrador
	public static void form() {
		render();
	}
	
	@Administrador
	public static void salvar(Usuario usuario) {
		usuario.save();
		listar();
	}
	
	public static void editar(Long id) {
		Usuario usuario = Usuario.findById(id);
		renderTemplate("Usuarios/form.html", usuario);
	}
	
	public static void remover(Long id) {
		Usuario usuario = Usuario.findById(id);
		usuario.delete();
		listar();
	}
	
	
	public static void listar() {
		List<Usuario> usuarios = Usuario.findAll();
		render(usuarios);
	}
}

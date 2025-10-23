package controllers;

import play.*;
import play.mvc.*;
import models.Perfil;
import java.util.*;
import security.Administrador;

public class Seguranca extends Controller {
	@Before
	static void verificarAutenticacao() {
		if (!session.contains("usuarioLogado")) {
			flash.error("Você deve logar no sistema.");
			Logins.form();
		}
	}
	
	
	@Before
 	static void verificarAdministrador() {
  	    String perfil = session.get("usuarioPerfil");
  	    Administrador adminAnnotation = getActionAnnotation(Administrador.class);
  	    if (adminAnnotation != null && 
		  !Perfil.ADMINISTRADOR.name().equals(perfil)) {
  	    	flash.error("Acesso restrito aos administradores do sistema.");
  	    	Produtos.listar(null);
  	    }
 	}
}

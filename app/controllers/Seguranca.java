package controllers;

import play.*;
import play.mvc.*;

import java.util.*;


public class Seguranca extends Controller {
	
	@Before
	static void verificarAutenticacao() {
		if (!session.contains("usuarioLogado")) {
			flash.error("Você deve logar no sistema.");
			Logins.form();
		}
	}
}
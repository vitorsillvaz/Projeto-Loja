package controllers;

import play.*;
import play.mvc.*;

import java.util.*;


public class Seguranca extends Controller {

	@Before
    static void verificar() {
		if(session.contains("Usuario.email") == false) {
			Login.form();
		}
    }

}
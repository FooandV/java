package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredential;

/** Esta clase controlador simula que hay una seguridad con un login */

@Controller
public class LoginController {

	/*
	 * se añade logs para validar errores que puedan existir y hacerles un
	 * seguimiento
	 */
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	// Este metodo lo que hace es redirigir al login simulando que hay seguridad
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");

		return "redirect:/login";
	}

	// este metodo suelta la vista del login
	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error= " + error + ", Logout:" + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredential());
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	// este metodo se va encargar del formulario login para autenticarse
	// el metodo va comprobar simplemente si el usuario y la contraseña es user user
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential) {
		LOG.info("METHOD: loginCheck() -- PARAMS: " + userCredential.toString());

		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			LOG.info("Returning to contacts view");

			return "redirect:/contacts/showcontact";
		} else {
			LOG.info("Redirect to login?error");
			return "redirect:/login?error";// esto significa que se debe añadir en el @GetMapping("/") un parametro
		}

	}

}

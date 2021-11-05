package curso.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.spring.model.Usuario;
import curso.spring.service.UsuarioService;

@Controller
@RequestMapping("")
public class MainController {

	@Autowired
	UsuarioService us; // = new UsuarioService();
	
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/login/submit")
	public String logar(Model model, @ModelAttribute Usuario usuario) {

		if(us.comprobarLogin(usuario)) { 
			model.addAttribute("nombre", usuario.getName());
			return "ok";
		}
		else {
			model.addAttribute("mensaje", "El usuario y/o la contraseña no son correctos.");
			model.addAttribute("usuario", new Usuario());
			return "login";
			//return "redirect:/login";
		}
	}
	

}

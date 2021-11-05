package curso.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import curso.spring.model.Usuario;
import curso.spring.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	//private ArrayList<Contacto> listaContactos = listaContactos();
	@Autowired
	UsuarioService us;// = new UsuarioService();
	
	@GetMapping("/listar")
	public String listarUsuarios(Model model) {
		model.addAttribute("lista", us.getListaUsuarios());
		return "usuario/list";
	}
	
	@GetMapping("/crear")
	public String nuevoForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/new";
	}
	
	@PostMapping("/crear/submit")
	public String crear(@ModelAttribute Usuario usuario) {
		us.addUsuario(usuario);
		return "redirect:/usuario/listar";
		//model.addAttribute("lista", us.getListaUsuarios());
		//return "usuario/list";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		us.delUsuario(id);
		return "redirect:/usuario/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String actualizacionForm(@PathVariable int id, Model model) {
		Usuario u = us.getUsuarioXId(id);
		model.addAttribute("usuario", u);
		return "usuario/edit";
	}
	
	@PostMapping("/editar/submit")
	public String actualizar(@ModelAttribute Usuario usuario) {
		us.editUsuario(usuario);
		return "redirect:/usuario/listar";
		//model.addAttribute("lista", us.getListaUsuarios());
		//return "usuario/list";
	}

}

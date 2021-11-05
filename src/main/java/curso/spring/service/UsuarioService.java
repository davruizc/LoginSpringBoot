package curso.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.model.Usuario;
import curso.spring.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository ur;
	
	//private static ArrayList<Usuario> listaUsuarios = new UsuarioService().cargarUsuarios();
	
	@PostConstruct
	public /*ArrayList<Usuario>*/ void cargarUsuarios() {
		//ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario u = new Usuario(1, "admin", "admin", "admin@tiendaonline.es");
		//lista.add(u);
		ur.save(u);
		u = new Usuario(2, "pepe", "1234", "pepe@tiendaonline.es");
		ur.save(u);
		//lista.add(u);
		//return lista;
	}
	
	public List<Usuario> getListaUsuarios() {
		return ur.findAll();
		//return listaUsuarios;
	}
	
	public void addUsuario(Usuario usuario) {
		ur.save(usuario);
		//usuario.setId(listaUsuarios.size()+1);
		//listaUsuarios.add(usuario);
	}
	
	public void delUsuario(int id) {
		Usuario u = ur.getById(id);
		ur.delete(u);
		/*
		for(Usuario u : listaUsuarios) {
			if(u.getId() == id) {
				listaUsuarios.remove(u);
				break;
			}
		}
		*/
		//usuario.setId(listaUsuarios.size()+1);
		//listaUsuarios.add(usuario);
	}
	
	public void editUsuario(Usuario u) {
		//listaUsuarios.add(u);
		ur.save(u);
		/*
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getId() == u.getId()) {
				usuario.setName(u.getName());
				usuario.setEmail(u.getEmail());
				usuario.setPass(u.getPass());
			}
		}
		*/
		
	}
	
	public boolean comprobarLogin(Usuario usuario) {
		boolean result = false;
		List<Usuario> lista = ur.buscarUsuarioLogin(usuario.getName(), usuario.getPass());
		if(!lista.isEmpty()) {
			result = true;
		}
		return result;
	}
	
	public Usuario getUsuarioXId(int id) {
		/*
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
		*/
		Usuario u = ur.getById(id);
		return u;
	}
	
	public static void main(String[] args) {
		UsuarioService us = new UsuarioService();
		us.delUsuario(1);
		us.delUsuario(2);
	}
		
	/*
	public Usuario getUsuarioXNombre(String nombre) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getName().equals(nombre)) {
				return usuario;
			}
		}
		return null;
	}
	
	public ArrayList<Usuario> getListaUsuarios(int num) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		//la lista contiene más elementos
		if(listaUsuarios.size()>num) {
			for(int i=0; i<num; i++) {
				lista.add(listaUsuarios.get(i));
			}
		}
		else {
			return listaUsuarios;
		}
		return lista;
	}
	*/
}

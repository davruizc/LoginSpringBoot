package curso.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import curso.spring.model.Usuario;
import curso.spring.repository.UsuarioRepository;

public class UsuarioService2 {
	
	private static ArrayList<Usuario> listaUsuarios = new UsuarioService2().cargarUsuarios();
	
	public ArrayList<Usuario> cargarUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario u = new Usuario(1, "admin", "admin", "admin@tiendaonline.es");
		lista.add(u);
		u = new Usuario(2, "pepe", "1234", "pepe@tiendaonline.es");
		lista.add(u);
		return lista;
	}
	
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public void addUsuario(Usuario usuario) {
		usuario.setId(listaUsuarios.size()+1);
		listaUsuarios.add(usuario);
	}
	
	public void delUsuario(int id) {
		for(Usuario u : listaUsuarios) {
			if(u.getId() == id) {
				listaUsuarios.remove(u);
				break;
			}
		}
		//usuario.setId(listaUsuarios.size()+1);
		//listaUsuarios.add(usuario);
	}
	
	public void editUsuario(Usuario u) {
		//listaUsuarios.add(u);
		
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getId() == u.getId()) {
				usuario.setName(u.getName());
				usuario.setEmail(u.getEmail());
				usuario.setPass(u.getPass());
			}
		}
		
	}
	
	public boolean comprobarLogin(Usuario usuario) {
		boolean result = false;
		for(Usuario u : listaUsuarios) {
			if(u.getName().equals(usuario.getName()) && u.getPass().equals(usuario.getPass())) {
				result = true;
			}
		}
		return result;
	}

	public Usuario getUsuarioXId(int id) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		UsuarioService2 us = new UsuarioService2();
		us.delUsuario(1);
		us.delUsuario(2);
	}
		
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
}

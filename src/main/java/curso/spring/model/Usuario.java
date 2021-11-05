package curso.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id @GeneratedValue
	private int id;
	private String name;
	private String pass;
	private String email;

	public Usuario() {

	}

	public Usuario(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public Usuario(int id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public Usuario(int id, String name, String pass, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

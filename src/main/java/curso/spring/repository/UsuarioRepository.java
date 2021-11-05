package curso.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import curso.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByName(String name);
	
	@Query(value="select * from Usuario where name=?1 and pass=?2", nativeQuery=true)
	List<Usuario> buscarUsuarioLogin(String name, String pass);
}

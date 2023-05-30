package org.repuestosgaston.app.repository;

import org.repuestosgaston.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);

}

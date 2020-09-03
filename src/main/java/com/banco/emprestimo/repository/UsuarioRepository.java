package com.banco.emprestimo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.emprestimo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	// FROM Usuario u WHERE u.email = :email
	Optional<Usuario> findByEmail(String email);
}

package com.banco.emprestimo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banco.emprestimo.model.Emprestimo;
import com.banco.emprestimo.model.Usuario;


@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
	@Query("FROM Emprestimo e WHERE e.usuario.id = :userId")
	List<Emprestimo> buscarPorUsuario(@Param("userId") Long id);
}
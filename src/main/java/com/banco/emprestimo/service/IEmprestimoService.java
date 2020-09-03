package com.banco.emprestimo.service;

import java.util.List;

import com.banco.emprestimo.model.Emprestimo;

public interface IEmprestimoService {
	
	Emprestimo save(final Emprestimo emprestimo);
	
	Emprestimo getById(final Long id);
	
	List<Emprestimo> buscarPorUsuario(Long id);
}

package com.banco.emprestimo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.banco.emprestimo.model.Usuario;

public interface IUsuarioService extends UserDetailsService {
	
	Usuario save(final Usuario usuario);
	
	Usuario getById(final Long id);
}

package com.banco.emprestimo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.emprestimo.exception.ResourceNotFoundException;
import com.banco.emprestimo.exception.UserAuthenticationNotFoundException;
import com.banco.emprestimo.model.Usuario;
import com.banco.emprestimo.repository.UsuarioRepository;
import com.banco.emprestimo.security.model.UserSecurity;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private UsuarioRepository usuarioRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	@Override
	public Usuario save(final Usuario usuario) {

		// cifra senha do usuario de acordo com o encoder do app
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario getById(final Long id) {
		return this.usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return new UserSecurity(usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UserAuthenticationNotFoundException("Usuário/Senha inválido(s)")));
	}
}

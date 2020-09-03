package com.banco.emprestimo.security.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.banco.emprestimo.model.Usuario;

public class UserSecurity extends Usuario implements UserDetails {

	public UserSecurity(Usuario usuario) {
		setId(usuario.getId());
		setNome(usuario.getNome());
		setEmail(usuario.getEmail());
		setSenha(usuario.getSenha());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority[] { new SimpleGrantedAuthority("ADMIN") });
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

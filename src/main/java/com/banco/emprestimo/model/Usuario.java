package com.banco.emprestimo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.banco.emprestimo.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Usuario(UsuarioDTO usuarioDto) {
		this.id = usuarioDto.getId();
		this.nome = usuarioDto.getNome();
		this.senha = usuarioDto.getSenha();
		this.email = usuarioDto.getEmail();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private String email;
	
	@JsonIgnore
	@Column
	private String senha;


	@JsonIgnoreProperties("usuario")
	@OneToMany(mappedBy = "usuario")
	List<Emprestimo> emprestimos = new ArrayList<>();

}

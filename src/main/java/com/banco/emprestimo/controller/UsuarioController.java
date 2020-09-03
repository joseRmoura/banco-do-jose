package com.banco.emprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.emprestimo.dto.UsuarioDTO;
import com.banco.emprestimo.model.Usuario;
import com.banco.emprestimo.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController {

	private IUsuarioService usuarioService;

	@Autowired
	public UsuarioController(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Usuario> novo(@RequestBody UsuarioDTO usuarioDto) {
		Usuario usuario = usuarioService.save(new Usuario(usuarioDto));

		return ResponseEntity.created(createUri(usuario.getId())).body(usuario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		return ResponseEntity.ok().body(usuarioService.getById(id));
	}
	
}

package com.banco.emprestimo.controller;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public abstract class BaseController {
	
	protected URI createUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}

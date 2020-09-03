package com.banco.emprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.emprestimo.dto.EmprestimoDTO;
import com.banco.emprestimo.model.Emprestimo;
import com.banco.emprestimo.service.IEmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController extends BaseController {

	private IEmprestimoService emprestimoService;

	@Autowired
	public EmprestimoController(IEmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(emprestimoService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Emprestimo> novo(@RequestBody EmprestimoDTO emprestimoDto) {
		Emprestimo emprestimo = emprestimoService.save(new Emprestimo(emprestimoDto));

		return ResponseEntity.created(createUri(emprestimo.getId())).body(emprestimo);
	}

	@GetMapping
	public ResponseEntity<List<Emprestimo>> buscarPorUsuario(@RequestParam("usuario") Long id) {
		List<Emprestimo> emprestimos = emprestimoService.buscarPorUsuario(id);

		if (emprestimos.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(emprestimos);
	}
}

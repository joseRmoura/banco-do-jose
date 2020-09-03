package com.banco.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.emprestimo.exception.ResourceNotFoundException;
import com.banco.emprestimo.model.Emprestimo;
import com.banco.emprestimo.repository.EmprestimoRepository;

@Service
public class EmprestimoServiceImpl implements IEmprestimoService {

	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	public EmprestimoServiceImpl(EmprestimoRepository emprestimoRepository) {
		this.emprestimoRepository = emprestimoRepository;
	}

	@Transactional
	@Override
	public Emprestimo save(final Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	@Override
	public Emprestimo getById(final Long id) {
		return emprestimoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado"));
	}

	@Override
	public List<Emprestimo> buscarPorUsuario(Long id) {
		return emprestimoRepository.buscarPorUsuario(id);
	}

}
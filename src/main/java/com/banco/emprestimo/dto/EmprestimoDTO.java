package com.banco.emprestimo.dto;

import java.math.BigDecimal;

import com.banco.emprestimo.model.SituacaoEmprestimo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmprestimoDTO {
	
	private Long id;

	private String motivo;

	private BigDecimal valor;
	
	private SituacaoEmprestimo situacao;

	private UsuarioDTO usuario;
}

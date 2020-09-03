package com.banco.emprestimo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.banco.emprestimo.dto.EmprestimoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties("usuario")
@Data
@NoArgsConstructor
@Entity
@Table(name = "emprestimos")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 1L;

	public Emprestimo(EmprestimoDTO emprestimoDto) {
		this.id = emprestimoDto.getId();
		this.motivo = emprestimoDto.getMotivo();
		this.valor = emprestimoDto.getValor();
		this.situacao = emprestimoDto.getSituacao();
		this.usuario = new Usuario(emprestimoDto.getUsuario());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String motivo;

	@Column
	private BigDecimal valor;

	@Column
	@Enumerated(EnumType.STRING)
	private SituacaoEmprestimo situacao;

	@CreationTimestamp
	@Column(name = "data_criacao")
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private LocalDate updatedAt;

	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

}

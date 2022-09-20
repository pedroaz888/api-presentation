package com.produtos.apirest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DadosBasicos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	@Column
	private BigDecimal quantidade;
	@Column
	private BigDecimal valor;

	
	
	
	public DadosBasicos(Long id, String nome, BigDecimal quantidade, BigDecimal valor) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		
	}
	
	public DadosBasicos(Produtos produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();
		this.valor = produto.getValor();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}

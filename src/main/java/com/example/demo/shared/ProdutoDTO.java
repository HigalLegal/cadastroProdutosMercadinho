package com.example.demo.shared;

import java.util.Objects;

//o que eu vou usar pra transferir dados entre controller e service
public class ProdutoDTO {

	private Integer id;
	private String nome;
	private Integer quantidade;
	private Double valor;
	private String observacao;
	
	//-------------------------------
	
	public ProdutoDTO() {}

	public ProdutoDTO(Integer id, String nome, Integer quantidade, Double valor, String observacao) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.observacao = observacao;
	}
	
	//-------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	//-------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
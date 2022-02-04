package com.example.demo.view.model;

import java.util.Objects;

//o que eu vou devolver
public class ProdutoResponse {
	
	/*
	 * Digamos que por algum motivo eu não queira retornar a observação na resposta...
	 * */

	private Integer id;
	private String nome;
	private Integer quantidade;
	private Double valor;
	
	//-------------------------------
	
	public ProdutoResponse() {}

	public ProdutoResponse(Integer id, String nome, Integer quantidade, Double valor) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
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
		ProdutoResponse other = (ProdutoResponse) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
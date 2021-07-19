package com.renanmateus.comic.api.exceptionHandler;

public class Campo {

	private String nome;
	private String detalhe;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	public Campo(String nome, String detalhe) {
		super();
		this.nome = nome;
		this.detalhe = detalhe;
	}
	
	
}

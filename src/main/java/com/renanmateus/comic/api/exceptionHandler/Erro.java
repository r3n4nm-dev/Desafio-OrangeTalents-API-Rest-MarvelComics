package com.renanmateus.comic.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 	//  ignore all null fields
public class Erro {

	
	private int status;
	private String mensagem;
	private LocalDateTime dataHora;
	private List<Campo> campos;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	public Erro(int status, String mensagem, LocalDateTime dataHora, List<Campo> campos) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
		this.campos = campos;
	}
	
	
	public Erro(int status, String mensagem, LocalDateTime dataHora) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
	
	}
	


}

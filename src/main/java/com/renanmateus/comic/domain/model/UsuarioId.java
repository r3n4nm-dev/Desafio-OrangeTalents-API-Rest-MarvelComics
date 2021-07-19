package com.renanmateus.comic.domain.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Embeddable
public class UsuarioId implements Serializable {
	private static final long serialVersionUID = 1L;

	@CPF(message = "Informe um cpf válido")
	@Column(name = "cpf")
	private String cpf;
	@NotBlank(message=" É Obrigatorio.")
	@Email(message = "Informe um email válido")
	@Column(name = "email")
    private String email;
	
    public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UsuarioId(String cpf, String email) {
		this.cpf = cpf;
		this.email = email;
	}
	public UsuarioId() {
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioId other = (UsuarioId) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}


}


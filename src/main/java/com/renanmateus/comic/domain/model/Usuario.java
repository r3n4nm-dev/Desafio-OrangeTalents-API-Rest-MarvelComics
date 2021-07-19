package com.renanmateus.comic.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Table(name = "USUARIOS")
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Valid
	@EmbeddedId
	@NotNull
	private UsuarioId id;
	@NotBlank(message="É Obrigatorio.")
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	@PastOrPresent
	@NotNull(message = "É Obrigatorio.")
	private LocalDate dataNascimento;
	@ManyToMany (fetch=FetchType.EAGER)
	@JoinTable(name = "usuario_has_comics", 
	joinColumns = { @JoinColumn(name = "cpf", referencedColumnName = "cpf"),
					@JoinColumn(name = "email", referencedColumnName = "email")	},
	inverseJoinColumns = @JoinColumn(name = "comicId", referencedColumnName = "comicId"))
	private List<Comics> comics;

		
	public UsuarioId getId() {
		return id;
	}

	public void setId(UsuarioId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Comics> getComics() {
		return comics;
	}

	public void setComics(List<Comics> comics) {
		this.comics = comics;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comics == null) ? 0 : comics.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (comics == null) {
			if (other.comics != null)
				return false;
		} else if (!comics.equals(other.comics))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Usuario() {
		super();
	}

	public Usuario(UsuarioId id, @NotNull(message = " É Obrigatorio.") String nome,
			@NotNull(message = " É Obrigatorio.") LocalDate dataNascimento, List<Comics> comics) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.comics = comics;
	}
	
	
}


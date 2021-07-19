package com.renanmateus.comic.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "COMICS")
public class Comics implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long comicId;
	@Column(nullable = true, length = 255)
	private String titulo;
	@Column(nullable = true, length = 255)
	private double preco;
	@Column(nullable = true, length = 255)
	private String autores;
	@Column(nullable = true, length = 255)
	private String isbn;
	@Lob
	@Column(nullable = true)
	private String descricao;
	@Column(nullable = true, length = 255)
	private String diaDesconto;
	@Column(nullable = true, length = 255)
	private boolean descontoAtivo;
	
	public boolean isDescontoAtivo() {
		return descontoAtivo;
	}

	public void setDescontoAtivo(boolean descontoAtivo) {
		this.descontoAtivo = descontoAtivo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getComicId() {
		return comicId;
	}

	public void setComicId(long comicId) {
		this.comicId = comicId;
	}

	


	public String getDiaDesconto() {
		return diaDesconto;
	}

	public void setDiaDesconto(String diaDesconto) {
		this.diaDesconto = diaDesconto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}


	
	



	public Comics(long comicId, String titulo, double preco, String autores, String isbn, String descricao,
			String diaDesconto, boolean descontoAtivo) {
		super();
		this.comicId = comicId;
		this.titulo = titulo;
		this.preco = preco;
		this.autores = autores;
		this.isbn = isbn;
		this.descricao = descricao;
		this.diaDesconto = diaDesconto;
		this.descontoAtivo = descontoAtivo;
	}

	public Comics() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + (int) (comicId ^ (comicId >>> 32));
		result = prime * result + (descontoAtivo ? 1231 : 1237);
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((diaDesconto == null) ? 0 : diaDesconto.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Comics other = (Comics) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (comicId != other.comicId)
			return false;
		if (descontoAtivo != other.descontoAtivo)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diaDesconto == null) {
			if (other.diaDesconto != null)
				return false;
		} else if (!diaDesconto.equals(other.diaDesconto))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	

	
}

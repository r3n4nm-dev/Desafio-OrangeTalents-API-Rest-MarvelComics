package com.renanmateus.comic.domain.utils.model;

import java.util.List;

public class Result {

	
	private int id;
	private String title;
	private String description;
	private String isbn;
	private List<Price> prices;
	private Creator creators;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
	
	public Creator getCreators() {
		return creators;
	}
	public void setCreators(Creator creators) {
		this.creators = creators;
	}
	
	
	public Result(int id, String title, String description, String isbn, List<Price> prices, Creator creators) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.isbn = isbn;
		this.prices = prices;
		this.creators = creators;
	}
	
	public Result() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creators == null) ? 0 : creators.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((prices == null) ? 0 : prices.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Result other = (Result) obj;
		if (creators == null) {
			if (other.creators != null)
				return false;
		} else if (!creators.equals(other.creators))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (prices == null) {
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}

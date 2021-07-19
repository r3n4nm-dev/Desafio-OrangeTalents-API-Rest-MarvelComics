package com.renanmateus.comic.domain.utils.model;

public class ComicFeign {	
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public ComicFeign(Data data) {
		super();
		this.data = data;
	}
public ComicFeign() {}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((data == null) ? 0 : data.hashCode());
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
	ComicFeign other = (ComicFeign) obj;
	if (data == null) {
		if (other.data != null)
			return false;
	} else if (!data.equals(other.data))
		return false;
	return true;
}


}

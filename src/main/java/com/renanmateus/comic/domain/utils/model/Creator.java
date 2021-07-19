package com.renanmateus.comic.domain.utils.model;

import java.util.List;

public class Creator {
private List<Item> items;

public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((items == null) ? 0 : items.hashCode());
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
	Creator other = (Creator) obj;
	if (items == null) {
		if (other.items != null)
			return false;
	} else if (!items.equals(other.items))
		return false;
	return true;
}

public Creator(List<Item> items) {
	super();
	this.items = items;
}

public Creator() {}
}

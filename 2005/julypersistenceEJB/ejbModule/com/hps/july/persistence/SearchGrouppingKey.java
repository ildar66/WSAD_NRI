package com.hps.july.persistence;

public class SearchGrouppingKey implements java.io.Serializable {
	public int searchGroupping;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SearchGrouppingKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSearchGroupping int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SearchGrouppingKey(int argSearchGroupping) {
	searchGroupping = argSearchGroupping;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SearchGrouppingKey) {
		SearchGrouppingKey otherKey = (SearchGrouppingKey) o;
		return (((this.searchGroupping == otherKey.searchGroupping)));
	}
	else
		return false;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new java.lang.Integer(searchGroupping).hashCode()));
}
}

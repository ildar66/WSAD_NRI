package com.hps.july.persistence;

public class CurrencyKey implements java.io.Serializable {
	public int currency;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CurrencyKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argCurrency int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CurrencyKey(int argCurrency) {
	currency = argCurrency;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof CurrencyKey) {
		CurrencyKey otherKey = (CurrencyKey) o;
		return (((this.currency == otherKey.currency)));
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
	return ((new java.lang.Integer(currency).hashCode()));
}
}

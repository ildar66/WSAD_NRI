package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: Country
 */
public class CountryKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: country
	 */
	public int country;
	/**
	 * Creates an empty key for Entity Bean: Country
	 */
	public CountryKey() {
	}
	/**
	 * Creates a key for Entity Bean: Country
	 */
	public CountryKey(int country) {
		this.country = country;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence2.CountryKey) {
			com.hps.july.persistence2.CountryKey o =
				(com.hps.july.persistence2.CountryKey) otherKey;
			return ((this.country == o.country));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(country).hashCode()));
	}
}

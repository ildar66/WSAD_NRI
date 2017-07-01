package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: AfsScheme
 */
public class AfsSchemeKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: schemeid
	 */
	public java.lang.Integer schemeid;
	/**
	 * Creates an empty key for Entity Bean: AfsScheme
	 */
	public AfsSchemeKey() {
		super();
	}
	/**
	 * Creates a key for Entity Bean: AfsScheme
	 */
	public AfsSchemeKey(java.lang.Integer schemeid) {
		this.schemeid = schemeid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence2.AfsSchemeKey) {
			com.hps.july.persistence2.AfsSchemeKey o =
				(com.hps.july.persistence2.AfsSchemeKey) otherKey;
			return ((this.schemeid.equals(o.schemeid)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (schemeid.hashCode());
	}
}
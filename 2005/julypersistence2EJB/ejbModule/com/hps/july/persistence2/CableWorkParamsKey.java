package com.hps.july.persistence2;

public class CableWorkParamsKey implements java.io.Serializable {
	public short band;
	public int id_anten;
	public int id_cable;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CableWorkParamsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBand short
 * @param argId_anten int
 * @param argId_cable int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CableWorkParamsKey(short argBand, int argId_anten, int argId_cable) {
	band = argBand;
	id_anten = argId_anten;
	id_cable = argId_cable;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof CableWorkParamsKey) {
		CableWorkParamsKey otherKey = (CableWorkParamsKey) o;
		return (((this.band == otherKey.band)
		 && (this.id_anten == otherKey.id_anten)
		 && (this.id_cable == otherKey.id_cable)));
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
	return ((new Short(band).hashCode())
		 + (new java.lang.Integer(id_anten).hashCode())
		 + (new java.lang.Integer(id_cable).hashCode()));
}
}

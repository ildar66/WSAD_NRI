package com.hps.july.persistence;

public class PIEDogovorLinkKey implements java.io.Serializable {
	public int iddogovornri;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.String typedogovornri;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDogovorLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIddogovornri int
 * @param argTypedogovornri java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDogovorLinkKey(int argIddogovornri, java.lang.String argTypedogovornri) {
	iddogovornri = argIddogovornri;
	typedogovornri = argTypedogovornri;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEDogovorLinkKey) {
		PIEDogovorLinkKey otherKey = (PIEDogovorLinkKey) o;
		return (((this.iddogovornri == otherKey.iddogovornri)
		 && this.typedogovornri.equals(otherKey.typedogovornri)));
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
	return ((new java.lang.Integer(iddogovornri).hashCode())
		 + typedogovornri.hashCode());
}
}

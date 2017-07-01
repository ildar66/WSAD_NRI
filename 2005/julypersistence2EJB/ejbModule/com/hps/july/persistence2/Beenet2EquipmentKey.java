package com.hps.july.persistence2;

public class Beenet2EquipmentKey implements java.io.Serializable {
	public java.lang.String beenetid;
	public int equipment;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Beenet2EquipmentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBeenetid java.lang.String
 * @param argEquipment int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Beenet2EquipmentKey(java.lang.String argBeenetid, int argEquipment) {
	beenetid = argBeenetid;
	equipment = argEquipment;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof Beenet2EquipmentKey) {
		Beenet2EquipmentKey otherKey = (Beenet2EquipmentKey) o;
		return ((this.beenetid.equals(otherKey.beenetid)
		 && (this.equipment == otherKey.equipment)));
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
	return (beenetid.hashCode()
		 + (new java.lang.Integer(equipment).hashCode()));
}
}

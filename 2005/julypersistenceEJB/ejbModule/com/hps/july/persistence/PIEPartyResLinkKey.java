package com.hps.july.persistence;

public class PIEPartyResLinkKey implements java.io.Serializable {
	public int owner;
	public java.lang.String party;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPartyResLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOwner int
 * @param argParty java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPartyResLinkKey(int argOwner, java.lang.String argParty) {
	owner = argOwner;
	party = argParty;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEPartyResLinkKey) {
		PIEPartyResLinkKey otherKey = (PIEPartyResLinkKey) o;
		return (((this.owner == otherKey.owner)
		 && this.party.equals(otherKey.party)));
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
	return ((new java.lang.Integer(owner).hashCode())
		 + party.hashCode());
}
}

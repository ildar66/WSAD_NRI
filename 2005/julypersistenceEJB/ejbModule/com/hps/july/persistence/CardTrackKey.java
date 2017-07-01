package com.hps.july.persistence;

public class CardTrackKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int trackId;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CardTrackKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argTrackId int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CardTrackKey(int argTrackId) {
	trackId = argTrackId;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof CardTrackKey) {
		CardTrackKey otherKey = (CardTrackKey) o;
		return (((this.trackId == otherKey.trackId)));
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
	return ((new java.lang.Integer(trackId).hashCode()));
}
}

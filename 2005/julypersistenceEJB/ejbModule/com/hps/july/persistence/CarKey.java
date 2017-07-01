package com.hps.july.persistence;

public class CarKey implements java.io.Serializable {
	public int car;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CarKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argCar int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CarKey(int argCar) {
	car = argCar;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof CarKey) {
		CarKey otherKey = (CarKey) o;
		return (((this.car == otherKey.car)));
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
	return ((new java.lang.Integer(car).hashCode()));
}
}

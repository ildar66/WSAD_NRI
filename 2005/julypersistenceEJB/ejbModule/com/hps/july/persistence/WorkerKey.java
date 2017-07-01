package com.hps.july.persistence;

public class WorkerKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int worker;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public WorkerKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argWorker int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public WorkerKey(int argWorker) {
	worker = argWorker;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof WorkerKey) {
		WorkerKey otherKey = (WorkerKey) o;
		return (((this.worker == otherKey.worker)));
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
	return ((new java.lang.Integer(worker).hashCode()));
}
}

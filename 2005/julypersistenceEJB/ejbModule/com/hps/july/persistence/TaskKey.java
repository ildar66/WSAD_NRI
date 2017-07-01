package com.hps.july.persistence;

public class TaskKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int task;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public TaskKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argTask int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public TaskKey(int argTask) {
	task = argTask;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof TaskKey) {
		TaskKey otherKey = (TaskKey) o;
		return (((this.task == otherKey.task)));
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
	return ((new java.lang.Integer(task).hashCode()));
}
}

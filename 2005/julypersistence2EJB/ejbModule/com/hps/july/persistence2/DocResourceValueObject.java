package com.hps.july.persistence2;

public class DocResourceValueObject
	implements java.io.Serializable
{
	private int resource;
	private String freqrange;
public DocResourceValueObject() {
	super();
}
public DocResourceValueObject(int resource, String freqrange) {
	this();
	this.resource = resource;
	this.freqrange = freqrange;
	
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFreqrange() {
	return freqrange;
}
/**
 * 
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * 
 * @param newFreqrange java.lang.String
 */
public void setFreqrange(java.lang.String newFreqrange) {
	freqrange = newFreqrange;
}
/**
 * 
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
}

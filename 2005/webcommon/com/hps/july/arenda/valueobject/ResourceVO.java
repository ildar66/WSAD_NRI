package com.hps.july.arenda.valueobject;

/**
 * контейнер "Ресурсов".
 * Creation date: (15.04.2004 14:04:37)
 * @author: Shafigullin Ildar
 */
public class ResourceVO {
	private java.lang.Integer resource;
	private java.lang.String name;
/**
 * ResourceVO constructor comment.
 */
public ResourceVO(Integer newResource) {
	super();
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:07:10)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:05:40)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:07:10)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
}

package com.hps.july.project.valueobject;

/**
 * Объект для хранения зоны сети.
 * Creation date: (26.09.2003 18:19:50)
 * @author: Dmitry Dneprov
 */
public class NetzoneObject {
	private int netzone;
	private java.lang.String name;
/**
 * NetzoneObject constructor comment.
 */
public NetzoneObject(int azoneId, String azonename) {
	super();
	netzone = azoneId;
	name = azonename;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:59:10)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:58:58)
 * @return int
 */
public int getNetzone() {
	return netzone;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:59:10)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:58:58)
 * @param newNetzone int
 */
public void setNetzone(int newNetzone) {
	netzone = newNetzone;
}
}

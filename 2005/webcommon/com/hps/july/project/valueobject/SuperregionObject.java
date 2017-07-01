package com.hps.july.project.valueobject;

/**
 * Объект для хранения суперрегиона.
 * Creation date: (26.09.2003 18:19:50)
 * @author: Dmitry Dneprov
 */
public class SuperregionObject {
	private int supregid;
	private java.lang.String supregname;
/**
 * RegionObject constructor comment.
 */
public SuperregionObject(int asupregId, String asupregname) {
	super();
	supregid = asupregId;
	supregname = asupregname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:22:22)
 * @return int
 */
public int getSupregid() {
	return supregid;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:46:50)
 * @return java.lang.String
 */
public java.lang.String getSupregname() {
	return supregname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:22:22)
 * @param newSupregid int
 */
public void setSupregid(int newSupregid) {
	supregid = newSupregid;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:46:50)
 * @param newSupregname java.lang.String
 */
public void setSupregname(java.lang.String newSupregname) {
	supregname = newSupregname;
}
}

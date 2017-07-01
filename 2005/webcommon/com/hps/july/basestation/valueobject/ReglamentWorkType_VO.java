package com.hps.july.basestation.valueobject;

/**
 * Тип работы.
 * Creation date: (28.07.2005 18:25:55)
 * @author: Shafigullin Ildar
 */
public class ReglamentWorkType_VO {
	private int idtype;
	private java.lang.String nametype;
/**
 * ReglamentWorkType_VO constructor comment.
 */
public ReglamentWorkType_VO(int id, String name) {
	super();
	idtype= id;
	nametype = name;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:26:55)
 * @return int
 */
public int getIdtype() {
	return idtype;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:28:07)
 * @return java.lang.String
 */
public java.lang.String getNametype() {
	return nametype;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:26:55)
 * @param newIdtype int
 */
public void setIdtype(int newIdtype) {
	idtype = newIdtype;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:28:07)
 * @param newNametype java.lang.String
 */
public void setNametype(java.lang.String newNametype) {
	nametype = newNametype;
}
}

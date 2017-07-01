package com.hps.july.basestation.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (08.07.2005 17:10:16)
 * @author: Shafigullin Ildar
 */
public class DonorRepiterVO {
	private java.lang.String numberGSM;
	private java.lang.String namePos;
/**
 * DonorRepiterVO constructor comment.
 */
public DonorRepiterVO(String aNumberGSM, String aNamePos) {
	super();
	setNumberGSM(aNumberGSM);
	setNamePos(aNamePos);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 17:10:56)
 * @return java.lang.String
 */
public java.lang.String getNamePos() {
	return namePos;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 17:10:39)
 * @return java.lang.String
 */
public java.lang.String getNumberGSM() {
	return numberGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 17:10:56)
 * @param newNamePos java.lang.String
 */
public void setNamePos(java.lang.String newNamePos) {
	namePos = newNamePos;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 17:10:39)
 * @param newNumberGSM java.lang.String
 */
public void setNumberGSM(java.lang.String newNumberGSM) {
	numberGSM = newNumberGSM;
}
}

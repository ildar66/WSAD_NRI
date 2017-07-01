package com.hps.july.basestation.valueobject;

/**
 * Creation date: (10.07.2005 13:15:19)
 * @author: Shafigullin Ildar
 */
public class Repiter_TO {
	private Repiter_VO o;
	private java.lang.String donorBS;
	private java.lang.String donorSector;
	private java.lang.String donorAntenn;
/**
 * Repiter_TO constructor comment.
 */
public Repiter_TO(Repiter_VO vo) {
	super();
	o = vo;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 15:46:06)
 * @return java.lang.String
 */
public java.lang.String getDonorAntenn() {
	return donorAntenn;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2005 13:31:12)
 * @return java.lang.String
 */
public java.lang.String getDonorBS() {
	return donorBS;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2005 13:33:52)
 * @return java.lang.String
 */
public java.lang.String getDonorSector() {
	return donorSector;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2005 13:39:07)
 * @return com.hps.july.basestation.valueobject.Repiter_VO
 */
public Repiter_VO getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 15:46:06)
 * @param newDonorAntenn java.lang.String
 */
public void setDonorAntenn(java.lang.String newDonorAntenn) {
	donorAntenn = newDonorAntenn;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2005 13:31:12)
 * @param newDonorBS java.lang.String
 */
public void setDonorBS(java.lang.String newDonorBS) {
	donorBS = newDonorBS;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2005 13:33:52)
 * @param newDonorSector java.lang.String
 */
public void setDonorSector(java.lang.String newDonorSector) {
	donorSector = newDonorSector;
}
}

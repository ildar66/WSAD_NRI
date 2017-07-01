package com.hps.july.basestation.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (08.08.2005 11:15:58)
 * @author: Shafigullin Ildar
 */
public class Sector_TO {
	private Sector_VO vo;
	private java.lang.String trxstring;
/**
 * Sector_TO constructor comment.
 */
public Sector_TO(Sector_VO vo) {
	super();
	this.vo = vo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:22:02)
 * @return java.lang.String
 */
public java.lang.String getTrxstring() {
	return trxstring;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:16:16)
 * @return com.hps.july.basestation.valueobject.Sector_VO
 */
public Sector_VO getVo() {
	return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:22:02)
 * @param newTrxstring java.lang.String
 */
public void setTrxstring(java.lang.String newTrxstring) {
	trxstring = newTrxstring;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 11:16:16)
 * @param newVo com.hps.july.basestation.valueobject.Sector_VO
 */
public void setVo(Sector_VO newVo) {
	vo = newVo;
}
}

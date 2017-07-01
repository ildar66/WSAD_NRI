package com.hps.july.arenda.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (08.11.2005 17:21:53)
 * @author: Shafigullin Ildar
 */
public class LoanAktGetPut_TO {
    private java.lang.String ourManName;
    private LoanAktGetPut_VO vo;
/**
 * LoanAktGetPut_TO constructor comment.
 * @param id java.lang.Integer
 * @param loanContractID java.lang.Integer
 */
public LoanAktGetPut_TO(LoanAktGetPut_VO vo) {
    super();
    this.vo = vo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 17:23:17)
 * @return java.lang.String
 */
public java.lang.String getOurManName() {
	return ourManName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 17:09:16)
 * @return com.hps.july.arenda.valueobject.LoanAktGetPut_VO
 */
public LoanAktGetPut_VO getVo() {
	return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 17:23:17)
 * @param newOurManName java.lang.String
 */
public void setOurManName(java.lang.String newOurManName) {
	ourManName = newOurManName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 17:09:16)
 * @param newVo com.hps.july.arenda.valueobject.LoanAktGetPut_VO
 */
public void setVo(LoanAktGetPut_VO newVo) {
	vo = newVo;
}
}

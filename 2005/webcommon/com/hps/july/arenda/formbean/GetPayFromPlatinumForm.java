package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "плптежи из системы Platinum".
 * Creation date: (08.04.2003 9:53:01)
 * @author: Sergey Gourov
 */
public class GetPayFromPlatinumForm extends org.apache.struts.action.ActionForm {
	private int leaseDocPosition;
	private java.lang.Boolean isSuccess;
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 9:55:57)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSuccess() {
	return isSuccess;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 9:53:30)
 * @return int
 */
public int getLeaseDocPosition() {
	return leaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 9:55:57)
 * @param newIsSuccess java.lang.Boolean
 */
public void setIsSuccess(java.lang.Boolean newIsSuccess) {
	isSuccess = newIsSuccess;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 9:53:30)
 * @param newLeaseDocPosition int
 */
public void setLeaseDocPosition(int newLeaseDocPosition) {
	leaseDocPosition = newLeaseDocPosition;
}
}

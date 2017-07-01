package com.hps.july.persistence;

/**
 * EJSFinderProjectActionTypeBean
 */
public interface EJSFinderProjectActionTypeBean {
	/**
	 * findProjectActionTypesByResponsibilitytype
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionTypesByResponsibilitytype(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByProjecttypeOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjecttypeOrderByCodeAsc(java.lang.Integer argProjectType, java.lang.Integer argProjectActionType) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectActionTypesByAction2division
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionTypesByAction2division(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByCodeAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}

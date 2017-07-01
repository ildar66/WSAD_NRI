package com.hps.july.persistence;

/**
 * EJSFinderI13nActResourceSetBean
 */
public interface EJSFinderI13nActResourceSetBean {
	/**
	 * findI13nActResourceSetByI13nAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nActResourceSetByI13nAct(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findI13nActResourceSetByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nActResourceSetByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBlockingRecord
	 */
	public com.hps.july.persistence.I13nActResourceSet findBlockingRecord(java.lang.Integer argResource, java.lang.Integer argStorage, java.sql.Date docDate, java.lang.Integer argCurrentDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
}

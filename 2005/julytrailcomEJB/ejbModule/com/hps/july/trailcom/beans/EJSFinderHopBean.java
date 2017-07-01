package com.hps.july.trailcom.beans;

/**
 * EJSFinderHopBean
 */
public interface EJSFinderHopBean {
	/**
	 * findBySiteid_endbOrderByHopsidAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySiteid_endbOrderByHopsidAsc(java.lang.Integer siteid_endb) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySiteid_endaOrderByHopsidAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySiteid_endaOrderByHopsidAsc(java.lang.Integer siteid_enda) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPositions
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPositions(java.lang.Boolean isTypeR, java.lang.Boolean isTypeO, java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPositionAndType
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPositionAndType(java.lang.String hopstype, java.lang.Integer siteid_enda, java.lang.Integer siteid_endb) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findNestedLines
	 */
	public com.ibm.ejs.persistence.EJSFinder findNestedLines(java.lang.Boolean useType, java.lang.String type, java.lang.Integer hop, java.lang.Integer position) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findHopsByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findHopsByPosition(java.lang.Integer position) throws javax.ejb.FinderException, java.rmi.RemoteException;
}

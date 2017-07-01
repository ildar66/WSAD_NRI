package com.hps.july.trailcom.beans;

/**
 * EJSFinderHopLabelBean
 */
public interface EJSFinderHopLabelBean {
	/**
	 * findHopLabelsByHopid
	 */
	public com.ibm.ejs.persistence.EJSFinder findHopLabelsByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByHopsidOrderByHopslabelidAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByHopsidOrderByHopslabelidAsc(java.lang.Integer hopid) throws javax.ejb.FinderException, java.rmi.RemoteException;
}

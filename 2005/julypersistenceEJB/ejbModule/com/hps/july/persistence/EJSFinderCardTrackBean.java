package com.hps.july.persistence;

/**
 * EJSFinderCardTrackBean
 */
public interface EJSFinderCardTrackBean {
	/**
	 * findCardTrackByDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findCardTrackByDocument(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findCardTrackFromByFrom
	 */
	public com.ibm.ejs.persistence.EJSFinder findCardTrackFromByFrom(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySerialAfterId
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySerialAfterId(java.lang.String argSerial, java.lang.Integer id) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findCardTrackByCard
	 */
	public com.ibm.ejs.persistence.EJSFinder findCardTrackByCard(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLastDocumentTrack
	 */
	public com.hps.july.persistence.CardTrack findLastDocumentTrack(java.lang.Integer argCard, java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findCardTrackToByTo
	 */
	public com.ibm.ejs.persistence.EJSFinder findCardTrackToByTo(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBeforeDocument
	 */
	public com.hps.july.persistence.CardTrack findBeforeDocument(java.lang.Integer argCard, java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
}

package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: Bank
 */
public interface BankHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: Bank
	 * 
	 */
	public com.hps.july.persistence.Bank create(java.lang.Integer idBank) throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: Bank
	 */
	public com.hps.july.persistence.Bank findByPrimaryKey(java.lang.Integer primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	public com.hps.july.persistence.Bank findBankByBik(java.lang.String argBik) throws javax.ejb.FinderException, java.rmi.RemoteException;
}

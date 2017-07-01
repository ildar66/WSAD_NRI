package com.hps.july.persistence;

/**
 * EJSFinderBankBean
 */
public interface EJSFinderBankBean {
	/**
	 * findBankByBik
	 */
	public com.hps.july.persistence.Bank findBankByBik(java.lang.String argBik) throws javax.ejb.FinderException, java.rmi.RemoteException;
}

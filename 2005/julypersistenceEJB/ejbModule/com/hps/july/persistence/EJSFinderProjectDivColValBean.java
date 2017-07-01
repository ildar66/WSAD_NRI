package com.hps.july.persistence;

/**
 * EJSFinderProjectDivColValBean
 */
public interface EJSFinderProjectDivColValBean {
	/**
	 * findProjectDivColValsByProjectDivColumn
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectDivColValsByProjectDivColumn(com.hps.july.persistence.ProjectDivColumnsKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectDivColValsByProject
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectDivColValsByProject(com.hps.july.persistence.ProjectKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}

package com.hps.july.persistence;

/**
 * EJSRemoteCMPSearches
 */
public class EJSRemoteCMPSearches extends com.hps.july.persistence.EJSRemoteCMPSearches_cc646049 implements Searches {
	/**
	 * EJSRemoteCMPSearches
	 */
	public EJSRemoteCMPSearches() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return new com.ibm.ejs.container.EJSDeployedSupport();
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		return;
	}
}

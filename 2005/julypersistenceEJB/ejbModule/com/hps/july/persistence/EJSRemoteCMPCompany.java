package com.hps.july.persistence;

/**
 * EJSRemoteCMPCompany
 */
public class EJSRemoteCMPCompany extends com.hps.july.persistence.EJSRemoteCMPCompany_d6330f7d implements Company {
	/**
	 * EJSRemoteCMPCompany
	 */
	public EJSRemoteCMPCompany() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEBudjet
 */
public class EJSRemoteCMPPIEBudjet extends com.hps.july.persistence.EJSRemoteCMPPIEBudjet_740d54eb implements PIEBudjet {
	/**
	 * EJSRemoteCMPPIEBudjet
	 */
	public EJSRemoteCMPPIEBudjet() throws java.rmi.RemoteException {
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

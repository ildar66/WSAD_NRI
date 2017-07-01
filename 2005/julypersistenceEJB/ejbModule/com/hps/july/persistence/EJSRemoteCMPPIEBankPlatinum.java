package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEBankPlatinum
 */
public class EJSRemoteCMPPIEBankPlatinum extends com.hps.july.persistence.EJSRemoteCMPPIEBankPlatinum_7d2bd30b implements PIEBankPlatinum {
	/**
	 * EJSRemoteCMPPIEBankPlatinum
	 */
	public EJSRemoteCMPPIEBankPlatinum() throws java.rmi.RemoteException {
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

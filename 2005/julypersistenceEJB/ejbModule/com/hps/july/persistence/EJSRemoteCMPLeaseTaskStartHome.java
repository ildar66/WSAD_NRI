package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseTaskStartHome
 */
public class EJSRemoteCMPLeaseTaskStartHome extends com.hps.july.persistence.EJSRemoteCMPLeaseTaskStartHome_4ec6dba1 implements com.hps.july.persistence.LeaseTaskStartHome {
	/**
	 * EJSRemoteCMPLeaseTaskStartHome
	 */
	public EJSRemoteCMPLeaseTaskStartHome() throws java.rmi.RemoteException {
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

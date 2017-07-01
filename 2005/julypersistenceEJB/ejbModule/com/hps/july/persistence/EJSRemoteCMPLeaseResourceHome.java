package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseResourceHome
 */
public class EJSRemoteCMPLeaseResourceHome extends com.hps.july.persistence.EJSRemoteCMPLeaseResourceHome_37b5eaeb implements com.hps.july.persistence.LeaseResourceHome {
	/**
	 * EJSRemoteCMPLeaseResourceHome
	 */
	public EJSRemoteCMPLeaseResourceHome() throws java.rmi.RemoteException {
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

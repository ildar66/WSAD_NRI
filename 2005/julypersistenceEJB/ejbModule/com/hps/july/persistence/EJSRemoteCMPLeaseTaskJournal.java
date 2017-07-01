package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseTaskJournal
 */
public class EJSRemoteCMPLeaseTaskJournal extends com.hps.july.persistence.EJSRemoteCMPLeaseTaskJournal_d1845446 implements LeaseTaskJournal {
	/**
	 * EJSRemoteCMPLeaseTaskJournal
	 */
	public EJSRemoteCMPLeaseTaskJournal() throws java.rmi.RemoteException {
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

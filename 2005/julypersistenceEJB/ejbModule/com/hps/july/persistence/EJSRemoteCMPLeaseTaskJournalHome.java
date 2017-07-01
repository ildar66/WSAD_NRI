package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseTaskJournalHome
 */
public class EJSRemoteCMPLeaseTaskJournalHome extends com.hps.july.persistence.EJSRemoteCMPLeaseTaskJournalHome_d1845446 implements com.hps.july.persistence.LeaseTaskJournalHome {
	/**
	 * EJSRemoteCMPLeaseTaskJournalHome
	 */
	public EJSRemoteCMPLeaseTaskJournalHome() throws java.rmi.RemoteException {
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

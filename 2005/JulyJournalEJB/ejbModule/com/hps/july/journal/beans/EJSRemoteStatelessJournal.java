package com.hps.july.journal.beans;

/**
 * EJSRemoteStatelessJournal
 */
public class EJSRemoteStatelessJournal extends com.hps.july.journal.beans.EJSRemoteStatelessJournal_d19677f4 implements Journal {
	/**
	 * EJSRemoteStatelessJournal
	 */
	public EJSRemoteStatelessJournal() throws java.rmi.RemoteException {
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

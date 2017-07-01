package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatelessJournal
 */
public class EJSRemoteStatelessJournal extends com.hps.july.arenda.sessionbean.EJSRemoteStatelessJournal_408185ce implements Journal {
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

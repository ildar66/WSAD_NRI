package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessParty
 */
public class EJSRemoteStatelessParty extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessParty_dc8443e4 implements Party {
	/**
	 * EJSRemoteStatelessParty
	 */
	public EJSRemoteStatelessParty() throws java.rmi.RemoteException {
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

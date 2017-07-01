package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessPartyHome
 */
public class EJSRemoteStatelessPartyHome extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessPartyHome_dc8443e4 implements com.hps.july.inventory.sessionbean.PartyHome {
	/**
	 * EJSRemoteStatelessPartyHome
	 */
	public EJSRemoteStatelessPartyHome() throws java.rmi.RemoteException {
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

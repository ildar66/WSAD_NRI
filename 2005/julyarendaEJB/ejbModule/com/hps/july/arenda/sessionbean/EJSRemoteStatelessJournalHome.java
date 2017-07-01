package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatelessJournalHome
 */
public class EJSRemoteStatelessJournalHome extends com.hps.july.arenda.sessionbean.EJSRemoteStatelessJournalHome_408185ce implements com.hps.july.arenda.sessionbean.JournalHome {
	/**
	 * EJSRemoteStatelessJournalHome
	 */
	public EJSRemoteStatelessJournalHome() throws java.rmi.RemoteException {
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

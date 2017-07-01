package com.hps.july.journal.beans;

/**
 * EJSRemoteStatelessJournalHome
 */
public class EJSRemoteStatelessJournalHome extends com.hps.july.journal.beans.EJSRemoteStatelessJournalHome_d19677f4 implements com.hps.july.journal.beans.JournalHome {
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

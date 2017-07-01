package com.hps.july.persistence;

/**
 * EJSRemoteCMPSearchesHome
 */
public class EJSRemoteCMPSearchesHome extends com.hps.july.persistence.EJSRemoteCMPSearchesHome_cc646049 implements com.hps.july.persistence.SearchesHome {
	/**
	 * EJSRemoteCMPSearchesHome
	 */
	public EJSRemoteCMPSearchesHome() throws java.rmi.RemoteException {
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

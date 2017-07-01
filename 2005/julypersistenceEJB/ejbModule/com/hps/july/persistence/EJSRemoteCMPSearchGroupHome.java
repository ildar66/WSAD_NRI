package com.hps.july.persistence;

/**
 * EJSRemoteCMPSearchGroupHome
 */
public class EJSRemoteCMPSearchGroupHome extends com.hps.july.persistence.EJSRemoteCMPSearchGroupHome_59f80681 implements com.hps.july.persistence.SearchGroupHome {
	/**
	 * EJSRemoteCMPSearchGroupHome
	 */
	public EJSRemoteCMPSearchGroupHome() throws java.rmi.RemoteException {
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

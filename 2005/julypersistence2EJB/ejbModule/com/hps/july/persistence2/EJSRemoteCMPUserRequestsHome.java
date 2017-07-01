package com.hps.july.persistence2;

/**
 * EJSRemoteCMPUserRequestsHome
 */
public class EJSRemoteCMPUserRequestsHome extends com.hps.july.persistence2.EJSRemoteCMPUserRequestsHome_1c968d68 implements com.hps.july.persistence2.UserRequestsHome {
	/**
	 * EJSRemoteCMPUserRequestsHome
	 */
	public EJSRemoteCMPUserRequestsHome() throws java.rmi.RemoteException {
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

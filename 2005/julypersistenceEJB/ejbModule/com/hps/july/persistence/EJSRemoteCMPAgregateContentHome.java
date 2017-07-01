package com.hps.july.persistence;

/**
 * EJSRemoteCMPAgregateContentHome
 */
public class EJSRemoteCMPAgregateContentHome extends com.hps.july.persistence.EJSRemoteCMPAgregateContentHome_d4664c44 implements com.hps.july.persistence.AgregateContentHome {
	/**
	 * EJSRemoteCMPAgregateContentHome
	 */
	public EJSRemoteCMPAgregateContentHome() throws java.rmi.RemoteException {
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

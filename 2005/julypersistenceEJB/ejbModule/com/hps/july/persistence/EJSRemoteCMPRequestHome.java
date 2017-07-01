package com.hps.july.persistence;

/**
 * EJSRemoteCMPRequestHome
 */
public class EJSRemoteCMPRequestHome extends com.hps.july.persistence.EJSRemoteCMPRequestHome_0e6db469 implements com.hps.july.persistence.RequestHome {
	/**
	 * EJSRemoteCMPRequestHome
	 */
	public EJSRemoteCMPRequestHome() throws java.rmi.RemoteException {
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

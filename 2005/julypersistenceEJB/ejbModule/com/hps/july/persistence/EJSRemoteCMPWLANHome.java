package com.hps.july.persistence;

/**
 * EJSRemoteCMPWLANHome
 */
public class EJSRemoteCMPWLANHome extends com.hps.july.persistence.EJSRemoteCMPWLANHome_a4ea2a90 implements com.hps.july.persistence.WLANHome {
	/**
	 * EJSRemoteCMPWLANHome
	 */
	public EJSRemoteCMPWLANHome() throws java.rmi.RemoteException {
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

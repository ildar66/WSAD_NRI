package com.hps.july.persistence;

/**
 * EJSRemoteCMPNamedValueHome
 */
public class EJSRemoteCMPNamedValueHome extends com.hps.july.persistence.EJSRemoteCMPNamedValueHome_f02f46b8 implements com.hps.july.persistence.NamedValueHome {
	/**
	 * EJSRemoteCMPNamedValueHome
	 */
	public EJSRemoteCMPNamedValueHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPTRXResourceHome
 */
public class EJSRemoteCMPTRXResourceHome extends com.hps.july.persistence.EJSRemoteCMPTRXResourceHome_92b2ea12 implements com.hps.july.persistence.TRXResourceHome {
	/**
	 * EJSRemoteCMPTRXResourceHome
	 */
	public EJSRemoteCMPTRXResourceHome() throws java.rmi.RemoteException {
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

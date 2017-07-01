package com.hps.july.persistence;

/**
 * EJSRemoteCMPRepiterHome
 */
public class EJSRemoteCMPRepiterHome extends com.hps.july.persistence.EJSRemoteCMPRepiterHome_8d933516 implements com.hps.july.persistence.RepiterHome {
	/**
	 * EJSRemoteCMPRepiterHome
	 */
	public EJSRemoteCMPRepiterHome() throws java.rmi.RemoteException {
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

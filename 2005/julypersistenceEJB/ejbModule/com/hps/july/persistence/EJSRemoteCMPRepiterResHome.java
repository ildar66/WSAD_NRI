package com.hps.july.persistence;

/**
 * EJSRemoteCMPRepiterResHome
 */
public class EJSRemoteCMPRepiterResHome extends com.hps.july.persistence.EJSRemoteCMPRepiterResHome_afbcb081 implements com.hps.july.persistence.RepiterResHome {
	/**
	 * EJSRemoteCMPRepiterResHome
	 */
	public EJSRemoteCMPRepiterResHome() throws java.rmi.RemoteException {
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

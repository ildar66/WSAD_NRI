package com.hps.july.persistence;

/**
 * EJSRemoteCMPPositionHome
 */
public class EJSRemoteCMPPositionHome extends com.hps.july.persistence.EJSRemoteCMPPositionHome_324e4597 implements com.hps.july.persistence.PositionHome {
	/**
	 * EJSRemoteCMPPositionHome
	 */
	public EJSRemoteCMPPositionHome() throws java.rmi.RemoteException {
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

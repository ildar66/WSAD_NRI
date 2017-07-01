package com.hps.july.persistence;

/**
 * EJSRemoteCMPChangeLogHome
 */
public class EJSRemoteCMPChangeLogHome extends com.hps.july.persistence.EJSRemoteCMPChangeLogHome_7a6fd283 implements com.hps.july.persistence.ChangeLogHome {
	/**
	 * EJSRemoteCMPChangeLogHome
	 */
	public EJSRemoteCMPChangeLogHome() throws java.rmi.RemoteException {
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

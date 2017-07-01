package com.hps.july.persistence;

/**
 * EJSRemoteCMPGroupHome
 */
public class EJSRemoteCMPGroupHome extends com.hps.july.persistence.EJSRemoteCMPGroupHome_191efb78 implements com.hps.july.persistence.GroupHome {
	/**
	 * EJSRemoteCMPGroupHome
	 */
	public EJSRemoteCMPGroupHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPRole
 */
public class EJSRemoteCMPRole extends com.hps.july.persistence.EJSRemoteCMPRole_745b5a02 implements Role {
	/**
	 * EJSRemoteCMPRole
	 */
	public EJSRemoteCMPRole() throws java.rmi.RemoteException {
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

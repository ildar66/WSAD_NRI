package com.hps.july.persistence;

/**
 * EJSRemoteCMPRoleHome
 */
public class EJSRemoteCMPRoleHome extends com.hps.july.persistence.EJSRemoteCMPRoleHome_745b5a02 implements com.hps.july.persistence.RoleHome {
	/**
	 * EJSRemoteCMPRoleHome
	 */
	public EJSRemoteCMPRoleHome() throws java.rmi.RemoteException {
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

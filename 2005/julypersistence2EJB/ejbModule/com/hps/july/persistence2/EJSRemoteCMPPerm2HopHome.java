package com.hps.july.persistence2;

/**
 * EJSRemoteCMPPerm2HopHome
 */
public class EJSRemoteCMPPerm2HopHome extends com.hps.july.persistence2.EJSRemoteCMPPerm2HopHome_acbed29c implements com.hps.july.persistence2.Perm2HopHome {
	/**
	 * EJSRemoteCMPPerm2HopHome
	 */
	public EJSRemoteCMPPerm2HopHome() throws java.rmi.RemoteException {
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

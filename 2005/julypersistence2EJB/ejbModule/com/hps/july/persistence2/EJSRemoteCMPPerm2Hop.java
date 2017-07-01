package com.hps.july.persistence2;

/**
 * EJSRemoteCMPPerm2Hop
 */
public class EJSRemoteCMPPerm2Hop extends com.hps.july.persistence2.EJSRemoteCMPPerm2Hop_acbed29c implements Perm2Hop {
	/**
	 * EJSRemoteCMPPerm2Hop
	 */
	public EJSRemoteCMPPerm2Hop() throws java.rmi.RemoteException {
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

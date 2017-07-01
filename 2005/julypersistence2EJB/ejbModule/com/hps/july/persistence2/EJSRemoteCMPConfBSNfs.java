package com.hps.july.persistence2;

/**
 * EJSRemoteCMPConfBSNfs
 */
public class EJSRemoteCMPConfBSNfs extends com.hps.july.persistence2.EJSRemoteCMPConfBSNfs_4e13be9f implements ConfBSNfs {
	/**
	 * EJSRemoteCMPConfBSNfs
	 */
	public EJSRemoteCMPConfBSNfs() throws java.rmi.RemoteException {
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

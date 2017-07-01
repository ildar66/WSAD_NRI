package com.hps.july.persistence;

/**
 * EJSRemoteCMPSearchGroup
 */
public class EJSRemoteCMPSearchGroup extends com.hps.july.persistence.EJSRemoteCMPSearchGroup_59f80681 implements SearchGroup {
	/**
	 * EJSRemoteCMPSearchGroup
	 */
	public EJSRemoteCMPSearchGroup() throws java.rmi.RemoteException {
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

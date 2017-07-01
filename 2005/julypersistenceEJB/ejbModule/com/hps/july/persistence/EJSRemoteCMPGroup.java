package com.hps.july.persistence;

/**
 * EJSRemoteCMPGroup
 */
public class EJSRemoteCMPGroup extends com.hps.july.persistence.EJSRemoteCMPGroup_191efb78 implements Group {
	/**
	 * EJSRemoteCMPGroup
	 */
	public EJSRemoteCMPGroup() throws java.rmi.RemoteException {
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

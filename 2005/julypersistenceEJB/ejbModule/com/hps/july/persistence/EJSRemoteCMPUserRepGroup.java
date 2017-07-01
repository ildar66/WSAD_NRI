package com.hps.july.persistence;

/**
 * EJSRemoteCMPUserRepGroup
 */
public class EJSRemoteCMPUserRepGroup extends com.hps.july.persistence.EJSRemoteCMPUserRepGroup_1512cf12 implements UserRepGroup {
	/**
	 * EJSRemoteCMPUserRepGroup
	 */
	public EJSRemoteCMPUserRepGroup() throws java.rmi.RemoteException {
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

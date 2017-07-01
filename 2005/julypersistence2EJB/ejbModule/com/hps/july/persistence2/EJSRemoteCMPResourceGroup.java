package com.hps.july.persistence2;

/**
 * EJSRemoteCMPResourceGroup
 */
public class EJSRemoteCMPResourceGroup extends com.hps.july.persistence2.EJSRemoteCMPResourceGroup_34fe15dc implements ResourceGroup {
	/**
	 * EJSRemoteCMPResourceGroup
	 */
	public EJSRemoteCMPResourceGroup() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceType
 */
public class EJSRemoteCMPResourceType extends com.hps.july.persistence.EJSRemoteCMPResourceType_482c8901 implements ResourceType {
	/**
	 * EJSRemoteCMPResourceType
	 */
	public EJSRemoteCMPResourceType() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPPhoto
 */
public class EJSRemoteCMPPhoto extends com.hps.july.persistence.EJSRemoteCMPPhoto_b9c81ce3 implements Photo {
	/**
	 * EJSRemoteCMPPhoto
	 */
	public EJSRemoteCMPPhoto() throws java.rmi.RemoteException {
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

package com.hps.july.persistence2;

/**
 * EJSRemoteCMPContainer
 */
public class EJSRemoteCMPContainer extends com.hps.july.persistence2.EJSRemoteCMPContainer_91f4bd0b implements Container {
	/**
	 * EJSRemoteCMPContainer
	 */
	public EJSRemoteCMPContainer() throws java.rmi.RemoteException {
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

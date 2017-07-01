package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseMutualActInfo
 */
public class EJSRemoteCMPLeaseMutualActInfo extends com.hps.july.persistence.EJSRemoteCMPLeaseMutualActInfo_77a58df7 implements LeaseMutualActInfo {
	/**
	 * EJSRemoteCMPLeaseMutualActInfo
	 */
	public EJSRemoteCMPLeaseMutualActInfo() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEQueryList
 */
public class EJSRemoteCMPPIEQueryList extends com.hps.july.persistence.EJSRemoteCMPPIEQueryList_543889f5 implements PIEQueryList {
	/**
	 * EJSRemoteCMPPIEQueryList
	 */
	public EJSRemoteCMPPIEQueryList() throws java.rmi.RemoteException {
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

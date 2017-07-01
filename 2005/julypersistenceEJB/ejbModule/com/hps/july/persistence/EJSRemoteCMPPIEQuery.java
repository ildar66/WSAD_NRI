package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEQuery
 */
public class EJSRemoteCMPPIEQuery extends com.hps.july.persistence.EJSRemoteCMPPIEQuery_3b29e425 implements PIEQuery {
	/**
	 * EJSRemoteCMPPIEQuery
	 */
	public EJSRemoteCMPPIEQuery() throws java.rmi.RemoteException {
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

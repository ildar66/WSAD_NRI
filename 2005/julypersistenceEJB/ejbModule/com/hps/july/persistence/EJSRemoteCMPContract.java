package com.hps.july.persistence;

/**
 * EJSRemoteCMPContract
 */
public class EJSRemoteCMPContract extends com.hps.july.persistence.EJSRemoteCMPContract_f0f90933 implements Contract {
	/**
	 * EJSRemoteCMPContract
	 */
	public EJSRemoteCMPContract() throws java.rmi.RemoteException {
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

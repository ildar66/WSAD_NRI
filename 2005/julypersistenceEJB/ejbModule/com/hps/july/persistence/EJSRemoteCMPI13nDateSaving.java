package com.hps.july.persistence;

/**
 * EJSRemoteCMPI13nDateSaving
 */
public class EJSRemoteCMPI13nDateSaving extends com.hps.july.persistence.EJSRemoteCMPI13nDateSaving_85b3cc12 implements I13nDateSaving {
	/**
	 * EJSRemoteCMPI13nDateSaving
	 */
	public EJSRemoteCMPI13nDateSaving() throws java.rmi.RemoteException {
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

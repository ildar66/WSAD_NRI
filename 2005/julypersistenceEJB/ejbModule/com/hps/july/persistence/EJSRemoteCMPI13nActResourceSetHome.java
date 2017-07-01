package com.hps.july.persistence;

/**
 * EJSRemoteCMPI13nActResourceSetHome
 */
public class EJSRemoteCMPI13nActResourceSetHome extends com.hps.july.persistence.EJSRemoteCMPI13nActResourceSetHome_1b32abe9 implements com.hps.july.persistence.I13nActResourceSetHome {
	/**
	 * EJSRemoteCMPI13nActResourceSetHome
	 */
	public EJSRemoteCMPI13nActResourceSetHome() throws java.rmi.RemoteException {
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

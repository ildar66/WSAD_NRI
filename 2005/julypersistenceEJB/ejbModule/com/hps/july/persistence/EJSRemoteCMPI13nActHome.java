package com.hps.july.persistence;

/**
 * EJSRemoteCMPI13nActHome
 */
public class EJSRemoteCMPI13nActHome extends com.hps.july.persistence.EJSRemoteCMPI13nActHome_90887391 implements com.hps.july.persistence.I13nActHome {
	/**
	 * EJSRemoteCMPI13nActHome
	 */
	public EJSRemoteCMPI13nActHome() throws java.rmi.RemoteException {
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

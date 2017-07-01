package com.hps.july.persistence;

/**
 * EJSRemoteCMPAssemblingActHome
 */
public class EJSRemoteCMPAssemblingActHome extends com.hps.july.persistence.EJSRemoteCMPAssemblingActHome_6fcd0905 implements com.hps.july.persistence.AssemblingActHome {
	/**
	 * EJSRemoteCMPAssemblingActHome
	 */
	public EJSRemoteCMPAssemblingActHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence2;

/**
 * EJSRemoteCMPGroup2ResourceHome
 */
public class EJSRemoteCMPGroup2ResourceHome extends com.hps.july.persistence2.EJSRemoteCMPGroup2ResourceHome_ebda9379 implements com.hps.july.persistence2.Group2ResourceHome {
	/**
	 * EJSRemoteCMPGroup2ResourceHome
	 */
	public EJSRemoteCMPGroup2ResourceHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence2;

/**
 * EJSRemoteCMPEtapDocHome
 */
public class EJSRemoteCMPEtapDocHome extends com.hps.july.persistence2.EJSRemoteCMPEtapDocHome_273da4f8 implements com.hps.july.persistence2.EtapDocHome {
	/**
	 * EJSRemoteCMPEtapDocHome
	 */
	public EJSRemoteCMPEtapDocHome() throws java.rmi.RemoteException {
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

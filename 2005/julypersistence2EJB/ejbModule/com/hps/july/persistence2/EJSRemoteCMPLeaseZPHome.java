package com.hps.july.persistence2;

/**
 * EJSRemoteCMPLeaseZPHome
 */
public class EJSRemoteCMPLeaseZPHome extends com.hps.july.persistence2.EJSRemoteCMPLeaseZPHome_93845009 implements com.hps.july.persistence2.LeaseZPHome {
	/**
	 * EJSRemoteCMPLeaseZPHome
	 */
	public EJSRemoteCMPLeaseZPHome() throws java.rmi.RemoteException {
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

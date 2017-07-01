package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEPayPlatinum
 */
public class EJSRemoteCMPPIEPayPlatinum extends com.hps.july.persistence.EJSRemoteCMPPIEPayPlatinum_fb1fdc8d implements PIEPayPlatinum {
	/**
	 * EJSRemoteCMPPIEPayPlatinum
	 */
	public EJSRemoteCMPPIEPayPlatinum() throws java.rmi.RemoteException {
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

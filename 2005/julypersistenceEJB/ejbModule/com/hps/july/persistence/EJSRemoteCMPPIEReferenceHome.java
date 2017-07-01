package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEReferenceHome
 */
public class EJSRemoteCMPPIEReferenceHome extends com.hps.july.persistence.EJSRemoteCMPPIEReferenceHome_9693a3c8 implements com.hps.july.persistence.PIEReferenceHome {
	/**
	 * EJSRemoteCMPPIEReferenceHome
	 */
	public EJSRemoteCMPPIEReferenceHome() throws java.rmi.RemoteException {
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

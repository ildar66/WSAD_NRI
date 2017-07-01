package com.hps.july.persistence;

/**
 * EJSRemoteCMPSwitchParams
 */
public class EJSRemoteCMPSwitchParams extends com.hps.july.persistence.EJSRemoteCMPSwitchParams_7de41f30 implements SwitchParams {
	/**
	 * EJSRemoteCMPSwitchParams
	 */
	public EJSRemoteCMPSwitchParams() throws java.rmi.RemoteException {
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

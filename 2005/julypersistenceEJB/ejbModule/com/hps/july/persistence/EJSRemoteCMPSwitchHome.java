package com.hps.july.persistence;

/**
 * EJSRemoteCMPSwitchHome
 */
public class EJSRemoteCMPSwitchHome extends com.hps.july.persistence.EJSRemoteCMPSwitchHome_dc445190 implements com.hps.july.persistence.SwitchHome {
	/**
	 * EJSRemoteCMPSwitchHome
	 */
	public EJSRemoteCMPSwitchHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPSwitchParamsHome
 */
public class EJSRemoteCMPSwitchParamsHome extends com.hps.july.persistence.EJSRemoteCMPSwitchParamsHome_7de41f30 implements com.hps.july.persistence.SwitchParamsHome {
	/**
	 * EJSRemoteCMPSwitchParamsHome
	 */
	public EJSRemoteCMPSwitchParamsHome() throws java.rmi.RemoteException {
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

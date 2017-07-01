package com.hps.july.persistence;

/**
 * EJSRemoteCMPSwitchAddInfo
 */
public class EJSRemoteCMPSwitchAddInfo extends com.hps.july.persistence.EJSRemoteCMPSwitchAddInfo_5fbc6808 implements SwitchAddInfo {
	/**
	 * EJSRemoteCMPSwitchAddInfo
	 */
	public EJSRemoteCMPSwitchAddInfo() throws java.rmi.RemoteException {
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

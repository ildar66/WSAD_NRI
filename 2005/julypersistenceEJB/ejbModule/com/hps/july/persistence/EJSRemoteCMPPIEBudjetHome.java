package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEBudjetHome
 */
public class EJSRemoteCMPPIEBudjetHome extends com.hps.july.persistence.EJSRemoteCMPPIEBudjetHome_740d54eb implements com.hps.july.persistence.PIEBudjetHome {
	/**
	 * EJSRemoteCMPPIEBudjetHome
	 */
	public EJSRemoteCMPPIEBudjetHome() throws java.rmi.RemoteException {
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

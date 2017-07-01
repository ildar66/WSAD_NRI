package com.hps.july.persistence;

/**
 * EJSRemoteCMPUnitHome
 */
public class EJSRemoteCMPUnitHome extends com.hps.july.persistence.EJSRemoteCMPUnitHome_7609fbf2 implements com.hps.july.persistence.UnitHome {
	/**
	 * EJSRemoteCMPUnitHome
	 */
	public EJSRemoteCMPUnitHome() throws java.rmi.RemoteException {
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

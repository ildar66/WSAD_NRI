package com.hps.july.persistence;

/**
 * EJSRemoteCMPUZOPowerSupplySet
 */
public class EJSRemoteCMPUZOPowerSupplySet extends com.hps.july.persistence.EJSRemoteCMPUZOPowerSupplySet_d36d4692 implements UZOPowerSupplySet {
	/**
	 * EJSRemoteCMPUZOPowerSupplySet
	 */
	public EJSRemoteCMPUZOPowerSupplySet() throws java.rmi.RemoteException {
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

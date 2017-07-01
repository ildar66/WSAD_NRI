package com.hps.july.persistence;

/**
 * EJSRemoteCMPPowerSupplySet
 */
public class EJSRemoteCMPPowerSupplySet extends com.hps.july.persistence.EJSRemoteCMPPowerSupplySet_caaa5cc8 implements PowerSupplySet {
	/**
	 * EJSRemoteCMPPowerSupplySet
	 */
	public EJSRemoteCMPPowerSupplySet() throws java.rmi.RemoteException {
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

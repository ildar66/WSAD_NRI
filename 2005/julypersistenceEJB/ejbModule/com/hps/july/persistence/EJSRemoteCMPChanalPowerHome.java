package com.hps.july.persistence;

/**
 * EJSRemoteCMPChanalPowerHome
 */
public class EJSRemoteCMPChanalPowerHome extends com.hps.july.persistence.EJSRemoteCMPChanalPowerHome_a231b69f implements com.hps.july.persistence.ChanalPowerHome {
	/**
	 * EJSRemoteCMPChanalPowerHome
	 */
	public EJSRemoteCMPChanalPowerHome() throws java.rmi.RemoteException {
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

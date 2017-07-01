package com.hps.july.persistence;

/**
 * EJSRemoteCMPChanalPower
 */
public class EJSRemoteCMPChanalPower extends com.hps.july.persistence.EJSRemoteCMPChanalPower_a231b69f implements ChanalPower {
	/**
	 * EJSRemoteCMPChanalPower
	 */
	public EJSRemoteCMPChanalPower() throws java.rmi.RemoteException {
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

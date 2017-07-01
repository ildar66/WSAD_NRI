package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseCalcRate
 */
public class EJSRemoteCMPLeaseCalcRate extends com.hps.july.persistence.EJSRemoteCMPLeaseCalcRate_be50a3fb implements LeaseCalcRate {
	/**
	 * EJSRemoteCMPLeaseCalcRate
	 */
	public EJSRemoteCMPLeaseCalcRate() throws java.rmi.RemoteException {
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

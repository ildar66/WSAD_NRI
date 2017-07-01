package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseCalcRateHome
 */
public class EJSRemoteCMPLeaseCalcRateHome extends com.hps.july.persistence.EJSRemoteCMPLeaseCalcRateHome_be50a3fb implements com.hps.july.persistence.LeaseCalcRateHome {
	/**
	 * EJSRemoteCMPLeaseCalcRateHome
	 */
	public EJSRemoteCMPLeaseCalcRateHome() throws java.rmi.RemoteException {
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

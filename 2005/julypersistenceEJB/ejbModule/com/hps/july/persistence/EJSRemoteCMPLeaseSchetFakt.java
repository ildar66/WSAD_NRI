package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseSchetFakt
 */
public class EJSRemoteCMPLeaseSchetFakt extends com.hps.july.persistence.EJSRemoteCMPLeaseSchetFakt_be4c2759 implements LeaseSchetFakt {
	/**
	 * EJSRemoteCMPLeaseSchetFakt
	 */
	public EJSRemoteCMPLeaseSchetFakt() throws java.rmi.RemoteException {
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

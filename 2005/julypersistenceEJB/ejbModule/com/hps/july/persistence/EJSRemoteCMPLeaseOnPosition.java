package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseOnPosition
 */
public class EJSRemoteCMPLeaseOnPosition extends com.hps.july.persistence.EJSRemoteCMPLeaseOnPosition_1a97eb14 implements LeaseOnPosition {
	/**
	 * EJSRemoteCMPLeaseOnPosition
	 */
	public EJSRemoteCMPLeaseOnPosition() throws java.rmi.RemoteException {
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

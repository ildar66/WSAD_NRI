package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseDocPosition
 */
public class EJSRemoteCMPLeaseDocPosition extends com.hps.july.persistence.EJSRemoteCMPLeaseDocPosition_40024402 implements LeaseDocPosition {
	/**
	 * EJSRemoteCMPLeaseDocPosition
	 */
	public EJSRemoteCMPLeaseDocPosition() throws java.rmi.RemoteException {
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

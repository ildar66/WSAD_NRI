package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeasePayRule
 */
public class EJSRemoteCMPLeasePayRule extends com.hps.july.persistence.EJSRemoteCMPLeasePayRule_0016f96c implements LeasePayRule {
	/**
	 * EJSRemoteCMPLeasePayRule
	 */
	public EJSRemoteCMPLeasePayRule() throws java.rmi.RemoteException {
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

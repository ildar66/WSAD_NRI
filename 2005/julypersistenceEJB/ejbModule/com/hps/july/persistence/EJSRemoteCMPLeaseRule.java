package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseRule
 */
public class EJSRemoteCMPLeaseRule extends com.hps.july.persistence.EJSRemoteCMPLeaseRule_75a2de69 implements LeaseRule {
	/**
	 * EJSRemoteCMPLeaseRule
	 */
	public EJSRemoteCMPLeaseRule() throws java.rmi.RemoteException {
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

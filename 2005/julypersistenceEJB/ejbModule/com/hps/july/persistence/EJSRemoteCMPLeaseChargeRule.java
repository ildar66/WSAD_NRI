package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseChargeRule
 */
public class EJSRemoteCMPLeaseChargeRule extends com.hps.july.persistence.EJSRemoteCMPLeaseChargeRule_b513c224 implements LeaseChargeRule {
	/**
	 * EJSRemoteCMPLeaseChargeRule
	 */
	public EJSRemoteCMPLeaseChargeRule() throws java.rmi.RemoteException {
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

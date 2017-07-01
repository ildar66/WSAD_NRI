package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseRuleHome
 */
public class EJSRemoteCMPLeaseRuleHome extends com.hps.july.persistence.EJSRemoteCMPLeaseRuleHome_75a2de69 implements com.hps.july.persistence.LeaseRuleHome {
	/**
	 * EJSRemoteCMPLeaseRuleHome
	 */
	public EJSRemoteCMPLeaseRuleHome() throws java.rmi.RemoteException {
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

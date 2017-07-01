package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatelessLeaseArendaAgreementProcessor
 */
public class EJSRemoteStatelessLeaseArendaAgreementProcessor extends com.hps.july.arenda.sessionbean.EJSRemoteStatelessLeaseArendaAgreementProcessor_03acdd81 implements LeaseArendaAgreementProcessor {
	/**
	 * EJSRemoteStatelessLeaseArendaAgreementProcessor
	 */
	public EJSRemoteStatelessLeaseArendaAgreementProcessor() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPBaseAgreement
 */
public class EJSRemoteCMPBaseAgreement extends com.hps.july.persistence.EJSRemoteCMPBaseAgreement_74ca5fa3 implements BaseAgreement {
	/**
	 * EJSRemoteCMPBaseAgreement
	 */
	public EJSRemoteCMPBaseAgreement() throws java.rmi.RemoteException {
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

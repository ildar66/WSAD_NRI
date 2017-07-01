package com.hps.july.persistence;

/**
 * EJSRemoteCMPBankHome
 */
public class EJSRemoteCMPBankHome extends com.hps.july.persistence.EJSRemoteCMPBankHome_96552406 implements com.hps.july.persistence.BankHome {
	/**
	 * EJSRemoteCMPBankHome
	 */
	public EJSRemoteCMPBankHome() throws java.rmi.RemoteException {
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

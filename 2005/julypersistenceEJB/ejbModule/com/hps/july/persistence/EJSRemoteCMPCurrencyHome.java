package com.hps.july.persistence;

/**
 * EJSRemoteCMPCurrencyHome
 */
public class EJSRemoteCMPCurrencyHome extends com.hps.july.persistence.EJSRemoteCMPCurrencyHome_bce2196f implements com.hps.july.persistence.CurrencyHome {
	/**
	 * EJSRemoteCMPCurrencyHome
	 */
	public EJSRemoteCMPCurrencyHome() throws java.rmi.RemoteException {
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

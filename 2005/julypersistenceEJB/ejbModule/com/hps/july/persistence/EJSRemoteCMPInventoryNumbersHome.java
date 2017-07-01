package com.hps.july.persistence;

/**
 * EJSRemoteCMPInventoryNumbersHome
 */
public class EJSRemoteCMPInventoryNumbersHome extends com.hps.july.persistence.EJSRemoteCMPInventoryNumbersHome_bc436f0d implements com.hps.july.persistence.InventoryNumbersHome {
	/**
	 * EJSRemoteCMPInventoryNumbersHome
	 */
	public EJSRemoteCMPInventoryNumbersHome() throws java.rmi.RemoteException {
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

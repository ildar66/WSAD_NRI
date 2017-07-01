package com.hps.july.persistence;

/**
 * EJSRemoteCMPSupplyTypeHome
 */
public class EJSRemoteCMPSupplyTypeHome extends com.hps.july.persistence.EJSRemoteCMPSupplyTypeHome_ef5af5dc implements com.hps.july.persistence.SupplyTypeHome {
	/**
	 * EJSRemoteCMPSupplyTypeHome
	 */
	public EJSRemoteCMPSupplyTypeHome() throws java.rmi.RemoteException {
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

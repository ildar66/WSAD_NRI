package com.hps.july.persistence;

/**
 * EJSRemoteCMPCableResourceHome
 */
public class EJSRemoteCMPCableResourceHome extends com.hps.july.persistence.EJSRemoteCMPCableResourceHome_df1d097a implements com.hps.july.persistence.CableResourceHome {
	/**
	 * EJSRemoteCMPCableResourceHome
	 */
	public EJSRemoteCMPCableResourceHome() throws java.rmi.RemoteException {
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

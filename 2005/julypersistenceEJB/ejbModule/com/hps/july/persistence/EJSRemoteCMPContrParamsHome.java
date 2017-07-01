package com.hps.july.persistence;

/**
 * EJSRemoteCMPContrParamsHome
 */
public class EJSRemoteCMPContrParamsHome extends com.hps.july.persistence.EJSRemoteCMPContrParamsHome_7788f282 implements com.hps.july.persistence.ContrParamsHome {
	/**
	 * EJSRemoteCMPContrParamsHome
	 */
	public EJSRemoteCMPContrParamsHome() throws java.rmi.RemoteException {
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

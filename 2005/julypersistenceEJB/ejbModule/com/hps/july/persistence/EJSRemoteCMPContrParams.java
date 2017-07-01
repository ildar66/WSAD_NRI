package com.hps.july.persistence;

/**
 * EJSRemoteCMPContrParams
 */
public class EJSRemoteCMPContrParams extends com.hps.july.persistence.EJSRemoteCMPContrParams_7788f282 implements ContrParams {
	/**
	 * EJSRemoteCMPContrParams
	 */
	public EJSRemoteCMPContrParams() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEValutes
 */
public class EJSRemoteCMPPIEValutes extends com.hps.july.persistence.EJSRemoteCMPPIEValutes_ef13060b implements PIEValutes {
	/**
	 * EJSRemoteCMPPIEValutes
	 */
	public EJSRemoteCMPPIEValutes() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPRRLAntParamsHome
 */
public class EJSRemoteCMPRRLAntParamsHome extends com.hps.july.persistence.EJSRemoteCMPRRLAntParamsHome_f2fc01d9 implements com.hps.july.persistence.RRLAntParamsHome {
	/**
	 * EJSRemoteCMPRRLAntParamsHome
	 */
	public EJSRemoteCMPRRLAntParamsHome() throws java.rmi.RemoteException {
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

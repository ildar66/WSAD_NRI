package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEQueryHome
 */
public class EJSRemoteCMPPIEQueryHome extends com.hps.july.persistence.EJSRemoteCMPPIEQueryHome_3b29e425 implements com.hps.july.persistence.PIEQueryHome {
	/**
	 * EJSRemoteCMPPIEQueryHome
	 */
	public EJSRemoteCMPPIEQueryHome() throws java.rmi.RemoteException {
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

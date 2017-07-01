package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEQueryLogHome
 */
public class EJSRemoteCMPPIEQueryLogHome extends com.hps.july.persistence.EJSRemoteCMPPIEQueryLogHome_a5116b49 implements com.hps.july.persistence.PIEQueryLogHome {
	/**
	 * EJSRemoteCMPPIEQueryLogHome
	 */
	public EJSRemoteCMPPIEQueryLogHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPCarHome
 */
public class EJSRemoteCMPCarHome extends com.hps.july.persistence.EJSRemoteCMPCarHome_b17f05e2 implements com.hps.july.persistence.CarHome {
	/**
	 * EJSRemoteCMPCarHome
	 */
	public EJSRemoteCMPCarHome() throws java.rmi.RemoteException {
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

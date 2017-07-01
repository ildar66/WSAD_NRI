package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEExpenceHome
 */
public class EJSRemoteCMPPIEExpenceHome extends com.hps.july.persistence.EJSRemoteCMPPIEExpenceHome_74e71f50 implements com.hps.july.persistence.PIEExpenceHome {
	/**
	 * EJSRemoteCMPPIEExpenceHome
	 */
	public EJSRemoteCMPPIEExpenceHome() throws java.rmi.RemoteException {
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

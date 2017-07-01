package com.hps.july.persistence2;

/**
 * EJSRemoteCMPBeenetObjectHome
 */
public class EJSRemoteCMPBeenetObjectHome extends com.hps.july.persistence2.EJSRemoteCMPBeenetObjectHome_f8cb309f implements com.hps.july.persistence2.BeenetObjectHome {
	/**
	 * EJSRemoteCMPBeenetObjectHome
	 */
	public EJSRemoteCMPBeenetObjectHome() throws java.rmi.RemoteException {
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

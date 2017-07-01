package com.hps.july.persistence;

/**
 * EJSRemoteCMPBSInstComplectResourceSetHome
 */
public class EJSRemoteCMPBSInstComplectResourceSetHome extends com.hps.july.persistence.EJSRemoteCMPBSInstComplectResourceSetHome_c1bebc4d implements com.hps.july.persistence.BSInstComplectResourceSetHome {
	/**
	 * EJSRemoteCMPBSInstComplectResourceSetHome
	 */
	public EJSRemoteCMPBSInstComplectResourceSetHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceSubTypeHome
 */
public class EJSRemoteCMPResourceSubTypeHome extends com.hps.july.persistence.EJSRemoteCMPResourceSubTypeHome_fc97d1dd implements com.hps.july.persistence.ResourceSubTypeHome {
	/**
	 * EJSRemoteCMPResourceSubTypeHome
	 */
	public EJSRemoteCMPResourceSubTypeHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence2;

/**
 * EJSRemoteCMPResourceGroupHome
 */
public class EJSRemoteCMPResourceGroupHome extends com.hps.july.persistence2.EJSRemoteCMPResourceGroupHome_34fe15dc implements com.hps.july.persistence2.ResourceGroupHome {
	/**
	 * EJSRemoteCMPResourceGroupHome
	 */
	public EJSRemoteCMPResourceGroupHome() throws java.rmi.RemoteException {
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

package com.hps.july.persistence2;

/**
 * EJSRemoteStatelessBeenetFacadeHome
 */
public class EJSRemoteStatelessBeenetFacadeHome extends com.hps.july.persistence2.EJSRemoteStatelessBeenetFacadeHome_0cb5367e implements com.hps.july.persistence2.BeenetFacadeHome {
	/**
	 * EJSRemoteStatelessBeenetFacadeHome
	 */
	public EJSRemoteStatelessBeenetFacadeHome() throws java.rmi.RemoteException {
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

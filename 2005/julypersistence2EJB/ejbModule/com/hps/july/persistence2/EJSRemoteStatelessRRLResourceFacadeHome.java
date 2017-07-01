package com.hps.july.persistence2;

/**
 * EJSRemoteStatelessRRLResourceFacadeHome
 */
public class EJSRemoteStatelessRRLResourceFacadeHome extends com.hps.july.persistence2.EJSRemoteStatelessRRLResourceFacadeHome_d111db25 implements com.hps.july.persistence2.RRLResourceFacadeHome {
	/**
	 * EJSRemoteStatelessRRLResourceFacadeHome
	 */
	public EJSRemoteStatelessRRLResourceFacadeHome() throws java.rmi.RemoteException {
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

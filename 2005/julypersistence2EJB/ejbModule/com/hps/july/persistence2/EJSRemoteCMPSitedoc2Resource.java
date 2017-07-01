package com.hps.july.persistence2;

/**
 * EJSRemoteCMPSitedoc2Resource
 */
public class EJSRemoteCMPSitedoc2Resource extends com.hps.july.persistence2.EJSRemoteCMPSitedoc2Resource_8be96277 implements Sitedoc2Resource {
	/**
	 * EJSRemoteCMPSitedoc2Resource
	 */
	public EJSRemoteCMPSitedoc2Resource() throws java.rmi.RemoteException {
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

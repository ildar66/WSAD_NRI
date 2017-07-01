package com.hps.july.persistence2;

/**
 * EJSRemoteCMPSitedoc2Region
 */
public class EJSRemoteCMPSitedoc2Region extends com.hps.july.persistence2.EJSRemoteCMPSitedoc2Region_3b145ede implements Sitedoc2Region {
	/**
	 * EJSRemoteCMPSitedoc2Region
	 */
	public EJSRemoteCMPSitedoc2Region() throws java.rmi.RemoteException {
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

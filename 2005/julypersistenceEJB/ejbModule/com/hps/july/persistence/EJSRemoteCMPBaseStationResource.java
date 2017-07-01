package com.hps.july.persistence;

/**
 * EJSRemoteCMPBaseStationResource
 */
public class EJSRemoteCMPBaseStationResource extends com.hps.july.persistence.EJSRemoteCMPBaseStationResource_cd778579 implements BaseStationResource {
	/**
	 * EJSRemoteCMPBaseStationResource
	 */
	public EJSRemoteCMPBaseStationResource() throws java.rmi.RemoteException {
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

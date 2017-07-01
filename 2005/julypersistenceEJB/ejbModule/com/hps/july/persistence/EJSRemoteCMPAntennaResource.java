package com.hps.july.persistence;

/**
 * EJSRemoteCMPAntennaResource
 */
public class EJSRemoteCMPAntennaResource extends com.hps.july.persistence.EJSRemoteCMPAntennaResource_8763e04a implements AntennaResource {
	/**
	 * EJSRemoteCMPAntennaResource
	 */
	public EJSRemoteCMPAntennaResource() throws java.rmi.RemoteException {
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

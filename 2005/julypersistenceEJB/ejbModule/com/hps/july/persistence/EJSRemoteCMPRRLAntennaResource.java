package com.hps.july.persistence;

/**
 * EJSRemoteCMPRRLAntennaResource
 */
public class EJSRemoteCMPRRLAntennaResource extends com.hps.july.persistence.EJSRemoteCMPRRLAntennaResource_ad455fd7 implements RRLAntennaResource {
	/**
	 * EJSRemoteCMPRRLAntennaResource
	 */
	public EJSRemoteCMPRRLAntennaResource() throws java.rmi.RemoteException {
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

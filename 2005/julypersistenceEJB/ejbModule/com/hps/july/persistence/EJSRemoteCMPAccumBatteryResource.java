package com.hps.july.persistence;

/**
 * EJSRemoteCMPAccumBatteryResource
 */
public class EJSRemoteCMPAccumBatteryResource extends com.hps.july.persistence.EJSRemoteCMPAccumBatteryResource_5ca25302 implements AccumBatteryResource {
	/**
	 * EJSRemoteCMPAccumBatteryResource
	 */
	public EJSRemoteCMPAccumBatteryResource() throws java.rmi.RemoteException {
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

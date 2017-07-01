package com.hps.july.persistence;

/**
 * EJSRemoteCMPCar
 */
public class EJSRemoteCMPCar extends com.hps.july.persistence.EJSRemoteCMPCar_b17f05e2 implements Car {
	/**
	 * EJSRemoteCMPCar
	 */
	public EJSRemoteCMPCar() throws java.rmi.RemoteException {
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

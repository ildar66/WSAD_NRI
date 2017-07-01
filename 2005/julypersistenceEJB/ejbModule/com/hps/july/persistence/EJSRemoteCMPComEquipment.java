package com.hps.july.persistence;

/**
 * EJSRemoteCMPComEquipment
 */
public class EJSRemoteCMPComEquipment extends com.hps.july.persistence.EJSRemoteCMPComEquipment_f7643898 implements ComEquipment {
	/**
	 * EJSRemoteCMPComEquipment
	 */
	public EJSRemoteCMPComEquipment() throws java.rmi.RemoteException {
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

package com.hps.july.persistence;

/**
 * EJSRemoteCMPEquipmentSet
 */
public class EJSRemoteCMPEquipmentSet extends com.hps.july.persistence.EJSRemoteCMPEquipmentSet_fc405c6f implements EquipmentSet {
	/**
	 * EJSRemoteCMPEquipmentSet
	 */
	public EJSRemoteCMPEquipmentSet() throws java.rmi.RemoteException {
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

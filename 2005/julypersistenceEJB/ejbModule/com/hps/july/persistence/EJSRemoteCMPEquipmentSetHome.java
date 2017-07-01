package com.hps.july.persistence;

/**
 * EJSRemoteCMPEquipmentSetHome
 */
public class EJSRemoteCMPEquipmentSetHome extends com.hps.july.persistence.EJSRemoteCMPEquipmentSetHome_fc405c6f implements com.hps.july.persistence.EquipmentSetHome {
	/**
	 * EJSRemoteCMPEquipmentSetHome
	 */
	public EJSRemoteCMPEquipmentSetHome() throws java.rmi.RemoteException {
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

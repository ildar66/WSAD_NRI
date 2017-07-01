package com.hps.july.persistence2;

/**
 * EJSRemoteCMPEtapType
 */
public class EJSRemoteCMPEtapType extends com.hps.july.persistence2.EJSRemoteCMPEtapType_4abb9761 implements EtapType {
	/**
	 * EJSRemoteCMPEtapType
	 */
	public EJSRemoteCMPEtapType() throws java.rmi.RemoteException {
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

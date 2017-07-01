package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceSubType
 */
public class EJSRemoteCMPResourceSubType extends com.hps.july.persistence.EJSRemoteCMPResourceSubType_fc97d1dd implements ResourceSubType {
	/**
	 * EJSRemoteCMPResourceSubType
	 */
	public EJSRemoteCMPResourceSubType() throws java.rmi.RemoteException {
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

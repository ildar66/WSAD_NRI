package com.hps.july.persistence;

/**
 * EJSRemoteCMPProtoActionHome
 */
public class EJSRemoteCMPProtoActionHome extends com.hps.july.persistence.EJSRemoteCMPProtoActionHome_80500ecc implements com.hps.july.persistence.ProtoActionHome {
	/**
	 * EJSRemoteCMPProtoActionHome
	 */
	public EJSRemoteCMPProtoActionHome() throws java.rmi.RemoteException {
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

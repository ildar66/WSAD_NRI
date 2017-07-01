package com.hps.july.persistence2;

/**
 * EJSRemoteCMPContainerHome
 */
public class EJSRemoteCMPContainerHome extends com.hps.july.persistence2.EJSRemoteCMPContainerHome_91f4bd0b implements com.hps.july.persistence2.ContainerHome {
	/**
	 * EJSRemoteCMPContainerHome
	 */
	public EJSRemoteCMPContainerHome() throws java.rmi.RemoteException {
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

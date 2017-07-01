package com.hps.july.config.beans;

/**
 * EJSCMPCfgEquipObjectsCfgHomeBean
 */
public class EJSCMPCfgEquipObjectsCfgHomeBean extends com.hps.july.config.beans.EJSCMPCfgEquipObjectsCfgHomeBean_087e3fc2 {
	/**
	 * EJSCMPCfgEquipObjectsCfgHomeBean
	 */
	public EJSCMPCfgEquipObjectsCfgHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfg postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgEquipObjectsCfg) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

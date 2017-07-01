package com.hps.july.persistence;

/**
 * EJSCMPEquipmentSetHomeBean
 */
public class EJSCMPEquipmentSetHomeBean extends com.hps.july.persistence.EJSCMPEquipmentSetHomeBean_fc405c6f {
	/**
	 * EJSCMPEquipmentSetHomeBean
	 */
	public EJSCMPEquipmentSetHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.EquipmentSet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.EquipmentSet) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

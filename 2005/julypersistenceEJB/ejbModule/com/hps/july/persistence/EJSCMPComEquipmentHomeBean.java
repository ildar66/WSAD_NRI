package com.hps.july.persistence;

/**
 * EJSCMPComEquipmentHomeBean
 */
public class EJSCMPComEquipmentHomeBean extends com.hps.july.persistence.EJSCMPComEquipmentHomeBean_f7643898 {
	/**
	 * EJSCMPComEquipmentHomeBean
	 */
	public EJSCMPComEquipmentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ComEquipment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ComEquipment) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

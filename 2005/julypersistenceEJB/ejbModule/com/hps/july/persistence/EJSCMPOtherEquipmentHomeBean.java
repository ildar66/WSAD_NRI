package com.hps.july.persistence;

/**
 * EJSCMPOtherEquipmentHomeBean
 */
public class EJSCMPOtherEquipmentHomeBean extends com.hps.july.persistence.EJSCMPOtherEquipmentHomeBean_9a1c12fd {
	/**
	 * EJSCMPOtherEquipmentHomeBean
	 */
	public EJSCMPOtherEquipmentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OtherEquipment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OtherEquipment) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

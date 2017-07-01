package com.hps.july.persistence2;

/**
 * EJSCMPEquipManufacturerHomeBean
 */
public class EJSCMPEquipManufacturerHomeBean extends com.hps.july.persistence2.EJSCMPEquipManufacturerHomeBean_e49c88d8 {
	/**
	 * EJSCMPEquipManufacturerHomeBean
	 */
	public EJSCMPEquipManufacturerHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.EquipManufacturer postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.EquipManufacturer) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

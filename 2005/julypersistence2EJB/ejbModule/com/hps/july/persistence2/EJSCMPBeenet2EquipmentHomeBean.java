package com.hps.july.persistence2;

/**
 * EJSCMPBeenet2EquipmentHomeBean
 */
public class EJSCMPBeenet2EquipmentHomeBean extends com.hps.july.persistence2.EJSCMPBeenet2EquipmentHomeBean_1c9d5b1d {
	/**
	 * EJSCMPBeenet2EquipmentHomeBean
	 */
	public EJSCMPBeenet2EquipmentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Beenet2Equipment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Beenet2Equipment) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

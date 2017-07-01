package com.hps.july.persistence2;

/**
 * EJSCMPOporaPlacesHomeBean
 */
public class EJSCMPOporaPlacesHomeBean extends com.hps.july.persistence2.EJSCMPOporaPlacesHomeBean_ead98640 {
	/**
	 * EJSCMPOporaPlacesHomeBean
	 */
	public EJSCMPOporaPlacesHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OporaPlaces postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OporaPlaces) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

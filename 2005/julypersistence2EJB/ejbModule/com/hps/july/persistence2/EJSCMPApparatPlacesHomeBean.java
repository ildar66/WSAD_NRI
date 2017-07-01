package com.hps.july.persistence2;

/**
 * EJSCMPApparatPlacesHomeBean
 */
public class EJSCMPApparatPlacesHomeBean extends com.hps.july.persistence2.EJSCMPApparatPlacesHomeBean_0a67f164 {
	/**
	 * EJSCMPApparatPlacesHomeBean
	 */
	public EJSCMPApparatPlacesHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ApparatPlaces postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ApparatPlaces) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

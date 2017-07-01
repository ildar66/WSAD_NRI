package com.hps.july.persistence2;

/**
 * EJSCMPApparatPlaceTypeHomeBean
 */
public class EJSCMPApparatPlaceTypeHomeBean extends com.hps.july.persistence2.EJSCMPApparatPlaceTypeHomeBean_82cd314b {
	/**
	 * EJSCMPApparatPlaceTypeHomeBean
	 */
	public EJSCMPApparatPlaceTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ApparatPlaceType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ApparatPlaceType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

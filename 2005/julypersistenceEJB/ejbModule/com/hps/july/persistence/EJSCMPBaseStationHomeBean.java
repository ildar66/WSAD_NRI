package com.hps.july.persistence;

/**
 * EJSCMPBaseStationHomeBean
 */
public class EJSCMPBaseStationHomeBean extends com.hps.july.persistence.EJSCMPBaseStationHomeBean_5156cef4 {
	/**
	 * EJSCMPBaseStationHomeBean
	 */
	public EJSCMPBaseStationHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.BaseStation postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.BaseStation) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

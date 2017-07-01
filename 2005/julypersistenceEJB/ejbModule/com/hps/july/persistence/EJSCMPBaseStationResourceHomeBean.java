package com.hps.july.persistence;

/**
 * EJSCMPBaseStationResourceHomeBean
 */
public class EJSCMPBaseStationResourceHomeBean extends com.hps.july.persistence.EJSCMPBaseStationResourceHomeBean_cd778579 {
	/**
	 * EJSCMPBaseStationResourceHomeBean
	 */
	public EJSCMPBaseStationResourceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.BaseStationResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.BaseStationResource) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

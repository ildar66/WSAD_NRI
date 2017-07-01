package com.hps.july.persistence2;

/**
 * EJSCMPOfficeMemoTargetHomeBean
 */
public class EJSCMPOfficeMemoTargetHomeBean extends com.hps.july.persistence2.EJSCMPOfficeMemoTargetHomeBean_d1f1d09e {
	/**
	 * EJSCMPOfficeMemoTargetHomeBean
	 */
	public EJSCMPOfficeMemoTargetHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OfficeMemoTarget postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OfficeMemoTarget) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

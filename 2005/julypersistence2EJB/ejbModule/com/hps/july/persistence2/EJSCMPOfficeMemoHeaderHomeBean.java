package com.hps.july.persistence2;

/**
 * EJSCMPOfficeMemoHeaderHomeBean
 */
public class EJSCMPOfficeMemoHeaderHomeBean extends com.hps.july.persistence2.EJSCMPOfficeMemoHeaderHomeBean_7991c071 {
	/**
	 * EJSCMPOfficeMemoHeaderHomeBean
	 */
	public EJSCMPOfficeMemoHeaderHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OfficeMemoHeader postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OfficeMemoHeader) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

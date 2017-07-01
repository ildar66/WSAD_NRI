package com.hps.july.persistence2;

/**
 * EJSCMPOfficeMemoPosHomeBean
 */
public class EJSCMPOfficeMemoPosHomeBean extends com.hps.july.persistence2.EJSCMPOfficeMemoPosHomeBean_8b7defe2 {
	/**
	 * EJSCMPOfficeMemoPosHomeBean
	 */
	public EJSCMPOfficeMemoPosHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OfficeMemoPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OfficeMemoPos) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

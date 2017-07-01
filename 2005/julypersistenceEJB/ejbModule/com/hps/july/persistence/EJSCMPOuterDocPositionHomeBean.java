package com.hps.july.persistence;

/**
 * EJSCMPOuterDocPositionHomeBean
 */
public class EJSCMPOuterDocPositionHomeBean extends com.hps.july.persistence.EJSCMPOuterDocPositionHomeBean_b5a64898 {
	/**
	 * EJSCMPOuterDocPositionHomeBean
	 */
	public EJSCMPOuterDocPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OuterDocPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OuterDocPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

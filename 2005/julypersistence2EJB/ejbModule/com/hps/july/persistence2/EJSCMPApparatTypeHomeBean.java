package com.hps.july.persistence2;

/**
 * EJSCMPApparatTypeHomeBean
 */
public class EJSCMPApparatTypeHomeBean extends com.hps.july.persistence2.EJSCMPApparatTypeHomeBean_9bcda663 {
	/**
	 * EJSCMPApparatTypeHomeBean
	 */
	public EJSCMPApparatTypeHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ApparatType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ApparatType) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

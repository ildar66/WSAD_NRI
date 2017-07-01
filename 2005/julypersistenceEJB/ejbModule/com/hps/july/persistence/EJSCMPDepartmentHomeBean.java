package com.hps.july.persistence;

/**
 * EJSCMPDepartmentHomeBean
 */
public class EJSCMPDepartmentHomeBean extends com.hps.july.persistence.EJSCMPDepartmentHomeBean_f0bb03b3 {
	/**
	 * EJSCMPDepartmentHomeBean
	 */
	public EJSCMPDepartmentHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Department postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Department) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

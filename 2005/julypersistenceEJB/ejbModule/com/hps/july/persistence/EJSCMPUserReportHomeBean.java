package com.hps.july.persistence;

/**
 * EJSCMPUserReportHomeBean
 */
public class EJSCMPUserReportHomeBean extends com.hps.july.persistence.EJSCMPUserReportHomeBean_7abdfa48 {
	/**
	 * EJSCMPUserReportHomeBean
	 */
	public EJSCMPUserReportHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.UserReport postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.UserReport) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

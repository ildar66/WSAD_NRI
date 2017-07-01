package com.hps.july.persistence;

/**
 * EJSCMPRRLAntParamsHomeBean
 */
public class EJSCMPRRLAntParamsHomeBean extends com.hps.july.persistence.EJSCMPRRLAntParamsHomeBean_f2fc01d9 {
	/**
	 * EJSCMPRRLAntParamsHomeBean
	 */
	public EJSCMPRRLAntParamsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RRLAntParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RRLAntParams) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

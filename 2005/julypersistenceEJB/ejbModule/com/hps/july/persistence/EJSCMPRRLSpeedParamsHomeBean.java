package com.hps.july.persistence;

/**
 * EJSCMPRRLSpeedParamsHomeBean
 */
public class EJSCMPRRLSpeedParamsHomeBean extends com.hps.july.persistence.EJSCMPRRLSpeedParamsHomeBean_64177aa5 {
	/**
	 * EJSCMPRRLSpeedParamsHomeBean
	 */
	public EJSCMPRRLSpeedParamsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RRLSpeedParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RRLSpeedParams) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

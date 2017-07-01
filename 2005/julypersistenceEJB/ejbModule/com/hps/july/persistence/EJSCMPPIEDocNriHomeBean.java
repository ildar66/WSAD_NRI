package com.hps.july.persistence;

/**
 * EJSCMPPIEDocNriHomeBean
 */
public class EJSCMPPIEDocNriHomeBean extends com.hps.july.persistence.EJSCMPPIEDocNriHomeBean_596461e0 {
	/**
	 * EJSCMPPIEDocNriHomeBean
	 */
	public EJSCMPPIEDocNriHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDocNri postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDocNri) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

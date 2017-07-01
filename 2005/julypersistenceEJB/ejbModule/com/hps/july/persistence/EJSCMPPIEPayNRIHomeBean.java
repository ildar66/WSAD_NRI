package com.hps.july.persistence;

/**
 * EJSCMPPIEPayNRIHomeBean
 */
public class EJSCMPPIEPayNRIHomeBean extends com.hps.july.persistence.EJSCMPPIEPayNRIHomeBean_6b039a46 {
	/**
	 * EJSCMPPIEPayNRIHomeBean
	 */
	public EJSCMPPIEPayNRIHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPayNRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPayNRI) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

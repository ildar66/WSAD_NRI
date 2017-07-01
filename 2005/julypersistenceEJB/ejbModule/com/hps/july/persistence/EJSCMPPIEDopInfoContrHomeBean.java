package com.hps.july.persistence;

/**
 * EJSCMPPIEDopInfoContrHomeBean
 */
public class EJSCMPPIEDopInfoContrHomeBean extends com.hps.july.persistence.EJSCMPPIEDopInfoContrHomeBean_1d890592 {
	/**
	 * EJSCMPPIEDopInfoContrHomeBean
	 */
	public EJSCMPPIEDopInfoContrHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDopInfoContr postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDopInfoContr) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

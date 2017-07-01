package com.hps.july.persistence;

/**
 * EJSCMPPIEExpenceHomeBean
 */
public class EJSCMPPIEExpenceHomeBean extends com.hps.july.persistence.EJSCMPPIEExpenceHomeBean_74e71f50 {
	/**
	 * EJSCMPPIEExpenceHomeBean
	 */
	public EJSCMPPIEExpenceHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEExpence postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEExpence) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

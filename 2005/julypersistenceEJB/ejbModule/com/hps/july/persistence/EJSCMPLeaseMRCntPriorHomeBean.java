package com.hps.july.persistence;

/**
 * EJSCMPLeaseMRCntPriorHomeBean
 */
public class EJSCMPLeaseMRCntPriorHomeBean extends com.hps.july.persistence.EJSCMPLeaseMRCntPriorHomeBean_5e3fe006 {
	/**
	 * EJSCMPLeaseMRCntPriorHomeBean
	 */
	public EJSCMPLeaseMRCntPriorHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMRCntPrior postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMRCntPrior) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

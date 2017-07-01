package com.hps.july.persistence;

/**
 * EJSCMPOperatorHomeBean
 */
public class EJSCMPOperatorHomeBean extends com.hps.july.persistence.EJSCMPOperatorHomeBean_b06d3afd {
	/**
	 * EJSCMPOperatorHomeBean
	 */
	public EJSCMPOperatorHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Operator postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Operator) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

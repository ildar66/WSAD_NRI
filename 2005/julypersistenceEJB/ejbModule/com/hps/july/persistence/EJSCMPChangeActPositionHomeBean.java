package com.hps.july.persistence;

/**
 * EJSCMPChangeActPositionHomeBean
 */
public class EJSCMPChangeActPositionHomeBean extends com.hps.july.persistence.EJSCMPChangeActPositionHomeBean_e8688648 {
	/**
	 * EJSCMPChangeActPositionHomeBean
	 */
	public EJSCMPChangeActPositionHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChangeActPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChangeActPosition) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

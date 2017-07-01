package com.hps.july.persistence;

/**
 * EJSCMPLeaseMutualActBLOBHomeBean
 */
public class EJSCMPLeaseMutualActBLOBHomeBean extends com.hps.july.persistence.EJSCMPLeaseMutualActBLOBHomeBean_ddcc7e78 {
	/**
	 * EJSCMPLeaseMutualActBLOBHomeBean
	 */
	public EJSCMPLeaseMutualActBLOBHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualActBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualActBLOB) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

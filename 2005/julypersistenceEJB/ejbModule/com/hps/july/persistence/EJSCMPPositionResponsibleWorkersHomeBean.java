package com.hps.july.persistence;

/**
 * EJSCMPPositionResponsibleWorkersHomeBean
 */
public class EJSCMPPositionResponsibleWorkersHomeBean extends com.hps.july.persistence.EJSCMPPositionResponsibleWorkersHomeBean_5cb3b8ab {
	/**
	 * EJSCMPPositionResponsibleWorkersHomeBean
	 */
	public EJSCMPPositionResponsibleWorkersHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PositionResponsibleWorkers postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PositionResponsibleWorkers) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}

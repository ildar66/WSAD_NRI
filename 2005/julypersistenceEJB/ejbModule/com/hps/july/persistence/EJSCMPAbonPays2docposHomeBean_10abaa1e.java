package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAbonPays2docposHomeBean_10abaa1e
 */
public class EJSCMPAbonPays2docposHomeBean_10abaa1e extends EJSHome {
	/**
	 * EJSCMPAbonPays2docposHomeBean_10abaa1e
	 */
	public EJSCMPAbonPays2docposHomeBean_10abaa1e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonPays2docpos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonPays2docpos) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findAbonPays2docposByLeasedocposition
	 */
	public com.hps.july.persistence.AbonPays2docpos findAbonPays2docposByLeasedocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPAbonPays2docposBean_10abaa1e)persister).findAbonPays2docposByLeasedocposition(inKey);	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonPays2docpos findByPrimaryKey(com.hps.july.persistence.AbonPays2docposKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAbonPays2docposBean_10abaa1e) persister).findByPrimaryKey(key);
	}
	/**
	 * findAbonPays2docposesByPaypos
	 */
	public java.util.Enumeration findAbonPays2docposesByPaypos(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonPays2docposBean)persister).findAbonPays2docposesByPaypos(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonPays2docpos create(int argLeaseDocposition, int argPayPos) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonPays2docpos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonPays2docposBean bean = (com.hps.july.persistence.AbonPays2docposBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocposition, argPayPos);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AbonPays2docposBean tmpEJB = (com.hps.july.persistence.AbonPays2docposBean) generalEJB;
		com.hps.july.persistence.AbonPays2docposKey keyClass = new com.hps.july.persistence.AbonPays2docposKey();
		keyClass.leasedocposition_leaseDocPosition = tmpEJB.leasedocposition_leaseDocPosition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AbonPays2docposKey keyFromFields(java.lang.Integer f0) {
		com.hps.july.persistence.AbonPays2docposKey keyClass = new com.hps.july.persistence.AbonPays2docposKey();
		keyClass.leasedocposition_leaseDocPosition = f0;
		return keyClass;
	}
}

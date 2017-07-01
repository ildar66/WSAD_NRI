package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAbonBillpos2docposHomeBean_d13558d4
 */
public class EJSCMPAbonBillpos2docposHomeBean_d13558d4 extends EJSHome {
	/**
	 * EJSCMPAbonBillpos2docposHomeBean_d13558d4
	 */
	public EJSCMPAbonBillpos2docposHomeBean_d13558d4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonBillpos2docpos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonBillpos2docpos) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findAbonBillpos2docposByLeasedocposition
	 */
	public com.hps.july.persistence.AbonBillpos2docpos findAbonBillpos2docposByLeasedocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPAbonBillpos2docposBean_d13558d4)persister).findAbonBillpos2docposByLeasedocposition(inKey);	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonBillpos2docpos findByPrimaryKey(com.hps.july.persistence.AbonBillpos2docposKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAbonBillpos2docposBean_d13558d4) persister).findByPrimaryKey(key);
	}
	/**
	 * findAbonBillpos2docposesByBillpos
	 */
	public java.util.Enumeration findAbonBillpos2docposesByBillpos(com.hps.july.persistence.AbonentBillPosKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonBillpos2docposBean)persister).findAbonBillpos2docposesByBillpos(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonBillpos2docpos create(int argLeaseDocposition, int argBillPos) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonBillpos2docpos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonBillpos2docposBean bean = (com.hps.july.persistence.AbonBillpos2docposBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocposition, argBillPos);
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
		com.hps.july.persistence.AbonBillpos2docposBean tmpEJB = (com.hps.july.persistence.AbonBillpos2docposBean) generalEJB;
		com.hps.july.persistence.AbonBillpos2docposKey keyClass = new com.hps.july.persistence.AbonBillpos2docposKey();
		keyClass.leasedocposition_leaseDocPosition = tmpEJB.leasedocposition_leaseDocPosition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AbonBillpos2docposKey keyFromFields(java.lang.Integer f0) {
		com.hps.july.persistence.AbonBillpos2docposKey keyClass = new com.hps.july.persistence.AbonBillpos2docposKey();
		keyClass.leasedocposition_leaseDocPosition = f0;
		return keyClass;
	}
}

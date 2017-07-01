package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseDocPositionHomeBean_40024402
 */
public class EJSCMPLeaseDocPositionHomeBean_40024402 extends EJSHome {
	/**
	 * EJSCMPLeaseDocPositionHomeBean_40024402
	 */
	public EJSCMPLeaseDocPositionHomeBean_40024402() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseDocPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseDocPosition) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseDocPosition findByPrimaryKey(com.hps.july.persistence.LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseDocPositionBean_40024402) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseDocPositionByLeaseContract
	 */
	public java.util.Enumeration findLeaseDocPositionByLeaseContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDocPositionBean)persister).findLeaseDocPositionByLeaseContract(inKey));	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer leaseContract, java.lang.Integer resource, java.sql.Date date, java.lang.String docposvid) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDocPositionBean)persister).findByQBE2(leaseContract, resource, date, docposvid));	}
	/**
	 * findByQBE5
	 */
	public java.util.Enumeration findByQBE5(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isDocposvid, java.lang.String[] docposvid, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDocPositionBean)persister).findByQBE5(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, isDocposvid, docposvid, order));	}
	/**
	 * findLeaseDocPositionsByCurrency
	 */
	public java.util.Enumeration findLeaseDocPositionsByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDocPositionBean)persister).findLeaseDocPositionsByCurrency(inKey));	}
	/**
	 * findLeaseDocPositionsByAct
	 */
	public java.util.Enumeration findLeaseDocPositionsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDocPositionBean)persister).findLeaseDocPositionsByAct(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseDocPosition create(int argLeaseDocPosition, java.sql.Date argDate, java.lang.Integer argLeaseContract, java.lang.String argSource, java.lang.String argVid, java.sql.Date argSDate, java.sql.Date argEDate, java.lang.Integer argResource, java.math.BigDecimal argSumm, java.lang.Integer argCurrency, java.math.BigDecimal argSumNds) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseDocPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseDocPositionBean bean = (com.hps.july.persistence.LeaseDocPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocPosition, argDate, argLeaseContract, argSource, argVid, argSDate, argEDate, argResource, argSumm, argCurrency, argSumNds);
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
	 * findLeaseDocPositionsByResource
	 */
	public java.util.Enumeration findLeaseDocPositionsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDocPositionBean)persister).findLeaseDocPositionsByResource(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDocPositionBean)persister).findByQBE(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseDocPositionBean tmpEJB = (com.hps.july.persistence.LeaseDocPositionBean) generalEJB;
		com.hps.july.persistence.LeaseDocPositionKey keyClass = new com.hps.july.persistence.LeaseDocPositionKey();
		keyClass.leaseDocPosition = tmpEJB.leaseDocPosition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseDocPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseDocPositionKey keyClass = new com.hps.july.persistence.LeaseDocPositionKey();
		keyClass.leaseDocPosition = f0;
		return keyClass;
	}
}

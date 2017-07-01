package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseContractHomeBean_62ebfc4f
 */
public class EJSCMPLeaseContractHomeBean_62ebfc4f extends EJSHome {
	/**
	 * EJSCMPLeaseContractHomeBean_62ebfc4f
	 */
	public EJSCMPLeaseContractHomeBean_62ebfc4f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseContract postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseContract) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeaseContract2ByCurrency2
	 */
	public java.util.Enumeration findLeaseContract2ByCurrency2(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findLeaseContract2ByCurrency2(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.String contractType, java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findByQBE(contractType, isOrgCustomer, orgCustomer, isOrgExecutor, orgExecutor, isMainEconomist, mainEconomist, isDocNumber, docNumber, order));	}
	/**
	 * findLeaseContractExecutorByOrgExecutor
	 */
	public java.util.Enumeration findLeaseContractExecutorByOrgExecutor(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findLeaseContractExecutorByOrgExecutor(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseContract create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argContractType, java.lang.String argContractState, java.lang.Integer argOrgCustomer, java.lang.Integer argOrgExecutor, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.String argExtendType, java.lang.String argReportPeriod, java.lang.String agrCustname, java.lang.String argExecname) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseContract _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseContractBean bean = (com.hps.july.persistence.LeaseContractBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument, argDocDate, argDocNumber, argContractType, argContractState, argOrgCustomer, argOrgExecutor, argStartDate, argEndDate, argExtendType, argReportPeriod, agrCustname, argExecname);
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
	 * findLeaseContractsByReglamentOrderByCodeAsc
	 */
	public java.util.Enumeration findLeaseContractsByReglamentOrderByCodeAsc(java.lang.Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findLeaseContractsByReglamentOrderByCodeAsc(argReglament));	}
	/**
	 * findLeaseContractsByManager
	 */
	public java.util.Enumeration findLeaseContractsByManager(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findLeaseContractsByManager(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseContract findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseContractBean_62ebfc4f) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseContractByCurrency1
	 */
	public java.util.Enumeration findLeaseContractByCurrency1(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findLeaseContractByCurrency1(inKey));	}
	/**
	 * findLeaseContractEconomistByEconomist
	 */
	public java.util.Enumeration findLeaseContractEconomistByEconomist(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findLeaseContractEconomistByEconomist(inKey));	}
	/**
	 * findLeaseContractCustomerByOrgCustomer
	 */
	public java.util.Enumeration findLeaseContractCustomerByOrgCustomer(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseContractBean)persister).findLeaseContractCustomerByOrgCustomer(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseContract create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseContract _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseContractBean bean = (com.hps.july.persistence.LeaseContractBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeaseDocument);
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
		com.hps.july.persistence.LeaseContractBean tmpEJB = (com.hps.july.persistence.LeaseContractBean) generalEJB;
		com.hps.july.persistence.LeaseDocumentKey keyClass = new com.hps.july.persistence.LeaseDocumentKey();
		keyClass.leaseDocument = tmpEJB.leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseDocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseDocumentKey keyClass = new com.hps.july.persistence.LeaseDocumentKey();
		keyClass.leaseDocument = f0;
		return keyClass;
	}
}

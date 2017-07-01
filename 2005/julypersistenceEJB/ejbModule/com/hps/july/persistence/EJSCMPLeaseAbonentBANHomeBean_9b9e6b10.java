package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseAbonentBANHomeBean_9b9e6b10
 */
public class EJSCMPLeaseAbonentBANHomeBean_9b9e6b10 extends EJSHome {
	/**
	 * EJSCMPLeaseAbonentBANHomeBean_9b9e6b10
	 */
	public EJSCMPLeaseAbonentBANHomeBean_9b9e6b10() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentBAN postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentBAN) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByBAN
	 */
	public java.util.Enumeration findByBAN(java.lang.Integer argBan) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBANBean)persister).findByBAN(argBan));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseAbonentBAN create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argContractType, java.lang.String argContractState, java.lang.Integer argOrgCustomer, java.lang.Integer argOrgExecutor, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.String argExtendType, java.lang.String argReportPeriod, java.lang.String agrCustname, java.lang.String argExecname, int argBan, boolean argFlagWorkPIE) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseAbonentBAN _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseAbonentBANBean bean = (com.hps.july.persistence.LeaseAbonentBANBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument, argDocDate, argDocNumber, argContractType, argContractState, argOrgCustomer, argOrgExecutor, argStartDate, argEndDate, argExtendType, argReportPeriod, agrCustname, argExecname, argBan, argFlagWorkPIE);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.String contractType, java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBANBean)persister).findByQBE(contractType, isOrgCustomer, orgCustomer, isOrgExecutor, orgExecutor, isMainEconomist, mainEconomist, isDocNumber, docNumber, order));	}
	/**
	 * findByFlagWorkPIE
	 */
	public java.util.Enumeration findByFlagWorkPIE(java.lang.String argFlagWorkPIE) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBANBean)persister).findByFlagWorkPIE(argFlagWorkPIE));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseAbonentBAN findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseAbonentBANBean_9b9e6b10) persister).findByPrimaryKey(key);
	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isCustomerName, java.lang.String customerName, java.lang.Boolean isCustomerInn, java.lang.String customerInn, java.lang.Boolean isBan, java.lang.String ban, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBANBean)persister).findByQBE2(isCustomerName, customerName, isCustomerInn, customerInn, isBan, ban, order));	}
	/**
	 * findByQBE3
	 */
	public java.util.Enumeration findByQBE3(java.lang.Boolean isCustomerName, java.lang.String customerName, java.lang.Boolean isCustomerInn, java.lang.String customerInn, java.lang.Boolean isBan, java.lang.String ban, java.lang.Boolean isContractState, java.lang.String contractState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBANBean)persister).findByQBE3(isCustomerName, customerName, isCustomerInn, customerInn, isBan, ban, isContractState, contractState, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseAbonentBAN create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseAbonentBAN _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseAbonentBANBean bean = (com.hps.july.persistence.LeaseAbonentBANBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.LeaseAbonentBANBean tmpEJB = (com.hps.july.persistence.LeaseAbonentBANBean) generalEJB;
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

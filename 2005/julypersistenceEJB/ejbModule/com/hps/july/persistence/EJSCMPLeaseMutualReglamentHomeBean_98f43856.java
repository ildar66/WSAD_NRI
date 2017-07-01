package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMutualReglamentHomeBean_98f43856
 */
public class EJSCMPLeaseMutualReglamentHomeBean_98f43856 extends EJSHome {
	/**
	 * EJSCMPLeaseMutualReglamentHomeBean_98f43856
	 */
	public EJSCMPLeaseMutualReglamentHomeBean_98f43856() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualReglament postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualReglament) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualReglament create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argMutualPeriod, java.lang.Integer argMainCurrency, java.lang.Boolean argCommonRate, java.lang.String argActType, java.lang.String argMutstate, java.lang.String argDutyraterule, java.sql.Date argStartDate, java.sql.Date argEndDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualReglament _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualReglamentBean bean = (com.hps.july.persistence.LeaseMutualReglamentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument, argDocDate, argDocNumber, argMutualPeriod, argMainCurrency, argCommonRate, argActType, argMutstate, argDutyraterule, argStartDate, argEndDate);
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
	 * findByLeaseDocumentOrderByDocumentNumberAsc
	 */
	public java.util.Enumeration findByLeaseDocumentOrderByDocumentNumberAsc(java.lang.Integer leaseDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualReglamentBean)persister).findByLeaseDocumentOrderByDocumentNumberAsc(leaseDocument));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isDocDate, java.sql.Date docDate, java.lang.Boolean isBlank, java.lang.String blank, java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isMutStateEdit, java.lang.Boolean isMutStateRun, java.lang.Boolean isMutStateClose, java.lang.Boolean isActType, java.lang.String actType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualReglamentBean)persister).findByQBE(isDocDate, docDate, isBlank, blank, isLeaseContract, leaseContract, isMutStateEdit, isMutStateRun, isMutStateClose, isActType, actType, order));	}
	/**
	 * findLeaseMutualReglamentsMainByMaincurrency
	 */
	public java.util.Enumeration findLeaseMutualReglamentsMainByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualReglamentBean)persister).findLeaseMutualReglamentsMainByMaincurrency(inKey));	}
	/**
	 * findByResourceContractDates
	 */
	public java.util.Enumeration findByResourceContractDates(java.lang.Integer resource, java.lang.Integer contract, java.sql.Date startDate, java.sql.Date finishDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualReglamentBean)persister).findByResourceContractDates(resource, contract, startDate, finishDate));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseMutualReglament findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMutualReglamentBean_98f43856) persister).findByPrimaryKey(key);
	}
	/**
	 * findByResourceContractMaxDateStart
	 */
	public java.util.Enumeration findByResourceContractMaxDateStart(java.lang.Integer resource, java.lang.Integer contract) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualReglamentBean)persister).findByResourceContractMaxDateStart(resource, contract));	}
	/**
	 * findConcurentReglamentsByReglament
	 */
	public java.util.Enumeration findConcurentReglamentsByReglament(java.lang.Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualReglamentBean)persister).findConcurentReglamentsByReglament(argReglament));	}
	/**
	 * findLeaseMutualReglamentsAddByAdditionalCurrency
	 */
	public java.util.Enumeration findLeaseMutualReglamentsAddByAdditionalCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualReglamentBean)persister).findLeaseMutualReglamentsAddByAdditionalCurrency(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualReglament create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualReglament _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualReglamentBean bean = (com.hps.july.persistence.LeaseMutualReglamentBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.LeaseMutualReglamentBean tmpEJB = (com.hps.july.persistence.LeaseMutualReglamentBean) generalEJB;
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

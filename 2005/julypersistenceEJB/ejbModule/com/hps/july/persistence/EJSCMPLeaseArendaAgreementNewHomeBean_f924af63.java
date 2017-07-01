package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseArendaAgreementNewHomeBean_f924af63
 */
public class EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 extends EJSHome {
	/**
	 * EJSCMPLeaseArendaAgreementNewHomeBean_f924af63
	 */
	public EJSCMPLeaseArendaAgreementNewHomeBean_f924af63() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseArendaAgreementNew) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE4
	 */
	public java.util.Enumeration findByQBE4(java.lang.Boolean isEconomist, java.lang.Integer economist) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseArendaAgreementNewBean)persister).findByQBE4(isEconomist, economist));	}
	/**
	 * findByContractAndResource
	 */
	public java.util.Enumeration findByContractAndResource(java.lang.Integer contract, java.lang.Integer resource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseArendaAgreementNewBean)persister).findByContractAndResource(contract, resource, order));	}
	/**
	 * findLeaseArendaAgreementNewsByMainposition
	 */
	public java.util.Enumeration findLeaseArendaAgreementNewsByMainposition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseArendaAgreementNewBean)persister).findLeaseArendaAgreementNewsByMainposition(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Boolean isState, java.lang.String state, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseArendaAgreementNewBean)persister).findByQBE(isOrgCustomer, orgCustomer, isOrgExecutor, orgExecutor, isMainEconomist, mainEconomist, isPosition, position, isDocNumber, docNumber, isState, state, order));	}
	/**
	 * findByQBE3
	 */
	public java.util.Enumeration findByQBE3(java.lang.Boolean isEndDate, java.sql.Date startEndDate, java.sql.Date finishEndDate, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Boolean isContractState, java.lang.String ContractState, java.lang.Boolean isExtendType, java.lang.String ExtendType, java.lang.Boolean isEconomist, java.lang.Integer economist) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseArendaAgreementNewBean)persister).findByQBE3(isEndDate, startEndDate, finishEndDate, isIsActive, isActive, isContractState, ContractState, isExtendType, ExtendType, isEconomist, economist));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseArendaAgreementNewBean_f924af63) persister).findByPrimaryKey(key);
	}
	/**
	 * findByQBE5
	 */
	public java.util.Enumeration findByQBE5(java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Boolean isState, java.lang.String state, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseArendaAgreementNewBean)persister).findByQBE5(isOrgCustomer, orgCustomer, isOrgExecutor, orgExecutor, isMainEconomist, mainEconomist, isPosition, position, isDocNumber, docNumber, isState, state, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argContractType, java.lang.String argContractState, java.lang.Integer argOrgCustomer, java.lang.Integer argOrgExecutor, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.String argExtendType, java.lang.String argReportPeriod, java.lang.Boolean argIsActive, java.lang.String argHowGivePhones, java.lang.String argCalcElectroType, java.lang.Boolean argIsDogElectro, java.lang.String agrCustname, java.lang.String argExecname, java.lang.Integer argMainDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseArendaAgreementNew _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseArendaAgreementNewBean bean = (com.hps.july.persistence.LeaseArendaAgreementNewBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument, argDocDate, argDocNumber, argContractType, argContractState, argOrgCustomer, argOrgExecutor, argStartDate, argEndDate, argExtendType, argReportPeriod, argIsActive, argHowGivePhones, argCalcElectroType, argIsDogElectro, agrCustname, argExecname, argMainDocument);
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
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer mainLeaseDocument, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Boolean isContractState, java.lang.String contractState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseArendaAgreementNewBean)persister).findByQBE2(mainLeaseDocument, isIsActive, isActive, isContractState, contractState, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseArendaAgreementNewBean tmpEJB = (com.hps.july.persistence.LeaseArendaAgreementNewBean) generalEJB;
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

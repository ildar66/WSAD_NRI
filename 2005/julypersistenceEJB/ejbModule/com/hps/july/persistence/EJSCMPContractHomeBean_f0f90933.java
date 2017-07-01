package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPContractHomeBean_f0f90933
 */
public class EJSCMPContractHomeBean_f0f90933 extends EJSHome {
	/**
	 * EJSCMPContractHomeBean_f0f90933
	 */
	public EJSCMPContractHomeBean_f0f90933() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Contract postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Contract) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findControlledContractByController
	 */
	public java.util.Enumeration findControlledContractByController(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findControlledContractByController(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Contract create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Integer argCurrency, java.lang.String argName, java.lang.Integer argWorker, java.lang.Integer argController, java.sql.Date argStartDate, java.sql.Date argFinishDate, java.math.BigDecimal argSum, java.lang.Integer argSupplyType, java.lang.Integer argBaseAgreement) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Contract _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ContractBean bean = (com.hps.july.persistence.ContractBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argBlankDate, argBlankindex, argBlankNumber, argState, argCurrency, argName, argWorker, argController, argStartDate, argFinishDate, argSum, argSupplyType, argBaseAgreement);
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
	 * findContractBySupplyType
	 */
	public java.util.Enumeration findContractBySupplyType(com.hps.july.persistence.SupplyTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findContractBySupplyType(inKey));	}
	/**
	 * findContractByCurrency
	 */
	public java.util.Enumeration findContractByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findContractByCurrency(inKey));	}
	/**
	 * findContractByQBE2
	 */
	public java.util.Enumeration findContractByQBE2(java.lang.Boolean isSupplyType, java.lang.Integer sypplyType, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.String matchName, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findContractByQBE2(isSupplyType, sypplyType, isOwner, owner, isContragent, contragent, matchName, order));	}
	/**
	 * findContractByQBE3
	 */
	public java.util.Enumeration findContractByQBE3(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argBlankDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findContractByQBE3(argSupplyType, isBaseAgreement, argBaseAgreement, isOrganization, argOrganization, isContragent, argContragent, argBlankDate, argFinishDate, isState, argState, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Contract findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPContractBean_f0f90933) persister).findByPrimaryKey(key);
	}
	/**
	 * findWorkedContractByWorker
	 */
	public java.util.Enumeration findWorkedContractByWorker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findWorkedContractByWorker(inKey));	}
	/**
	 * findContractByBaseAgreement
	 */
	public java.util.Enumeration findContractByBaseAgreement(com.hps.july.persistence.BaseAgreementKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findContractByBaseAgreement(inKey));	}
	/**
	 * findContractByQBE
	 */
	public java.util.Enumeration findContractByQBE(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argStartDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContractBean)persister).findContractByQBE(argSupplyType, isBaseAgreement, argBaseAgreement, isOrganization, argOrganization, isContragent, argContragent, argStartDate, argFinishDate, isState, argState, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Contract create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Contract _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ContractBean bean = (com.hps.july.persistence.ContractBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocument);
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
		com.hps.july.persistence.ContractBean tmpEJB = (com.hps.july.persistence.ContractBean) generalEJB;
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = tmpEJB.document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = f0;
		return keyClass;
	}
}

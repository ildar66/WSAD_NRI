package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMutualContractsHomeBean_0dc94a49
 */
public class EJSCMPLeaseMutualContractsHomeBean_0dc94a49 extends EJSHome {
	/**
	 * EJSCMPLeaseMutualContractsHomeBean_0dc94a49
	 */
	public EJSCMPLeaseMutualContractsHomeBean_0dc94a49() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualContracts postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualContracts) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseMutualContracts create(java.lang.Integer argReglament, java.lang.Integer argContract, java.lang.Integer argResource) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualContracts _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualContractsBean bean = (com.hps.july.persistence.LeaseMutualContractsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argReglament, argContract, argResource);
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
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualContracts create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualContracts _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualContractsBean bean = (com.hps.july.persistence.LeaseMutualContractsBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
	 * findLeaseArendaAgreementsByReglament
	 */
	public java.util.Enumeration findLeaseArendaAgreementsByReglament(java.lang.Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualContractsBean)persister).findLeaseArendaAgreementsByReglament(argReglament));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseMutualContracts findByPrimaryKey(com.hps.july.persistence.LeaseMutualContractsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMutualContractsBean_0dc94a49) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseMutualContractsByReglament
	 */
	public java.util.Enumeration findLeaseMutualContractsByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualContractsBean)persister).findLeaseMutualContractsByReglament(inKey));	}
	/**
	 * findLeaseMutualContractsByResource
	 */
	public java.util.Enumeration findLeaseMutualContractsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualContractsBean)persister).findLeaseMutualContractsByResource(inKey));	}
	/**
	 * findLeaseMutualContractsByContract
	 */
	public java.util.Enumeration findLeaseMutualContractsByContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualContractsBean)persister).findLeaseMutualContractsByContract(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseMutualContractsBean tmpEJB = (com.hps.july.persistence.LeaseMutualContractsBean) generalEJB;
		com.hps.july.persistence.LeaseMutualContractsKey keyClass = new com.hps.july.persistence.LeaseMutualContractsKey();
		keyClass.reglament_leaseDocument = tmpEJB.reglament_leaseDocument;
		keyClass.contract_leaseDocument = tmpEJB.contract_leaseDocument;
		keyClass.resource_resource = tmpEJB.resource_resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseMutualContractsKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1, java.lang.Integer f2) {
		com.hps.july.persistence.LeaseMutualContractsKey keyClass = new com.hps.july.persistence.LeaseMutualContractsKey();
		keyClass.reglament_leaseDocument = f0;
		keyClass.contract_leaseDocument = f1;
		keyClass.resource_resource = f2;
		return keyClass;
	}
}

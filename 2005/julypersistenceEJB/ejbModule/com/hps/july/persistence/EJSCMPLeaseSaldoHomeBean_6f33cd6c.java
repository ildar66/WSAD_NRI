package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseSaldoHomeBean_6f33cd6c
 */
public class EJSCMPLeaseSaldoHomeBean_6f33cd6c extends EJSHome {
	/**
	 * EJSCMPLeaseSaldoHomeBean_6f33cd6c
	 */
	public EJSCMPLeaseSaldoHomeBean_6f33cd6c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseSaldo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseSaldo) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByLeaseContractAndResourceOrderDateDesc
	 */
	public java.util.Enumeration findByLeaseContractAndResourceOrderDateDesc(java.lang.Integer leaseContract, java.lang.Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSaldoBean)persister).findByLeaseContractAndResourceOrderDateDesc(leaseContract, resource));	}
	/**
	 * findByLeaseContractAndResourceOrderDateAsc
	 */
	public java.util.Enumeration findByLeaseContractAndResourceOrderDateAsc(java.lang.Integer leaseContract, java.lang.Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSaldoBean)persister).findByLeaseContractAndResourceOrderDateAsc(leaseContract, resource));	}
	/**
	 * findLeaseSaldoMainsByMaincurrency
	 */
	public java.util.Enumeration findLeaseSaldoMainsByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSaldoBean)persister).findLeaseSaldoMainsByMaincurrency(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseSaldo create(java.lang.Integer argLeaseContract, java.sql.Date argSalDate, java.lang.Integer argResource, java.lang.Integer argMainCurrency, java.math.BigDecimal argMainSum, java.math.BigDecimal argMainNdsSum, java.lang.Boolean argIsTemp) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseSaldo _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseSaldoBean bean = (com.hps.july.persistence.LeaseSaldoBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseContract, argSalDate, argResource, argMainCurrency, argMainSum, argMainNdsSum, argIsTemp);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseSaldo findByPrimaryKey(com.hps.july.persistence.LeaseSaldoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseSaldoBean_6f33cd6c) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseSaldosByAct
	 */
	public java.util.Enumeration findLeaseSaldosByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSaldoBean)persister).findLeaseSaldosByAct(inKey));	}
	/**
	 * findLeaseSaldoByResource
	 */
	public java.util.Enumeration findLeaseSaldoByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSaldoBean)persister).findLeaseSaldoByResource(inKey));	}
	/**
	 * findLeaseSaldoAddsByAdditionalcurrency
	 */
	public java.util.Enumeration findLeaseSaldoAddsByAdditionalcurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSaldoBean)persister).findLeaseSaldoAddsByAdditionalcurrency(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer leaseContract, java.lang.Boolean isDateStart, java.sql.Date fromDateStart, java.sql.Date toDateStart, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseSaldoBean)persister).findByQBE(leaseContract, isDateStart, fromDateStart, toDateStart, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseSaldoBean tmpEJB = (com.hps.july.persistence.LeaseSaldoBean) generalEJB;
		com.hps.july.persistence.LeaseSaldoKey keyClass = new com.hps.july.persistence.LeaseSaldoKey();
		keyClass.leaseContract = tmpEJB.leaseContract;
		keyClass.SalDate = tmpEJB.SalDate;
		keyClass.resource_resource = tmpEJB.resource_resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseSaldoKey keyFromFields(java.lang.Integer f0, java.sql.Date f1, java.lang.Integer f2) {
		com.hps.july.persistence.LeaseSaldoKey keyClass = new com.hps.july.persistence.LeaseSaldoKey();
		keyClass.leaseContract = f0;
		keyClass.SalDate = f1;
		keyClass.resource_resource = f2;
		return keyClass;
	}
}

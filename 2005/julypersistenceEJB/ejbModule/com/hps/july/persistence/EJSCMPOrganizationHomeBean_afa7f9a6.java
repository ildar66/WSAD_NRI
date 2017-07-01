package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOrganizationHomeBean_afa7f9a6
 */
public class EJSCMPOrganizationHomeBean_afa7f9a6 extends EJSHome {
	/**
	 * EJSCMPOrganizationHomeBean_afa7f9a6
	 */
	public EJSCMPOrganizationHomeBean_afa7f9a6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Organization postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Organization) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findOrganizationsButBanksByCompanyAndGroup
	 */
	public java.util.Enumeration findOrganizationsButBanksByCompanyAndGroup(java.lang.Integer argCompany, java.lang.Boolean isGroup, java.lang.Integer searchgroup, java.lang.Integer searchGroupping) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationsButBanksByCompanyAndGroup(argCompany, isGroup, searchgroup, searchGroupping));	}
	/**
	 * findOrganizationsByQBE2
	 */
	public java.util.Enumeration findOrganizationsByQBE2(java.lang.Boolean isHaveBans, java.lang.Boolean isRenter, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Boolean isBan, java.lang.Integer ban, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationsByQBE2(isHaveBans, isRenter, isName, argName, isInn, argInn, isBan, ban, order));	}
	/**
	 * findOrganizationByCompany
	 */
	public java.util.Enumeration findOrganizationByCompany(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationByCompany(inKey));	}
	/**
	 * findOrganizationsByNameOrderByNameAsc
	 */
	public java.util.Enumeration findOrganizationsByNameOrderByNameAsc(java.lang.String name, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationsByNameOrderByNameAsc(name, argIsSupplier, argIsProvider, argIsRenter));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Organization create(int organization, com.hps.july.persistence.Company argCompany) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Organization _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OrganizationBean bean = (com.hps.july.persistence.OrganizationBean) beanO.getEnterpriseBean();
			bean.ejbCreate(organization, argCompany);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(organization, argCompany);
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
	public com.hps.july.persistence.Organization create(int argOrganization, java.lang.String argName, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter, java.lang.Boolean argBank) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Organization _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OrganizationBean bean = (com.hps.july.persistence.OrganizationBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOrganization, argName, argIsSupplier, argIsProvider, argIsRenter, argBank);
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
	 * findOrganizationsButBanksByCompany
	 */
	public java.util.Enumeration findOrganizationsButBanksByCompany(java.lang.Integer argCompany) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationsButBanksByCompany(argCompany));	}
	/**
	 * findByInnOrderByInnAsc
	 */
	public java.util.Enumeration findByInnOrderByInnAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findByInnOrderByInnAsc(name));	}
	/**
	 * findByNameOrderByNameAsc
	 */
	public java.util.Enumeration findByNameOrderByNameAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findByNameOrderByNameAsc(name));	}
	/**
	 * findBanksByNameOrderByNameAsc
	 */
	public java.util.Enumeration findBanksByNameOrderByNameAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findBanksByNameOrderByNameAsc(name));	}
	/**
	 * findOurOrganizations
	 */
	public java.util.Enumeration findOurOrganizations() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOurOrganizations());	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Organization findByPrimaryKey(com.hps.july.persistence.OrganizationKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPOrganizationBean_afa7f9a6) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Organization create(int argOrganization, java.lang.String argName, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter, java.lang.Boolean argIsChannalRenter, java.lang.Boolean argBank) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Organization _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OrganizationBean bean = (com.hps.july.persistence.OrganizationBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOrganization, argName, argIsSupplier, argIsProvider, argIsRenter, argIsChannalRenter, argBank);
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
	 * findOrganizationsByQBE
	 */
	public java.util.Enumeration findOrganizationsByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationsByQBE(isName, argName, isSupplier, isProvider, isRenter, isInn, argInn, order));	}
	/**
	 * findOrganizationsByQBEAndGroup
	 */
	public java.util.Enumeration findOrganizationsByQBEAndGroup(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order, java.lang.Boolean isGroup, java.lang.Integer group, java.lang.Integer groupping) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationsByQBEAndGroup(isName, argName, isSupplier, isProvider, isRenter, isInn, argInn, order, isGroup, group, groupping));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Organization create(int argOrganization) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Organization _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OrganizationBean bean = (com.hps.july.persistence.OrganizationBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOrganization);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argOrganization);
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
	 * findBanksByQBE
	 */
	public java.util.Enumeration findBanksByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isBic, java.lang.String argBic, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findBanksByQBE(isName, argName, isBic, argBic, order));	}
	/**
	 * findOrganizationsByReglament
	 */
	public java.util.Enumeration findOrganizationsByReglament(java.lang.Integer argCustReglament, java.lang.Integer argExecReglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOrganizationBean)persister).findOrganizationsByReglament(argCustReglament, argExecReglament));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.OrganizationBean tmpEJB = (com.hps.july.persistence.OrganizationBean) generalEJB;
		com.hps.july.persistence.OrganizationKey keyClass = new com.hps.july.persistence.OrganizationKey();
		keyClass.organization = tmpEJB.organization;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.OrganizationKey keyFromFields(int f0) {
		com.hps.july.persistence.OrganizationKey keyClass = new com.hps.july.persistence.OrganizationKey();
		keyClass.organization = f0;
		return keyClass;
	}
}

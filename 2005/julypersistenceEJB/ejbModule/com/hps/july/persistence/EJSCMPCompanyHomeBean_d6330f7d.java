package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCompanyHomeBean_d6330f7d
 */
public class EJSCMPCompanyHomeBean_d6330f7d extends EJSHome {
	/**
	 * EJSCMPCompanyHomeBean_d6330f7d
	 */
	public EJSCMPCompanyHomeBean_d6330f7d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Company postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Company) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Company create(int argCompany, java.lang.String argName, java.lang.String argShortName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Company _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CompanyBean bean = (com.hps.july.persistence.CompanyBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCompany, argName, argShortName);
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
	 * findOrderByNameDesc
	 */
	public java.util.Enumeration findOrderByNameDesc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCompanyBean)persister).findOrderByNameDesc());	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Company findByPrimaryKey(com.hps.july.persistence.CompanyKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPCompanyBean_d6330f7d) persister).findByPrimaryKey(key);
	}
	/**
	 * findOrderByNameAsc
	 */
	public java.util.Enumeration findOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCompanyBean)persister).findOrderByNameAsc());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Company create(int argCompany) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Company _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CompanyBean bean = (com.hps.july.persistence.CompanyBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCompany);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argCompany);
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
		com.hps.july.persistence.CompanyBean tmpEJB = (com.hps.july.persistence.CompanyBean) generalEJB;
		com.hps.july.persistence.CompanyKey keyClass = new com.hps.july.persistence.CompanyKey();
		keyClass.company = tmpEJB.company;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.CompanyKey keyFromFields(int f0) {
		com.hps.july.persistence.CompanyKey keyClass = new com.hps.july.persistence.CompanyKey();
		keyClass.company = f0;
		return keyClass;
	}
}

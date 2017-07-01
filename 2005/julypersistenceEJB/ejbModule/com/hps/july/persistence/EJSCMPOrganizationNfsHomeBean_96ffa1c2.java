package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOrganizationNfsHomeBean_96ffa1c2
 */
public class EJSCMPOrganizationNfsHomeBean_96ffa1c2 extends EJSHome {
	/**
	 * EJSCMPOrganizationNfsHomeBean_96ffa1c2
	 */
	public EJSCMPOrganizationNfsHomeBean_96ffa1c2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OrganizationNfs postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OrganizationNfs) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.OrganizationNfs create(int organization) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OrganizationNfs _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OrganizationNfsBean bean = (com.hps.july.persistence.OrganizationNfsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(organization);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(organization);
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
	public com.hps.july.persistence.OrganizationNfs findByPrimaryKey(com.hps.july.persistence.OrganizationNfsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPOrganizationNfsBean_96ffa1c2) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.OrganizationNfsBean tmpEJB = (com.hps.july.persistence.OrganizationNfsBean) generalEJB;
		com.hps.july.persistence.OrganizationNfsKey keyClass = new com.hps.july.persistence.OrganizationNfsKey();
		keyClass.organization = tmpEJB.organization;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.OrganizationNfsKey keyFromFields(int f0) {
		com.hps.july.persistence.OrganizationNfsKey keyClass = new com.hps.july.persistence.OrganizationNfsKey();
		keyClass.organization = f0;
		return keyClass;
	}
}

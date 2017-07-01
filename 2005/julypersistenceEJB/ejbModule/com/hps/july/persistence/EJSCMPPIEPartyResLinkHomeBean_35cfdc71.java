package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEPartyResLinkHomeBean_35cfdc71
 */
public class EJSCMPPIEPartyResLinkHomeBean_35cfdc71 extends EJSHome {
	/**
	 * EJSCMPPIEPartyResLinkHomeBean_35cfdc71
	 */
	public EJSCMPPIEPartyResLinkHomeBean_35cfdc71() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPartyResLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPartyResLink) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEPartyResLink create(java.lang.String argParty, int argOwner, java.lang.String argPartyPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEPartyResLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEPartyResLinkBean bean = (com.hps.july.persistence.PIEPartyResLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argParty, argOwner, argPartyPlatinum);
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
	public com.hps.july.persistence.PIEPartyResLink findByPrimaryKey(com.hps.july.persistence.PIEPartyResLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEPartyResLinkBean_35cfdc71) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEPartyResLink create(java.lang.String argParty, int argOwner, java.lang.String argPartyPlatinum, java.lang.String argIdResPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEPartyResLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEPartyResLinkBean bean = (com.hps.july.persistence.PIEPartyResLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argParty, argOwner, argPartyPlatinum, argIdResPlatinum);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEPartyResLinkBean tmpEJB = (com.hps.july.persistence.PIEPartyResLinkBean) generalEJB;
		com.hps.july.persistence.PIEPartyResLinkKey keyClass = new com.hps.july.persistence.PIEPartyResLinkKey();
		keyClass.owner = tmpEJB.owner;
		keyClass.party = tmpEJB.party;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEPartyResLinkKey keyFromFields(int f0, java.lang.String f1) {
		com.hps.july.persistence.PIEPartyResLinkKey keyClass = new com.hps.july.persistence.PIEPartyResLinkKey();
		keyClass.owner = f0;
		keyClass.party = f1;
		return keyClass;
	}
}

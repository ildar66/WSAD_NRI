package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPChangeLogDetailsHomeBean_f1d1fd8b
 */
public class EJSCMPChangeLogDetailsHomeBean_f1d1fd8b extends EJSHome {
	/**
	 * EJSCMPChangeLogDetailsHomeBean_f1d1fd8b
	 */
	public EJSCMPChangeLogDetailsHomeBean_f1d1fd8b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChangeLogDetails postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChangeLogDetails) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ChangeLogDetails findByPrimaryKey(com.hps.july.persistence.ChangeLogDetailsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPChangeLogDetailsBean_f1d1fd8b) persister).findByPrimaryKey(key);
	}
	/**
	 * findChangeLogDetailsesByChangelog
	 */
	public java.util.Enumeration findChangeLogDetailsesByChangelog(com.hps.july.persistence.ChangeLogKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChangeLogDetailsBean)persister).findChangeLogDetailsesByChangelog(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ChangeLogDetails create(int argLogdetid, int argLogid, java.lang.String argFieldLabel) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ChangeLogDetails _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ChangeLogDetailsBean bean = (com.hps.july.persistence.ChangeLogDetailsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLogdetid, argLogid, argFieldLabel);
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
	 * findByChangelogOrderByCodeAsc
	 */
	public java.util.Enumeration findByChangelogOrderByCodeAsc(java.lang.Integer argLog) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChangeLogDetailsBean)persister).findByChangelogOrderByCodeAsc(argLog));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ChangeLogDetailsBean tmpEJB = (com.hps.july.persistence.ChangeLogDetailsBean) generalEJB;
		com.hps.july.persistence.ChangeLogDetailsKey keyClass = new com.hps.july.persistence.ChangeLogDetailsKey();
		keyClass.logdetid = tmpEJB.logdetid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ChangeLogDetailsKey keyFromFields(int f0) {
		com.hps.july.persistence.ChangeLogDetailsKey keyClass = new com.hps.july.persistence.ChangeLogDetailsKey();
		keyClass.logdetid = f0;
		return keyClass;
	}
}

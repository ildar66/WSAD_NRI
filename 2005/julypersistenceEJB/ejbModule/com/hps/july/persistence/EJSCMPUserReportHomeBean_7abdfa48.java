package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPUserReportHomeBean_7abdfa48
 */
public class EJSCMPUserReportHomeBean_7abdfa48 extends EJSHome {
	/**
	 * EJSCMPUserReportHomeBean_7abdfa48
	 */
	public EJSCMPUserReportHomeBean_7abdfa48() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.UserReport postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.UserReport) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.UserReport create(int argUserrepid, java.lang.Integer usergrpid, java.lang.String argRepname, java.lang.String argClassname, java.lang.String argRptname) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.UserReport _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.UserReportBean bean = (com.hps.july.persistence.UserReportBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argUserrepid, usergrpid, argRepname, argClassname, argRptname);
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
	 * findByGroupOrderByNameAsc
	 */
	public java.util.Enumeration findByGroupOrderByNameAsc(java.lang.Integer argGroupId) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderUserReportBean)persister).findByGroupOrderByNameAsc(argGroupId));	}
	/**
	 * findUserReportsByUserRepGroup
	 */
	public java.util.Enumeration findUserReportsByUserRepGroup(com.hps.july.persistence.UserRepGroupKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderUserReportBean)persister).findUserReportsByUserRepGroup(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.UserReport findByPrimaryKey(com.hps.july.persistence.UserReportKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPUserReportBean_7abdfa48) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.UserReportBean tmpEJB = (com.hps.july.persistence.UserReportBean) generalEJB;
		com.hps.july.persistence.UserReportKey keyClass = new com.hps.july.persistence.UserReportKey();
		keyClass.userrepid = tmpEJB.userrepid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.UserReportKey keyFromFields(int f0) {
		com.hps.july.persistence.UserReportKey keyClass = new com.hps.july.persistence.UserReportKey();
		keyClass.userrepid = f0;
		return keyClass;
	}
}

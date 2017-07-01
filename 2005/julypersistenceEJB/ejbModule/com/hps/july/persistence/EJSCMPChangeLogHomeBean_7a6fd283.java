package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPChangeLogHomeBean_7a6fd283
 */
public class EJSCMPChangeLogHomeBean_7a6fd283 extends EJSHome {
	/**
	 * EJSCMPChangeLogHomeBean_7a6fd283
	 */
	public EJSCMPChangeLogHomeBean_7a6fd283() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChangeLog postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChangeLog) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ChangeLog findByPrimaryKey(com.hps.july.persistence.ChangeLogKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPChangeLogBean_7a6fd283) persister).findByPrimaryKey(key);
	}
	/**
	 * findChangeLogsByPeople
	 */
	public java.util.Enumeration findChangeLogsByPeople(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChangeLogBean)persister).findChangeLogsByPeople(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ChangeLog create(int argLogid, java.sql.Timestamp argRecdate, short argObjtype, int argObjid, java.lang.String argEventtype, int argMan) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ChangeLog _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ChangeLogBean bean = (com.hps.july.persistence.ChangeLogBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLogid, argRecdate, argObjtype, argObjid, argEventtype, argMan);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isObjtype, java.lang.Short objtype, java.lang.Boolean isObjid, java.lang.Integer objid, java.lang.Boolean isPeriod, java.sql.Timestamp dateStart, java.sql.Timestamp dateEnd, java.lang.Boolean isMan, java.lang.Integer man, java.lang.Boolean isEventtype, java.lang.String eventtype, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChangeLogBean)persister).findByQBE(isObjtype, objtype, isObjid, objid, isPeriod, dateStart, dateEnd, isMan, man, isEventtype, eventtype, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ChangeLogBean tmpEJB = (com.hps.july.persistence.ChangeLogBean) generalEJB;
		com.hps.july.persistence.ChangeLogKey keyClass = new com.hps.july.persistence.ChangeLogKey();
		keyClass.logid = tmpEJB.logid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ChangeLogKey keyFromFields(int f0) {
		com.hps.july.persistence.ChangeLogKey keyClass = new com.hps.july.persistence.ChangeLogKey();
		keyClass.logid = f0;
		return keyClass;
	}
}

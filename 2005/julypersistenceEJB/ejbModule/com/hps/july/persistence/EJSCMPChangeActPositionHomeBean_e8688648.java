package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPChangeActPositionHomeBean_e8688648
 */
public class EJSCMPChangeActPositionHomeBean_e8688648 extends EJSHome {
	/**
	 * EJSCMPChangeActPositionHomeBean_e8688648
	 */
	public EJSCMPChangeActPositionHomeBean_e8688648() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChangeActPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChangeActPosition) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByDocNewSerial
	 */
	public java.util.Enumeration findByDocNewSerial(java.lang.Integer argDoc, java.lang.String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChangeActPositionBean)persister).findByDocNewSerial(argDoc, argSerial));	}
	/**
	 * findChangeActPositionByChangeAct
	 */
	public java.util.Enumeration findChangeActPositionByChangeAct(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChangeActPositionBean)persister).findChangeActPositionByChangeAct(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ChangeActPosition findByPrimaryKey(com.hps.july.persistence.ChangeActPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPChangeActPositionBean_e8688648) persister).findByPrimaryKey(key);
	}
	/**
	 * findChangeActPositionsByNewresource
	 */
	public java.util.Enumeration findChangeActPositionsByNewresource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChangeActPositionBean)persister).findChangeActPositionsByNewresource(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ChangeActPosition create(int argCode, java.lang.String argOldSerial, java.lang.String argNewSerial, java.lang.Integer argChangeAct) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ChangeActPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ChangeActPositionBean bean = (com.hps.july.persistence.ChangeActPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCode, argOldSerial, argNewSerial, argChangeAct);
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
	public com.hps.july.persistence.ChangeActPosition create(int argCode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ChangeActPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ChangeActPositionBean bean = (com.hps.july.persistence.ChangeActPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCode);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argCode);
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
		com.hps.july.persistence.ChangeActPositionBean tmpEJB = (com.hps.july.persistence.ChangeActPositionBean) generalEJB;
		com.hps.july.persistence.ChangeActPositionKey keyClass = new com.hps.july.persistence.ChangeActPositionKey();
		keyClass.code = tmpEJB.code;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ChangeActPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.ChangeActPositionKey keyClass = new com.hps.july.persistence.ChangeActPositionKey();
		keyClass.code = f0;
		return keyClass;
	}
}

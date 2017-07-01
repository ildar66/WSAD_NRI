package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAntennaCableHomeBean_0c548ccb
 */
public class EJSCMPAntennaCableHomeBean_0c548ccb extends EJSHome {
	/**
	 * EJSCMPAntennaCableHomeBean_0c548ccb
	 */
	public EJSCMPAntennaCableHomeBean_0c548ccb() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.AntennaCable postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.AntennaCable) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.AntennaCable findByPrimaryKey(com.hps.july.persistence2.AntennaCableKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPAntennaCableBean_0c548ccb) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.AntennaCable create(int argIdcable, int argIdAntenna, int argCableRes, java.math.BigDecimal argLenCable) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.AntennaCable _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.AntennaCableBean bean = (com.hps.july.persistence2.AntennaCableBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdcable, argIdAntenna, argCableRes, argLenCable);
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
	 * findByAnten
	 */
	public java.util.Enumeration findByAnten(java.lang.Integer argAntenId) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence2.EJSFinderAntennaCableBean)persister).findByAnten(argAntenId));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.AntennaCableBean tmpEJB = (com.hps.july.persistence2.AntennaCableBean) generalEJB;
		com.hps.july.persistence2.AntennaCableKey keyClass = new com.hps.july.persistence2.AntennaCableKey();
		keyClass.idcable = tmpEJB.idcable;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.AntennaCableKey keyFromFields(int f0) {
		com.hps.july.persistence2.AntennaCableKey keyClass = new com.hps.july.persistence2.AntennaCableKey();
		keyClass.idcable = f0;
		return keyClass;
	}
}

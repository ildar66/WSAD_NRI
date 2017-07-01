package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRRLSpeedParamsHomeBean_64177aa5
 */
public class EJSCMPRRLSpeedParamsHomeBean_64177aa5 extends EJSHome {
	/**
	 * EJSCMPRRLSpeedParamsHomeBean_64177aa5
	 */
	public EJSCMPRRLSpeedParamsHomeBean_64177aa5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RRLSpeedParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RRLSpeedParams) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.RRLSpeedParams findByPrimaryKey(com.hps.july.persistence.RRLSpeedParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRRLSpeedParamsBean_64177aa5) persister).findByPrimaryKey(key);
	}
	/**
	 * findByResourceAndSpeed
	 */
	public java.util.Enumeration findByResourceAndSpeed(int argResource, java.lang.String argStreamSpeed) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLSpeedParamsBean)persister).findByResourceAndSpeed(argResource, argStreamSpeed));	}
	/**
	 * findByResource
	 */
	public java.util.Enumeration findByResource(int argResource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLSpeedParamsBean)persister).findByResource(argResource));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.RRLSpeedParams create(int argRrlspeedid, int argResource, java.lang.String argStreamSpeed, java.lang.String argRadiationClass, java.math.BigDecimal argRecvSensitivity) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RRLSpeedParams _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RRLSpeedParamsBean bean = (com.hps.july.persistence.RRLSpeedParamsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRrlspeedid, argResource, argStreamSpeed, argRadiationClass, argRecvSensitivity);
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
		com.hps.july.persistence.RRLSpeedParamsBean tmpEJB = (com.hps.july.persistence.RRLSpeedParamsBean) generalEJB;
		com.hps.july.persistence.RRLSpeedParamsKey keyClass = new com.hps.july.persistence.RRLSpeedParamsKey();
		keyClass.rrlspeedid = tmpEJB.rrlspeedid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.RRLSpeedParamsKey keyFromFields(int f0) {
		com.hps.july.persistence.RRLSpeedParamsKey keyClass = new com.hps.july.persistence.RRLSpeedParamsKey();
		keyClass.rrlspeedid = f0;
		return keyClass;
	}
}

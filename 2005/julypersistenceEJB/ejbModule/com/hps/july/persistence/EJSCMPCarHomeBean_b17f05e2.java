package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCarHomeBean_b17f05e2
 */
public class EJSCMPCarHomeBean_b17f05e2 extends EJSHome {
	/**
	 * EJSCMPCarHomeBean_b17f05e2
	 */
	public EJSCMPCarHomeBean_b17f05e2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Car postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Car) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isDivision, java.lang.Integer division, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCarBean)persister).findByQBE(isOrganization, organization, isDivision, division, order));	}
	/**
	 * findCarsByOrganization
	 */
	public java.util.Enumeration findCarsByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCarBean)persister).findCarsByOrganization(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Car create(int argCar, java.lang.Boolean argIsour, java.lang.String argCarmodel, java.lang.String argCarnumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Car _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CarBean bean = (com.hps.july.persistence.CarBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCar, argIsour, argCarmodel, argCarnumber);
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
	 * findByOrganizationIsour
	 */
	public java.util.Enumeration findByOrganizationIsour(java.lang.Integer organization, java.lang.String isour) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCarBean)persister).findByOrganizationIsour(organization, isour));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Car findByPrimaryKey(com.hps.july.persistence.CarKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPCarBean_b17f05e2) persister).findByPrimaryKey(key);
	}
	/**
	 * findCarsByDivision
	 */
	public java.util.Enumeration findCarsByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCarBean)persister).findCarsByDivision(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.CarBean tmpEJB = (com.hps.july.persistence.CarBean) generalEJB;
		com.hps.july.persistence.CarKey keyClass = new com.hps.july.persistence.CarKey();
		keyClass.car = tmpEJB.car;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.CarKey keyFromFields(int f0) {
		com.hps.july.persistence.CarKey keyClass = new com.hps.july.persistence.CarKey();
		keyClass.car = f0;
		return keyClass;
	}
}

package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeasePosSchetFaktHomeBean_13ea5e6d
 */
public class EJSCMPLeasePosSchetFaktHomeBean_13ea5e6d extends EJSHome {
	/**
	 * EJSCMPLeasePosSchetFaktHomeBean_13ea5e6d
	 */
	public EJSCMPLeasePosSchetFaktHomeBean_13ea5e6d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePosSchetFakt postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePosSchetFakt) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeasePosSchetFaktByResourceNri
	 */
	public java.util.Enumeration findLeasePosSchetFaktByResourceNri(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePosSchetFaktBean)persister).findLeasePosSchetFaktByResourceNri(inKey));	}
	/**
	 * findByIdSchetFaktOrderByPosorderDesc
	 */
	public java.util.Enumeration findByIdSchetFaktOrderByPosorderDesc(java.lang.Integer idSchetFact) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePosSchetFaktBean)persister).findByIdSchetFaktOrderByPosorderDesc(idSchetFact));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeasePosSchetFakt findByPrimaryKey(com.hps.july.persistence.LeasePosSchetFaktKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeasePosSchetFaktBean_13ea5e6d) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeasePosSchetFaktsByIdSchetFakt
	 */
	public java.util.Enumeration findLeasePosSchetFaktsByIdSchetFakt(com.hps.july.persistence.LeaseSchetFaktKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePosSchetFaktBean)persister).findLeasePosSchetFaktsByIdSchetFakt(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeasePosSchetFakt create(java.lang.Integer argIdPosSchetFakt, java.lang.Integer idSchetFakt, java.lang.Integer argPosorder, java.lang.Integer resourceNri) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePosSchetFakt _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePosSchetFaktBean bean = (com.hps.july.persistence.LeasePosSchetFaktBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdPosSchetFakt, idSchetFakt, argPosorder, resourceNri);
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
	 * findByIdSchetFaktOrderByPosorderAsc
	 */
	public java.util.Enumeration findByIdSchetFaktOrderByPosorderAsc(java.lang.Integer idSchetFact) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePosSchetFaktBean)persister).findByIdSchetFaktOrderByPosorderAsc(idSchetFact));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeasePosSchetFaktBean tmpEJB = (com.hps.july.persistence.LeasePosSchetFaktBean) generalEJB;
		com.hps.july.persistence.LeasePosSchetFaktKey keyClass = new com.hps.july.persistence.LeasePosSchetFaktKey();
		keyClass.idPosSchetFakt = tmpEJB.idPosSchetFakt;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeasePosSchetFaktKey keyFromFields(int f0) {
		com.hps.july.persistence.LeasePosSchetFaktKey keyClass = new com.hps.july.persistence.LeasePosSchetFaktKey();
		keyClass.idPosSchetFakt = f0;
		return keyClass;
	}
}

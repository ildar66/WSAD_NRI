package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMRCntPriorHomeBean_5e3fe006
 */
public class EJSCMPLeaseMRCntPriorHomeBean_5e3fe006 extends EJSHome {
	/**
	 * EJSCMPLeaseMRCntPriorHomeBean_5e3fe006
	 */
	public EJSCMPLeaseMRCntPriorHomeBean_5e3fe006() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMRCntPrior postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMRCntPrior) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeaseMRCntPriors2ByContract2
	 */
	public java.util.Enumeration findLeaseMRCntPriors2ByContract2(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMRCntPriorBean)persister).findLeaseMRCntPriors2ByContract2(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseMRCntPrior findByPrimaryKey(com.hps.july.persistence.LeaseMRCntPriorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMRCntPriorBean_5e3fe006) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseMRCntPriors1ByContract1
	 */
	public java.util.Enumeration findLeaseMRCntPriors1ByContract1(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMRCntPriorBean)persister).findLeaseMRCntPriors1ByContract1(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMRCntPrior create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMRCntPrior _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMRCntPriorBean bean = (com.hps.july.persistence.LeaseMRCntPriorBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
	 * findByReglamentContractOrderbyPriorityAsc
	 */
	public java.util.Enumeration findByReglamentContractOrderbyPriorityAsc(java.lang.Integer reglament, java.lang.Integer contract1, java.lang.Integer contract2) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMRCntPriorBean)persister).findByReglamentContractOrderbyPriorityAsc(reglament, contract1, contract2));	}
	/**
	 * findLeaseMRCntPriorsByReglament
	 */
	public java.util.Enumeration findLeaseMRCntPriorsByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMRCntPriorBean)persister).findLeaseMRCntPriorsByReglament(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMRCntPrior create(java.lang.Integer argReglament, java.lang.Integer argContract1, java.lang.Integer argContract2, java.lang.Short argPriority) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMRCntPrior _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMRCntPriorBean bean = (com.hps.july.persistence.LeaseMRCntPriorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argReglament, argContract1, argContract2, argPriority);
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
		com.hps.july.persistence.LeaseMRCntPriorBean tmpEJB = (com.hps.july.persistence.LeaseMRCntPriorBean) generalEJB;
		com.hps.july.persistence.LeaseMRCntPriorKey keyClass = new com.hps.july.persistence.LeaseMRCntPriorKey();
		keyClass.contract2_leaseDocument = tmpEJB.contract2_leaseDocument;
		keyClass.contract1_leaseDocument = tmpEJB.contract1_leaseDocument;
		keyClass.reglament_leaseDocument = tmpEJB.reglament_leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseMRCntPriorKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1, java.lang.Integer f2) {
		com.hps.july.persistence.LeaseMRCntPriorKey keyClass = new com.hps.july.persistence.LeaseMRCntPriorKey();
		keyClass.contract2_leaseDocument = f0;
		keyClass.contract1_leaseDocument = f1;
		keyClass.reglament_leaseDocument = f2;
		return keyClass;
	}
}

package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseAbonentBENHomeBean_269c14e7
 */
public class EJSCMPLeaseAbonentBENHomeBean_269c14e7 extends EJSHome {
	/**
	 * EJSCMPLeaseAbonentBENHomeBean_269c14e7
	 */
	public EJSCMPLeaseAbonentBENHomeBean_269c14e7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentBEN postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentBEN) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseAbonentBEN findByPrimaryKey(com.hps.july.persistence.LeaseAbonentBENKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseAbonentBENBean_269c14e7) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseAbonentBENsByLeaseabonentban
	 */
	public java.util.Enumeration findLeaseAbonentBENsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBENBean)persister).findLeaseAbonentBENsByLeaseabonentban(inKey));	}
	/**
	 * findByBen
	 */
	public java.util.Enumeration findByBen(java.lang.Short argBen) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBENBean)persister).findByBen(argBen));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseAbonentBEN create(int argLeaseDocument, short argBen) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseAbonentBEN _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseAbonentBENBean bean = (com.hps.july.persistence.LeaseAbonentBENBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument, argBen);
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
	 * findByLeasedocumentOrderByBenAsc
	 */
	public java.util.Enumeration findByLeasedocumentOrderByBenAsc(java.lang.Integer argLeasedocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentBENBean)persister).findByLeasedocumentOrderByBenAsc(argLeasedocument));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseAbonentBENBean tmpEJB = (com.hps.july.persistence.LeaseAbonentBENBean) generalEJB;
		com.hps.july.persistence.LeaseAbonentBENKey keyClass = new com.hps.july.persistence.LeaseAbonentBENKey();
		keyClass.ben = tmpEJB.ben;
		keyClass.leaseabonentban_leaseDocument = tmpEJB.leaseabonentban_leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseAbonentBENKey keyFromFields(short f0, java.lang.Integer f1) {
		com.hps.july.persistence.LeaseAbonentBENKey keyClass = new com.hps.july.persistence.LeaseAbonentBENKey();
		keyClass.ben = f0;
		keyClass.leaseabonentban_leaseDocument = f1;
		return keyClass;
	}
}

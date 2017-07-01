package com.hps.july.journal.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessJournal_d19677f4
 */
public class EJSRemoteStatelessJournal_d19677f4 extends EJSWrapper implements Journal {
	/**
	 * EJSRemoteStatelessJournal_d19677f4
	 */
	public EJSRemoteStatelessJournal_d19677f4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * removeAntenna
	 */
	public boolean removeAntenna(int idAntenna) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.removeAntenna(idAntenna);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeBasestation
	 */
	public boolean removeBasestation(int idBasestation) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.removeBasestation(idBasestation);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeLeaseArendaAgrmnts
	 */
	public boolean removeLeaseArendaAgrmnts(int idLeasedocument) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.removeLeaseArendaAgrmnts(idLeasedocument);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeLeaseMutualAct
	 */
	public boolean removeLeaseMutualAct(int idLeasedocument) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.removeLeaseMutualAct(idLeasedocument);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeLeasePayment
	 */
	public boolean removeLeasePayment(int idPay) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.removeLeasePayment(idPay);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removePosition
	 */
	public boolean removePosition(int idPosition) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.removePosition(idPosition);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeSector
	 */
	public boolean removeSector(int idSector) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.removeSector(idSector);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeWorkresponsible
	 */
	public boolean removeWorkresponsible(int idResponsibility, int idStorageplace, java.lang.String idResptype) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.journal.beans.JournalBean beanRef = (com.hps.july.journal.beans.JournalBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.removeWorkresponsible(idResponsibility, idStorageplace, idResptype);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.ServerException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}

package com.hps.july.utils.ejbtransaction;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.hps.july.utils.Logger;

/**
 * @author dimitry
 * Created 05.05.2006
 */
public class EJBTransactionTemplate {

	protected static String JNDI_TRANSACTION_REF = "jta/usertransaction"; 
	protected Logger logger = new Logger(this.getClass());
	
	public UserTransaction lookupTransaction() throws NamingException {
		try {
			Context ctx = new InitialContext();
			UserTransaction transaction = (UserTransaction) ctx.lookup(JNDI_TRANSACTION_REF);
			return transaction;
		} catch (NamingException e){
			logger.error("Can not resolve UserTransaction by ref: " + JNDI_TRANSACTION_REF + ". Original message: " + e.getMessage(), e);
			throw e;
		}
	}
	
	
	public Object execute(TransactionCallback transactionCallback) throws Exception {
		UserTransaction transaction = lookupTransaction(); 
        Object result = null;

        try {
			transaction.begin();
		} catch (Exception e) {
			convertException("Exception while begin transaction", e);
		}
		
        try {
    		result = transactionCallback.doInTransaction();
        } catch(Exception e){
        	rollbackOnException(transaction, e);
        	throw e;
        } catch(Error e){
        	rollbackOnException(transaction, e);
        	throw e;
        }

    	try {
			transaction.commit();
		} catch (Exception e) {
			convertException("Exception while commit transaction", e);
		}
        return result;
	}
	
	private void convertException(String message, Exception e) throws Exception{
		logger.error(message + ". Original message: " + e.getMessage(), e);
		throw e;
	}
	

	private void rollbackOnException(UserTransaction transaction, Throwable ex) throws SystemException {
		logger.debug("Initiating transaction rollback on application exception", ex);
		try {
			transaction.rollback();
		} catch (RuntimeException e) {
			logger.error("Application exception overridden by rollback exception", e);
			throw e;
		} catch (SystemException e) {
			logger.error("Application exception overridden by rollback exception", ex);
			throw e;
		} catch (Error err){
			logger.error("Application exception overridden by rollback error", err);
			throw err;
		}
	}
}

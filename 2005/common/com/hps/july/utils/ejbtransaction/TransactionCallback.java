package com.hps.july.utils.ejbtransaction;

/**
 * @author dimitry
 * Created 05.05.2006
 */
public interface TransactionCallback {

	Object doInTransaction() throws Exception;
	
}

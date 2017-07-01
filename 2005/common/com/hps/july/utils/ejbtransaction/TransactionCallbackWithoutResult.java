package com.hps.july.utils.ejbtransaction;

/**
 * @author dimitry
 * Created 05.05.2006
 */
public abstract class TransactionCallbackWithoutResult implements TransactionCallback {

	public final Object doInTransaction() throws Exception {
		doInTransactionWithoutResult();
		return null;
	}

	protected abstract void doInTransactionWithoutResult() throws Exception;

}

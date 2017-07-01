package com.hps.july.inventory.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (25.06.2002 22:19:47)
 * @author: Oleg Gashnikov
 */
public class CurrencySumProcessingExceptionChecker {
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 22:21:20)
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param ex java.lang.Exception
 */
public static CurrencySumProcessingError check(Exception ex) {
	Exception e = ex;
	while( e instanceof java.rmi.RemoteException ) {
		e = (Exception)(((java.rmi.RemoteException)e).detail);
	}
	return (e instanceof CurrencySumProcessingError)? (CurrencySumProcessingError)e: null;
}
}

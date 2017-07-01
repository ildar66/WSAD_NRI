package com.hps.july.inventory.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (25.06.2002 22:19:47)
 * @author: Oleg Gashnikov
 */
public class DocumentProcessingExceptionChecker {
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 22:21:20)
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param ex java.lang.Exception
 */
public static DocumentProcessingException check(Exception ex) {
	Exception e = ex;
	int level = 0;
	while( true ) {
		if( e == null )
			break;
		System.out.println( "EXCEPTION CHECKING!!! class="+e.getClass().getName()+" level="+(++level) );
		if( e instanceof java.rmi.RemoteException ) {
			e = (Exception)(((java.rmi.RemoteException)e).detail);
		} else {
			break;
		}
	}
	return (e instanceof DocumentProcessingException)? (DocumentProcessingException)e: null;
}
}

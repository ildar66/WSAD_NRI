package com.hps.july.util;

import javax.ejb.*;
import org.apache.struts.action.*;

/**
 * Класс для обработки ошибок.
 * Creation date: (21.01.2002 15:49:34)
 * @author: Administrator
 */
public class ErrorProcessor {
/**
 * ErrorProcessor constructor.
 */
public ErrorProcessor() {
	super();
}
/**
 * Проверка исключения "Запись не найдена".
 * Creation date: (22.02.2002 18:54:06)
 * @return boolean
 * @param ex java.lang.Exception
 */
public static boolean isRecordNotExistException(Exception ex) throws Exception {
	try {
		if (ex instanceof javax.ejb.ObjectNotFoundException)
			return true;
		else
		if (ex instanceof java.rmi.ServerException)
		  if ( ((java.rmi.ServerException)ex).detail != null)
		    if (  ((java.rmi.ServerException)ex).detail instanceof com.ibm.ejs.persistence.EJSPersistenceException)
		      if ( ((com.ibm.ejs.persistence.EJSPersistenceException)((java.rmi.ServerException)ex).detail).detail != null)
		        if ( (  ((com.ibm.ejs.persistence.EJSPersistenceException)((java.rmi.ServerException)ex).detail).detail instanceof java.sql.SQLException ) && 
		          (  ((java.sql.SQLException)((com.ibm.ejs.persistence.EJSPersistenceException)((java.rmi.ServerException)ex).detail).detail).getErrorCode() == -391 ) )
		          return true;
	} catch (Exception a) {
		throw ex;
	}
	throw ex;
}
/**
 * Замена кода ошибки на человеческое сообщение.
 * Creation date: (21.01.2002 15:51:15)
 * @param e java.lang.Exception
 */
public static void processException(ActionErrors errors, Exception ex) {
	try {
		throw ex;
	    } catch( com.hps.july.web.util.UpdateValidationException e ) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(e.getMessage()));
	    } catch( javax.ejb.DuplicateKeyException e ) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.duplicate"));
	    } catch( FinderException e ) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.absent"));
	    } catch( RemoveException e ) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.referenced"));
	    } catch( java.rmi.ServerException e ) {
		    java.rmi.ServerException ee = e;
		    while (ee.detail instanceof java.rmi.ServerException)
		    	ee = (java.rmi.ServerException)ee.detail;
		    if( ee.detail instanceof com.ibm.ejs.persistence.EJSPersistenceException ) {
			    if( ((com.ibm.ejs.persistence.EJSPersistenceException)(ee.detail)).detail 
				    instanceof java.sql.SQLException ) {
				    int code = ((java.sql.SQLException)(((com.ibm.ejs.persistence.EJSPersistenceException)
					    	(ee.detail)).detail)).getErrorCode();
				    switch( code ) {
					    case -268:
					        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.duplicate"));
					        break;
					    case -692:
					        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.referenced"));
					        break;
					    default:
					        System.out.println("Unknown SQL code = " + code);
					        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
					        break;
				    	}
				    }
		    } else if( ee.detail instanceof com.ibm.websphere.cpi.CPIException ) {
			    if( ((com.ibm.websphere.cpi.CPIException)(ee.detail)).detail
				    instanceof java.sql.SQLException ) {
				    int code = ((java.sql.SQLException)(((com.ibm.websphere.cpi.CPIException)
					    	(ee.detail)).detail)).getErrorCode();
				    switch( code ) {
					    case -268:
					        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.duplicate"));
					        break;
					    case -692:
					        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.referenced"));
					        break;
					    default:
					        System.out.println("Unknown SQL code = " + code);
					        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
					        break;
				    }
				} else {
					System.out.println("Detail exception class: " + ((com.ibm.websphere.cpi.CPIException)(ee.detail)).detail.getClass());
				}
		    } else if (ee.detail instanceof java.rmi.NoSuchObjectException) {
	        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.absent"));
		    } else {
				System.out.println("Exception.detail class=" + ee.detail.getClass());
		       	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		    }
	    } catch( Exception e ) {
		    if( e instanceof javax.transaction.TransactionRolledbackException ) {
		       	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.referenced"));
		    } else {
		       	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		    }
	    }
	}
}

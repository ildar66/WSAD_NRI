package com.hps.july.inventory.sessionbean;

import java.math.*;
import java.util.*;
import com.hps.july.persistence.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Подсчет суммы поставок по контракту
 */
public class ContractSuppliesInfoBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 16:21:20)
 * @return java.math.BigDecimal
 * @param argContract java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public java.math.BigDecimal getSuppliesSum(Integer argContract) throws java.rmi.RemoteException {

	BigDecimal sum = new BigDecimal(0);
	
	try {
		DocumentsLinkAccessBeanTable sups = new DocumentsLinkAccessBeanTable();
		sups.setDocumentsLinkAccessBean(
			(new DocumentsLinkAccessBean()).findByTypeAndDocFrom( "I", argContract )
			);
		DocumentProcessorAccessBean processor = new DocumentProcessorAccessBean();
		for( int i = 0; i < sups.numberOfRows(); i++ ) {
			sum = sum.add(  processor.getDocumentSum( sups.getDocumentsLinkAccessBean(i).getDocumentTo_document() ) );
		}
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While getting contract supplies.", e );
	}
	
	return sum;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}

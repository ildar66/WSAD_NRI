package com.hps.july.inventory.sessionbean;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Обсчет документа с проведением доп. обработок - передача в Platinum, расчеты по Trailcom, ...
 */
public class RealDocumentProcessorBean extends DocumentProcessorBean {
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 11:08:04)
 * @return java.util.Enumeration 
 * @param docPosition java.lang.Integer 
 */
public DocumentProcessingException applyDocument(Integer argDoc ) 
	throws java.rmi.RemoteException  {
	try {
		
		DocumentProcessingException exception = super.applyDocument(argDoc);

		if (exception == null) {
			// Send document to platinum
			com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean platproc = new com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean();
			Integer query = platproc.processVirtualDocument(argDoc);
			platproc.processDocument(query, argDoc);
			
			// Send document to trailcom
			com.hps.july.trailcom.beans.TrailcomProcessorAccessBean trproc = new com.hps.july.trailcom.beans.TrailcomProcessorAccessBean();
			trproc.processDocument(argDoc);
		}

		return exception;
		
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While applying real document.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 11:08:04)
 * @return java.util.Enumeration
 * @param docPosition java.lang.Integer
 */
public DocumentProcessingException cancelDocument( Integer argDoc ) 
	throws java.rmi.RemoteException  {
	try { 

		// UnSend document to platinum
		com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean platproc = new com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean();
		platproc.cancelDocument(argDoc);
		
		// UnSend document to trailcom
		com.hps.july.trailcom.beans.TrailcomProcessorAccessBean trproc = new com.hps.july.trailcom.beans.TrailcomProcessorAccessBean();
		trproc.cancelDocument(argDoc);
		
		DocumentProcessingException exception = super.cancelDocument(argDoc);
		return exception;
		
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While cancelling real document.", e );
	}
}
}

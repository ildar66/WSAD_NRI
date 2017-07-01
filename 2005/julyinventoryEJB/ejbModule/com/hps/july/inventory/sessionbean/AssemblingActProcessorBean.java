package com.hps.july.inventory.sessionbean;

import com.hps.july.persistence.*;
import java.math.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import java.util.Properties;
import javax.ejb.*;

/**
 * This is a Session Bean Class
 * Процессор актов монтажа / демонтажа
 */
public class AssemblingActProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 16:36:22)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException applyAssemblingAct(Integer actCode) throws java.rmi.RemoteException {
	try {
		// First of all - call document processor
		RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
		DocumentProcessingException ex = processor.applyDocument(actCode);
		//processor.getEJBRef().remove();
		if( ex != null )
			return ex;

		// Find requested assembling act
		AssemblingActAccessBean act = new AssemblingActAccessBean();
		act.setInitKey_document( actCode.intValue() );
		act.refreshCopyHelper();

		// Find main agregate part
		StorageCardAccessBean agr_part = act.getAgregat();
		StorageCardAccessBean agr = new StorageCardAccessBean();
		agr.setInitKey_storagecard(agr_part.getStoragecard());
		agr.refreshCopyHelper();

		// Change Configuration -> newConfiguration for main agregate part
		agr.setConfiguration(act.getNewConfiguration());
		agr.commitCopyHelper();
		return null;
	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While processing assembling act.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 18:17:00)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException cancelAssemblingAct( Integer argAct ) throws java.rmi.RemoteException {

	try {
		// Find requested assembling act
		AssemblingActAccessBean act = new AssemblingActAccessBean();
		act.setInitKey_document( argAct.intValue() );
		act.refreshCopyHelper();

		// Find main agregate part
		StorageCardAccessBean agr_part = act.getAgregat();
		StorageCardAccessBean agr = new StorageCardAccessBean();
		agr.setInitKey_storagecard(agr_part.getStoragecard());
		agr.refreshCopyHelper();

		// Change Configuration -> newConfiguration for main agregate part
		agr.setConfiguration(act.getOldConfiguration());
		agr.commitCopyHelper();
		
		// Call document processor 
		RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
		DocumentProcessingException ret = processor.cancelDocument(argAct);
		//processor.getEJBRef().remove();
		return ret;

	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While cancelling assembling act.", e );
	}

}
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
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}

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
 * Процессор актов замены
 */
public class ChangeActProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 16:36:22)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException applyChangeAct(Integer actCode) throws java.rmi.RemoteException {
	try {
		ChangeActAccessBean act = new ChangeActAccessBean();
		act.setInitKey_document( actCode.intValue() );
		act.refreshCopyHelper();

		//check act state 
		if( !act.getDocumentState().equals( "1" ) ) {
			return new DocumentProcessingException( 1, "Incompatible state" );			
		}
		ArrayList errors = new ArrayList();
		ArrayList pSet = new ArrayList();
		ArrayList sSet = new ArrayList();
		ProcessingPositionError error;

		//create payoff act header
		PayOffActAccessBean payOff = new PayOffActAccessBean( 
			(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
			new Integer(act.getOwnerKey().organization ), new Integer( act.getFromKey().storageplace ), 
			new Integer( act.getToKey().storageplace ), act.getBlankdate(), 
			act.getBlankindex(), act.getBlanknumber(), "1", Boolean.TRUE, Boolean.FALSE );
		if (act.getStorageManager() != null)
			payOff.setStorageManager((Worker)act.getStorageManager().getEJBRef());
		payOff.setShowtouser(false);
		payOff.commitCopyHelper();
		new DocumentsLinkAccessBean( "P", new Integer( act.getDocument() ), new Integer( payOff.getDocument() ) );		
		
		//create surplus act header
		SurplusActAccessBean surAct = new SurplusActAccessBean( 
			(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
			new Integer(act.getOwnerKey().organization ), new Integer( act.getFromKey().storageplace ), 
			new Integer( act.getToKey().storageplace ), act.getBlankdate(), 
			act.getBlankindex(), act.getBlanknumber(), "1", Boolean.FALSE, Boolean.TRUE );
		if (act.getStorageManager() != null)
			surAct.setStorageManager((Worker)act.getStorageManager().getEJBRef());
		surAct.setShowtouser(false);
		surAct.commitCopyHelper();
		new DocumentsLinkAccessBean( "S", new Integer( act.getDocument() ), new Integer( surAct.getDocument() ) );		

		//get positions
		ChangeActPositionAccessBeanTable pos = new ChangeActPositionAccessBeanTable();
		pos.setChangeActPositionAccessBean( 
			new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
				act.getChangeActPosition(),
				ChangeActPositionAccessBean.class
			));
		
		//create acts positions
		for( int i = 0; i < pos.numberOfRows(); i++ ) {
			ChangeActPositionAccessBean p = pos.getChangeActPositionAccessBean(i);
			StorageCardAccessBean card = null;
			try {
				card = (new StorageCardAccessBean()).findBySerial(p.getOldSerial());
				//MUST be the same storage
				if( card.getCurrentstorageKey().storageplace != act.getFromKey().storageplace ) {
					error = new ProcessingPositionError();
					error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
					error.setMessage( "No card in storage serial="+p.getOldSerial() );
					error.setPositionCode( p.getCode() );
					error.setResource(card.getResource().getResource());
					error.setSerial(p.getOldSerial());
					error.setStorage(card.getCurrentstorageKey().storageplace);
					errors.add( error );
					continue;
				}
				//MUST NOT participate in agregations
				if( card.getAgregate().hasMoreElements() || card.getAgregateContent().hasMoreElements() ) {
					error = new ProcessingPositionError();
					error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTSUPPORTED );
					error.setMessage( "Cant change card in agregate!" );
					error.setPositionCode( p.getCode() );
					errors.add( error );
					continue;
				}
				//payoff position
				int doccode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
				DocumentPositionAccessBean docPos = new DocumentPositionAccessBean( 
					doccode, 
					new Integer(card.getResourceKey().resource), new Integer(card.getOwnerKey().organization), 
					new Integer(payOff.getDocument()), 
					//i+1, card.getQty(), card.getPrice(), Boolean.FALSE, card.getBoxed(), Boolean.FALSE, // DD
					i+1, card.getQty(), card.getPrice(), card.getBoxed(), card.getBoxed(), card.getBroken(), 
					card.getBroken(), Boolean.FALSE, Boolean.TRUE );
				docPos.setSerialnumber( card.getSerialnumber() );
				docPos.setConfiguration( card.getConfiguration() );
				docPos.commitCopyHelper();
				
				// DD - we must save original document position ----
				StorageCellValueObject sdp = new StorageCellValueObject();
				sdp.setVirtposition(new Integer(doccode));
				sdp.setRealposition(new Integer(p.getCode()));
				pSet.add(sdp);
				// DD ----------------------------------------------
				
				//surplus position
				doccode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
				Integer rescode = null;
				if (("U".equals(act.getActtype())) && (p.getNewresource() != null))
					rescode = new Integer(p.getNewresource().getResource());
				else
					rescode = new Integer(card.getResourceKey().resource);
				
				docPos = new DocumentPositionAccessBean( 
					doccode, 
					rescode, new Integer(card.getOwnerKey().organization), 
					new Integer(surAct.getDocument()), 
					//i+1, card.getQty(), card.getPrice(), Boolean.FALSE, card.getBoxed(), Boolean.FALSE, // DD
					i+1, card.getQty(), card.getPrice(), card.getBoxed(), card.getBoxed(), card.getBroken(), 
					card.getBroken(), Boolean.TRUE, Boolean.FALSE );
				docPos.setSerialnumber( p.getNewSerial() );
				docPos.setConfiguration( card.getConfiguration() );
				docPos.setManufserial(p.getManufserial());
				docPos.commitCopyHelper();
				
				// DD - we must save original document position ----
				sdp = new StorageCellValueObject();
				sdp.setVirtposition(new Integer(doccode));
				sdp.setRealposition(new Integer(p.getCode()));
				sSet.add(sdp);
				// DD ----------------------------------------------
				
			}catch( javax.ejb.ObjectNotFoundException e ) {
				error = new ProcessingPositionError();
				// DD - we must report NO_CARD here
				error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
				//error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
				error.setMessage( "No card in storage serial="+p.getOldSerial() );
				error.setPositionCode( p.getCode() );
				error.setSerial(p.getOldSerial());
				errors.add( error );
				continue;
			}
		}

		//check errors
		if( errors.size() != 0 ) {
			DocumentProcessingException ex = new DocumentProcessingException();
			ex.setPositionErrors(errors);
			return ex;
		}
			
		//process documents
		DocumentProcessorAccessBean processor = new DocumentProcessorAccessBean();
		DocumentProcessingException ex;
		ex = processor.applyDocument( new Integer( payOff.getDocument() ) );
		if( ex != null ) {
			recodeToActPositions(ex, pSet);
			return ex;
		}
		ex = processor.applyDocument( new Integer( surAct.getDocument() ) );
		if( ex != null ) {
			recodeToActPositions(ex, sSet);
			return ex;
		}
		
		//change document state
		act.setDocumentState( "2" );
		act.commitCopyHelper();

		// Send document to trailcom
		com.hps.july.trailcom.beans.TrailcomProcessorAccessBean trproc = new com.hps.july.trailcom.beans.TrailcomProcessorAccessBean();
		trproc.processDocument(new Integer(payOff.getDocument()));
		trproc.processDocument(new Integer(surAct.getDocument()));
		
		return null;
	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While processing change act.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 18:17:00)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException cancelChangeAct( Integer argAct ) throws java.rmi.RemoteException {

	try {
		ChangeActAccessBean act = new ChangeActAccessBean();
		act.setInitKey_document( argAct.intValue() );
		act.refreshCopyHelper();

		//check act state
		if( !act.getDocumentState().equals( "2" ) ) {
			return new DocumentProcessingException( 1, "Incompatible state" );			
		}
		
		//cancel documents
		DocumentProcessorAccessBean processor = new DocumentProcessorAccessBean();
		DocumentsLinkAccessBean payOffLink = (DocumentsLinkAccessBean)(((new DocumentsLinkAccessBean()).
			findByTypeAndDocFrom( "P", new Integer( act.getDocument() ) )).nextElement());
		DocumentsLinkAccessBean surPlusLink = (DocumentsLinkAccessBean)(((new DocumentsLinkAccessBean()).
			findByTypeAndDocFrom( "S", new Integer( act.getDocument() ) )).nextElement());
		int payOffCode = payOffLink.getDocumentTo().getDocument();
		int surplusCode = surPlusLink.getDocumentTo().getDocument();
		PayOffActAccessBean payOff 		= new PayOffActAccessBean();
		payOff.setInitKey_document( payOffCode );
		payOff.refreshCopyHelper();
		SurplusActAccessBean surPlus 	= new SurplusActAccessBean();
		surPlus.setInitKey_document( surplusCode );
		surPlus.refreshCopyHelper();

		// Send document to trailcom
		com.hps.july.trailcom.beans.TrailcomProcessorAccessBean trproc = new com.hps.july.trailcom.beans.TrailcomProcessorAccessBean();
		trproc.cancelDocument(new Integer(surPlus.getDocument()));
		trproc.cancelDocument(new Integer(payOff.getDocument()));
		
		//cancelling documents
		DocumentProcessingException ex;
		ex = processor.cancelDocument( new Integer(surPlus.getDocument()) );
		if( ex != null )
			return ex;
		ex = processor.cancelDocument( new Integer(payOff.getDocument()) );
		if( ex != null )
			return ex;

		// UnSend act to Platinum
		com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean platproc = new com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean();
		platproc.cancelDocument(argAct);
		//platproc.cancelDocument(new Integer(payOffCode));
		//platproc.cancelDocument(new Integer(surplusCode));
				
		//delete doc links
		payOffLink.getEJBRef().remove();
		surPlusLink.getEJBRef().remove();
		
		//delete documentpositions		
		DocumentPositionAccessBeanTable positions = new DocumentPositionAccessBeanTable();
		positions.setDocumentPositionAccessBean( 
			(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( new Integer( payOff.getDocument() ) ) );
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			positions.getDocumentPositionAccessBean(i).setAgregate(null);
		}
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			positions.getDocumentPositionAccessBean(i).getEJBRef().remove();
		}
		positions.setDocumentPositionAccessBean( 
			(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( new Integer( surPlus.getDocument() ) ) );
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			positions.getDocumentPositionAccessBean(i).setAgregate(null);
		}		
		
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			positions.getDocumentPositionAccessBean(i).getEJBRef().remove();
		}		
		//delete documents
		payOff.getEJBRef().remove();
		surPlus.getEJBRef().remove();
		
		//change act state
		act.setDocumentState( "1" );
		act.commitCopyHelper();

		return null;
	}catch( Exception e ) {
		throw new java.rmi.RemoteException( "While cancelling document.", e );
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
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:19:49)
 * @param ex com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param aSet java.util.ArrayList
 */
protected void recodeToActPositions(DocumentProcessingException ex, ArrayList aSet) {
	ArrayList errs = ex.getPositionErrors();
	if (errs != null) {
		for( int i = 0; i < errs.size(); i++ ) {
			ProcessingPositionError err = (ProcessingPositionError)errs.get(i);
			// Find recode for position
			for( int j = 0; j < aSet.size(); j++ ) {
				StorageCellValueObject lstObj = (StorageCellValueObject)(aSet.get(j));
				if (lstObj.getVirtposition() != null)
					if (err.getPositionCode() == lstObj.getVirtposition().intValue()) {
						if (lstObj.getRealposition() != null)
							err.setPositionCode(lstObj.getRealposition().intValue());
						break;
					}
			}
		}
	}
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

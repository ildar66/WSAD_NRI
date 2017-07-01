package com.hps.july.inventory.sessionbean;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import java.util.*;
import com.hps.july.platinum.sessionbean.*;

/**
 * This is a Session Bean Class
 * Процессор документов "Сбойный рапорт"
 */
public class FaultReportProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 16:36:22)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException applyFaultReport(Integer docCode) throws java.rmi.RemoteException {
	try {
		FaultReportAccessBean frep = new FaultReportAccessBean();
		frep.setInitKey_document( docCode.intValue() );
		frep.refreshCopyHelper();


		System.out.println(">>>>> FAULT REPORT >>>>>>   #1");
		//check state 
		if( !frep.getDocumentState().equals( "1" ) ) {
			return new DocumentProcessingException( 1, "Incompatible state" );			
		}

		System.out.println(">>>>> FAULT REPORT >>>>>>   #2");
		if ("W".equals(frep.getEqplace()) || ( "S".equals(frep.getEqplace()) && 
			(frep.getOldagregate() == null) && (frep.getNewserial() == null) ) ) {
			// Worker owns fault equipment
			// Mark it as broken
			// Find storagecard
			System.out.println(">>>>> FAULT REPORT >>>>>>   #3");
			ProcessingPositionError error = checkCard(frep, frep.getOldserial());
			if (error != null) {
				System.out.println(">>>>> FAULT REPORT >>>>>>   #4");
				DocumentProcessingException result = new DocumentProcessingException();
				result.addError( error );
				return result;
			}
			StorageCardAccessBean card = new StorageCardAccessBean();
			try {
				System.out.println(">>>>> FAULT REPORT >>>>>>   #4");
				card = card.findBySerial(frep.getOldserial());
				card.setBroken(Boolean.TRUE);
				card.commitCopyHelper();
			} catch (javax.ejb.ObjectNotFoundException e) {
				System.out.println("FAULT-REPORT: Error after error check: "+ e.getMessage());
			}
			
			System.out.println(">>>>> FAULT REPORT >>>>>>   #5");
			CardTrackAccessBean ctrack = new CardTrackAccessBean((new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.cardtracks" ), 
				new Integer(card.getStoragecard()), new Integer(card.getLastDocument().getDocument()), 
				new java.sql.Timestamp((new java.util.Date()).getTime()), "C");
			if (frep.getFrom() != null)
				ctrack.setFrom((StoragePlace)frep.getFrom().getEJBRef());
			if (frep.getTo() != null)
				ctrack.setTo((StoragePlace)frep.getTo().getEJBRef());
			ctrack.setConfiguration(card.getConfiguration());
			ctrack.commitCopyHelper();

			System.out.println(">>>>> FAULT REPORT >>>>>>   #6");
			//return null;
		} else if ( "S".equals(frep.getEqplace()) || "P".equals(frep.getEqplace()) ) {

			System.out.println(">>>>> FAULT REPORT >>>>>>   #7");
			RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
			AssemblingActProcessorAccessBean assprocessor = new AssemblingActProcessorAccessBean();
			DocumentProcessingException ex = null;
			String configuration = "";
			String place = "";
			
			if (frep.getOldagregate() != null) {
				// Make disassembling act
				System.out.println(">>>>> FAULT REPORT >>>>>>   #8");
				Integer toPlace = null;
				if ("S".equals(frep.getEqplace())) {
					toPlace = new Integer(frep.getFromKey().storageplace);
				} else {
					ExpeditionAccessBean exped = getExpeditor(frep.getTechStuff().getWorker());
					toPlace = new Integer(exped.getStorageplace());
				}
				AssemblingActAccessBean dassact = new AssemblingActAccessBean( 
					(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
					new Integer(frep.getOwnerKey().organization ), new Integer( frep.getFromKey().storageplace ), 
					toPlace, frep.getBlankdate(), 
					frep.getBlankindex(), frep.getBlanknumber(), "1", Boolean.TRUE, Boolean.TRUE,
					new Integer(frep.getOldagregate().getStoragecard()), "D");
				if (frep.getStorageManager() != null)
					dassact.setStorageManager((Worker)frep.getStorageManager().getEJBRef());
				dassact.setShowtouser(false);
				dassact.commitCopyHelper();
				new DocumentsLinkAccessBean( "D", new Integer( frep.getDocument() ), new Integer( dassact.getDocument() ) );
				
				ProcessingPositionError error = checkCard(frep, frep.getOldserial());
				if (error != null) {
					System.out.println(">>>>> FAULT REPORT >>>>>>   #9");
					DocumentProcessingException result = new DocumentProcessingException();
					result.addError( error );
					return result;
				}
				System.out.println(">>>>> FAULT REPORT >>>>>>   #10");
				StorageCardAccessBean card = new StorageCardAccessBean();
				try {
					card = card.findBySerial(frep.getOldserial());
					configuration = card.getConfiguration();
					place = card.getPlace();
				} catch (javax.ejb.ObjectNotFoundException e) {
					System.out.println("FAULT-REPORT: Error after error check: "+ e.getMessage());
				}
				System.out.println(">>>>> FAULT REPORT >>>>>>   #11");
				final int doccode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
				DocumentPositionAccessBean docPos = new DocumentPositionAccessBean( 
					doccode, 
					new Integer(card.getResourceKey().resource), new Integer(card.getOwnerKey().organization), 
					new Integer(dassact.getDocument()), 
					1, card.getQty(), card.getPrice(), card.getBoxed(), card.getBoxed(), card.getBroken(), 
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE );
				docPos.setOldAgregateSerial(frep.getOldagregate().getSerialnumber());
				docPos.setSerialnumber( card.getSerialnumber() );
				docPos.setConfiguration( configuration );
				docPos.setOldplace(place);
				docPos.commitCopyHelper();
				
				System.out.println(">>>>> FAULT REPORT >>>>>>   #12");
				if (dassact != null)
					ex = assprocessor.applyAssemblingAct( new Integer( dassact.getDocument() ) );
				if( ex != null ) 
					return ex;
				System.out.println(">>>>> FAULT REPORT >>>>>>   #13");
				
			}

			// Position/Storage outcome
			System.out.println(">>>>> FAULT REPORT >>>>>>   #14");
			if (frep.getOldagregate() == null) {
				// Find/create expedition
				System.out.println(">>>>> FAULT REPORT >>>>>>   #15");
				
				ExpeditionAccessBean exped = getExpeditor(frep.getTechStuff().getWorker());
				
				InternalOutBillAccessBean intout = new InternalOutBillAccessBean( 
					(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
					new Integer(frep.getOwnerKey().organization ), new Integer( frep.getFromKey().storageplace ), 
					new Integer( exped.getStorageplace() ), frep.getBlankdate(), 
					frep.getBlankindex(), frep.getBlanknumber(), "1", Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
				if (frep.getStorageManager() != null)
					intout.setStorageManager((Worker)frep.getStorageManager().getEJBRef());
				intout.setShowtouser(false);
				intout.commitCopyHelper();
				new DocumentsLinkAccessBean( "D", new Integer( frep.getDocument() ), new Integer( intout.getDocument() ) );
				
				System.out.println(">>>>> FAULT REPORT >>>>>>   #18");
				ProcessingPositionError error = checkCard(frep, frep.getOldserial());
				if (error != null) {
					System.out.println(">>>>> FAULT REPORT >>>>>>   #19");
					DocumentProcessingException result = new DocumentProcessingException();
					result.addError( error );
					return result;
				}
				System.out.println(">>>>> FAULT REPORT >>>>>>   #20");
				StorageCardAccessBean card = new StorageCardAccessBean();
				try {
					card = card.findBySerial(frep.getOldserial());
					configuration = card.getConfiguration();
					place = card.getPlace();
				} catch (javax.ejb.ObjectNotFoundException e) {
					System.out.println("FAULT-REPORT: Error after error check: "+ e.getMessage());
				}
				System.out.println(">>>>> FAULT REPORT >>>>>>   #21");
				final int doccode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
				DocumentPositionAccessBean docPos = new DocumentPositionAccessBean( 
					doccode, 
					new Integer(card.getResourceKey().resource), new Integer(card.getOwnerKey().organization), 
					new Integer(intout.getDocument()), 
					1, card.getQty(), card.getPrice(), card.getBoxed(), card.getBoxed(), card.getBroken(), 
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE );
				docPos.setSerialnumber( card.getSerialnumber() );
				docPos.setConfiguration( configuration );
				docPos.setOldplace(place);
				docPos.commitCopyHelper();
				
				System.out.println(">>>>> FAULT REPORT >>>>>>   #22");
				if (intout != null)
					ex = processor.applyDocument( new Integer( intout.getDocument() ) );
				if( ex != null ) 
					return ex;
				
				System.out.println(">>>>> FAULT REPORT >>>>>>   #23");
			}

			if ( (frep.getOldagregate() != null) && (frep.getNewserial() != null) ) {
				// Make assembling act
				System.out.println(">>>>> FAULT REPORT >>>>>>   #24");
				Integer fromPlace = null;
				if ("S".equals(frep.getEqplace())) {
					fromPlace = new Integer(frep.getToKey().storageplace);
				} else {
					ExpeditionAccessBean exped = getExpeditor(frep.getTechStuff().getWorker());
					fromPlace = new Integer(exped.getStorageplace());
				}
				AssemblingActAccessBean assact = new AssemblingActAccessBean( 
					(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
					new Integer(frep.getOwnerKey().organization ), fromPlace, 
					new Integer( frep.getToKey().storageplace ), frep.getBlankdate(), 
					frep.getBlankindex(), frep.getBlanknumber(), "1", Boolean.TRUE, Boolean.TRUE,
					new Integer(frep.getOldagregate().getStoragecard()), "A");
				if (frep.getStorageManager() != null)
					assact.setStorageManager((Worker)frep.getStorageManager().getEJBRef());
				assact.setShowtouser(false);
				assact.commitCopyHelper();
				new DocumentsLinkAccessBean( "M", new Integer( frep.getDocument() ), new Integer( assact.getDocument() ) );
				System.out.println(">>>>> FAULT REPORT >>>>>>   #25");

				/*
				ProcessingPositionError error = checkCard(frep, frep.getNewserial());
				if (error != null) {
					System.out.println(">>>>> FAULT REPORT >>>>>>   #26");
					DocumentProcessingException result = new DocumentProcessingException();
					result.addError( error );
					return result;
				}
				*/
				System.out.println(">>>>> FAULT REPORT >>>>>>   #27");
				StorageCardAccessBean card = new StorageCardAccessBean();
				try {
					card = card.findBySerial(frep.getNewserial());
				} catch (javax.ejb.ObjectNotFoundException e) {
					System.out.println("FAULT-REPORT: Error after error check: "+ e.getMessage());
					// Invalid serial
					ProcessingPositionError error = new ProcessingPositionError();
					error.setPositionCode( 0 );
					error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
					error.setMessage( "No card for serial: " + frep.getNewserial() );
					error.setSerial(frep.getNewserial());
					DocumentProcessingException result = new DocumentProcessingException();
					result.addError( error );
					return result;
				}
				System.out.println(">>>>> FAULT REPORT >>>>>>   #28");
				final int doccode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
				DocumentPositionAccessBean docPos = new DocumentPositionAccessBean( 
					doccode, 
					new Integer(card.getResourceKey().resource), new Integer(card.getOwnerKey().organization), 
					new Integer(assact.getDocument()), 
					1, card.getQty(), card.getPrice(), card.getBoxed(), card.getBoxed(), card.getBroken(), 
					card.getBroken(), Boolean.FALSE, Boolean.FALSE );
				docPos.setAgregateSerial(frep.getOldagregate().getSerialnumber());
				docPos.setSerialnumber( card.getSerialnumber() );
				docPos.setConfiguration( configuration );
				docPos.setNewplace(place);
				docPos.commitCopyHelper();
				
				System.out.println(">>>>> FAULT REPORT >>>>>>   #29");
				if (assact != null)
					ex = assprocessor.applyAssemblingAct( new Integer( assact.getDocument() ) );
				if( ex != null ) 
					return ex;
				System.out.println(">>>>> FAULT REPORT >>>>>>   #30");
			}
			
			if ( (frep.getOldagregate() == null) && (frep.getNewserial() != null) ) {
				// Make assembling act
				// Find expedition
				System.out.println(">>>>> FAULT REPORT >>>>>>   #31");
				ExpeditionAccessBean exped = getExpeditor(frep.getTechStuff().getWorker());
				System.out.println(">>>>> FAULT REPORT >>>>>>   #34");
				InternalWayBillAccessBean intin = new InternalWayBillAccessBean( 
					(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
					new Integer(frep.getOwnerKey().organization ), new Integer( exped.getStorageplace() ), 
					new Integer( frep.getToKey().storageplace ), frep.getBlankdate(), 
					frep.getBlankindex(), frep.getBlanknumber(), "1", Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
				if (frep.getStorageManager() != null)
					intin.setStorageManager((Worker)frep.getStorageManager().getEJBRef());
				intin.setMonter((Worker)frep.getTechStuff().getEJBRef());
				intin.setShowtouser(false);
				intin.commitCopyHelper();
				new DocumentsLinkAccessBean( "M", new Integer( frep.getDocument() ), new Integer( intin.getDocument() ) );
				
				System.out.println(">>>>> FAULT REPORT >>>>>>   #35");
				/*
				ProcessingPositionError error = checkCard(frep, frep.getNewserial());
				if (error != null) {
					System.out.println(">>>>> FAULT REPORT >>>>>>   #36");
					DocumentProcessingException result = new DocumentProcessingException();
					result.addError( error );
					return result;
				}
				*/
				System.out.println(">>>>> FAULT REPORT >>>>>>   #37");
				StorageCardAccessBean card = new StorageCardAccessBean();
				try {
					card = card.findBySerial(frep.getNewserial());
				} catch (javax.ejb.ObjectNotFoundException e) {
					System.out.println("FAULT-REPORT: Error after error check: "+ e.getMessage());
				}
				final int doccode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
				InternalWayBillPositionAccessBean docPos = new InternalWayBillPositionAccessBean( 
					doccode, 
					new Integer(card.getResourceKey().resource), new Integer(card.getOwnerKey().organization), 
					new Integer(intin.getDocument()), 
					1, card.getQty(), card.getPrice(), card.getBoxed(), card.getBoxed(), card.getBroken(), 
					card.getBroken(), Boolean.FALSE, Boolean.FALSE );
				docPos.setSerialnumber( card.getSerialnumber() );
				docPos.setConfiguration( configuration );
				docPos.setNewplace(place);
				docPos.commitCopyHelper();
				
				System.out.println(">>>>> FAULT REPORT >>>>>>   #38");
				if (intin != null)
					ex = processor.applyDocument( new Integer( intin.getDocument() ) );
				if( ex != null ) 
					return ex;
				System.out.println(">>>>> FAULT REPORT >>>>>>   #39");
			}
		}
			
		System.out.println(">>>>> FAULT REPORT >>>>>>   #40");
		//change document state
		frep.setDocumentState( "2" );
		frep.commitCopyHelper();
		
		System.out.println(">>>>> FAULT REPORT >>>>>>   #41");
		return null;
		
	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While processing fault report.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 18:17:00)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException cancelFaultReport( Integer argDoc ) throws java.rmi.RemoteException {

	try {
		FaultReportAccessBean frep = new FaultReportAccessBean();
		frep.setInitKey_document( argDoc.intValue() );
		frep.refreshCopyHelper();

		//check act state
		if( !frep.getDocumentState().equals( "2" ) ) {
			return new DocumentProcessingException( 1, "Incompatible state" );			
		}
		
		if ("W".equals(frep.getEqplace()) || ( "S".equals(frep.getEqplace()) && 
			(frep.getOldagregate() == null) && (frep.getNewserial() == null) ) ) {
				
			ProcessingPositionError error = checkCard(frep, frep.getOldserial());
			if (error != null) {
				DocumentProcessingException result = new DocumentProcessingException();
				result.addError( error );
				return result;
			}

			// Find storage card
			StorageCardAccessBean card = new StorageCardAccessBean();
			try {
				card = card.findBySerial(frep.getOldserial());
			} catch (javax.ejb.ObjectNotFoundException e) {
				System.out.println("FAULT-REPORT: Error after error check: "+ e.getMessage());
			}
			
			// Find Card Track
			CardTrackAccessBean track = null;
			try {
				
				track = (new CardTrackAccessBean()).findBeforeDocument( new Integer( card.getStoragecard() ), 
				argDoc );
				card.setLastDocument( (Document)(track.getDocument().getEJBRef()) );
				card.setConfiguration( track.getConfiguration() );

				track.getEJBRef().remove();
					
			} catch( javax.ejb.ObjectNotFoundException e ) {
				card.setLastDocument( null );
			}
			
			card.setBroken(Boolean.FALSE);
			card.commitCopyHelper();
			
			//return null;
		} else  {
			//cancel documents
			DocumentsLinkAccessBean dassactLink = null;
			Enumeration en1 = new DocumentsLinkAccessBean().findByTypeAndDocFrom( "D", new Integer(frep.getDocument()) );
			if (en1.hasMoreElements())
				dassactLink = (DocumentsLinkAccessBean)en1.nextElement();

			if (dassactLink != null) {
				int dassactCode = dassactLink.getDocumentTo().getDocument();
				//delete doc links
				dassactLink.getEJBRef().remove();
				// delete document
				DocumentProcessingException result = deleteDocument(dassactCode);
				if (result != null)
					return result;
			}
			
			DocumentsLinkAccessBean assactLink = null;
			Enumeration en2 = new DocumentsLinkAccessBean().findByTypeAndDocFrom( "M", new Integer(frep.getDocument()) );
			if (en2.hasMoreElements())
				assactLink = (DocumentsLinkAccessBean)en2.nextElement();
			
			if (assactLink != null) {
				int assactCode = assactLink.getDocumentTo().getDocument();
				// Delete doc link
				assactLink.getEJBRef().remove();
				// Delete document
				DocumentProcessingException result = deleteDocument(assactCode);
				if (result != null)
					return result;
			}
		}
		
		//change act state
		frep.setDocumentState( "1" );
		frep.commitCopyHelper();

		return null;
	}catch( Exception e ) {
		throw new java.rmi.RemoteException( "While cancelling fault report.", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 12:37:39)
 * @return com.hps.july.inventory.sessionbean.ProcessingPositionError
 * @param frep com.hps.july.persistence.FaultReportAccessBean
 * @param oldSerial java.lang.String
 */
private ProcessingPositionError checkCard(FaultReportAccessBean document, String oldSerial) {
	// Find storagecard
	ProcessingPositionError error = new ProcessingPositionError();
	StorageCardAccessBean card = new StorageCardAccessBean();
	try {
		card = card.findBySerial(oldSerial);

		// Check FAULT report type
		int stType = determineStorageType(document.getFrom());

		if ( 
			( (stType == STORAGETYPES.STORAGE) && (!"S".equals(document.getEqplace())) ) ||
			( (stType == STORAGETYPES.POSITION) && (!"P".equals(document.getEqplace())) ) ||
			( (stType == STORAGETYPES.EXPEDITOR) && (!"W".equals(document.getEqplace())) ) 
			) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
			error.setMessage( "Trying to move card from other storage serial="+oldSerial );
			error.setStorage( document.getFromKey().storageplace );
			error.setSerial( oldSerial );
			return error;
		}
		
		//must be in the same storage
		if( card.getCurrentstorageKey().storageplace != document.getFromKey().storageplace ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
			error.setMessage( "Trying to move card from other storage serial="+oldSerial );
			error.setStorage( card.getCurrentstorageKey().storageplace );
			error.setSerial( oldSerial );
			return error;
		}

		/*
		//  Removed by Gennady directive 23/06/03
		//must be the same property
		if( card.getOwnerKey().organization != document.getOwnerKey().organization ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_DOC_OWNER );
			error.setMessage( "Tring moove alias owner card serial="+oldSerial );
			error.setOwner( card.getOwner().getOrganization() );
			return error;
		}
		*/
		
		//must not be documents later them this one
		if( card.getLastDocument().getBlankdate().after( document.getBlankdate() ) ) {
			System.out.println(">>>> CheckCard: card.lastDocument=" + card.getLastDocumentKey().document +
				",lastdocdate=" + card.getLastDocument().getBlankdate() +
				", document=" + document.getDocument() +
				",docdate=" + document.getBlankdate()
				);
			error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
			error.setMessage( "Position hidden with serial="+oldSerial );
			error.setLastDocumentCode( card.getLastDocument().getDocument() );
			return error;										
		}
		
		//must not be boxed
		if( card.getBoxed().booleanValue() ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.CARD_IS_BOXED );
			error.setMessage( "Can't move boxed card." );
			return error;										
		}
	
	} catch (Exception e) {
		// Invalid serial
		error.setPositionCode( 0 );
		error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
		error.setMessage( "No card for oldserial: " + oldSerial );
		error.setSerial(oldSerial);
		return error;
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 17:42:39)
 * @param argDoccode int
 */
private DocumentProcessingException deleteDocument(int argDoccode) throws Exception {
	//cancelling documents
	DocumentProcessingException ex;

	RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
	ex = processor.cancelDocument( new Integer(argDoccode) );
	if( ex != null )
		return ex;
	
	//delete documentpositions
	int i = 0;
	Enumeration positions = (new DocumentPositionAccessBean()).findByDocOrderByAgregateDesc(new Integer(argDoccode));
	while (positions.hasMoreElements()) {
		i++;
		System.out.println("Deleting position #" + i);
		((DocumentPositionAccessBean)(positions.nextElement())).getEJBRef().remove();
	}

	i = 0;
	positions = (new DocumentPositionAccessBean()).findByDocOrderByAgregateDesc(new Integer(argDoccode));
	while (positions.hasMoreElements()) {
		System.out.println("Found position #" + i);
		positions.nextElement();
	}
	
	//delete documents
	try {
		DocumentAccessBean doc = new DocumentAccessBean();
		doc.setInitKey_document(argDoccode);
		doc.refreshCopyHelper();
		doc.getEJBRef().remove();
	} catch (Exception e) {
		// Error
		System.out.println("FAULT-REPORT: document not found: " + e.getMessage());
	}
	
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 10:21:18)
 * @return int
 * @param argStoragePlace com.hps.july.persistence.StoragePlaceAccessBean
 */
private int determineStorageType(StoragePlaceAccessBean argStoragePlace) {

	int storageType = STORAGETYPES.EMPTY;
	int storagecode = 0;
	
	if (argStoragePlace != null) {
		try {
			storagecode = argStoragePlace.getStorageplace();
			if (argStoragePlace.getEJBRef() instanceof Storage)
				storageType = STORAGETYPES.STORAGE;
			else if (argStoragePlace.getEJBRef() instanceof EquipmentSet)
				storageType = STORAGETYPES.POSITION;
			else if (argStoragePlace.getEJBRef() instanceof Expedition)
				storageType = STORAGETYPES.EXPEDITOR;
		} catch (Exception e) {
			System.out.println("FAULT-REPORT: cannot determine storage type");
			e.printStackTrace(System.out);
		}
	}
	
	//logIt("Determine storage type, storageplace=" + storagecode + ", type=" + storageType);
	return storageType;
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
 * Insert the method's description here.
 * Creation date: (17.04.2003 10:16:56)
 * @return com.hps.july.persistence.ExpeditionAccessBean
 * @param argWorker int
 */
private ExpeditionAccessBean getExpeditor(int argWorker) throws Exception {
	ExpeditionAccessBean exped = new ExpeditionAccessBean();
	Enumeration en = exped.findExpeditionByExpeditor(new WorkerKey(argWorker));
	if (en.hasMoreElements()) {
		exped = (ExpeditionAccessBean)en.nextElement();
		System.out.println(">>>>> FAULT REPORT >>>>>>   Exped found, code=" + exped.getStorageplace());
	} else {
		System.out.println(">>>>> FAULT REPORT >>>>>>   Creating expeditor");
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		exped = new ExpeditionAccessBean(
			keyGen.getNextKey("tables.storageplaces"), null, "", ""
		);
		WorkerAccessBean w = new WorkerAccessBean();
		w.setInitKey_worker(argWorker);
		w.refreshCopyHelper();
		exped.setOrganization(null);
		exped.setExpeditor((Worker)w.getEJBRef());
		exped.setName(w.getMan().getLastname());
		exped.commitCopyHelper();
	}
	return exped;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2003 16:42:54)
 */
void newMethod() {
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:19:49)
 * @param ex com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param aSet java.util.ArrayList
 */
protected void recodeToFaultPositions(DocumentProcessingException ex, ArrayList aSet) {
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

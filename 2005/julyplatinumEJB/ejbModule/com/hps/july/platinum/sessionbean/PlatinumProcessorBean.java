package com.hps.july.platinum.sessionbean;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.platinum.sessionbean.*;
import com.hps.july.commonbean.*;

/**
 * This is a Session Bean Class
 * Передача данных по учету оборудования в Platinum
 */
public class PlatinumProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

	private final static java.lang.String LOGGENSEQ = "tables.pie_query_log";
	private final static java.lang.String PIELINKSEQ = "tables.pie_linkprihrash";
	private final static java.lang.String DOCGENSEQ = "tables.pie_docsnri";
	private final static java.lang.String ISPIEENABLED = "SyncNriPlatinumSklad";
	private final static java.lang.String DOCPOSGENSEQ = "tables.pie_docposnri";
	private final static java.lang.String QRYGENSEQ = "tables.pie_query";
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 10:31:09)
 * @param argDocument java.lang.Integer
 */
public void cancelDocument(Integer argDocument)  throws java.rmi.RemoteException {

	PIEQueryAccessBean query = null;	
	DocumentAccessBean document = null;;
	StoragePlaceAccessBean fromStorage = null;
	StoragePlaceAccessBean toStorage = null;
	StoragePlaceAccessBean expeditor = null;
	int docType = DOCTYPES.NO_PROCESSING;
	int fromStorageType = STORAGETYPES.EMPTY;
	int toStorageType = STORAGETYPES.EMPTY;
	int locIdQuery = 0;
	
	try {
		
		logIt("Cancel to platinum called, document=" + argDocument);
		
		// 1. Check if processing enabled
		if (!isProcessingEnabled())
			return;
		
		// 2. Determine document
		try {
			document = new DocumentAccessBean();
			document.setInitKey_document(argDocument.intValue());
			document.refreshCopyHelper();
		} catch (javax.ejb.ObjectNotFoundException e) {
			// Document not found - nothing to do - just report error
			System.out.println("PLATINUM-SYNC: document not found code = " + argDocument.toString());
			throw e;
		}

		// 3. Determine document type
		docType = determineDocType(document);
		
		// 4. Determine FROM type & FROM
		fromStorage = document.getFrom();
		fromStorageType = determineStorageType(fromStorage);

		// 5. Determine TO type & TO
		toStorage = document.getTo();
		toStorageType = determineStorageType(toStorage);
		
		// 6. Determine request type
		String reqType = determineRequestType(document);

		// 7. Create request header
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		locIdQuery = keygen.getNextKey(QRYGENSEQ);
		try {
			String lreqType = REQUESTTYPES.O_VPRIX1;
			if (reqType != REQUESTTYPES.UNKNOWN)
				lreqType = reqType;
			query = new PIEQueryAccessBean(locIdQuery, lreqType, OPERATIONTYPES.DELETE,
				STATUSTYPES.PREPARE, EXTSTATUSTYPES.WAIT, new java.sql.Timestamp(new java.util.Date().getTime()));
			query.setTypeobjnri(NRIOBJECTTYPES.DOCUMENT);
			query.setIdobjnriint(new Integer(document.getDocument()));
			query.commitCopyHelper();
		} catch (Exception e) {
			// Cannot create query - fatal ....
			System.out.println("PLATINUM-SYNC: cannot create query");
			throw e;
		}
		logIt("Creating request header with id=" + locIdQuery);

		// 8. Check if we need to send document to Platinum
		if ( (docType == DOCTYPES.NO_PROCESSING) || (reqType == REQUESTTYPES.UNKNOWN) ) {
			// We do not need to send document to platinum
			logIt("Document does not requires to be transferred to platinum");
			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.NO_PROCESSING_REQ, "No processing required", new java.sql.Timestamp(new java.util.Date().getTime()));
			log.setInt1(new Integer(document.getDocument()));
			log.commitCopyHelper();
			query.setStatus(STATUSTYPES.PREPAREERR);
			query.commitCopyHelper();
			return;
		}

		// 9. Deleting LinkPrihRash
		deleteLinkPrihRash(argDocument);

		// 10. Mark query ready to be processed by Platinum
		logIt("Marking delete request as OK!!!!");
		query.setStatus(STATUSTYPES.PREPAREOK);
		query.commitCopyHelper();
		
	} catch( Exception e ) {
		System.out.println( "PLATINUM-SYNC: Unknown error while sending document to platinum" );
		e.printStackTrace();
		//throw new java.rmi.RemoteException( "PLATINUM-SYNC: Unknown error while sending document to platinum", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 11:09:37)
 * @param argDocument java.lang.Integer
 */
private void deleteLinkPrihRash(Integer argDocument) throws Exception {
		logIt("Deleting linkprihrash");
		DocumentPositionAccessBean adocp = new DocumentPositionAccessBean();
		Enumeration dposes = adocp.findDocPositionsByDocOrderByOrderAsc(argDocument);
		while (dposes.hasMoreElements()) {
			DocumentPositionAccessBean docpos = (DocumentPositionAccessBean)dposes.nextElement();
			try {
				PIEDocInfoDocPosAccessBean dopinfo = new PIEDocInfoDocPosAccessBean();
				dopinfo.setInitKey_docposition(docpos.getDocposition());
				dopinfo.refreshCopyHelper();
				dopinfo.getEJBRef().remove();
			} catch (Exception e) {
				System.out.println("PLATINUM-SYNC: dopinfo docposition not found - cannot remove");
				e.printStackTrace(System.out);
			}
			PIELinkPrihRashAccessBean pielink = new PIELinkPrihRashAccessBean();
			Enumeration pielinkps = pielink.findByDocposPrihod(new Integer(docpos.getDocposition()));
			while (pielinkps.hasMoreElements()) {
				PIELinkPrihRashAccessBean tpielink = (PIELinkPrihRashAccessBean)pielinkps.nextElement();
				try {
					tpielink.getEJBRef().remove();
				} catch (Exception e) {
					System.out.println("PLATINUM-SYNC: linkprihrash docposition not found - cannot remove");
					e.printStackTrace(System.out);
				}
			}
			pielinkps = pielink.findByDocposRashod(new Integer(docpos.getDocposition()));
			while (pielinkps.hasMoreElements()) {
				PIELinkPrihRashAccessBean tpielink = (PIELinkPrihRashAccessBean)pielinkps.nextElement();
				try {
					tpielink.getEJBRef().remove();
				} catch (Exception e) {
					System.out.println("PLATINUM-SYNC: linkprihrash docposition not found - cannot remove");
					e.printStackTrace(System.out);
				}
			}
		}
	}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2003 13:02:17)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
private CurrencyAccessBean determineBaseCurrency() {
	// Determine base currency
	CurrencyAccessBean crab = null;
	try {
		NamedValueAccessBean cab = new NamedValueAccessBean();
		cab.setInitKey_id("BASE_CURRENCY");
		cab.refreshCopyHelper();

		crab = new CurrencyAccessBean();
		crab.setInitKey_currency(cab.getIntvalue());
		crab.refreshCopyHelper();
	} catch (Exception ex) {
		crab = null;
		System.out.println("PLATINUM-SYNC: BASE_CURRENCY constant not found or illegal");
	}
	return crab;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 10:21:18)
 * @return int
 * @param argStoragePlace com.hps.july.persistence.StoragePlaceAccessBean
 */
private int determineDocType(DocumentAccessBean argDocument) {

	int docType = DOCTYPES.NO_PROCESSING;
	
	if (argDocument != null) {
		try {
			if (argDocument.getEJBRef() instanceof I13nAct)
				docType = DOCTYPES.I13NACT;
			else if (argDocument.getEJBRef() instanceof ChangeAct)
				docType = DOCTYPES.CHANGEACT;
			else if (argDocument.getEJBRef() instanceof InwayBill)
				docType = DOCTYPES.EXT_IN;
			else if (argDocument.getEJBRef() instanceof OutWayBill)
				docType = DOCTYPES.EXT_OUT;
			else if (argDocument.getEJBRef() instanceof InternalWayBill)
				docType = DOCTYPES.INT_IN;
			else if (argDocument.getEJBRef() instanceof PayOffAct)
				docType = DOCTYPES.PAYOFF;
			else if (argDocument.getEJBRef() instanceof SurplusAct)
				docType = DOCTYPES.SURPLUS;
			else if (argDocument.getEJBRef() instanceof AssemblingAct) {
				AssemblingActAccessBean aact = new AssemblingActAccessBean(argDocument.getEJBRef());
				if ("A".equals(aact.getOperationType()))
					docType = DOCTYPES.BLOK_IN;
			}
		} catch (Exception e) {
			System.out.println("PLATINUM-SYNC: cannot determine document type");
			e.printStackTrace(System.out);
		}
	}
	
	logIt("Determine document type, type=" + docType);
	return docType;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2003 12:48:10)
 * @return com.hps.july.persistence.InwayBillAccessBean
 * @param argDocument int
 */
private InwayBillAccessBean determineInwayBill(DocumentAccessBean argDocument) {
	InwayBillAccessBean inbl = null;
	int docType = determineDocType(argDocument);
	if (docType == DOCTYPES.EXT_IN) {
		try {
			inbl = new InwayBillAccessBean();
			inbl.setInitKey_document(argDocument.getDocument());
			inbl.refreshCopyHelper();
		} catch (Exception ee) {
			System.out.println("PLATINUM-SYNC: InWayBill not found - strange");
			ee.printStackTrace(System.out);
			inbl = null;
		}
	}
	return inbl;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2003 12:20:50)
 * @return boolean
 * @param argDocType int
 */
private boolean determineOuterSync(DocumentAccessBean argDocument) {

	boolean result = false;
	int docType = determineDocType(argDocument);
	if (docType == DOCTYPES.EXT_IN) {
		try {
			logIt("Getting constant 'SyncSkladOuter'");
			NamedValueAccessBean ab = new NamedValueAccessBean();
			ab.setInitKey_id("SyncSkladOuter");
			ab.refreshCopyHelper();
			if (ab.getIntvalue() == 1) {
				result = true;
				logIt("Constand found, intvalue=1, syncing outer-docpositions");
			} else {
				logIt("Constand found, intvalue<>1, syncing docpositions");
			}
		} catch (Exception ex) {
			// Suppress
			logIt("Constant 'SyncSkladOuter' not found - syncing docpositions");
		}
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2003 13:14:40)
 * @return java.lang.String
 * @param argDocument com.hps.july.persistence.DocumentAccessBean
 */
private String determineRequestType(DocumentAccessBean argDocument) {
	
	String reqType = REQUESTTYPES.UNKNOWN;

	try {
		int docType = determineDocType(argDocument);
		int fromStorageType = determineStorageType(argDocument.getFrom());
		int toStorageType = determineStorageType(argDocument.getTo());
		if ( (docType == DOCTYPES.I13NACT) && (1==1) )
			reqType = REQUESTTYPES.O_INVEN1;
		else if ( (docType == DOCTYPES.CHANGEACT) && (fromStorageType == STORAGETYPES.EXPEDITOR) )
			reqType = REQUESTTYPES.O_ZAMEN1;
		else if ( (docType == DOCTYPES.CHANGEACT) && ( 
			(fromStorageType == STORAGETYPES.POSITION) || (fromStorageType == STORAGETYPES.STORAGE) ) )
			reqType = REQUESTTYPES.O_ZAMEN2;
		else if ( (docType == DOCTYPES.EXT_IN) && (toStorageType == STORAGETYPES.STORAGE) )
			reqType = REQUESTTYPES.O_VPRIX1;
		else if ( (docType == DOCTYPES.EXT_OUT) && (fromStorageType == STORAGETYPES.STORAGE) )
			reqType = REQUESTTYPES.O_VRASX1;
		else if ( (docType == DOCTYPES.INT_IN) && (fromStorageType == STORAGETYPES.EXPEDITOR) )
			reqType = REQUESTTYPES.O_VPRIX2;
		else if ( (docType == DOCTYPES.PAYOFF) && (fromStorageType == STORAGETYPES.STORAGE) )
			reqType = REQUESTTYPES.O_SPIS1;
		else if ( (docType == DOCTYPES.EXT_IN) && (toStorageType == STORAGETYPES.STORAGE) )
			reqType = REQUESTTYPES.O_VPRIX1;
		else if ( (docType == DOCTYPES.EXT_OUT) && (fromStorageType == STORAGETYPES.STORAGE) )
			reqType = REQUESTTYPES.O_VRASX1;
		else if ( ( (docType == DOCTYPES.INT_IN) || (docType == DOCTYPES.BLOK_IN) )&& (fromStorageType == STORAGETYPES.EXPEDITOR) )
			reqType = REQUESTTYPES.O_VPRIX2;
	} catch (Exception e) {
		System.out.println("PLATINUM-SYNC: Cannot determine PIE request type");
		e.printStackTrace(System.out);
	}
		
	logIt("Determine PIE query type, type=" + reqType);
	return reqType;
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
			System.out.println("PLATINUM-SYNC: cannot determine storage type");
			e.printStackTrace(System.out);
		}
	}
	
	logIt("Determine storage type, storageplace=" + storagecode + ", type=" + storageType);
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
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 11:05:43)
 * @return boolean
 */
private boolean isArendaProcessingEnabled() throws RemoteException {

    try {
         return Util_Alex.receiveIntConstant(com.hps.july.platinum.sessionbean.arenda.SystemConstants.SYNCNRIPLATINARENDA) == 1;
    } catch (Exception e) {
     return false;   
	    //throw new RemoteException("SYNCNRIPLATINARENDA not received", e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 11:05:43)
 * @return boolean
 */
public boolean isProcessingEnabled() {
	logIt("Check if processing enabled");
	try {
		NamedValueAccessBean nv = new NamedValueAccessBean();
		nv.setInitKey_id(ISPIEENABLED);
		nv.refreshCopyHelper();
		if (nv.getIntvalue() != 1) {
			logIt("Constant " + ISPIEENABLED + ".intvalue <> 1 - transmition to platinum disabled" );
			return false;
		}
	} catch (Exception e) {
		logIt("Constant " + ISPIEENABLED + " not found - transmition to platinum disabled" );
		return false;
	}
	logIt("Transmit to platinum enabled - continue processing");
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 10:03:34)
 * @param msg java.lang.String
 */
private void logIt(String msg) {
	System.out.println("PLATINUM-SYNC-LOG: " + msg);
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 10:31:09)
 * @param argDocument java.lang.Integer
 */
public void processDocument(Integer argQueryId, Integer argDocument)  throws java.rmi.RemoteException {

	PIEQueryAccessBean query = null;
	DocumentAccessBean document = null;;
	StoragePlaceAccessBean fromStorage = null;
	StoragePlaceAccessBean toStorage = null;
	StoragePlaceAccessBean expeditor = null;
	int docType = DOCTYPES.NO_PROCESSING;
	short piedocType = PIEDOCTYPES.UNKNOWN;
	int fromStorageType = STORAGETYPES.EMPTY;
	int toStorageType = STORAGETYPES.EMPTY;
	int locIdQuery = 0;
	
	try {
		
		logIt("Transmit to platinum called, document=" + argDocument);
		
		// 1. Check if processing enabled
		if (!isProcessingEnabled())
			return;

		// 2. Determine document
		try {
			document = new DocumentAccessBean();
			document.setInitKey_document(argDocument.intValue());
			document.refreshCopyHelper();
		} catch (javax.ejb.ObjectNotFoundException e) {
			// Document not found - nothing to do - just report error
			System.out.println("PLATINUM-SYNC: document not found code = " + argDocument.toString());
			throw e;
		}

		// 3. Determine document type
		docType = determineDocType(document);

		// 4. Determine FROM type & FROM
		fromStorage = document.getFrom();
		fromStorageType = determineStorageType(fromStorage);

		// 5. Determine TO type & TO
		toStorage = document.getTo();
		toStorageType = determineStorageType(toStorage);
		
		// 6. Determine request type
		String reqType = REQUESTTYPES.UNKNOWN;

		if (argQueryId != null) {
			// Find query
			locIdQuery = argQueryId.intValue();
			query = new PIEQueryAccessBean();
			query.setInitKey_idquery(locIdQuery);
			try {
				query.refreshCopyHelper();
				reqType = query.getTypequery();
			} catch (javax.ejb.ObjectNotFoundException eex) {
				System.out.println("PLATINUM-SYNC: Query not found by primary key - very strange error");
				query = null;
			}
		} else {
			System.out.println("PLATINUM-SYNC: Error NO QUERY");
			return;
		}
			
		logIt("Determine PIE query type, type=" + reqType);


		// 8. Check if we need to send document to Platinum
		if ( (docType == DOCTYPES.NO_PROCESSING) || (reqType.equals(REQUESTTYPES.UNKNOWN)) ) {
			// We do not need to send document to platinum
			logIt("Document does not requires to be transferred to platinum");
			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.NO_PROCESSING_REQ, "No processing required", new java.sql.Timestamp(new java.util.Date().getTime()));
			log.setInt1(new Integer(document.getDocument()));
			log.commitCopyHelper();
			query.setStatus(STATUSTYPES.PREPAREERR);
			query.commitCopyHelper();
			return;
		}

		// 9. Check if we need to determine source storage
		boolean isDetermineFrom;
		if (  ( ( (docType == DOCTYPES.INT_IN) || (docType == DOCTYPES.BLOK_IN) ) && (fromStorageType == STORAGETYPES.EXPEDITOR) ) ||
			  ( (docType == DOCTYPES.PAYOFF) && (fromStorageType == STORAGETYPES.EXPEDITOR) ) ||
			  ( (docType == DOCTYPES.SURPLUS) && (toStorageType == STORAGETYPES.EXPEDITOR) ) )
			{
			// We need to determine "real" FROM storage for document
			logIt("Real storage check - we need to determine 'real' storage for document positions");
			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.DETERMINE_STORAGE_REQ, "We need to determine storage, from=expeditor", new java.sql.Timestamp(new java.util.Date().getTime()));
			isDetermineFrom = true;
			if (docType == DOCTYPES.SURPLUS)
				expeditor = toStorage;
			else
				expeditor = fromStorage;
		} else {
			logIt("Real storage check - we do not need to determine 'real' storage for document positions");
			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.NO_DETERMINE_STORAGE_REQ, "We do not need to determine storage", new java.sql.Timestamp(new java.util.Date().getTime()));
			isDetermineFrom = false;
		}

		// 9. Determine from if we need it
		if (isDetermineFrom) {
			logIt("Start of determinefrom - calling setFromOnExpeditor");
			if (!setFromOnExpeditor(document, expeditor))
				System.out.println("PLATINUM-SYNC: determine from storage failed!");
		}
		
		// 10. Check if we need to sync outerdocpositions
		boolean SyncSkladOuter = determineOuterSync(document);


		// Get InWayBill
		InwayBillAccessBean inbl = determineInwayBill(document);

		// Check if we have 'contract' for permanent (P) documents
		Integer idContract = null;
		if (docType == DOCTYPES.EXT_IN) {
			if ("P".equals(inbl.getSupplyCondition())) {
				// Get Contract
				DocumentsLinkAccessBean tdl = new DocumentsLinkAccessBean();
				Enumeration tdls = tdl.findByTypeAndDocTo("I", argDocument);
				if (tdls.hasMoreElements()) {
					DocumentsLinkAccessBean dl = (DocumentsLinkAccessBean)tdls.nextElement();
					if (dl.getDocumentfrom() != null)
						idContract = new Integer(dl.getDocumentfrom().getDocument());
				}

				// Check if contract found
				if (idContract == null) {
					// We do not need to send document to platinum
					logIt("No contract found for inwaybill - abort procedure");
					KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
					PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
						locIdQuery, "E", ERRORTYPES.NO_CONTRACT, "No contract found for inwaybill", new java.sql.Timestamp(new java.util.Date().getTime()));
					query.setStatus(STATUSTYPES.PREPAREERR);
					query.commitCopyHelper();
					return;
				}
			}
		}
			
		// 11. Make Temp Array of docpositions & determine number of pairs (owner, storage) & # of owners
		logIt("10. Make Temp Array of docpositions & determine number of pairs (owner, storage) & # of owners");
		ArrayList tempDocPositions = new ArrayList();
		HashMap ownerStorages = new HashMap();
		HashMap owners = new HashMap();
		boolean isFromStorage = true;

		if ( (docType == DOCTYPES.EXT_IN) && SyncSkladOuter ) {
			// Sync by outerdocpositions
			OuterDocPositionAccessBean oudpab = new OuterDocPositionAccessBean();
			Enumeration toudpabs = oudpab.findByInWayBillOrderByOrderAsc(argDocument);
			while (toudpabs.hasMoreElements()) {
				oudpab = (OuterDocPositionAccessBean) toudpabs.nextElement();

				// For each outer docposition - find real docpositions
				java.math.BigDecimal rcount = new java.math.BigDecimal(0).setScale(3);
				java.math.BigDecimal ocount = oudpab.getOuterQty();
				InWayBillPositionAccessBean adocp = new InWayBillPositionAccessBean();
				Enumeration dposes = adocp.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(oudpab.getOuterDocPosition()));
				boolean hasRealPositions = false;
				while ( (ocount.compareTo(rcount) >= 0) && dposes.hasMoreElements() ) {
					hasRealPositions = true;
					adocp = (InWayBillPositionAccessBean)dposes.nextElement();
					DocPositionObject tdp = new DocPositionObject();
					try {
						if ("S".equals(oudpab.getResource().getCountpolicy())) {
							// Find docposition
							DocumentPositionAccessBean rdocpos = new DocumentPositionAccessBean();
							rdocpos.setInitKey_docposition(adocp.getDocposition());
							rdocpos.refreshCopyHelper();
							tdp.setAllAttributes(1, rdocpos);
							tdp.setPrice(oudpab.getOuterPrice());
						} else if ("P".equals(oudpab.getResource().getCountpolicy())) {
							DocumentPositionAccessBean rdocpos = new DocumentPositionAccessBean();
							rdocpos.setInitKey_docposition(adocp.getDocposition());
							rdocpos.refreshCopyHelper();
							tdp.setCountpolicy(oudpab.getResource().getCountpolicy());
							tdp.setResource(oudpab.getResource());
							tdp.setPrice(oudpab.getOuterPrice());
							tdp.setQty(oudpab.getOuterQty());
							tdp.setOwner(document.getOwner());
							tdp.setFrom(document.getFrom());
							tdp.setTo(document.getTo());
							//tdp.setParty(inbl.getCordocnum() + oudpab.getOuterDocPosition());
							//tdp.setPartyplatinum(inbl.getCordocnum() + oudpab.getOuterDocPosition());
							tdp.setParty(rdocpos.getParty());
							tdp.setPartyplatinum(rdocpos.getParty());
						} else {
							tdp.setCountpolicy(oudpab.getResource().getCountpolicy());
							tdp.setResource(oudpab.getResource());
							tdp.setPrice(oudpab.getOuterPrice());
							tdp.setQty(oudpab.getOuterQty());
							tdp.setOwner(document.getOwner());
							tdp.setFrom(document.getFrom());
							tdp.setTo(document.getTo());
						}
						OwnerStorageObject oos = new OwnerStorageObject(tdp.getOwner(), tdp.getFrom());
						if (!ownerStorages.containsKey(oos))
							ownerStorages.put(oos, "");
						OwnerStorageObject oo = new OwnerStorageObject(tdp.getOwner(), null);
						if (!owners.containsKey(oo))
							owners.put(oo, "");
						tempDocPositions.add(tdp);
						rcount = rcount.add(tdp.getQty());
					} catch (javax.ejb.ObjectNotFoundException eex) {
						// Strange
						System.out.println("PLATINUM-SYNC: Docposition not found by outerdocposition, code=" + adocp.getDocposition());
						break;
					}
				}

				// Create extra outerdocpositions
				if ("S".equals(oudpab.getResource().getCountpolicy())) {
					int extraqty = ocount.subtract(rcount).intValue();
					for (int i=0; i<extraqty; i++) {
						DocPositionObject tdp = new DocPositionObject();
						tdp.setResource(oudpab.getResource());
						tdp.setCountpolicy(oudpab.getResource().getCountpolicy());
						tdp.setPrice(oudpab.getOuterPrice());
						tdp.setQty(new java.math.BigDecimal(1).setScale(2));
						tdp.setOwner(document.getOwner());
						tdp.setFrom(document.getFrom());
						tdp.setTo(document.getTo());
						tdp.setSerialnumber(inbl.getCordocnum() + oudpab.getOuterDocPosition() + "" + i);
						OwnerStorageObject oos = new OwnerStorageObject(tdp.getOwner(), tdp.getFrom());
						if (!ownerStorages.containsKey(oos))
							ownerStorages.put(oos, "");
						OwnerStorageObject oo = new OwnerStorageObject(tdp.getOwner(), null);
						if (!owners.containsKey(oo))
							owners.put(oo, "");
						tempDocPositions.add(tdp);
					}
				} else if ("P".equals(oudpab.getResource().getCountpolicy())) {
					if (!hasRealPositions) {
						java.math.BigDecimal extraqty = ocount.subtract(rcount);
						DocPositionObject tdp = new DocPositionObject();
						tdp.setResource(oudpab.getResource());
						tdp.setPrice(oudpab.getOuterPrice());
						tdp.setQty(extraqty);
						tdp.setOwner(document.getOwner());
						tdp.setFrom(document.getFrom());
						tdp.setTo(document.getTo());
						tdp.setPartyplatinum(inbl.getCordocnum() + oudpab.getOuterDocPosition());
						OwnerStorageObject oos = new OwnerStorageObject(tdp.getOwner(), tdp.getFrom());
						if (!ownerStorages.containsKey(oos))
							ownerStorages.put(oos, "");
						OwnerStorageObject oo = new OwnerStorageObject(tdp.getOwner(), null);
						if (!owners.containsKey(oo))
							owners.put(oo, "");
						tempDocPositions.add(tdp);
					}
				} else {
					if (!hasRealPositions) {
						java.math.BigDecimal extraqty = ocount.subtract(rcount);
						DocPositionObject tdp = new DocPositionObject();
						tdp.setResource(oudpab.getResource());
						tdp.setPrice(oudpab.getOuterPrice());
						tdp.setQty(extraqty);
						tdp.setOwner(document.getOwner());
						tdp.setFrom(document.getFrom());
						tdp.setTo(document.getTo());
						OwnerStorageObject oos = new OwnerStorageObject(tdp.getOwner(), tdp.getFrom());
						if (!ownerStorages.containsKey(oos))
							ownerStorages.put(oos, "");
						OwnerStorageObject oo = new OwnerStorageObject(tdp.getOwner(), null);
						if (!owners.containsKey(oo))
							owners.put(oo, "");
						tempDocPositions.add(tdp);
					}
				}
			}
			
		} else {
			// Sync by Real docpositions
			
			DocumentPositionAccessBean adocp = new DocumentPositionAccessBean();
			Enumeration dposes = adocp.findDocPositionsByDocOrderByOrderAsc(argDocument);
			int posnum = 1;
			while (dposes.hasMoreElements()) {

				DocumentPositionAccessBean docpos = (DocumentPositionAccessBean)dposes.nextElement();
				// Reinstantiate docposition
				DocumentPositionAccessBean rdocpos = new DocumentPositionAccessBean();
				try {
					logIt("getting position " + (posnum++));
					rdocpos.setInitKey_docposition(docpos.getDocposition());
					rdocpos.refreshCopyHelper();
				} catch (Exception e) {
					System.out.println("PLATINUM-SYNC: cannot read docposition");
					e.printStackTrace(System.out);
				}
				

				logIt("Processing docposition=" + rdocpos.getDocposition());	
				if (isDetermineFrom) {

					logIt("We must determine from - find in PIE_linkprihrash");
					// We need to determine from - it can produce additional records

					PIELinkPrihRashAccessBean plpr = new PIELinkPrihRashAccessBean();
					Enumeration plprs = plpr.findByDocposRashod(new Integer(rdocpos.getDocposition()));
					java.math.BigDecimal rqty = rdocpos.getQty();

					while (plprs.hasMoreElements()) {

						plpr = (PIELinkPrihRashAccessBean)plprs.nextElement();
						
						logIt("Found PIE_linkprihrash record with qty=" + plpr.getQty() + "  fromstorageprihod=" + plpr.getFromstorageprihod());

						DocPositionObject tdp = new DocPositionObject();
						tdp.setAllAttributes(0, rdocpos);
						StoragePlaceAccessBean realfrom = new StoragePlaceAccessBean();
						realfrom.setInitKey_storageplace(plpr.getFromstorageprihod());
						realfrom.refreshCopyHelper();
						tdp.setFrom(realfrom);
						tdp.setQty(plpr.getQty());

						// Reduce QTY
						rqty = rqty.subtract(plpr.getQty());
						logIt("Reducing qty, remainder=" + rqty);
						
						OwnerStorageObject oos = new OwnerStorageObject(tdp.getOwner(), tdp.getFrom());
						if (!ownerStorages.containsKey(oos))
							ownerStorages.put(oos, "");

						OwnerStorageObject oo = new OwnerStorageObject(tdp.getOwner(), null);
						if (!owners.containsKey(oo))
							owners.put(oo, "");
							
						tempDocPositions.add(tdp);
					}
					
					// Check if "real" FROM storage has been determined
					if (rqty.compareTo(new java.math.BigDecimal(0).setScale(3)) != 0) {
						logIt("Remainder qty=" + rqty + " but no more records in pie_linkprihrash - cannot determine from storage");
						// No from storage - report it and exit
						KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
						PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
							locIdQuery, "E", ERRORTYPES.CANT_DETERMINE_STORAGE, "Cannot determine 'real' from storage", new java.sql.Timestamp(new java.util.Date().getTime()));
						log.setInt1(new Integer(rdocpos.getDocposition()));
						log.commitCopyHelper();
						isFromStorage = false;
					}
					
				} else {

					// We need not determine from - one record
					
					logIt("Take 'from' from document");


					DocPositionObject tdp = new DocPositionObject();
					tdp.setAllAttributes(1, rdocpos);
					
						
					OwnerStorageObject oos = new OwnerStorageObject(tdp.getOwner(), tdp.getFrom());
					if (!ownerStorages.containsKey(oos))
						ownerStorages.put(oos, "");

					OwnerStorageObject oo = new OwnerStorageObject(tdp.getOwner(), null);
					if (!owners.containsKey(oo))
						owners.put(oo, "");
						
					tempDocPositions.add(tdp);
				}
			}
		}

		if (!isFromStorage) {
			logIt("Errors detected, marking query as bad, exiting");
			query.setStatus(STATUSTYPES.PREPAREERR);
			query.commitCopyHelper();
			deleteLinkPrihRash(argDocument);
			return;
		}
		
		// 10. Check number of owners for external documents
		if (docType == DOCTYPES.EXT_IN || docType == DOCTYPES.EXT_OUT)
			if (owners.size() > 1) {
				logIt("Check number of owners for external document = " + owners.size()+ " - incorrect > 1");
				KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
				PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
					locIdQuery, "E", ERRORTYPES.TOO_MANY_OWNERS, "To many owners for external document", new java.sql.Timestamp(new java.util.Date().getTime()));
				query.setStatus(STATUSTYPES.PREPAREERR);
				query.commitCopyHelper();
				return;
			}


		// Determine base currency
		CurrencyAccessBean crab = determineBaseCurrency();
		
		// 11. Create separate Platinum document for each owner, fromstorage
		Iterator it = ownerStorages.keySet().iterator();
		logIt("Number of pairs (owner, storage) = " + ownerStorages.size() + " - creating documents");
		int docnum = 1;
		while (it.hasNext()) {

			OwnerStorageObject oo = (OwnerStorageObject)it.next();
			
			logIt("Creating document #" + docnum);
			
			docnum = docnum + 1;
			String serialPrefix = "";
			
			// Determine PIE document type
			piedocType = PIEDOCTYPES.UNKNOWN;
			if (docType == DOCTYPES.INT_IN)
				piedocType = PIEDOCTYPES.INT_IN;
			if (docType == DOCTYPES.BLOK_IN)
				piedocType = PIEDOCTYPES.INT_IN;
			if (docType == DOCTYPES.EXT_IN)
				piedocType = PIEDOCTYPES.EXT_IN;
			if (docType == DOCTYPES.EXT_OUT)
				piedocType = PIEDOCTYPES.EXT_OUT;

			// Expeditor ChangeAct
			if  ( (docType == DOCTYPES.PAYOFF) && (fromStorageType == STORAGETYPES.EXPEDITOR) ) 
				piedocType = PIEDOCTYPES.EXPPAYOFF;
			if  ( (docType == DOCTYPES.SURPLUS) && (toStorageType == STORAGETYPES.EXPEDITOR) ) 
				piedocType = PIEDOCTYPES.EXPSURPLUS;

			// Storage/Position ChangeAct
			if  ( (docType == DOCTYPES.PAYOFF) &&  ( 
				     (fromStorageType == STORAGETYPES.STORAGE) || (fromStorageType == STORAGETYPES.POSITION) ) ) 
				piedocType = PIEDOCTYPES.CHNGPAYOFF;
			if  ( (docType == DOCTYPES.SURPLUS) && (
				     (fromStorageType == STORAGETYPES.STORAGE) || (fromStorageType == STORAGETYPES.POSITION) ) ) 
				piedocType = PIEDOCTYPES.CHNGSURPLUS;
				
			// Storage PayOff Act
			if (reqType.equals(REQUESTTYPES.O_SPIS1)) {
				if  ( (docType == DOCTYPES.PAYOFF) && (fromStorageType == STORAGETYPES.STORAGE) ) 
					piedocType = PIEDOCTYPES.STRGPAYOFF;
			}

			// Inventarization
			I13nActAccessBean i13nact = null;
			if (reqType.equals(REQUESTTYPES.O_INVEN1)) {
				if  ( (docType == DOCTYPES.SURPLUS) && (1 == 1) ) 
					piedocType = PIEDOCTYPES.STRGSURPLUS;

					// Get i13nact
					i13nact = new I13nActAccessBean();
					if (query.getIdobjnriint() != null)
						i13nact.setInitKey_document(query.getIdobjnriint().intValue());
					try {
						i13nact.refreshCopyHelper();
					} catch (javax.ejb.ObjectNotFoundException eex) {
						System.out.println("PLATINUM-SYNC: i13nact not found, code=" + query.getIdobjnriint());
						query.setStatus(STATUSTYPES.PREPAREERR);
						return;
					}

					// Check if i13nact type="A"
					if (!"A".equals(i13nact.getType())) {
						logIt("I13N Acttype <> 'A', skipping");
						query.setStatus(STATUSTYPES.PREPAREERR);
						return;
					}

					// Check if i13nact has agregate
					if (i13nact.getAgregate() == null) {
						logIt("I13N agregate=null, skipping");
						query.setStatus(STATUSTYPES.PREPAREERR);
						return;
					}
			}

			if (piedocType != PIEDOCTYPES.UNKNOWN) {
				KeyGeneratorAccessBean docgen = new KeyGeneratorAccessBean();
				int idrecDoc = docgen.getNextKey(DOCGENSEQ);
				PIEDocNriAccessBean pieDoc = new PIEDocNriAccessBean(idrecDoc, locIdQuery, 
					piedocType, oo.getOwner().getOrganization());
				pieDoc.setDatedoc(document.getBlankdate());
				if (document.getStorageManager() != null)
					pieDoc.setHeaduser(new Integer(document.getStorageManager().getWorker()));
					
				if (piedocType == PIEDOCTYPES.CHNGPAYOFF) {
					if (oo.getStorage() != null)
						pieDoc.setPlacefrom(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlacefrom(null);
					pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.CHNGSURPLUS) {
					pieDoc.setPlacefrom(null);
					if (oo.getStorage() != null)
						pieDoc.setPlaceto(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.EXPPAYOFF) {
					if (oo.getStorage() != null)
						pieDoc.setPlacefrom(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlacefrom(null);
					pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.STRGPAYOFF) {
					if (oo.getStorage() != null)
						pieDoc.setPlacefrom(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlacefrom(null);
					pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.STRGSURPLUS) {
					pieDoc.setPlacefrom(null);
					if (oo.getStorage() != null)
						pieDoc.setPlaceto(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.EXPSURPLUS) {
					pieDoc.setPlacefrom(null);
					if (oo.getStorage() != null)
						pieDoc.setPlaceto(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.EXT_OUT) {
					if (document.getFrom() != null)
						pieDoc.setPlacefrom(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlacefrom(null);
					pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.INT_IN) {
					if (oo.getStorage() != null)
						pieDoc.setPlacefrom(new Integer(oo.getStorage().getStorageplace()));
					else
						pieDoc.setPlacefrom(null);
					if (document.getTo() != null)
						pieDoc.setPlaceto(new Integer(document.getTo().getStorageplace()));
					else
						pieDoc.setPlaceto(null);
				}
				if (piedocType == PIEDOCTYPES.EXT_IN) {
					if (idContract != null) {
						pieDoc.setIddogovnri(idContract);
						pieDoc.setTypedogovnri("O");
					}


					if (inbl != null) {
						serialPrefix = inbl.getCordocnum();
						
						pieDoc.setGtdnumber(inbl.getGtdnumber());
						//pieDoc.setGtddate(inbl.getGtddate());
						pieDoc.setSoprnumber(inbl.getCordocnum());
						pieDoc.setTempinbill(inbl.getSupplyCondition());

						// We must take valute from document, or from constant
						if (SyncSkladOuter) {
							logIt("Taking currency from InWayBill");
							if (inbl.getCurrency() != null)
								pieDoc.setIdvaluta(new Integer(inbl.getCurrency().getCurrency()));
							
						} else {
							logIt("Taking currency from BASE_CURRENCY");
							if (crab != null)
								pieDoc.setIdvaluta(new Integer(crab.getCurrency()));
						}
					}

					if (document.getContragent() != null)
						pieDoc.setContragent(new Integer(document.getContragent().getOrganization()));
					pieDoc.setPlacefrom(null);
					if (document.getTo() != null)
						pieDoc.setPlaceto(new Integer(document.getTo().getStorageplace()));
					else
						pieDoc.setPlaceto(null);
				}
				pieDoc.commitCopyHelper();

				// Create document positions
				KeyGeneratorAccessBean docposgen = new KeyGeneratorAccessBean();
				java.math.BigDecimal docsum = new java.math.BigDecimal(0).setScale(2);
				Iterator dps = tempDocPositions.iterator();
				while (dps.hasNext()) {
					DocPositionObject tdp = (DocPositionObject)dps.next();
					OwnerStorageObject poo = new OwnerStorageObject(tdp.getOwner(), tdp.getFrom());
					if (poo.equals(oo)) {
						// Owner=Owner, Storage=Storage - Add position to document
						PIEDocPosNriAccessBean pieDocPos = new PIEDocPosNriAccessBean(docposgen.getNextKey(DOCPOSGENSEQ),
							idrecDoc, tdp.getResource().getResource(), tdp.getQty(), tdp.getCountpolicy());

						if ("S".equals(tdp.getResource().getCountpolicy())) {
							// For serial positions - set storagecard
							if (tdp.getCardFrom() != null)
								pieDocPos.setStoragecard(new Integer(tdp.getCardFrom().getStoragecard()));
							else if (tdp.getCardTo() != null)
								pieDocPos.setStoragecard(new Integer(tdp.getCardTo().getStoragecard()));
							
							// Check if we have serialnumber
							if ((tdp.getSerialnumber() == null) ||
								(tdp.getSerialnumber().length() == 0) )
								pieDocPos.setSerialnumplat(serialPrefix + tdp.getDocposition()); // Make temp serial
							else
								pieDocPos.setSerialnumplat(tdp.getSerialnumber());
							
						} else if ("P".equals(tdp.getResource().getCountpolicy())) {
							pieDocPos.setPartynum(tdp.getParty());
							pieDocPos.setPartynumplat(tdp.getPartyplatinum());
						}
						
						if ( (piedocType == PIEDOCTYPES.EXT_IN) ||
							 (piedocType == PIEDOCTYPES.STRGSURPLUS) ) {
							pieDocPos.setPrice(tdp.getPrice());
							docsum = docsum.add(pieDocPos.getPrice().multiply(pieDocPos.getQty())).setScale(2);
						}
						if ( ( (piedocType == PIEDOCTYPES.EXPSURPLUS) ||
							 (piedocType == PIEDOCTYPES.CHNGSURPLUS) ||
							 (piedocType == PIEDOCTYPES.STRGSURPLUS) ) && (!reqType.equals(REQUESTTYPES.O_INVEN1)) ) {
								 
							// We need to determine old storagecard
							// Get Main document
							logIt("Determine oldstoragecard");
							DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
							Enumeration tdls = dl.findByTypeAndDocTo("S", argDocument);
							logIt("step 1 - find linked document (change act), type=S, documentto=" + argDocument);
							if (tdls.hasMoreElements()) {
								logIt("step 1 - found");
								dl = (DocumentsLinkAccessBean)tdls.nextElement();
								// Find old serial number from change act position
								ChangeActPositionAccessBean chp = new ChangeActPositionAccessBean();
								Enumeration tchps = chp.findByDocNewSerial(dl.getDocumentfrom_document(), tdp.getSerialnumber());
								logIt("step 2 - find change act position with new serial=" + tdp.getSerialnumber());
								if (tchps.hasMoreElements()) {
									chp = (ChangeActPositionAccessBean)tchps.nextElement();
									String oldSerial = chp.getOldSerial();
									logIt("step 2 - found, oldserial = " + oldSerial);
									// Find payoff
									tdls = dl.findByTypeAndDocFrom("P", dl.getDocumentfrom_document());
									logIt("step 3 - find linked document (payoff act), type=P, documentfrom=" + dl.getDocumentfrom_document());
									if (tdls.hasMoreElements()) {
										dl = (DocumentsLinkAccessBean)tdls.nextElement();

										logIt("step 3 - found, document=" + dl.getDocumentTo_document());
										
										// Find Payoff docposition
										DocumentPositionAccessBean abdp = new DocumentPositionAccessBean();
										logIt("step 4 - find payoff position with oldserial");
										try {
											abdp = abdp.findByDocumentSerialnum(dl.getDocumentTo_document(), oldSerial);
											logIt("step 4 - found, cardfrom=" + abdp.getCardFrom());
											if (abdp.getCardFrom() != null)
												pieDocPos.setOldstoragecard(new Integer(abdp.getCardFrom().getStoragecard()));
										} catch (javax.ejb.ObjectNotFoundException eex) {
											// Not found !!!
											logIt("step 4 - not found");
										}
									}
								}
							}
							
						}
						pieDocPos.commitCopyHelper();
					}
				}

				if (piedocType == PIEDOCTYPES.EXT_IN) {
					// We must update document sum
					pieDoc.setSumdoc(docsum);
					pieDoc.commitCopyHelper();
				}
				
				if (piedocType == PIEDOCTYPES.STRGSURPLUS) {

					// Set fields for surplus act after inventarisation
					if (crab != null)
						pieDoc.setIdvaluta(new Integer(crab.getCurrency()));
					pieDoc.setSumdoc(docsum);
					pieDoc.commitCopyHelper();
					
					// Create document before
					int idrecDoc1 = docgen.getNextKey(DOCGENSEQ);
					PIEDocNriAccessBean docbefore = new PIEDocNriAccessBean(idrecDoc1, locIdQuery, 
						PIEDOCTYPES.PAYOFFBEFORE, oo.getOwner().getOrganization());
					docbefore.setDatedoc(document.getBlankdate());
					if (document.getStorageManager() != null)
						docbefore.setHeaduser(new Integer(document.getStorageManager().getWorker()));
					if (crab != null)
						docbefore.setIdvaluta(new Integer(crab.getCurrency()));
					docbefore.setSumdoc(i13nact.getAgregate().getPrice().add(docsum));
					if (i13nact.getFrom() != null)
						docbefore.setPlacefrom(new Integer(i13nact.getFrom().getStorageplace()));
					docbefore.commitCopyHelper();

					// Create docposition before
					PIEDocPosNriAccessBean pieDocPos1 = new PIEDocPosNriAccessBean(docposgen.getNextKey(DOCPOSGENSEQ),
						idrecDoc1, i13nact.getAgregate().getResource().getResource(), 
						new java.math.BigDecimal(1).setScale(3), i13nact.getAgregate().getPolicy());
					pieDocPos1.setPrice(i13nact.getAgregate().getPrice().add(docsum));
					pieDocPos1.setStoragecard(new Integer(i13nact.getAgregate().getStoragecard()));
					pieDocPos1.commitCopyHelper();

					// Create document after
					int idrecDoc2 = docgen.getNextKey(DOCGENSEQ);
					PIEDocNriAccessBean docafter = new PIEDocNriAccessBean(idrecDoc2, locIdQuery, 
						PIEDOCTYPES.PAYOFFAFTER, oo.getOwner().getOrganization());
					docafter.setDatedoc(document.getBlankdate());
					if (document.getStorageManager() != null)
						docafter.setHeaduser(new Integer(document.getStorageManager().getWorker()));
					if (crab != null)
						docafter.setIdvaluta(new Integer(crab.getCurrency()));
					docafter.setSumdoc(i13nact.getAgregate().getPrice());
					if (i13nact.getTo() != null)
						docafter.setPlaceto(new Integer(i13nact.getTo().getStorageplace()));
					docafter.commitCopyHelper();

					// Create docposition after
					PIEDocPosNriAccessBean pieDocPos2 = new PIEDocPosNriAccessBean(docposgen.getNextKey(DOCPOSGENSEQ),
						idrecDoc2, i13nact.getAgregate().getResource().getResource(), 
						new java.math.BigDecimal(1).setScale(3), i13nact.getAgregate().getPolicy());
					pieDocPos2.setPrice(i13nact.getAgregate().getPrice());
					pieDocPos2.setStoragecard(new Integer(i13nact.getAgregate().getStoragecard()));
					pieDocPos2.commitCopyHelper();
				}
			}
		}

		// 12. Mark query ready to be processed by Platinum
		logIt("Marking request as OK!!!!");
		query.setStatus(STATUSTYPES.PREPAREOK);
		query.commitCopyHelper();
		
	} catch( Exception e ) {
		System.out.println("PLATINUM-SYNC: Unknown error while sending document to platinum");
		e.printStackTrace();
		//throw new java.rmi.RemoteException( "PLATINUM-SYNC: Unknown error while sending document to platinum", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 17:58:42)
 * @param argDocument java.lang.Integer
 */
public Integer processVirtualDocument(Integer argDocument) 
			throws java.rmi.RemoteException {

		PIEQueryAccessBean query = null;	
		DocumentAccessBean document = null;;
		int docType = DOCTYPES.NO_PROCESSING;
		int locIdQuery = 0;
		Integer result = null;
		
		try {
			
			logIt("Virtual Transmit to platinum called, document=" + argDocument);
			
			// 1. Check if processing enabled
			if (!isProcessingEnabled())
				return null;
			
			// 2. Determine document
			try {
				document = new DocumentAccessBean();
				document.setInitKey_document(argDocument.intValue());
				document.refreshCopyHelper();
			} catch (javax.ejb.ObjectNotFoundException e) {
				// Document not found - nothing to do - just report error
				System.out.println("PLATINUM-SYNC: document not found code = " + argDocument.toString());
				throw e;
			}

			// 3. Determine document type
			docType = determineDocType(document);

			StoragePlaceAccessBean fromStorage = document.getFrom();
			int fromStorageType = determineStorageType(fromStorage);
			logIt("Determine from type, type=" + fromStorageType);

			// 5. Determine TO type & TO
			StoragePlaceAccessBean toStorage = document.getTo();
			int toStorageType = determineStorageType(toStorage);
			logIt("Determine to type, type=" + toStorageType);
				
			// 6. Determine request type
			String reqType = determineRequestType(document);
			
			// 7. Create request header
			KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
			locIdQuery = keygen.getNextKey(QRYGENSEQ);
			try {
				String lreqType = REQUESTTYPES.O_VPRIX1;
				if (reqType != REQUESTTYPES.UNKNOWN)
					lreqType = reqType;
				query = new PIEQueryAccessBean(locIdQuery, lreqType, OPERATIONTYPES.INSERT,
					STATUSTYPES.PREPARE, EXTSTATUSTYPES.WAIT, new java.sql.Timestamp(new java.util.Date().getTime()));
				query.setTypeobjnri(NRIOBJECTTYPES.DOCUMENT);
				query.setIdobjnriint(new Integer(document.getDocument()));
				query.commitCopyHelper();
				result = new Integer(locIdQuery);
			} catch (Exception e) {
				// Cannot create query - fatal ....
				System.out.println("PLATINUM-SYNC: cannot create query");
				throw e;
			}
			logIt("Creating request header with id=" + locIdQuery);
			
		} catch( Exception e ) {
			System.out.println("PLATINUM-SYNC: Unknown error while sending document to platinum");
			e.printStackTrace();
			//throw new java.rmi.RemoteException( "PLATINUM-SYNC: Unknown error while sending document to platinum", e );
		}
		return result;
	}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 10:59:06)
 * @return boolean
 */
public Integer requestPlatinumResources() throws java.rmi.RemoteException {
	Integer result = null;
	try {
		
		logIt("Get resources from platinum called");
		
		// 1. Check if processing enabled
		if (!isProcessingEnabled())
			return result;

		// 2. Create query
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		int locIdQuery = keygen.getNextKey(QRYGENSEQ);
		try {
			PIEQueryAccessBean query = new PIEQueryAccessBean(locIdQuery, REQUESTTYPES.IRES, OPERATIONTYPES.INF,
				STATUSTYPES.PREPARE, EXTSTATUSTYPES.WAIT, new java.sql.Timestamp(new java.util.Date().getTime()));
			
			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.RESOURCES_REQUEST, "Resources request", new java.sql.Timestamp(new java.util.Date().getTime()));

			query.setStatus(STATUSTYPES.PREPAREOK);
			query.commitCopyHelper();
			
		} catch (Exception e) {
			// Cannot create query - fatal ....
			System.out.println("PLATINUM-SYNC: cannot create query");
			throw e;
		}
		logIt("Creating request header with id=" + locIdQuery);
		result = new Integer(locIdQuery);
			
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "PLATINUM-SYNC: Unknown error while sending resources to platinum", e );
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 10:59:06)
 * @return boolean
 */
public Integer requestPlatinumStorageplaces() throws java.rmi.RemoteException {
	Integer result = null;
	try {
		
		logIt("Get storageplaces from platinum called");
		
		// 1. Check if processing enabled
		if (!isProcessingEnabled())
			return result;

		// 2. Create query
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		int locIdQuery = keygen.getNextKey(QRYGENSEQ);
		try {
			PIEQueryAccessBean query = new PIEQueryAccessBean(locIdQuery, REQUESTTYPES.IMXRAN, OPERATIONTYPES.INF,
				STATUSTYPES.PREPARE, EXTSTATUSTYPES.WAIT, new java.sql.Timestamp(new java.util.Date().getTime()));
			
			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.STORAGEPLACES_REQUEST, "Storageplaces request", new java.sql.Timestamp(new java.util.Date().getTime()));

			query.setStatus(STATUSTYPES.PREPAREOK);
			query.commitCopyHelper();
			
		} catch (Exception e) {
			// Cannot create query - fatal ....
			System.out.println("PLATINUM-SYNC: cannot create query");
			throw e;
		}
		logIt("Creating request header with id=" + locIdQuery);
		result = new Integer(locIdQuery);
			
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "PLATINUM-SYNC: Unknown error while sending resources to platinum", e );
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 10:59:06)
 * @return boolean
 */
public Integer requestPlatinumUsers() throws java.rmi.RemoteException {
	Integer result = null;
	try {
		
		logIt("Get users from platinum called");
		
		// 1. Check if processing enabled
		if (!isProcessingEnabled())
			return result;

		// 2. Create query
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		int locIdQuery = keygen.getNextKey(QRYGENSEQ);
		try {
			PIEQueryAccessBean query = new PIEQueryAccessBean(locIdQuery, REQUESTTYPES.IOTV, OPERATIONTYPES.INF,
				STATUSTYPES.PREPARE, EXTSTATUSTYPES.WAIT, new java.sql.Timestamp(new java.util.Date().getTime()));

			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.USERS_REQUEST, "Users request", new java.sql.Timestamp(new java.util.Date().getTime()));

			query.setStatus(STATUSTYPES.PREPAREOK);
			query.commitCopyHelper();
			
			} catch (Exception e) {
			// Cannot create query - fatal ....
			System.out.println("PLATINUM-SYNC: cannot create query");
			throw e;
		}
		logIt("Creating request header with id=" + locIdQuery);
		result = new Integer(locIdQuery);
			
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "PLATINUM-SYNC: Unknown error while sending resources to platinum", e );
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 10:59:06)
 * @return boolean
 */
public Integer requestPlatinumValutes(java.sql.Timestamp argStartDate) throws java.rmi.RemoteException {
	Integer result = null;
	try {
		
		logIt("Get valutes from platinum called, startdate = " + argStartDate);
		
		// 1. Check if processing enabled
		if (!isProcessingEnabled() && !isArendaProcessingEnabled())
			return result;

		// 2. Create query
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		int locIdQuery = keygen.getNextKey(QRYGENSEQ);
		try {
			PIEQueryAccessBean query = new PIEQueryAccessBean(locIdQuery, REQUESTTYPES.IVAL, OPERATIONTYPES.INF,
				STATUSTYPES.PREPARE, EXTSTATUSTYPES.WAIT, new java.sql.Timestamp(new java.util.Date().getTime()));
			query.setDatebeg(argStartDate);

			KeyGeneratorAccessBean loggen = new KeyGeneratorAccessBean();
			PIEQueryLogAccessBean log = new PIEQueryLogAccessBean(loggen.getNextKey(LOGGENSEQ),
				locIdQuery, "I", ERRORTYPES.VALUTES_REQUEST, "Valutes request", new java.sql.Timestamp(new java.util.Date().getTime()));

			log.setDate1(new java.sql.Date(argStartDate.getTime()));
			log.commitCopyHelper();
			
			query.setStatus(STATUSTYPES.PREPAREOK);
			query.commitCopyHelper();
		} catch (Exception e) {
			// Cannot create query - fatal ....
			System.out.println("PLATINUM-SYNC: cannot create query");
			throw e;
		}
		logIt("Creating request header with id=" + locIdQuery);
		result = new Integer(locIdQuery);
			
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "PLATINUM-SYNC: Unknown error while sending resources to platinum", e );
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:24:53)
 * @return boolean
 * @param document com.hps.july.persistence.DocumentAccessBean
 * @param expeditor com.hps.july.persistence.StoragePlaceAccessBean
 */
private boolean setFromOnExpeditor(DocumentAccessBean argDocument, StoragePlaceAccessBean argExpeditor) {

	try {
		logIt("In setFromOnExpeditor doc=" + argDocument.getDocument() + "  expeditor=" + argExpeditor.getStorageplace());
		logIt(" Determine unique combinations of resource, owner, serial, party");
		HashMap uniquePositions = new HashMap();
		
		DocumentPositionAccessBean adocp = new DocumentPositionAccessBean();
		Enumeration dposes = adocp.findDocPositionsByDocOrderByOrderAsc(new Integer(argDocument.getDocument()));
		while (dposes.hasMoreElements()) {
			DocumentPositionAccessBean docpos = (DocumentPositionAccessBean)dposes.nextElement();
			// Reinstantiate docposition
			DocumentPositionAccessBean rdocpos = new DocumentPositionAccessBean();
			rdocpos.setInitKey_docposition(docpos.getDocposition());
			rdocpos.refreshCopyHelper();

			StoragecardObject scard = new StoragecardObject(rdocpos);
			if (!uniquePositions.containsKey(scard))
				uniquePositions.put(scard, "");
			
		}

		// Calculate from for each unique combination
		Iterator it = uniquePositions.keySet().iterator();
		while (it.hasNext()) {
			StoragecardObject oo = (StoragecardObject)it.next();
			if (!setFromResourceOnExped(argDocument, oo.getResource(), oo.getOwner(), oo.getCountpolicy(), 
					oo.getSerialnumber(), oo.getParty(), argExpeditor))
				return false;
		}
		
		return true;
		
	} catch	(Exception e) {
		System.out.println("PLATINUM-SYNC: exception in setFromOnExpeditor");
		e.printStackTrace(System.out);
	}
	return false;
}
/**
 * This method determines 'real' FROM for document position.
 * Creation date: (25.12.2002 13:06:04)
 * @return java.lang.Integer
 */
private boolean setFromResourceOnExped(DocumentAccessBean argDocument, int argResource, 
		int argOwner, String argCountpolicy, 
		String argSerialNumber, String argParty, StoragePlaceAccessBean expeditor) {

	ArrayList inPositions;
	ArrayList outPositions;

	try {

		logIt("IN SET FROMRESOURCEONEXPED resource=" + argResource + "  owner="+argOwner +
			"  countpolicy=" + argCountpolicy + "  serial=" + argSerialNumber +
			"  party=" + argParty + "  expeditor=" + expeditor.getStorageplace());
		
		inPositions = new ArrayList();
		outPositions = new ArrayList();
		Boolean isSerial = Boolean.FALSE;
		Boolean isParty = Boolean.FALSE;
		String serial = argSerialNumber;
		String party = argParty;
		DocumentPositionAccessBean tdp;
		Enumeration tdps;
		
		if ("S".equals(argCountpolicy))
			isSerial = Boolean.TRUE;
		if ("P".equals(argCountpolicy))
			isParty = Boolean.TRUE;

		tdp = new DocumentPositionAccessBean();
		
		// 1. Determine income positions - expeditor change acts
		logIt("Determine income positions - expeditor change acts");
		tdps = tdp.findByQBE(new Integer(argResource),
			new Integer(argOwner),
			isSerial, serial,
			isParty, party,
			Boolean.TRUE, new Integer(expeditor.getStorageplace()),
			Boolean.FALSE, null,
			"S",
			Boolean.FALSE, null
			);

		while (tdps.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)tdps.nextElement();
			DocPositionObject dpo = new DocPositionObject();
			if (!dpo.setAllAttributes(1, dp)) return false;
			dpo.setLocfromstorage(null);
			logIt(" docposition=" + dpo.getDocposition() + "  fromstorage=null");
			
			// We need to determine from storage from outcome positions
			logIt("  We need to determine from storage from outcome positions");
			
			// Find change act
			logIt("  Find change act");
			DocumentsLinkAccessBean tdl = new DocumentsLinkAccessBean();
			Enumeration tdls = tdl.findByTypeAndDocTo("S", new Integer(dp.getDocument().getDocument()));
			if (tdls.hasMoreElements()) {
				DocumentsLinkAccessBean dl = (DocumentsLinkAccessBean)tdls.nextElement();

				logIt("  found change act, doc=" + dl.getDocumentfrom().getDocument());
				
				// Find old serial from change act position
				logIt("   Find old serial from change act position");
				ChangeActPositionAccessBean tcp = new ChangeActPositionAccessBean();
				Enumeration tcps = tcp.findByDocNewSerial(new Integer(dl.getDocumentfrom().getDocument()), dpo.getSerialnumber());
				if (tcps.hasMoreElements()) {
					ChangeActPositionAccessBean cp = (ChangeActPositionAccessBean)tcps.nextElement();
					logIt("   Found changeactposition = " + cp.getCode() + " oldserial=" + cp.getOldSerial());

					// Find corresponding outcome position
					logIt("    Find corresponding outcome position");
					DocumentsLinkAccessBean tdlo = new DocumentsLinkAccessBean();
					Enumeration tdlos = tdlo.findByTypeAndDocFrom("P", new Integer(cp.getChangeAct().getDocument()));
					if (tdlos.hasMoreElements()) {
						DocumentsLinkAccessBean dlo = (DocumentsLinkAccessBean)tdlos.nextElement();
						logIt("    Found outcome doc = " + dlo.getDocumentTo().getDocument());

						// Find document position
						DocumentPositionAccessBean tdpp = new DocumentPositionAccessBean();
						try {
							DocumentPositionAccessBean dpp = tdpp.findByDocumentSerialnum(new Integer(dlo.getDocumentTo().getDocument()),
								cp.getOldSerial());
							logIt("    found outcome position = " + dpp.getDocposition());

							// Finally - find PIE_linkprihodrashod
							logIt("     Finally - find PIE_linkprihodrashod");
							PIELinkPrihRashAccessBean tplpr = new PIELinkPrihRashAccessBean();
							Enumeration tplprs = tplpr.findByDocposRashod(new Integer(dpp.getDocposition()));
							if (tplprs.hasMoreElements()) {
								PIELinkPrihRashAccessBean plpr = (PIELinkPrihRashAccessBean)tplprs.nextElement();
								logIt("     found storageplacefrom = " + plpr.getFromstorageprihod());
								StoragePlaceAccessBean locstrg = new StoragePlaceAccessBean();
								locstrg.setInitKey_storageplace(plpr.getFromstorageprihod());
								try {
									locstrg.refreshCopyHelper();
									dpo.setLocfromstorage(locstrg);
									// Create link record
									logIt("Creating link record");
									KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
									PIELinkPrihRashAccessBean lprh = new PIELinkPrihRashAccessBean(keygen.getNextKey(PIELINKSEQ),
										dpp.getDocposition(), locstrg.getStorageplace(),
										dpo.getDocposition(), dpo.getQty());
								} catch (javax.ejb.ObjectNotFoundException e) {
									// Cannot instantiate storageplace - very strange
									System.out.println("PLATINUM-SYNC: Cannot instantiate storageplace - very strange, storageplace=" + plpr.getFromstorageprihod());
									e.printStackTrace(System.out);
								} catch (Exception e) {
									// Unknown exception
									System.out.println("PLATINUM-SYNC: Unknown exception while creating LinkPrihRash");
									e.printStackTrace(System.out);
								}
							}
						} catch (javax.ejb.ObjectNotFoundException ee) {
							logIt("    outcome position not found");
						}
					}
				}
			}
			// Reduce qty - linked records
			if (!dpo.reduceQty(true)) return false;
			
			inPositions.add(dpo);
		}

		// 2. Determine income positions -  Storage internal outcome, Position internal outcome
		logIt("Determine income positions - Storage internal outcome, Position internal outcome");
		tdps = tdp.findByQBE(new Integer(argResource),
			new Integer(argOwner),
			isSerial, serial,
			isParty, party,
			Boolean.TRUE, new Integer(expeditor.getStorageplace()),
			Boolean.FALSE, null,
			"N",
			Boolean.FALSE, null
			);

		while (tdps.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)tdps.nextElement();
			DocPositionObject dpo = new DocPositionObject();
			if (!dpo.setAllAttributes(2, dp)) return false;
			logIt(" docposition=" + dpo.getDocposition() + "  fromstorage=" + dpo.getLocfromstorage().getStorageplace());
			// Reduce qty - linked records
			if (!dpo.reduceQty(true)) return false;
			inPositions.add(dpo);
		}
		
		// 3. Determine income positions -  Position dismount act
		logIt("Determine income positions - Position dismount act");
		tdps = tdp.findByQBE(new Integer(argResource),
			new Integer(argOwner),
			isSerial, serial,
			isParty, party,
			Boolean.TRUE, new Integer(expeditor.getStorageplace()),
			Boolean.FALSE, null,
			"A",
			Boolean.FALSE, null
			);

		while (tdps.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)tdps.nextElement();
			DocPositionObject dpo = new DocPositionObject();
			if (!dpo.setAllAttributes(3, dp)) return false;
			logIt(" docposition=" + dpo.getDocposition() + "  fromstorage=" + dpo.getLocfromstorage().getStorageplace());
			// Reduce qty - linked records
			if (!dpo.reduceQty(true)) return false;
			inPositions.add(dpo);
		}

		// 1. Determine outcome positions - expeditor change acts
		logIt("Determine outcome positions - expeditor change acts");
		tdps = tdp.findByQBE(new Integer(argResource),
			new Integer(argOwner),
			isSerial, serial,
			isParty, party,
			Boolean.FALSE, null,
			Boolean.TRUE, new Integer(expeditor.getStorageplace()),
			"P",
			Boolean.FALSE, new Integer(argDocument.getDocument())
			);

		while (tdps.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)tdps.nextElement();
			DocPositionObject dpo = new DocPositionObject();
			if (!dpo.setAllAttributes(1, dp)) return false;
			logIt(" docposition=" + dpo.getDocposition() );
			// Reduce qty - linked records
			if (!dpo.reduceQty(false)) return false;
			outPositions.add(dpo);
		}
		
		// 2. Determine outcome positions - storage internal income, position internal income
		logIt("Determine outcome positions - storage internal income, position internal income");
		tdps = tdp.findByQBE(new Integer(argResource),
			new Integer(argOwner),
			isSerial, serial,
			isParty, party,
			Boolean.FALSE, null,
			Boolean.TRUE, new Integer(expeditor.getStorageplace()),
			"T",
			Boolean.TRUE, new Integer(argDocument.getDocument())
			);

		while (tdps.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)tdps.nextElement();
			DocPositionObject dpo = new DocPositionObject();
			if (!dpo.setAllAttributes(2, dp)) return false;
			logIt(" docposition=" + dpo.getDocposition() );
			// Reduce qty - linked records
			if (!dpo.reduceQty(false)) return false;
			outPositions.add(dpo);
		}
		
		// 3. Determine outcome positions - position block mount
		logIt("Determine outcome positions - position block mount");
		tdps = tdp.findByQBE(new Integer(argResource),
			new Integer(argOwner),
			isSerial, serial,
			isParty, party,
			Boolean.FALSE, null,
			Boolean.TRUE, new Integer(expeditor.getStorageplace()),
			"A",
			Boolean.TRUE, new Integer(argDocument.getDocument())
			);

		while (tdps.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)tdps.nextElement();
			DocPositionObject dpo = new DocPositionObject();
			if (!dpo.setAllAttributes(3, dp)) return false;
			logIt(" docposition=" + dpo.getDocposition() );
			// Reduce qty - linked records
			if (!dpo.reduceQty(false)) return false;
			outPositions.add(dpo);
		}

		// Now we are ready to link income-outcome
		logIt("Sorting income-outcome positions");
		Collections.sort(inPositions, new DocPositionComparator());
		Collections.sort(outPositions, new DocPositionComparator());

		logIt("Link income-outcome cycle");	
		Iterator outit = outPositions.iterator();
		while (outit.hasNext()) {

			DocPositionObject outdp = (DocPositionObject)outit.next();

			logIt("Outcome position: " + outdp.getDocposition() + " qty=" + outdp.getQty());

			// Check if we have unlinked qty
			if ( outdp.getQty().compareTo(new java.math.BigDecimal(0).setScale(2)) <= 0)  {
				logIt(" qty <= 0 - nothing to link, skipping");
				continue;
			}

			// Check qty for serial positions
			if ("S".equals(outdp.getCountpolicy())) {
				if ( outdp.getQty().compareTo(new java.math.BigDecimal(1).setScale(2)) != 0)  {
					logIt(" Serial position - check qty failed skipping, qty<>1, qty=" + outdp.getQty());
					continue;
				}
			}
			
			Iterator initr = inPositions.iterator();
			while (initr.hasNext()) {
				DocPositionObject indp = (DocPositionObject)initr.next();
				logIt("  Income position: " + indp.getDocposition() + " qty=" + indp.getQty());
				
				// Check if we have unlinked qty
				if ( indp.getQty().compareTo(new java.math.BigDecimal(0).setScale(2)) <= 0)  {
					logIt("   qty <= 0 - nothing to link, skipping");
					continue;
				}
				
				// Check qty for serial positions
				if ("S".equals(indp.getCountpolicy())) {
					if ( indp.getQty().compareTo(new java.math.BigDecimal(1).setScale(2)) != 0)  {
						logIt(" Serial position - check qty failed skipping, qty<>1, qty=" + indp.getQty());
						continue;
					}
				}

				java.math.BigDecimal minQty;
				if (outdp.getQty().compareTo(indp.getQty()) < 0)
					minQty = outdp.getQty();
				else
					minQty = indp.getQty();

				// Create link record
				logIt("Creating link record");
				if (indp.getLocfromstorage() != null) {
					KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
					PIELinkPrihRashAccessBean lprh = new PIELinkPrihRashAccessBean(keygen.getNextKey(PIELINKSEQ),
						indp.getDocposition(), indp.getLocfromstorage().getStorageplace(),
						outdp.getDocposition(), minQty);

					// Reduce qty in outcome, income positions
					outdp.setQty(outdp.getQty().subtract(minQty));
					indp.setQty(indp.getQty().subtract(minQty));
				} else {
					logIt("Cannot create link - fromstorageprihod is null");
					break;
				}

				// Check if outcome position satisfied
				if ( outdp.getQty().compareTo(new java.math.BigDecimal(0).setScale(2)) <= 0)  {
					logIt(" qty <= 0 - outcome position full connect");
					break;
				}
				
			}
			
			// Check if outcome position not satisfied
			if ( outdp.getQty().compareTo(new java.math.BigDecimal(0).setScale(2)) > 0)  {
				logIt(" outcome position not fully connected - bad - return false, remainder qty=" + outdp.getQty());
				return false;
			}
			
		}
		logIt("SUCCESSFUL EXIT from SETFROMRESOURCEONEXPED");
		return true;
		
	} catch	(Exception e) {
		System.out.println("PLATINUM-SYNC: exception in whereFromResourceOnExped");
		e.printStackTrace(System.out);
	}
	return false;
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

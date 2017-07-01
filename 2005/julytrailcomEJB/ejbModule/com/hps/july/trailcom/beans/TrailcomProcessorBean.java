package com.hps.july.trailcom.beans;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;

/**
 * This is a Session Bean Class
 * Алгоритмы передачи данных в Trailcom - генерация адресного пространства
 */
public class TrailcomProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public final static String INVENTORY_VARIANT = "INVENTORY_VARIANT";
	public final static String ACCOUNTING_VARIANT = "AccountingVariant ";
/**
 * Блокирование адресного пространства.
 * Creation date: (10.02.2003 18:03:56)
 * @param argStorageCard int
 */
public void blockAddressSpace(int argStorageCard)  
	throws java.rmi.RemoteException {

	logIt("Blocking address space for storagecard=" + argStorageCard);
	try {
		setAddressSpaceState(argStorageCard, EXISTSTATES.BLOCKED);
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "TRAILCOM: Unknown error while BlockAddressSpace", e );
	}
}
/**
 * Обработка при откате документа.
 * Creation date: (19.12.2002 10:31:09)
 * @param argDocument java.lang.Integer
 */
public void cancelDocument(Integer argDocument)  throws java.rmi.RemoteException {

	try {
		processDocumentAction(argDocument, OPERATIONTYPES.OPCANCEL);
		
	} catch( Exception e ) {
		System.out.println( "TRAILCOM: Unknown error while unsending document to trailcom" );
		e.printStackTrace(System.out);
	}
}
/**
 * Закрытие адресного пространства.
 * Creation date: (10.02.2003 18:03:56)
 * @param argStorageCard int
 */
public void closeAddressSpace(int argStorageCard)  
	throws java.rmi.RemoteException {

	logIt("Closing address space for storagecard=" + argStorageCard);
	try {
		setAddressSpaceState(argStorageCard, EXISTSTATES.CLOSED);
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "TRAILCOM: Unknown error while CloseAddressSpace", e );
	}
}
/**
 * Создание адресного пространства.
 * Creation date: (11.02.2003 12:09:12)
 * @param tinfo com.hps.july.trailcom.beans.AddressInfoAccessBean
 * @param argAdrName java.lang.String
 */
private void createAddressSpace(int argStorageCard, AddressInfoAccessBean tinfo, 
	String argAdrName) throws Exception {

		logIt("Creating address space for storagecard=" + argStorageCard + ", addrname=" + argAdrName);
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		final AddressSpaceAccessBean tspace2 = new AddressSpaceAccessBean(keygen.getNextKey("tables.address_space"));
		tspace2.setStoragecard(new Integer(argStorageCard));
		tspace2.setAddressinfo((AddressInfo)tinfo.getEJBRef());
		tspace2.setAddress(argAdrName);
		tspace2.setExiststate(new Short(EXISTSTATES.ACTIVE));
		tspace2.setActivestate(new Short((short)1));
		tspace2.setRealconnect(new Integer(1));
		tspace2.commitCopyHelper();
		
	}
/**
 * Определение типа выполняемой операции.
 * Открытие/закрытие/блокировка адресного пространства
 * Creation date: (24.01.2003 10:21:18)
 * @return int
 * @param argStoragePlace com.hps.july.persistence.StoragePlaceAccessBean
 */
private int determineAction(DocumentAccessBean argDocument, int operType) throws Exception {

	int action = ACTIONTYPES.NO_PROCESSING;

	int invVariant = determineVariant(INVENTORY_VARIANT);

	int docType = determineDocType(argDocument);
	
	// 4. Determine FROM type & FROM
	StoragePlaceAccessBean fromStorage = argDocument.getFrom();
	int fromStorageType = determineStorageType(fromStorage);

	// 5. Determine TO type & TO
	StoragePlaceAccessBean toStorage = argDocument.getTo();
	int toStorageType = determineStorageType(toStorage);

	if (operType == OPERATIONTYPES.OPPROCESS) {

		// Акт инвентаризации на позиции при наличии излишков
		if ( (docType == DOCTYPES.SURPLUS) ) { // && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for inventarization
			if (invVariant == 1) {
				DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
				Enumeration en = dl.findByTypeAndDocTo("S", new Integer(argDocument.getDocument()));
				if (en.hasMoreElements()) {
					dl = (DocumentsLinkAccessBean)en.nextElement();
					if (determineDocType(dl.getDocumentfrom()) == DOCTYPES.I13NACT)
						action = ACTIONTYPES.OPENADDRESSSPACETO;
				}
			} else {
				if (determineDocType(argDocument.getParentdocument()) == DOCTYPES.I13NACT)
					action = ACTIONTYPES.OPENADDRESSSPACETO;
			}
		}

		// Акт инвентаризации на позиции при наличии недостач
		if ( (docType == DOCTYPES.PAYOFF) ) { //&& (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for inventarization
			if (invVariant == 1) {
				DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
				Enumeration en = dl.findByTypeAndDocFrom("P", new Integer(argDocument.getDocument()));
				if (en.hasMoreElements()) {
					dl = (DocumentsLinkAccessBean)en.nextElement();
					if (determineDocType(dl.getDocumentTo()) == DOCTYPES.I13NACT)
					action = ACTIONTYPES.CLOSEADDRESSSPACEFROM;
				}
			} else {
				if (determineDocType(argDocument.getParentdocument()) == DOCTYPES.I13NACT)
					action = ACTIONTYPES.CLOSEADDRESSSPACEFROM;
			}
		}
		
		// Акт монтажа блока на позиции
		if ( (docType == DOCTYPES.BLOK_IN) && (toStorageType == STORAGETYPES.POSITION) ) {
			// Check for block-in type
			AssemblingActAccessBean aa = new AssemblingActAccessBean();
			aa.setInitKey_document(argDocument.getDocument());
			try {
				aa.refreshCopyHelper();
				if ("A".equals(aa.getOperationType()))
					action = ACTIONTYPES.OPENADDRESSSPACETO;
			} catch (javax.ejb.ObjectNotFoundException e) {
				// Strange
				e.printStackTrace(System.out);
			}
		}
		
		// Акт монтажа на позиции
		if ( (docType == DOCTYPES.INT_IN) && (toStorageType == STORAGETYPES.POSITION) ) {
			// Position mount act
			action = ACTIONTYPES.OPENADDRESSSPACETO;
		}

		
		// Акт демонтажа на позиции	
		if ( (docType == DOCTYPES.INT_OUT) && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Position mount act
			action = ACTIONTYPES.BLOCKADDRESSSPACEFROM;
		}
		
		// Акт демонтажа блока на позиции
		if ( (docType == DOCTYPES.BLOK_IN) && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for block-in type
			AssemblingActAccessBean aa = new AssemblingActAccessBean();
			aa.setInitKey_document(argDocument.getDocument());
			try {
				aa.refreshCopyHelper();
				if ("D".equals(aa.getOperationType()))
					action = ACTIONTYPES.BLOCKADDRESSSPACEFROM;
			} catch (javax.ejb.ObjectNotFoundException e) {
				// Strange
				e.printStackTrace(System.out);
			}
		}
		
		// Акт замены на позиции - старый сер. номер
		if ( (docType == DOCTYPES.PAYOFF) ) { // && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for change act
			DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
			Enumeration en = dl.findByTypeAndDocFrom("P", new Integer(argDocument.getDocument()));
			if (en.hasMoreElements()) {
				dl = (DocumentsLinkAccessBean)en.nextElement();
				if (determineDocType(dl.getDocumentTo()) == DOCTYPES.CHANGEACT)
					action = ACTIONTYPES.CLOSEADDRESSSPACEFROM;
			}
		}
		
		// Акт замены на позиции - новый сер. номер
		if ( (docType == DOCTYPES.SURPLUS) ) { // && (toStorageType == STORAGETYPES.POSITION) ) {
			DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
			Enumeration en = dl.findByTypeAndDocFrom("S", new Integer(argDocument.getDocument()));
			if (en.hasMoreElements()) {
				dl = (DocumentsLinkAccessBean)en.nextElement();
				if (determineDocType(dl.getDocumentTo()) == DOCTYPES.CHANGEACT)
					action = ACTIONTYPES.OPENADDRESSSPACETO;
			}
		}

		// Внешняя расходная накладная
		if ( (docType == DOCTYPES.EXT_OUT) && (toStorageType == STORAGETYPES.STORAGE) ) {
			action = ACTIONTYPES.CLOSEADDRESSSPACEFROM;
		}
		
		// Акт списания на складе
		if ( (docType == DOCTYPES.PAYOFF) && (fromStorageType == STORAGETYPES.STORAGE) ) {
			// Check 
			DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
			Enumeration en = dl.findByTypeAndDocFrom("P", new Integer(argDocument.getDocument()));
			if (!en.hasMoreElements()) 
				action = ACTIONTYPES.CLOSEADDRESSSPACEFROM;
		}
		
	} else if (operType == OPERATIONTYPES.OPCANCEL) {
	
		// Акт демонтажа на позиции	
		if ( (docType == DOCTYPES.INT_OUT) && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Position mount act
			action = ACTIONTYPES.OPENADDRESSSPACEFROM;
		}
		
		// Акт демонтажа блока на позиции
		if ( (docType == DOCTYPES.BLOK_IN) && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for block-in type
			AssemblingActAccessBean aa = new AssemblingActAccessBean();
			aa.setInitKey_document(argDocument.getDocument());
			try {
				aa.refreshCopyHelper();
				if ("D".equals(aa.getOperationType()))
					action = ACTIONTYPES.OPENADDRESSSPACEFROM;
			} catch (javax.ejb.ObjectNotFoundException e) {
				// Strange
				e.printStackTrace(System.out);
			}
		}
		
		
		// Акт инвентаризации на позиции при наличии недостач
		if ( (docType == DOCTYPES.PAYOFF) ) { // && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for inventarization
			if (invVariant == 1) {
				DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
				Enumeration en = dl.findByTypeAndDocFrom("P", new Integer(argDocument.getDocument()));
				if (en.hasMoreElements()) {
					dl = (DocumentsLinkAccessBean)en.nextElement();
					if (determineDocType(dl.getDocumentTo()) == DOCTYPES.I13NACT)
						action = ACTIONTYPES.OPENADDRESSSPACEFROM;
				}
			} else {
				if (determineDocType(argDocument.getParentdocument()) == DOCTYPES.I13NACT)
					action = ACTIONTYPES.OPENADDRESSSPACEFROM;
			}
		}
		
		// Акт инвентаризации на позиции при наличии излишков
		if ( (docType == DOCTYPES.SURPLUS) ) { //&& (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for inventarization
			if (invVariant == 1) {
				DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
				Enumeration en = dl.findByTypeAndDocTo("S", new Integer(argDocument.getDocument()));
				if (en.hasMoreElements()) {
					dl = (DocumentsLinkAccessBean)en.nextElement();
					if (determineDocType(dl.getDocumentfrom()) == DOCTYPES.I13NACT)
						action = ACTIONTYPES.CLOSEADDRESSSPACETO;
				}
			} else {
				if (determineDocType(argDocument.getParentdocument()) == DOCTYPES.I13NACT)
					action = ACTIONTYPES.CLOSEADDRESSSPACETO;
			}
		}
		
		// Акт монтажа блока на позиции
		if ( (docType == DOCTYPES.BLOK_IN) && (toStorageType == STORAGETYPES.POSITION) ) {
			// Check for block-in type
			AssemblingActAccessBean aa = new AssemblingActAccessBean();
			aa.setInitKey_document(argDocument.getDocument());
			try {
				aa.refreshCopyHelper();
				if ("A".equals(aa.getOperationType()))
					action = ACTIONTYPES.BLOCKADDRESSSPACETO;
			} catch (javax.ejb.ObjectNotFoundException e) {
				// Strange
				e.printStackTrace(System.out);
			}
		}
		
		// Акт монтажа на позиции
		if ( (docType == DOCTYPES.INT_IN) && (toStorageType == STORAGETYPES.POSITION) ) {
			// Position mount act
			action = ACTIONTYPES.BLOCKADDRESSSPACETO;
		}
		
		// Акт замены на позиции - старый сер. номер
		if ( (docType == DOCTYPES.PAYOFF) ) { // && (fromStorageType == STORAGETYPES.POSITION) ) {
			// Check for change act
			DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
			Enumeration en = dl.findByTypeAndDocFrom("P", new Integer(argDocument.getDocument()));
			if (en.hasMoreElements()) {
				dl = (DocumentsLinkAccessBean)en.nextElement();
				if (determineDocType(dl.getDocumentTo()) == DOCTYPES.CHANGEACT)
					action = ACTIONTYPES.OPENADDRESSSPACEFROM;
			}
		}
		
		// Акт замены на позиции - новый сер. номер
		if ( (docType == DOCTYPES.SURPLUS) ) { // && (toStorageType == STORAGETYPES.POSITION) ) {
			DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
			Enumeration en = dl.findByTypeAndDocFrom("S", new Integer(argDocument.getDocument()));
			if (en.hasMoreElements()) {
				dl = (DocumentsLinkAccessBean)en.nextElement();
				if (determineDocType(dl.getDocumentTo()) == DOCTYPES.CHANGEACT)
					action = ACTIONTYPES.CLOSEADDRESSSPACETO;
			}
		}
		
		// Внешняя расходная накладная
		if ( (docType == DOCTYPES.EXT_OUT) && (toStorageType == STORAGETYPES.STORAGE) ) {
			action = ACTIONTYPES.BLOCKADDRESSSPACEFROM;
		}
		
		// Акт списания на складе
		if ( (docType == DOCTYPES.PAYOFF) && (fromStorageType == STORAGETYPES.STORAGE) ) {
			// Check 
			DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
			Enumeration en = dl.findByTypeAndDocFrom("P", new Integer(argDocument.getDocument()));
			if (!en.hasMoreElements()) 
				action = ACTIONTYPES.BLOCKADDRESSSPACEFROM;
		}
		
	}
	
	logIt("Determine action, action=" + action);
	return action;
}
/**
 * Определение типа документа.
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
			if (argDocument.getEJBRef() instanceof ChangeAct)
				docType = DOCTYPES.CHANGEACT;
			else if (argDocument.getEJBRef() instanceof InwayBill)
				docType = DOCTYPES.EXT_IN;
			else if (argDocument.getEJBRef() instanceof OutWayBill)
				docType = DOCTYPES.EXT_OUT;
			else if (argDocument.getEJBRef() instanceof InternalWayBill)
				docType = DOCTYPES.INT_IN;
			else if (argDocument.getEJBRef() instanceof InternalOutBill)
				docType = DOCTYPES.INT_OUT;
			else if (argDocument.getEJBRef() instanceof PayOffAct)
				docType = DOCTYPES.PAYOFF;
			else if (argDocument.getEJBRef() instanceof SurplusAct)
				docType = DOCTYPES.SURPLUS;
			else if (argDocument.getEJBRef() instanceof AssemblingAct)
				docType = DOCTYPES.BLOK_IN;
		} catch (Exception e) {
			System.out.println("TRAILCOM: cannot determine document type");
			e.printStackTrace(System.out);
		}
	}
	
	logIt("Determine document type, type=" + docType);
	return docType;
}
/**
 * Определение типа документа.
 * Creation date: (24.01.2003 10:21:18)
 * @return int
 * @param argStoragePlace com.hps.july.persistence.StoragePlaceAccessBean
 */
private int determineDocType(Integer argDoc) {

	int docType = DOCTYPES.NO_PROCESSING;

	if (argDoc != null) {
		int argDocument = 0;

		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				I13nActAccessBean ab = new I13nActAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.I13NACT;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				ChangeActAccessBean ab = new ChangeActAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.CHANGEACT;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				InwayBillAccessBean ab = new InwayBillAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.EXT_IN;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				OutWayBillAccessBean ab = new OutWayBillAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.EXT_OUT;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				InternalWayBillAccessBean ab = new InternalWayBillAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.INT_IN;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				InternalOutBillAccessBean ab = new InternalOutBillAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.INT_OUT;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				PayOffActAccessBean ab = new PayOffActAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.PAYOFF;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				SurplusActAccessBean ab = new SurplusActAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.SURPLUS;
			} catch (Exception ee) {
				// Ignore
			}
		}
		if (docType == DOCTYPES.NO_PROCESSING) {
			try {
				AssemblingActAccessBean ab = new AssemblingActAccessBean();
				ab.setInitKey_document(argDocument);
				ab.refreshCopyHelper();
				docType = DOCTYPES.BLOK_IN;
			} catch (Exception ee) {
				// Ignore
			}
		}
	}
	
	logIt("Determine document type, type=" + docType);
	return docType;
}
/**
 * Определение типа места хранения.
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
 * Определение варианта расчетов.
 * 1 - с использованием EJB
 * 2 - c использованием хранимых
 * Creation date: (19.08.2004 17:37:32)
 * @return int
 */
private int determineVariant(String argVariant) {
	int result = 1;
	try {
		NamedValueAccessBean nv = new NamedValueAccessBean();
		nv.setInitKey_id(argVariant);
		nv.refreshCopyHelper();
		int res = nv.getIntvalue();
		if ( (res == 1) || (res ==2) )
			result = res;
		else
			System.out.println("Invalid value for Constant " + ", using EJB for Inventory");
	} catch (Exception e) {
		System.out.println("Constant " + " not found, using EJB for Inventory");
	}
	return result;
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
 * Генерация непрерывного адресного пространства.
 * Creation date: (11.02.2003 12:09:12)
 * @param tinfo com.hps.july.trailcom.beans.AddressInfoAccessBean
 * @param argAdrName java.lang.String
 */
private void genPermanentAddressSpace(int argStorageCard, AddressInfoAccessBean tinfo) 
	throws Exception {

		logIt("Generating permanent address space for storagecard=" + argStorageCard);
		// Permanent addressation
		logIt("Finding address_info2...");
		final AddressInfo2AccessBean ainfo2 = new AddressInfo2AccessBean();
		Enumeration aen2 = ainfo2.findByResourceTypeport(new Integer(tinfo.getResource()),
			new Short(tinfo.getTypeport()));
		while (aen2.hasMoreElements()) {
			final AddressInfo2AccessBean tinfo2 = (AddressInfo2AccessBean)aen2.nextElement();
			logIt("Address)info2 found, creating address space with name=" + tinfo2.getAddressname());
			createAddressSpace(argStorageCard, tinfo, tinfo2.getAddressname());
		}
		
	}
/**
 * Генерация адресного пространства по правилам.
 * Creation date: (11.02.2003 12:09:12)
 * @param tinfo com.hps.july.trailcom.beans.AddressInfoAccessBean
 * @param argAdrName java.lang.String
 */
private void genRuleAddressSpace(int argStorageCard, AddressInfoAccessBean tinfo) 
	throws Exception {
	
		// Addressation by rule
		final int startAddr;
		if (tinfo.getStartaddress() != null)
			startAddr = tinfo.getStartaddress().intValue();
		else
			startAddr = 0;
		final int lastAddr;
		if (tinfo.getLastaddress() != null)
			lastAddr = tinfo.getLastaddress().intValue();
		else
			lastAddr = 0;
		final int step;
		if (tinfo.getAddressstep() != null)
			step = tinfo.getAddressstep().intValue();
		else
			step = 0;

		logIt("Generating rule address space for storagecard=" + argStorageCard + 
			", startAddr=" + startAddr + ", lastAddr=" + lastAddr +
			", step=" + step);
		for (int i = startAddr; i <= lastAddr; i=i+step) {
			String aname = tinfo.getAddresshead() + i;
			logIt("Creating address space with name=" + aname);
			createAddressSpace(argStorageCard, tinfo, aname);
		}
	}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Запись отладочных сообщений в журнал.
 * Creation date: (27.12.2002 10:03:34)
 * @param msg java.lang.String
 */
public void logIt(String msg) {
	System.out.println("TRAILCOM-LOG: " + msg);
}
/**
 * Открытие адресного пространства для карточки.
 * Creation date: (10.02.2003 18:03:56)
 * @param argStorageCard int
 */
public void openAddressSpace(int argStorageCard)  
	throws java.rmi.RemoteException {

	logIt("OpenAddressSpace for storagecard=" + argStorageCard);
	try {
		// Find storagecard
		final StorageCardAccessBean scard = new StorageCardAccessBean();
		scard.setInitKey_storagecard(argStorageCard);
		scard.refreshCopyHelper();
		
		// Check if address info exists
		logIt("Check if address_info exists");
		final AddressInfoAccessBean ainfo = new AddressInfoAccessBean();
		final Enumeration aen = ainfo.findByResource(new Integer(scard.getResource().getResource()));
		if (aen.hasMoreElements()) {
			logIt("address_info exists");
			// Check if address space already exists
		
			final AddressSpaceAccessBean aspace = new AddressSpaceAccessBean();
			final Enumeration en = aspace.findByStoragecard(new Integer(argStorageCard));
			if (en.hasMoreElements()) {
				logIt("Address_space exists - updating");
				setAddressSpaceState(argStorageCard, EXISTSTATES.ACTIVE);
			} else {
				
				logIt("Address_space not exists - generating");
				// Generate address space
				while (aen.hasMoreElements()) {
					final AddressInfoAccessBean tinfo = (AddressInfoAccessBean)aen.nextElement();
					logIt("Address_info address_type=" + tinfo.getAddresstype().shortValue());
					// Check address type
					if (tinfo.getAddresstype().shortValue() == 0)
						genPermanentAddressSpace(argStorageCard, tinfo);
					else 
						genRuleAddressSpace(argStorageCard, tinfo);
				}
			}
		}
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "TRAILCOM: Unknown error while OpenAddressSpace", e );
	}
}
/**
 * Обработка при обсчете документа.
 * Creation date: (19.12.2002 10:31:09)
 * @param argDocument java.lang.Integer
 */
public void processDocument(Integer argDocument)  throws java.rmi.RemoteException {

	try {
		processDocumentAction(argDocument, OPERATIONTYPES.OPPROCESS);
		
	} catch( Exception e ) {
		System.out.println( "TRAILCOM: Unknown error while sending document to trailcom" );
		e.printStackTrace(System.out);
	}
}
/**
 * Обобщенный обработчик адресного пространства.
 * Creation date: (19.12.2002 10:31:09)
 * @param argDocument java.lang.Integer
 */
private void processDocumentAction(Integer argDocument, int operType)  throws Exception {

	int docType = DOCTYPES.NO_PROCESSING;
	int fromStorageType = STORAGETYPES.EMPTY;
	int toStorageType = STORAGETYPES.EMPTY;
	DocumentAccessBean document = null;
	StoragePlaceAccessBean fromStorage = null;
	StoragePlaceAccessBean toStorage = null;
	
	try {
		
		logIt("****** Transmit to trailcom called, document=" + argDocument);
		
		// 1. Check if processing enabled
		//if (!isProcessingEnabled())
		//	return;

		// 2. Determine document
		try {
			document = new DocumentAccessBean();
			document.setInitKey_document(argDocument.intValue());
			document.refreshCopyHelper();
		} catch (javax.ejb.ObjectNotFoundException e) {
			// Document not found - nothing to do - just report error
			System.out.println("TRAILCOM: document not found code = " + argDocument.toString());
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

		
		int actionType = determineAction(document, operType);
		
		// Find docpositions
		final DocumentPositionAccessBean adocpos = new DocumentPositionAccessBean();
		final Enumeration en = adocpos.findDocPositionsByDocOrderByOrderAsc(argDocument);
		while (en.hasMoreElements()) {
			final DocumentPositionAccessBean docpos = (DocumentPositionAccessBean)en.nextElement();
			if ("S".equals(docpos.getResource().getCountpolicy())) {
				switch (actionType) {
					case ACTIONTYPES.OPENADDRESSSPACEFROM:
						openAddressSpace(docpos.getCardFrom().getStoragecard());
						break;
					case ACTIONTYPES.OPENADDRESSSPACETO:
						openAddressSpace(docpos.getCardTo().getStoragecard());
						break;
					case ACTIONTYPES.CLOSEADDRESSSPACEFROM:
						closeAddressSpace(docpos.getCardFrom().getStoragecard());
						break;
					case ACTIONTYPES.CLOSEADDRESSSPACETO:
						closeAddressSpace(docpos.getCardTo().getStoragecard());
						break;
					case ACTIONTYPES.BLOCKADDRESSSPACEFROM:
						blockAddressSpace(docpos.getCardFrom().getStoragecard());
						break;
					case ACTIONTYPES.BLOCKADDRESSSPACETO:
						blockAddressSpace(docpos.getCardTo().getStoragecard());
						break;
				}
			}
		}
		
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "TRAILCOM: Unknown error while sending document to trailcom", e );
	}
}
/**
 * Установка заданного значения адресного пространства для карточки.
 * Creation date: (11.02.2003 12:09:12)
 * @param tinfo com.hps.july.trailcom.beans.AddressInfoAccessBean
 * @param argAdrName java.lang.String
 */
private void setAddressSpaceState(int argStorageCard, short argState) 
throws Exception {

		logIt("Updating address space, scard=" + argStorageCard + ", state=" + argState);
		try {
			// Set address space state by storagecard
			final AddressSpaceAccessBean aspace = new AddressSpaceAccessBean();
			Enumeration en = aspace.findByStoragecard(new Integer(argStorageCard));
			while (en.hasMoreElements()) {
				final AddressSpaceAccessBean tspace = (AddressSpaceAccessBean)en.nextElement();
				logIt("Updating address space state, portid=" + tspace.getPortid());
				tspace.setExiststate(new Short(argState));
				tspace.commitCopyHelper();
			}
		} catch( Exception e ) {
			throw new java.rmi.RemoteException( "TRAILCOM: Unknown error while setting AddressSpace state", e );
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

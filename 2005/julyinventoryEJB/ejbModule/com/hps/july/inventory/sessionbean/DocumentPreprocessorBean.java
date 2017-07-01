package com.hps.july.inventory.sessionbean;

import java.util.*;
import com.hps.july.persistence.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Предварительная обработка документов перед обсчетом
 */
public class DocumentPreprocessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

protected void checkChangeActSerialnumbers(int documentkey)
	throws DocumentProcessingException
{
	ArrayList errors = new ArrayList();
	try {
		ChangeActPositionAccessBean df = new ChangeActPositionAccessBean();
		Enumeration en = 
			df.findChangeActPositionByChangeAct(new DocumentKey(documentkey));
		int cnt = 0;
		while(en.hasMoreElements()) {
			ChangeActPositionAccessBean d = (ChangeActPositionAccessBean)en.nextElement();
			if(
				(d.getOldSerial() == null || "".equals(d.getOldSerial()))
				|| (d.getNewSerial() == null || "".equals(d.getNewSerial()))
			) {
				ProcessingPositionError p = new ProcessingPositionError();
				p.setPositionCode(d.getCode());
				p.setErrorCode(ProcessingPositionError.ERRORS.NO_SERIAL);
				errors.add(p);
				cnt++;
			}
		}
	} catch(Exception e) {
		throw new DocumentProcessingException(6,"error.documentprocessing.docposselect");
	}
	if(!errors.isEmpty()) {
		DocumentProcessingException de = new DocumentProcessingException(0,"error.documentprocessing.serialcheck");
		de.setPositionErrors(errors);
		throw de;
	}
}
protected void checkSerialnumbers(int documentkey)
	throws DocumentProcessingException
{
	ArrayList errors = new ArrayList();
	try {
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
		Enumeration en = 
			df.findDocPositionsByDocAndPolicyOrderByOrderAsc(new Integer(documentkey),"S");
		int cnt = 0;
		while(en.hasMoreElements()) {
			DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
			if(
				"S".equals(d.getResource().getCountpolicy())
				&& (d.getSerialnumber() == null || "".equals(d.getSerialnumber().trim()))
				&& Boolean.FALSE.equals(d.getResultBoxed())
			) {
				ProcessingPositionError p = new ProcessingPositionError();
				p.setPositionCode(d.getDocposition());
				p.setErrorCode(ProcessingPositionError.ERRORS.NO_SERIAL);
				errors.add(p);
				cnt++;
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new DocumentProcessingException(6,"error.documentprocessing.docposselect");
	}
	if(!errors.isEmpty()) {
		DocumentProcessingException de = new DocumentProcessingException(0,"error.documentprocessing.serialcheck");
		de.setPositionErrors(errors);
		throw de;
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
private StorageCardAccessBean findCardByDocposition(DocumentPositionAccessBean pos)
	throws javax.ejb.ObjectNotFoundException
{
	try {
		return findCardByDocposition(pos,new Integer(pos.getDocument().getFrom().getStorageplace()));
	} catch(Exception e) {
		throw new javax.ejb.ObjectNotFoundException();
	}
}
private StorageCardAccessBean findCardByDocposition(DocumentPositionAccessBean pos, Integer storage)
	throws javax.ejb.ObjectNotFoundException
{
	try {
		StorageCardAccessBean card = new StorageCardAccessBean();
		String policy = pos.getResource().getCountpolicy();
		if("S".equals(policy)) {
			return (new StorageCardAccessBean()).findBySerial(pos.getSerialnumber());
		} else if("P".equals(policy)) {
			if(storage == null) {
				throw new Exception();
			}
			return (new StorageCardAccessBean()).findByStorageOwnerParty(
				storage,
				new Integer(pos.getOwner().getOrganization()),
				pos.getParty()
			);
		} else {
			if(storage == null) {
				throw new Exception();
			}
			return (new StorageCardAccessBean()).findByStorageOwnerResource(
				storage,
				new Integer(pos.getOwner().getOrganization()),
				new Integer(pos.getResource().getResource())
			);
		}
	} catch(Exception e) {
//		e.printStackTrace();
		throw new javax.ejb.ObjectNotFoundException();
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
 * Prepare document for DocumentProcessor.
 * Creation date: (21.05.2003 11:31:08)
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 */
public DocumentProcessingException preprocessDocument(int argDoc) throws java.rmi.RemoteException {
	DocumentProcessingException ex = null;
	DocumentAccessBean document = null;
	try {
		document = new DocumentAccessBean();
		document.setInitKey_document( argDoc );
		document.refreshCopyHelper();
	} catch( Exception e ) {
		return new DocumentProcessingException(5,"error.preprocessor.cannotfinddocument");
	}

	try {
		EJBObject ref = document.getEJBRef();
		if( ref instanceof InternalWayBill ) {
			InternalWayBillAccessBean b = new InternalWayBillAccessBean(ref);
			b.refreshCopyHelper();
			updateInternalWayBill(b);
			checkSerialnumbers(b.getDocument());
		} else if( ref instanceof InwayBill ) {
			InwayBillAccessBean b = new InwayBillAccessBean(ref);
			b.refreshCopyHelper();
			updateInwayBill(b);
			checkSerialnumbers(b.getDocument());
		} else if( ref instanceof InternalOutBill ) {
			InternalOutBillAccessBean b = new InternalOutBillAccessBean(ref);
			b.refreshCopyHelper();
			updateInternalOutBill(b);
			checkSerialnumbers(b.getDocument());
		} else if( ref instanceof OutWayBill ) {
			OutWayBillAccessBean b = new OutWayBillAccessBean(ref);
			b.refreshCopyHelper();
			updateOutWayBill(b);
			checkSerialnumbers(b.getDocument());
		} else if( ref instanceof I13nAct ) {
			// distingush on storage and position
			I13nActAccessBean b = new I13nActAccessBean(ref);
			b.refreshCopyHelper();
			updateI13nAct(b);
			checkSerialnumbers(b.getDocument());
		} else if( ref instanceof ChangeAct ) {
			ChangeActAccessBean b = new ChangeActAccessBean(ref);
			b.refreshCopyHelper();
			updateChangeAct(b);
			checkChangeActSerialnumbers(b.getDocument());
		} else if( ref instanceof PayOffAct ) {
			PayOffActAccessBean b = new PayOffActAccessBean(ref);
			b.refreshCopyHelper();
			updatePayOffAct(b);
			checkSerialnumbers(b.getDocument());
		} else if( ref instanceof FaultReport ) {
			FaultReportAccessBean b = new FaultReportAccessBean(ref);
			b.refreshCopyHelper();
			updateFaultReport(b);
			checkSerialnumbers(b.getDocument());
		} else if( ref instanceof AssemblingAct ) {
			AssemblingActAccessBean b = new AssemblingActAccessBean(ref);
			b.refreshCopyHelper();
			updateAssemblingAct(b);
			checkSerialnumbers(b.getDocument());
		}
		return null;
	} catch(DocumentProcessingException dpe) {
		return dpe;
	} catch(Exception e) {
		return new DocumentProcessingException(5,"error.preprocessor.refnotfound");
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
/**
 * 
 * @param dkey com.hps.july.persistence.DocumentKey
 * @param serial java.lang.String
 * @exception java.lang.Exception The exception description.
 */
private void updateAgregateSerial(DocumentKey dkey, String serial, boolean isnew)
	throws java.lang.Exception
{
	DocumentPositionAccessBean df = new DocumentPositionAccessBean();
	Enumeration en = df.findDocumentPositionByDocument(dkey);
	while(en.hasMoreElements()) {
		DocumentPositionAccessBean b = (DocumentPositionAccessBean)en.nextElement();
		if(isnew) {
			b.setAgregateSerial(serial);
		} else {
			b.setOldAgregateSerial(serial);
		}
		b.commitCopyHelper();
	}
}
private void updateAssemblingAct(AssemblingActAccessBean bean)
	throws DocumentProcessingException
{
	try {
		if("A".equals(bean.getOperationType())) {
			updateAgregateSerial(new DocumentKey(bean.getDocument()),bean.getAgregat().getSerialnumber(),true);
		} else if("D".equals(bean.getOperationType())) {
			updateAgregateSerial(new DocumentKey(bean.getDocument()),bean.getAgregat().getSerialnumber(),false);
		}
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.assemblingact");
	}
	try {
		updateDocumentPosition(bean.getDocument(),
			new Integer(bean.getFrom().getStorageplace()),
			Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
		);
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.update.assemblingact");
	}
}
private void updateChangeAct(ChangeActAccessBean bean)
	throws DocumentProcessingException
{
	try {
		updateDocumentPosition(bean.getDocument(),
			new Integer(bean.getFrom().getStorageplace()),
			Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
		);
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.update.changeact");
	}
}
private void updateDocumentPosition(int document, Integer storage, Boolean boxed, Boolean broken, Boolean closed)
	throws Exception
{
	DocumentPositionAccessBean pos;
	StorageCardAccessBean sc;
	java.util.Enumeration positions = (new DocumentPositionAccessBean()).
		findDocumentPositionByDocument(new DocumentKey(document));
	while(positions.hasMoreElements()) {
		pos = (DocumentPositionAccessBean)positions.nextElement();
		try {
			if("S".equals(pos.getResource().getCountpolicy())) {
				sc = findCardByDocposition(pos,storage);
				if(sc != null) {
					pos.setSourceBoxed(new Boolean(sc.getBoxed().booleanValue() | boxed.booleanValue()));
					pos.setSourceBroken(new Boolean(sc.getBroken().booleanValue() | broken.booleanValue()));
					pos.setSourceClosed(new Boolean(sc.getClosed().booleanValue() | closed.booleanValue()));
					pos.setManufserial(sc.getManufserial());
					pos.setOldplace(sc.getPlace());
					pos.setOwner((Organization)sc.getOwner().getEJBRef());
					pos.commitCopyHelper();
System.out.println("DOCPREPROCESS: Position:"+pos.getDocposition()+" - UPDATED");
				}
			}
		} catch(ObjectNotFoundException e) {
			// nothing to do, no storage card
System.out.println("DOCPREPROCESS: No card for position: "+pos.getDocposition());
		}
	}
}
private void updateFaultReport(FaultReportAccessBean bean)
	throws DocumentProcessingException
{
	try {
		updateDocumentPosition(bean.getDocument(),
			new Integer(bean.getFrom().getStorageplace()),
			Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
		);
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.update.faultreport");
	}
}
private void updateI13nAct(I13nActAccessBean bean)
	throws DocumentProcessingException
{
	try {
		if("A".equals(bean.getType())) {
			updateAgregateSerial(new DocumentKey(bean.getDocument()),bean.getAgregate().getSerialnumber(),true);
		}
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.i13n.updateagregate");
	}
}
private void updateInternalOutBill(InternalOutBillAccessBean bean)
	throws DocumentProcessingException
{
	try {
		updateDocumentPosition(bean.getDocument(),
			new Integer(bean.getFrom().getStorageplace()),
			Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
		);
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.update.internaloutbill");
	}
}
private void updateInternalWayBill(InternalWayBillAccessBean iwb)
	throws DocumentProcessingException
{
	try {
		updateDocumentPosition(iwb.getDocument(),
			new Integer(iwb.getFrom().getStorageplace()),
			Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
		);
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.update.internalwaybill");
	}
	/*
			// Внутренний приход или Монтаж на позиции
			try {
				InternalWayBillPositionAccessBean pf = new InternalWayBillPositionAccessBean();
				Enumeration en = pf.findDocPositionsByDocOrderByOrderAsc(new Integer(document.getDocument()));
				while(en.hasMoreElements()) {
					InternalWayBillPositionAccessBean pos = (InternalWayBillPositionAccessBean)en.nextElement();
					String poslicy = pos.getResource().getCountpolicy();
					
				}
				return null;
			} catch(Exception e) {
				return new DocumentProcessingException(5,"error.preprocessor.internalwaybill");
			}
	*/
}
private void updateInwayBill(InwayBillAccessBean bean)
	throws DocumentProcessingException
{
}
private void updateOutWayBill(OutWayBillAccessBean bean)
	throws DocumentProcessingException
{
	try {
		updateDocumentPosition(bean.getDocument(),
			new Integer(bean.getFrom().getStorageplace()),
			Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
		);
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.update.outwaybill");
	}
}
private void updatePayOffAct(PayOffActAccessBean bean)
	throws DocumentProcessingException
{
	try {
		updateDocumentPosition(bean.getDocument(),
			new Integer(bean.getFrom().getStorageplace()),
			Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
		);
	} catch( Exception e ) {
		throw new DocumentProcessingException(5,"error.preprocessor.update.payoff");
	}
}
}

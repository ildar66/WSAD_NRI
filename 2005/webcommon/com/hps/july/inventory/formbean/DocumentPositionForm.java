package com.hps.july.inventory.formbean;

import java.util.Enumeration;
import java.util.Vector;

import javax.ejb.ObjectNotFoundException;

import com.hps.july.inventory.sessionbean.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

import org.apache.struts.action.*;

/**
 * Абстрактный класс формы строки документа
 *
 * Содержит методы поиска строк в документе по параметрам
 * а так же методы добавления строки с оборудованием и его частями
 */
abstract public class DocumentPositionForm
	extends com.hps.july.web.util.EditForm
{
	private Integer ownercode;
	private Boolean sourceBoxed = Boolean.FALSE;
	private Boolean sourceBroken = Boolean.FALSE;
	private Boolean sourceClosed = Boolean.FALSE;
	private Boolean resultBoxed = Boolean.FALSE;
	private Boolean resultBroken = Boolean.FALSE;
	private Boolean resultClosed = Boolean.FALSE;

	private Boolean fictionSerial = Boolean.FALSE;
	private String serialnumber;
	private String manufserial;
	private String localserial; 
	private boolean sn_absent;
	private boolean inv_absent;
	private boolean loc_absent;
	
	
public DocumentPositionForm() {
	sourceBoxed = Boolean.FALSE;
	sourceBroken = Boolean.FALSE;
	sourceClosed = Boolean.FALSE;
	resultBoxed = Boolean.FALSE;
	resultBroken = Boolean.FALSE;
	resultClosed = Boolean.FALSE;
}

public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	setSn_absent(false);
	setInv_absent(false);
	setLoc_absent(true);
}

public void fillRecord(AbstractEntityAccessBean bean)
{
	if ( (getSerialnumber() == null) || (getSerialnumber().trim().length() == 0) )
		setSn_absent(true);
	if ( (getManufserial() == null) || (getManufserial().trim().length() == 0) )
		setInv_absent(true);
	if ( (getLocalserial() == null) || (getLocalserial().trim().length() == 0) )
		setLoc_absent(true);
}

public void preprocessSerials() {
	if (isSn_absent())
		setSerialnumber(null);
	if (isInv_absent())
		setManufserial(null);
	if (isLoc_absent())
		setLocalserial(null);
}

	public ProcessingPositionError addPosition2Document(Integer argPosition) throws java.rmi.RemoteException {
		try {
			DocumentPositionAccessBean position = new DocumentPositionAccessBean();
			position.setInitKey_docposition( argPosition.intValue() );
			position.refreshCopyHelper();
			DocumentAccessBean document = position.getDocument();
//System.out.println("DOCPOSFORM/addPosition2Document:ProcessSource:"+document.getProcessSource());
			if( document.getProcessSource() != null && document.getProcessSource().booleanValue() ) {
//System.out.println("DOCPOSFORM/addPosition2Document:CounterPolicy:"+position.getResource().getCountpolicy());
				if( position.getResource().getCountpolicy().equals("S") ) {
					//find corresponding storagecard
					StorageCardAccessBean card = (new StorageCardAccessBean()).findBySerial( position.getSerialnumber() );
					//must be the same storage
					if( card.getCurrentstorageKey().storageplace != document.getFromKey().storageplace ) {
						ProcessingPositionError error = new ProcessingPositionError();
						error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
						error.setStorage( card.getCurrentstorageKey().storageplace );
						return error;
					}
					//must be the same resource
					if( card.getResourceKey().resource != position.getResourceKey().resource ) {
						ProcessingPositionError error = new ProcessingPositionError();
						error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
						error.setResource( position.getResourceKey().resource );
						return error;
					}
					AgregateContentAccessBean ac = new AgregateContentAccessBean();
					Enumeration en = ac.findAgregateContentByAgregate(new StorageCardKey(card.getStoragecard()));
					int max = (new DocumentPositionAccessBean()).
						findMaxOrderPosition( new Integer( document.getDocument() ) ).getOrder();
//System.out.println("DOCPOSFORM/addPosition2Document/AgrElements:"+en.hasMoreElements());
					while(en.hasMoreElements()) {
						AgregateContentAccessBean agr = (AgregateContentAccessBean)en.nextElement();//parts.getAgregateContentAccessBean(i);
						StorageCardAccessBean sc = agr.getParts();
//System.out.println("DOCPOSFORM/addPosition2Document/AddPart:"+sc.getStoragecard());
						int nextKey = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
						DocumentPositionAccessBean pos = constructDocumentPosition(sc, document, nextKey, position, ++max, agr);
					}
				}
			}
		} catch (ObjectNotFoundException ee) {
			// Ignore
		} catch( Exception e ) {
			e.printStackTrace();
			throw new java.rmi.RemoteException( "While adding position to document.", e );
		}
		return null;
	}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2002 18:42:34)
 * @return com.hps.july.persistence.DocumentPositionAccessBean
 */
public DocumentPositionAccessBean constructDocumentPosition(StorageCardAccessBean sc, DocumentAccessBean document, int newDocposition, DocumentPositionAccessBean position, int order, AgregateContentAccessBean agr)
	throws Exception
{
	if(position != null) position.refreshCopyHelper();

	DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
		newDocposition, 
		new Integer(sc.getResourceKey().resource), new Integer(sc.getOwnerKey().organization), 
		new Integer(document.getDocument()), 
		order, agr.getQty(), sc.getPrice(), sc.getBoxed(), position.getResultBoxed(), sc.getBroken(), 
		position.getResultBroken(), sc.getClosed(), position.getResultClosed() );
	pos.setParty( sc.getParty() );
	pos.setIsfictserial(sc.getIsfictserial());
	pos.setSerialnumber(sc.getSerialnumber());
	pos.setRealserial(null);
	pos.setConfiguration( sc.getConfiguration() );
	pos.setAgregate( (DocumentPosition)(position.getEJBRef()) );
	pos.commitCopyHelper();
	return pos;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFictionSerial() {
	return fictionSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
public Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:57:32)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getResultBoxed() {
	return resultBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:57:50)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getResultBroken() {
	return resultBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:58:10)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getResultClosed() {
	return resultClosed;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:53:47)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSourceBoxed() {
	return sourceBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:54:14)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSourceBroken() {
	return sourceBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:57:01)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSourceClosed() {
	return sourceClosed;
}
public static boolean hasSameBulk(Integer resource, Integer owner, Integer document, Integer docposition) {
	if(document == null)
		return false;

	try {
//		System.out.println("HAS SAME BULK: "+resource+", "+owner+", "+document);
//		System.out.println(":::: call findByDocumentQBE2("+document+",'B','',TRUE,"+owner+",TRUE,"+resource+",1)");
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
		Enumeration en = df.findByDocumentQBE2(
			document, "B", "",
    		Boolean.TRUE, owner,
			Boolean.TRUE, resource,
			new Integer(1)
		);
		if(docposition != null) {
			while(en.hasMoreElements()) {
				DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
				if(d.getDocposition() != docposition.intValue()) {
					//System.out.println("HAS_SAME_BULK: search for=" + docposition.intValue() + ", found another position=" + d.getDocposition());
					return true;
				}
			}
			return false;
		} else {
			return en.hasMoreElements();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
}
public static boolean hasSameParty(String partynumber, Integer owner, Integer document, Integer docposition) {
	if(document == null)
		return false;

	try {
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
//		System.out.println("HAS SAME PARTY: "+partynumber+", "+owner+", "+document);
//		System.out.println(":::: call findByDocumentQBE2("+document+",'P','"+partynumber+"',TRUE,"+owner+",FALSE,0,1)");
		Enumeration en = df.findByDocumentQBE2(
			document,
    		"P", partynumber,
    		Boolean.TRUE, owner,
			Boolean.FALSE, new Integer(0),
			new Integer(1)
		);
		if(docposition != null) {
			while(en.hasMoreElements()) {
				DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
				if(d.getDocposition() != docposition.intValue()) {
					return true;
				}
			}
			return false;
		} else {
			return en.hasMoreElements();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
}
public static boolean hasSameSerial(String serialnumber, Integer document, Integer docposition) {
	if(document == null) {
		return false;
	}
	return com.hps.july.cdbc.objects.CDBCDocuments.hasSameSerial(serialnumber,document,docposition);
}
public static boolean hasSameSerialAndResource(String serialnumber, String resource, Integer document, Integer docposition) {
	if(document == null) {
		return false;
	}
	return com.hps.july.cdbc.objects.CDBCDocuments.hasSameSerialAndResource(serialnumber,resource,document,docposition);
}
	public void removePositionFromDocument(Integer docPosition) throws java.rmi.RemoteException {
		try {
			//System.out.println("Trying to remove documentposition agregate parts");
//			DocumentPositionAccessBean position = new DocumentPositionAccessBean();
//			position.setInitKey_docposition( docPosition.intValue() );
//			position.refreshCopyHelper();

//			if(.getAgregate() != null) {
//System.out.println("%%%% Agregate is not null");
				javax.naming.InitialContext ctx = new javax.naming.InitialContext();
				javax.transaction.UserTransaction ut = (javax.transaction.UserTransaction)ctx.lookup("jta/usertransaction");
				ut.begin();
				try {
					Enumeration en = (new DocumentPositionAccessBean()).
						findAgregatePartsByAgregate(new DocumentPositionKey(docPosition.intValue()));
					while(en.hasMoreElements()) {
						DocumentPositionAccessBean part = (DocumentPositionAccessBean)en.nextElement();
						part.refreshCopyHelper();
//System.out.println("%%%% Delete docposition: "+part.getDocposition());
						part.setAgregate(null);
						part.setAgregateSerial(null);
						part.getEJBRef().remove();
					}
					ut.commit();
				} catch(Exception e) {
					ut.rollback();
				}
//			}
		} catch( Exception e ) {
			e.printStackTrace(System.out);
			throw new java.rmi.RemoteException( "While adding position to document.", e );
		}
	}

	//			DocumentPositionAccessBeanTable parts = new DocumentPositionAccessBeanTable();
	//			parts.setDocumentPositionAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
	//				position.getAgregateParts(), DocumentPositionAccessBean.class ));
	//			for( int i = 0; i < parts.numberOfRows(); i++ ) {
	//				DocumentPositionAccessBean part = parts.getDocumentPositionAccessBean(i);
/**
 * 
 * @param newFictionSerial java.lang.Boolean
 */
public void setFictionSerial(java.lang.Boolean newFictionSerial) {
	fictionSerial = newFictionSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @param newOwnercode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:57:32)
 * @param newResultBoxed java.lang.Boolean
 */
public void setResultBoxed(java.lang.Boolean newResultBoxed) {
	resultBoxed = newResultBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:57:50)
 * @param newResultBroken java.lang.Boolean
 */
public void setResultBroken(java.lang.Boolean newResultBroken) {
	resultBroken = newResultBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:58:10)
 * @param newResultClosed java.lang.Boolean
 */
public void setResultClosed(java.lang.Boolean newResultClosed) {
	resultClosed = newResultClosed;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:53:47)
 * @param newSourceBoxed java.lang.Boolean
 */
public void setSourceBoxed(java.lang.Boolean newSourceBoxed) {
	sourceBoxed = newSourceBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:54:14)
 * @param newSourceBroken java.lang.Boolean
 */
public void setSourceBroken(java.lang.Boolean newSourceBroken) {
	sourceBroken = newSourceBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2002 9:57:01)
 * @param newSourceClosed java.lang.Boolean
 */
public void setSourceClosed(java.lang.Boolean newSourceClosed) {
	sourceClosed = newSourceClosed;
}
public void validateSerial(ActionErrors errors) throws Exception
{
/*
	if ( (serialnumber == null || "".equals(serialnumber))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalpos.serial"));
	}
	if(docqty.getBigDecimal().doubleValue() != 1.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.docqtyone"));
	}
	if(qty.getBigDecimal().doubleValue() != 1.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.qtylow"));
	}
	if (party != null && !"".equals(party)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.serialresource"));
	}
	if((serialnumber != null) && !"".equals(serialnumber)) {
		try {
			StorageCardAccessBean ab = new StorageCardAccessBean();
			StorageCardAccessBean card = ab.findBySerial(serialnumber);
			if( card.getResource().getResource() != resource.getInteger().intValue()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.diffresources"));
			}
			setOwnercode(new Integer(card.getOwner().getOrganization()));
			price.setBigDecimal(card.getPrice());
			setManufserial(card.getManufserial());
			setConfiguration(card.getConfiguration());
			setSourceBroken(card.getBroken());
			setSourceBoxed(card.getBoxed());
			setSourceClosed(card.getClosed());
		} catch(Exception e) {
//			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.serial"));
//			if (!errors.empty()) throw new ValidationException();
		}
	}
	if(DocumentPositionForm.hasSameSerial(serialnumber,document.getInteger(),docposition.getInteger())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
	}
*/
}
public java.lang.String getSerialnumber() {
	return serialnumber;
}
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
public java.lang.String getManufserial() {
	return manufserial;
}
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}

/**
 * @return
 */
public String getLocalserial() {
	return localserial;
}

/**
 * @param string
 */
public void setLocalserial(String string) {
	localserial = string;
}

	
/**
 * @return
 */
public boolean isSn_absent() {
	return sn_absent;
}

/**
 * @param b
 */
public void setSn_absent(boolean b) {
	sn_absent = b;
}

/**
 * @return
 */
public boolean isInv_absent() {
	return inv_absent;
}

/**
 * @return
 */
public boolean isLoc_absent() {
	return loc_absent;
}

/**
 * @param b
 */
public void setInv_absent(boolean b) {
	inv_absent = b;
}

/**
 * @param b
 */
public void setLoc_absent(boolean b) {
	loc_absent = b;
}

}

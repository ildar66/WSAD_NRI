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
 * Процессор внешних приходных накладных
 */
public class InWayBillProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 16:36:22)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException applyDocument(Integer argDocument) throws java.rmi.RemoteException {
	try {
		DocumentProcessingException err = new DocumentProcessingException();
		CurrencySumProcessingError cerr = new CurrencySumProcessingError();
		
		// Recalculate prices to base currency
		InWayBillPositionAccessBean dp = new InWayBillPositionAccessBean();
		Enumeration dps = dp.findDocPositionsByDocOrderByOrderAsc(argDocument);
		while (dps.hasMoreElements()) {
			InWayBillPositionAccessBean adp = (InWayBillPositionAccessBean)dps.nextElement();
			cerr = calcPrice(new Integer(adp.getDocposition()));
			if (cerr.getErrorCode() != 0) {
				err.setErrorCode(3);
				err.setCurErrorCode(cerr.getErrorCode());
				err.setErrorMessage(cerr.getMessage());
				err.setCurrency(cerr.getCurrency());
				err.setCurDate(cerr.getCurDate());
				err.setRateType(cerr.getRateType());
				return err;
			}
		}
		
		// Call document processor
		RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
		return processor.applyDocument(argDocument);
		
	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While processing InWayBill apply document.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2002 16:09:58)
 * @param argDocPosition com.hps.july.persistence.InWayBillPosition
 * @exception java.rmi.RemoteException The exception description.
 */
public CurrencySumProcessingError calcPrice(Integer argDocPosition) throws java.rmi.RemoteException {

	CurrencySumProcessingError err = new CurrencySumProcessingError();
	
	try {
		// Find position
		InWayBillPositionAccessBean inwbpos = new InWayBillPositionAccessBean();
		inwbpos.setInitKey_docposition(argDocPosition.intValue());
		inwbpos.refreshCopyHelper();

		// Recalculate sum
		Integer currency;
		Integer rateType;
		BigDecimal price;
		CurrencySumProcessorAccessBean currSumProcessor = new CurrencySumProcessorAccessBean();
		
		err = currSumProcessor.getBaseCurrency();
		if (err.getErrorCode() != 0)
			return err;
		else
			currency = err.getCurrency();
			
		err = currSumProcessor.getDefaultRateType();
		if (err.getErrorCode() != 0)
			return err;
		else
			rateType = err.getRateType();

		err = currSumProcessor.recalcSumToCurrency(
			new Integer(inwbpos.getOuterDocPosition().getInWayBill().getCurrency().getCurrency()),
			inwbpos.getSourcePrice(), 
			currency,
			inwbpos.getOuterDocPosition().getInWayBill().getBlankdate(),
			rateType );
		
		if (err.getErrorCode() != 0)
			return err;
		else
			price = err.getSum();		
		
		inwbpos.setPrice(price);
		inwbpos.commitCopyHelper();

		err.setErrorCode(0);

	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While calcPrice.", e );
	}
	return err;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 18:17:00)
 * @param actCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException cancelDocument( Integer argDocument ) throws java.rmi.RemoteException {

	try {
		// Call document processor
		RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
		return processor.cancelDocument(argDocument);
		
	}catch( Exception e ) {
		throw new java.rmi.RemoteException( "While cancelling InWayBill.", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2002 16:09:58)
 * @param argDocPosition com.hps.july.persistence.InWayBillPosition
 * @exception java.rmi.RemoteException The exception description.
 */
public void changeOuterDocPositionPrice(Integer argOuterDocPosition, BigDecimal argNewPrice) throws java.rmi.RemoteException {

	CurrencySumProcessingError err = new CurrencySumProcessingError();
	
	try {
		// Update corresponding DocPositions
		InWayBillPositionAccessBean inwbpos = new InWayBillPositionAccessBean();
		Enumeration dps = inwbpos.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(argOuterDocPosition.intValue()));
		while (dps.hasMoreElements()) {
			InWayBillPositionAccessBean dp = (InWayBillPositionAccessBean)dps.nextElement();
			dp.setSourcePrice(argNewPrice);
			dp.commitCopyHelper();
			err = calcPrice(new Integer(dp.getDocposition()));
			if (err.getErrorCode() != 0)
				throw err;
		}
			
	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While changeOuterDocPositionPrice.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2002 16:09:58)
 * @param argDocPosition com.hps.july.persistence.InWayBillPosition
 * @exception java.rmi.RemoteException The exception description.
 */
public void dropOuterDocPosition(Integer argOuterDocPosition) throws java.rmi.RemoteException {

	try {
		// Step 1 - remove corresponding DocPositions
		InWayBillPositionAccessBean inwbpos = new InWayBillPositionAccessBean();
		Enumeration dps = inwbpos.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(argOuterDocPosition.intValue()));
		while (dps.hasMoreElements()) {
			InWayBillPositionAccessBean dp = (InWayBillPositionAccessBean)dps.nextElement();
			dp.getEJBRef().remove();
		}
			
		// Step 2 - remove OuterDocPosition		
		OuterDocPositionAccessBean odp = new OuterDocPositionAccessBean();
		odp.setInitKey_outerDocPosition(argOuterDocPosition.intValue());
		odp.refreshCopyHelper();
		odp.getEJBRef().remove();

	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While dropOuterDocPosition.", e );
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
 * Updating serial & manuf code in documents.
 *   if serial=null  - no update
 *   if manufserial=null  - no update
 * Creation date: (07.08.2002 16:09:58)
 * @param argDocPosition com.hps.july.persistence.InWayBillPosition
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSerial(Integer argDocPosition, String newSerial, String newManufSerial) throws java.rmi.RemoteException {

	try {

		// Check if we already have the serial in another open card
		if (newSerial != null) {
			StorageCardAccessBean sc = new StorageCardAccessBean();
			try {
				sc = sc.findBySerial(newSerial);
				ProcessingPositionError err = new ProcessingPositionError();
				err.setErrorCode( ProcessingPositionError.ERRORS.CARD_ALREADY_EXISTS );
				err.setMessage( "StorageCard with specified serial already exists." );
				err.setPositionCode(argDocPosition.intValue());
				err.setSerial( newSerial );
				DocumentProcessingException ex = new DocumentProcessingException();
				ex.addError(err);
				throw ex;
			} catch (javax.ejb.ObjectNotFoundException e) {
			}
		}
		
		// Find position
		InWayBillPositionAccessBean inwbpos = new InWayBillPositionAccessBean();
		inwbpos.setInitKey_docposition(argDocPosition.intValue());
		inwbpos.refreshCopyHelper();
		if (newSerial != null)
			inwbpos.setSerialnumber(newSerial);
		if (newManufSerial != null)
			inwbpos.setManufserial(newManufSerial);
		inwbpos.commitCopyHelper();
		
		// Find card
		StorageCardAccessBean scrd = new StorageCardAccessBean();
		try {
			scrd.setInitKey_storagecard(inwbpos.getCardTo().getStoragecard());
			scrd.refreshCopyHelper();
			if (newSerial != null)
				scrd.setSerialnumber(newSerial);
			if (newManufSerial != null)
				scrd.setManufserial(newManufSerial);
			scrd.commitCopyHelper();
		} catch( javax.ejb.ObjectNotFoundException e ) {
			ProcessingPositionError err = new ProcessingPositionError();
			err.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
			err.setMessage( "No storagecard found." );
			err.setPositionCode(argDocPosition.intValue());
			DocumentProcessingException ex = new DocumentProcessingException();
			ex.addError(err);
			throw ex;
		}
		
	}catch( Exception e ) {
		throw new java.rmi.RemoteException( "While setSerial.", e );
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

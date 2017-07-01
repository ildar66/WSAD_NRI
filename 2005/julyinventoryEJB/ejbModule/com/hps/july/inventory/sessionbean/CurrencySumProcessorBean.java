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
 * Процессор сумм в разных валютах
 */
public class CurrencySumProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

	private static java.lang.Integer baseCurrency;
	private final static java.lang.String BASE_CURRENCY = "BASE_CURRENCY";
	private final static java.lang.String DEFAULT_RATE = "DEFAULT_RATE";
	private java.lang.Integer defaultRateType;
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
 * Creation date: (07.08.2002 17:36:45)
 * @return java.lang.Integer
 */
public CurrencySumProcessingError getBaseCurrency() throws java.rmi.RemoteException {
	CurrencySumProcessingError err = new CurrencySumProcessingError();
	try {
		if (baseCurrency == null) {
			NamedValueAccessBean nval = new NamedValueAccessBean();
			nval.setInitKey_id(BASE_CURRENCY);
			try {
				nval.refreshCopyHelper();
				baseCurrency = new Integer(nval.getIntvalue());
			} catch (Exception e) {
				System.out.println("Error while getting base currency = namedvalues with id:" + BASE_CURRENCY);
				err.setErrorCode( CurrencySumProcessingError.ERRORS.NO_BASE_CURRENCY );
				err.setMessage( "Cannot find requested rate type: " + BASE_CURRENCY  );
				return err;
			}
		}
		err.setErrorCode(0);
		err.setCurrency(baseCurrency);
	} catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While getBaseCurrency.", e );
	}
	return err;
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2002 20:10:54)
 * @return java.lang.Integer
 */
public CurrencySumProcessingError getDefaultRateType() throws java.rmi.RemoteException {

	CurrencySumProcessingError err = new CurrencySumProcessingError();
	try {	
		if (defaultRateType == null) {
			NamedValueAccessBean nval = new NamedValueAccessBean();
			nval.setInitKey_id(DEFAULT_RATE);
			try {
				nval.refreshCopyHelper();
				defaultRateType = new Integer(nval.getIntvalue());
			} catch (Exception e) {
				System.out.println("Error while getting default rate = namedvalues with id:" + DEFAULT_RATE);
				err.setErrorCode( CurrencySumProcessingError.ERRORS.NO_BASE_RATE_TYPE );
				err.setMessage( "Cannot find requested rate type: " + DEFAULT_RATE  );
				return err;
			}
		}
		err.setErrorCode(0);
		err.setRateType(defaultRateType);
	} catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While getDefaultRateType.", e );
	}
	return err;
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
 * Creation date: (07.08.2002 18:00:55)
 * @return java.math.BigDecimal
 * @param sourceCurrency java.lang.Integer
 * @param sourceSum java.math.BigDecimal
 * @param destCurrency java.lang.Integer
 * @param curDate java.util.Date
 * @exception java.rmi.RemoteException The exception description.
 */
public CurrencySumProcessingError recalcSumToCurrency(Integer sourceCurrency, BigDecimal sourceSum, Integer destCurrency, java.sql.Date currencyDate, Integer currencyRateType) throws java.rmi.RemoteException {

	CurrencySumProcessingError err = new CurrencySumProcessingError();
	BigDecimal destSum;

	try {
		// Check for simple cases
		if (sourceCurrency.intValue() == destCurrency.intValue())
			destSum = sourceSum;
		else if (sourceSum.equals(new BigDecimal(0)))
			destSum = sourceSum;
		else {
			// Check if BaseCurrency for RateType equals DestCurrency (we'll need double conversion)
			RateTypeAccessBean rtp = new RateTypeAccessBean();
			try {
				rtp.setInitKey_ratetype(currencyRateType.intValue());
				rtp.refreshCopyHelper();
			} catch (Exception e) {
				err.setErrorCode( CurrencySumProcessingError.ERRORS.BAD_RATE_TYPE );
				err.setMessage( "Cannot find requested rate type." );
				err.setRateType(currencyRateType);
				return err;
			}

			BigDecimal sourceRate;
			BigDecimal destRate;
			
			// Determine source rate
			if (rtp.getBasecurrency().getCurrency() == sourceCurrency.intValue())
				sourceRate = new BigDecimal(1);
			else {
				try {
					RateAccessBean srt = new RateAccessBean();
					srt = srt.findByTypeCurrencyForDate(currencyRateType, sourceCurrency, currencyDate);
					sourceRate = srt.getValue();
				} catch (javax.ejb.ObjectNotFoundException ex) {
					err.setErrorCode( CurrencySumProcessingError.ERRORS.BAD_RATE );
					err.setMessage( "Cannot find source rate." );
					err.setRateType(currencyRateType);
					err.setCurrency(sourceCurrency);
					err.setCurDate(currencyDate);
					return err;
				}
			}
			
			// Determine dest rate
			if (rtp.getBasecurrency().getCurrency() == destCurrency.intValue())
				destRate = new BigDecimal(1);
			else {
				try {
					RateAccessBean drt = new RateAccessBean();
					drt = drt.findByTypeCurrencyForDate(currencyRateType, destCurrency, currencyDate);
					destRate = drt.getValue();
				} catch (javax.ejb.ObjectNotFoundException ex) {
					err.setErrorCode( CurrencySumProcessingError.ERRORS.BAD_RATE );
					err.setMessage( "Cannot find destination rate." );
					err.setRateType(currencyRateType);
					err.setCurrency(sourceCurrency);
					err.setCurDate(currencyDate);
					return err;
				}
			}

			// Calculate value
			destSum = sourceSum.multiply(sourceRate).divide(destRate, BigDecimal.ROUND_DOWN);
		}
	
	} catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While calcPrice.", e );
	}
	
	err.setErrorCode(0);
	err.setSum(destSum);
	return err;
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

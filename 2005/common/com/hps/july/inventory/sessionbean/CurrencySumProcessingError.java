package com.hps.july.inventory.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (30.05.2002 13:36:17)
 * @author: Oleg Gashnikov
 */
public class CurrencySumProcessingError extends java.lang.Exception implements java.io.Serializable {
	private int errorCode;
	private java.lang.String message;
	public static class ERRORS {
		public static final int BAD_RATE_TYPE 		= 1;
		public static final int BAD_RATE 			= 2;
		public static final int NO_BASE_CURRENCY 	= 3;
		public static final int NO_BASE_RATE_TYPE 		= 4;
	}
	private java.lang.Integer rateType;
	private java.lang.Integer currency;
	private java.util.Date curDate;
	private java.math.BigDecimal rate;
	private java.math.BigDecimal sum;
/**
 * Insert the method's description here.
 * Creation date: (02.09.2002 12:02:44)
 * @return java.util.Date
 */
public java.util.Date getCurDate() {
	return curDate;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2002 12:02:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:53:37)
 * @return int
 */
public int getErrorCode() {
	return errorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:54:00)
 * @return java.lang.String
 */
public java.lang.String getMessage() {
	return message;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 19:37:39)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2002 12:02:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getRateType() {
	return rateType;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 19:48:02)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:10:00)
 * @param out java.io.PrintWriter
 */
public void print(java.io.PrintWriter out) {
	out.println( "Error code 	\t\t="+errorCode );
	out.println( "Error msg 	\t\t="+message );
	out.println( "Rate Type 	\t\t="+rateType );
	out.println( "Currency  	\t\t="+currency );
	out.println( "Cur Date		\t\t="+curDate );
	}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2002 12:02:44)
 * @param newCurDate java.util.Date
 */
public void setCurDate(java.util.Date newCurDate) {
	curDate = newCurDate;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2002 12:02:21)
 * @param newCurrency java.lang.Integer
 */
public void setCurrency(java.lang.Integer newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:53:37)
 * @param newErrorCode int
 */
public void setErrorCode(int newErrorCode) {
	errorCode = newErrorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:54:00)
 * @param newMessage java.lang.String
 */
public void setMessage(java.lang.String newMessage) {
	message = newMessage;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 19:37:39)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate = newRate;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2002 12:02:05)
 * @param newRateType java.lang.Integer
 */
public void setRateType(java.lang.Integer newRateType) {
	rateType = newRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 19:48:02)
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum = newSum;
}
}

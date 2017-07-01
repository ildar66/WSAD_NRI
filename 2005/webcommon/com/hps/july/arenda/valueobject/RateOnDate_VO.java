package com.hps.july.arenda.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (22.06.2005 17:03:05)
 * @author: Shafigullin Ildar
 */
public class RateOnDate_VO {
	private java.math.BigDecimal rate;
	private java.sql.Date onDate;
	private java.sql.Date fromDate;
/**
 * RateOnDate_VO constructor comment.
 */
public RateOnDate_VO(java.sql.Date iFromDate, java.sql.Date iOnDate, java.math.BigDecimal iRate) {
	super();
	this.fromDate=iFromDate;
	this.onDate = iOnDate;
	this.rate = iRate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:04:36)
 * @return java.sql.Date
 */
public java.sql.Date getFromDate() {
	return fromDate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:04:14)
 * @return java.sql.Date
 */
public java.sql.Date getOnDate() {
	return onDate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:03:32)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:04:36)
 * @param newFromDate java.sql.Date
 */
public void setFromDate(java.sql.Date newFromDate) {
	fromDate = newFromDate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:04:14)
 * @param newOnDate java.sql.Date
 */
public void setOnDate(java.sql.Date newOnDate) {
	onDate = newOnDate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:03:32)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate = newRate;
}
}

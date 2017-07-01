package com.hps.july.persistence;

public class LeaseCalcRateKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer docposition_leaseDocPosition;
	public java.lang.Integer currency_currency;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseCalcRateKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDocposition com.hps.july.persistence.LeaseDocPositionKey
 * @param argCurrency com.hps.july.persistence.CurrencyKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseCalcRateKey(LeaseDocPositionKey argDocposition, CurrencyKey argCurrency) {
	privateSetDocpositionKey(argDocposition);
	privateSetCurrencyKey(argCurrency);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseCalcRateKey) {
		LeaseCalcRateKey otherKey = (LeaseCalcRateKey) o;
		return ((this.docposition_leaseDocPosition.equals(otherKey.docposition_leaseDocPosition)
		 && this.currency_currency.equals(otherKey.currency_currency)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.CurrencyKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrencyKey() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean currency_NULLTEST = true;
	currency_NULLTEST &= (currency_currency == null);
	temp.currency = ((currency_currency == null) ? 0 : currency_currency.intValue());
	if (currency_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPositionKey getDocpositionKey() {
	com.hps.july.persistence.LeaseDocPositionKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocPositionKey();
	boolean docposition_NULLTEST = true;
	docposition_NULLTEST &= (docposition_leaseDocPosition == null);
	temp.leaseDocPosition = ((docposition_leaseDocPosition == null) ? 0 : docposition_leaseDocPosition.intValue());
	if (docposition_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (docposition_leaseDocPosition.hashCode()
		 + currency_currency.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.CurrencyKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean currency_NULLTEST = (inKey == null);
	if (currency_NULLTEST) currency_currency = null; else currency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDocpositionKey(com.hps.july.persistence.LeaseDocPositionKey inKey) {
	boolean docposition_NULLTEST = (inKey == null);
	if (docposition_NULLTEST) docposition_leaseDocPosition = null; else docposition_leaseDocPosition = (new Integer(inKey.leaseDocPosition));
}
}

package com.hps.july.persistence;

public class RateKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer currency_currency;
	public java.lang.Integer type_ratetype;
	public java.sql.Date date;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RateKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argCurrency com.hps.july.persistence.CurrencyKey
 * @param argType com.hps.july.persistence.RateTypeKey
 * @param argDate java.sql.Date
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RateKey(CurrencyKey argCurrency, RateTypeKey argType, java.sql.Date argDate) {
	privateSetCurrencyKey(argCurrency);
	privateSetTypeKey(argType);
	date = argDate;
}
/**
 * Initialize a key from the passed values
 * @param argDate java.util.Date
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RateKey(java.sql.Date argDate) {
	date = argDate;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof RateKey) {
		RateKey otherKey = (RateKey) o;
		return ((this.currency_currency.equals(otherKey.currency_currency)
		 && this.type_ratetype.equals(otherKey.type_ratetype)
		 && this.date.equals(otherKey.date)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named Rate2Currency.  
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
 * This method was generated for supporting the association named Rates2RateType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.RateTypeKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.RateTypeKey getTypeKey() {
	com.hps.july.persistence.RateTypeKey temp = null;
	temp = new com.hps.july.persistence.RateTypeKey();
	boolean type_NULLTEST = true;
	type_NULLTEST &= (type_ratetype == null);
	temp.ratetype = ((type_ratetype == null) ? 0 : type_ratetype.intValue());
	if (type_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (currency_currency.hashCode()
		 + type_ratetype.hashCode()
		 + date.hashCode());
}
/**
 * This method was generated for supporting the association named Rate2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.CurrencyKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean currency_NULLTEST = (inKey == null);
	if (currency_NULLTEST) currency_currency = null; else currency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named Rates2RateType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.RateTypeKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetTypeKey(com.hps.july.persistence.RateTypeKey inKey) {
	boolean type_NULLTEST = (inKey == null);
	if (type_NULLTEST) type_ratetype = null; else type_ratetype = (new Integer(inKey.ratetype));
}
}

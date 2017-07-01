package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
import java.sql.*;
import java.math.*;
/**
* контейнер "Позиции документов".
* Creation date: (15.04.2004 13:56:58)
* @author: Shafigullin Ildar
*/
public class LeaseDocPositionVO {
	private java.lang.Integer leaseDocPosition;
	private ResourceVO resource; //Ресурс
	private java.lang.String source; //Источник получения позиции
	private java.math.BigDecimal summ; //Сумма с НДС
	private CurrencyVO currency; //Валюта
	private Date begindate; //Дата начала периода за который начисление/платеж
	private java.sql.Date enddate; //Дата конца периода за который начисление/платеж
	private java.sql.Date date; //Дата
	private BigDecimal sumnds;//НДС
	private java.math.BigDecimal rate;
	private Integer usedInAct;
/**
 * LeaseDocPositionVO constructor comment.
 */
public LeaseDocPositionVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super();
	leaseDocPosition = (Integer) ro.getColumn("leasedocposition").asObject();
	initResource(ro);
	initCurrency(ro);
	setSource(ro.getColumn("source").asString());
	setSumm((java.math.BigDecimal)ro.getColumn("summ").asObject());
	setBegindate((Date)ro.getColumn("begindate").asObject());
	setEnddate((Date)ro.getColumn("enddate").asObject());
	setDate((Date)ro.getColumn("date").asObject());
	setSumnds((java.math.BigDecimal)ro.getColumn("sumnds").asObject());
	setUsedInAct((Integer)ro.getColumn("usedinact").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:30:23)
 * @return java.sql.Date
 */
public java.sql.Date getBegindate() {
	return begindate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:24:45)
 * @return com.hps.july.arenda.valueobject.CurrencyVO
 */
public CurrencyVO getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:36:12)
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:30:44)
 * @return java.sql.Date
 */
public java.sql.Date getEnddate() {
	return enddate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:00:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseDocPosition() {
	return leaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (17.11.2004 12:56:08)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:09:10) 
 * @return com.hps.july.arenda.valueobject.ResourceVO
 */
public ResourceVO getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:17:41)
 * @return java.lang.String
 */
public java.lang.String getSource() {
	return source;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:17:43)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm() {
	return summ;
}
/**
 * Insert the method's description here.
 * Creation date: (17.11.2004 12:01:28)
 * @return java.math.BigDecimal
 */
public BigDecimal getSumnds() {
	return sumnds;
}
/**
 * Creation date: (15.04.2004 16:22:10)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initCurrency(CDBCRowObject ro) {
	if (ro.getColumn("currency").asObject() != null) {
		CurrencyVO curr = new CurrencyVO((Integer) ro.getColumn("currency").asObject());
		curr.setShortname(ro.getColumn("curname").asString());
		setCurrency(curr);
	}
}
/**
 * Creation date: (15.04.2004 14:10:52)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initResource(CDBCRowObject ro) {
	if (ro.getColumn("resource").asObject() != null) {
		ResourceVO resource = new ResourceVO((Integer) ro.getColumn("resource").asObject());
		resource.setName(ro.getColumn("resname").asString());
		setResource(resource);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:30:23)
 * @param newBegindate java.sql.Date
 */
public void setBegindate(java.sql.Date newBegindate) {
	begindate = newBegindate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:24:45)
 * @param newCurrency com.hps.july.arenda.valueobject.CurrencyVO
 */
public void setCurrency(CurrencyVO newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:36:12)
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date = newDate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:30:44)
 * @param newEnddate java.sql.Date
 */
public void setEnddate(java.sql.Date newEnddate) {
	enddate = newEnddate;
}
/**
 * Insert the method's description here.
 * Creation date: (17.11.2004 12:56:08)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate = newRate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:09:10)
 * @param newResource com.hps.july.arenda.valueobject.ResourceVO
 */
public void setResource(ResourceVO newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 14:17:41)
 * @param newSource java.lang.String
 */
public void setSource(java.lang.String newSource) {
	source = newSource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.04.2004 16:17:43)
 * @param newSumm java.math.BigDecimal
 */
public void setSumm(java.math.BigDecimal newSumm) {
	summ = newSumm;
}
/**
 * Insert the method's description here.
 * Creation date: (17.11.2004 12:01:28)
 * @param newSumnds java.math.BigDecimal
 */
public void setSumnds(BigDecimal newSumnds) {
	sumnds = newSumnds;
}
	/**
	 * @return
	 */
	public Integer getUsedInAct() {
		return usedInAct;
	}

	/**
	 * @param Integer
	 */
	public void setUsedInAct(Integer aUsedInAct) {
		usedInAct = aUsedInAct;
	}

}

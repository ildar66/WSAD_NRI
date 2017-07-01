package com.hps.july.arenda.valueobject;

import java.math.*;
import java.sql.*;
/**
* Контейнер "печати конечной задолженностей актов"
* Creation date: (09.12.2003 17:42:15)
* @author: Shafigullin Ildar
*/
public class MutualEndDebtValueObject {
	private java.lang.String customer; //наименование заказчика
	private java.lang.String executor; //наименование исполнителя
	private java.lang.String resName; //услуга
	private java.lang.String contractNumber; //номер договора
	private java.sql.Date contractDate; //дата договора
	private BigDecimal sumMain; //конечная сумма сальдо в основной валюте
	private java.math.BigDecimal ndsMain; //конечная сумма ндс в основной валюте
	private java.lang.String currMain; //основная валюта акта
	private java.math.BigDecimal sumDop; //конечная сумма сальдо в доп. валюте
	private java.math.BigDecimal ndsDop; //конечная сумма НДС сальдо в доп. валюте
	private java.lang.String currDop; //дополнительная валюта акта
	private Date dateStartAkt; //дата начала акта
	private java.sql.Date dateEndAkt; //дата окончания акта
	private java.lang.Integer headerId; //Порядковый номер  принадлежность HEADER
	private BigDecimal sumWithoutMain; //конечная сумма без НДС в основной валюте
	/**
	 * MutualEndDebtValueObject constructor comment.
	 */
	public MutualEndDebtValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:45:06)
	 * @return java.lang.String
	 */
	public java.sql.Date getContractDate() {
		return contractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:44:46)
	 * @return java.lang.String
	 */
	public java.lang.String getContractNumber() {
		return contractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:50:31)
	 * @return java.lang.String
	 */
	public java.lang.String getCurrDop() {
		return currDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:48:55)
	 * @return java.lang.String
	 */
	public java.lang.String getCurrMain() {
		return currMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:43:29)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomer() {
		return customer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:51:21)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateEndAkt() {
		return dateEndAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:50:56)
	 * @return java.sql.Date
	 */
	public Date getDateStartAkt() {
		return dateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:44:06)
	 * @return java.lang.String
	 */
	public java.lang.String getExecutor() {
		return executor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:18:47)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getHeaderId() {
		return headerId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:50:08)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsDop() {
		return ndsDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:48:23)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsMain() {
		return ndsMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:44:26)
	 * @return java.lang.String
	 */
	public java.lang.String getResName() {
		return resName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:49:40)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumDop() {
		return sumDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:47:57)
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getSumMain() {
		return sumMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:45:06)
	 * @param newContractDate java.lang.String
	 */
	public void setContractDate(java.sql.Date newContractDate) {
		contractDate = newContractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:44:46)
	 * @param newContractNumber java.lang.String
	 */
	public void setContractNumber(java.lang.String newContractNumber) {
		contractNumber = newContractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:50:31)
	 * @param newCurrDop java.lang.String
	 */
	public void setCurrDop(java.lang.String newCurrDop) {
		currDop = newCurrDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:48:55)
	 * @param newCurrMain java.lang.String
	 */
	public void setCurrMain(java.lang.String newCurrMain) {
		currMain = newCurrMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:43:29)
	 * @param newCustomer java.lang.String
	 */
	public void setCustomer(java.lang.String newCustomer) {
		customer = newCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:51:21)
	 * @param newDateEndAkt java.sql.Date
	 */
	public void setDateEndAkt(java.sql.Date newDateEndAkt) {
		dateEndAkt = newDateEndAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:50:56)
	 * @param newDateStartAkt java.sql.Date
	 */
	public void setDateStartAkt(Date newDateStartAkt) {
		dateStartAkt = newDateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:44:06)
	 * @param newExecutor java.lang.String
	 */
	public void setExecutor(java.lang.String newExecutor) {
		executor = newExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:18:47)
	 * @param newHeaderId java.lang.Integer
	 */
	public void setHeaderId(java.lang.Integer newHeaderId) {
		headerId = newHeaderId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:50:08)
	 * @param newNdsDop java.math.BigDecimal
	 */
	public void setNdsDop(java.math.BigDecimal newNdsDop) {
		ndsDop = newNdsDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:48:23)
	 * @param newNdsMain java.math.BigDecimal
	 */
	public void setNdsMain(java.math.BigDecimal newNdsMain) {
		ndsMain = newNdsMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:44:26)
	 * @param newResName java.lang.String
	 */
	public void setResName(java.lang.String newResName) {
		resName = newResName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:49:40)
	 * @param newSumDop java.math.BigDecimal
	 */
	public void setSumDop(java.math.BigDecimal newSumDop) {
		sumDop = newSumDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:47:57)
	 * @param newSumMain java.math.BigDecimal
	 */
	public void setSumMain(BigDecimal newSumMain) {
		sumMain = newSumMain;
	}
	/**
	 * @return
	 */
	public BigDecimal getSumWithoutMain() {
		return sumWithoutMain;
	}

	/**
	 * @param decimal
	 */
	public void setSumWithoutMain(BigDecimal decimal) {
		sumWithoutMain = decimal;
	}

}

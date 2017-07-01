package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
/**
* Контейнер "начальной задолженности  актов"
* Creation date: (08.12.2003 16:52:47)
* @author: Shafigullin Ildar
*/
public class MutualStartDebtValueObject {
	private java.lang.String resname; //услуга 
	private java.lang.String contractNumber; //номер договора
	private Date contractDate; //дата договора
	private java.lang.String numberAct; //номер акта
	private java.sql.Date dateAct; //дата акта
	private BigDecimal summ; //сумма сальдо
	private java.lang.String cur; //валюта сальдо
	private java.math.BigDecimal summain; //сумма сальдо в основной валюте акта
	private java.lang.String customer; //наименовнаие заказчика
	private java.lang.String executor; //наименовнаие исполнителя    
	private java.lang.String currMain; //основная валюта акта
	private java.sql.Date dateStartAkt; //дата начала акта
	private java.lang.Integer headerId; //Порядковый номер  принадлежность HEADER
	private BigDecimal nds; //ндс сальдо в валюте сальдо
	private BigDecimal ndsRub; //ндс сальдо в основной валюте акта
	private BigDecimal sumWithoutMain; //конечная сумма без НДС в основной валюте
	/**
	 * MutualStartDebtValueObject constructor comment.
	 */
	public MutualStartDebtValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:00:26)
	 * @return java.sql.Date
	 */
	public Date getContractDate() {
		return contractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 16:59:29)
	 * @return java.lang.String
	 */
	public java.lang.String getContractNumber() {
		return contractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:03:50)
	 * @return java.lang.String
	 */
	public java.lang.String getCur() {
		return cur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:26:29)
	 * @return java.lang.String
	 */
	public java.lang.String getCurrMain() {
		return currMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:23:40)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomer() {
		return customer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:01:47)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateAct() {
		return dateAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:27:30)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateStartAkt() {
		return dateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:24:04)
	 * @return java.lang.String
	 */
	public java.lang.String getExecutor() {
		return executor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:19:58)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getHeaderId() {
		return headerId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:01:05)
	 * @return java.lang.String
	 */
	public java.lang.String getNumberAct() {
		return numberAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 16:57:46)
	 * @return java.lang.String
	 */
	public java.lang.String getResname() {
		return resname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:03:27)
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getSumm() {
		return summ;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:04:40)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSummain() {
		return summain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:00:26)
	 * @param newContractDate java.sql.Date
	 */
	public void setContractDate(Date newContractDate) {
		contractDate = newContractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 16:59:29)
	 * @param newContractNumber java.lang.String
	 */
	public void setContractNumber(java.lang.String newContractNumber) {
		contractNumber = newContractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:03:50)
	 * @param newCur java.lang.String
	 */
	public void setCur(java.lang.String newCur) {
		cur = newCur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:26:29)
	 * @param newCurrMain java.lang.String
	 */
	public void setCurrMain(java.lang.String newCurrMain) {
		currMain = newCurrMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:23:40)
	 * @param newCustomer java.lang.String
	 */
	public void setCustomer(java.lang.String newCustomer) {
		customer = newCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:01:47)
	 * @param newDateAct java.sql.Date
	 */
	public void setDateAct(java.sql.Date newDateAct) {
		dateAct = newDateAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:27:30)
	 * @param newDateStartAkt java.sql.Date
	 */
	public void setDateStartAkt(java.sql.Date newDateStartAkt) {
		dateStartAkt = newDateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2003 10:24:04)
	 * @param newExecutor java.lang.String
	 */
	public void setExecutor(java.lang.String newExecutor) {
		executor = newExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:19:58)
	 * @param newHeaderId java.lang.Integer
	 */
	public void setHeaderId(java.lang.Integer newHeaderId) {
		headerId = newHeaderId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:01:05)
	 * @param newNumberAct java.lang.String
	 */
	public void setNumberAct(java.lang.String newNumberAct) {
		numberAct = newNumberAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 16:57:46)
	 * @param newResname java.lang.String
	 */
	public void setResname(java.lang.String newResname) {
		resname = newResname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:03:27)
	 * @param newSumm java.math.BigDecimal
	 */
	public void setSumm(BigDecimal newSumm) {
		summ = newSumm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 17:04:40)
	 * @param newSummain java.math.BigDecimal
	 */
	public void setSummain(java.math.BigDecimal newSummain) {
		summain = newSummain;
	}
	/**
	 * @return
	 */
	public BigDecimal getNds() {
		return nds;
	}

	/**
	 * @return
	 */
	public BigDecimal getNdsRub() {
		return ndsRub;
	}

	/**
	 * @param decimal
	 */
	public void setNds(BigDecimal decimal) {
		nds = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNdsRub(BigDecimal decimal) {
		ndsRub = decimal;
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

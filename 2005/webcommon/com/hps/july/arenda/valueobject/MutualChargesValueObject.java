package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
/**
* Контейнер "начислений".
* список начислений по договорам и услугам, участвующим в акте (взаимозачета, зачета взаимных требований)
* для печати акта.
* Creation date: (09.12.2003 16:50:30)
* @author: Shafigullin Ildar
*/
public class MutualChargesValueObject {
	private java.lang.Integer codeAkt; //код акта 
	private java.lang.Integer codeContract; //код договора 
	private java.lang.Integer codeResource; // код услуги 
	private java.lang.String customer; //наименование заказчика 
	private java.lang.String executor; //наименование исполнителя 
	private java.lang.String resName; //наименование услуги 
	private java.lang.String contractNumber; //номер договора 
	private Date contractDate; //дата договора 
	private java.lang.String billNumber; //номер счета 
	private java.sql.Date billDate; // дата счета 
	private java.sql.Date dateCharge; //дата начисления 
	private java.sql.Date dateStart; //дата начала 
	private java.sql.Date dateEnd; // дата окончания 
	private BigDecimal sumContract; //сумма договора 
	private java.math.BigDecimal ndsContract; //НДС договора 
	private java.lang.String currContract; //валюта договора 
	private java.math.BigDecimal rateContract; //курс к валюте договора 
	private java.math.BigDecimal sumRub; //сумма в рублях 
	private java.math.BigDecimal ndsRub; //НДС в рублях 
	private java.lang.String mainCurr; //основная валюта акта
	private java.math.BigDecimal rateMainCurr; //курс рубля к основной валюте акта
	private java.math.BigDecimal sumMainCurr; //сумма в основной валюте акта
	private java.math.BigDecimal ndsMainCurr; //НДС в основной валюте акта
	private java.lang.String dopCurr; //доп. валюта акта
	private java.math.BigDecimal rateDopCurr; //курс рубля к доп. валюте акта 
	private java.math.BigDecimal sumDopCurr; //сумма в доп. валюте акта   
	private java.math.BigDecimal ndsDopCurr; //НДС в доп. валюте акта 
	private java.lang.Integer isCustomerBeeline; //Признак того, что заказчик Beeline
	private java.math.BigDecimal sumRubDifference; // сумма курсовой разницы
	private java.lang.Integer headerId; //Порядковый номер  принадлежность HEADER
	private BigDecimal sumWithoutMain; // сумма без НДС  в валюте акта
	/**
	 * MutualChargesValueObject constructor comment.
	 */
	public MutualChargesValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:02:06)
	 * @return java.sql.Date
	 */
	public java.sql.Date getBillDate() {
		return billDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:01:26)
	 * @return java.lang.String
	 */
	public java.lang.String getBillNumber() {
		return billNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:56:18)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeAkt() {
		return codeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:57:31)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeContract() {
		return codeContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:58:12)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeResource() {
		return codeResource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:01:03)
	 * @return java.sql.Date
	 */
	public Date getContractDate() {
		return contractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:00:37)
	 * @return java.lang.String
	 */
	public java.lang.String getContractNumber() {
		return contractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:05:27)
	 * @return java.lang.String
	 */
	public java.lang.String getCurrContract() {
		return currContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:58:39)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomer() {
		return customer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:02:52)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateCharge() {
		return dateCharge;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:03:40)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateEnd() {
		return dateEnd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:03:18)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateStart() {
		return dateStart;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:10:10)
	 * @return java.lang.String
	 */
	public java.lang.String getDopCurr() {
		return dopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:59:07)
	 * @return java.lang.String
	 */
	public java.lang.String getExecutor() {
		return executor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:19:10)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getHeaderId() {
		return headerId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:11:55)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIsCustomerBeeline() {
		return isCustomerBeeline;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:08:03)
	 * @return java.lang.String
	 */
	public java.lang.String getMainCurr() {
		return mainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:05:02)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsContract() {
		return ndsContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:11:28)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsDopCurr() {
		return ndsDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:09:28)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsMainCurr() {
		return ndsMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:07:35)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsRub() {
		return ndsRub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:05:52)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRateContract() {
		return rateContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:10:32)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRateDopCurr() {
		return rateDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:08:28)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRateMainCurr() {
		return rateMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:59:55)
	 * @return java.lang.String
	 */
	public java.lang.String getResName() {
		return resName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:04:23)
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getSumContract() {
		return sumContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:10:57)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumDopCurr() {
		return sumDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:08:59)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumMainCurr() {
		return sumMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:06:14)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumRub() {
		return sumRub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:12:28)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumRubDifference() {
		return sumRubDifference;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:02:06)
	 * @param newBillDate java.sql.Date
	 */
	public void setBillDate(java.sql.Date newBillDate) {
		billDate = newBillDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:01:26)
	 * @param newBillNumber java.lang.String
	 */
	public void setBillNumber(java.lang.String newBillNumber) {
		billNumber = newBillNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:56:18)
	 * @param newCodeAkt java.lang.Integer
	 */
	public void setCodeAkt(java.lang.Integer newCodeAkt) {
		codeAkt = newCodeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:57:31)
	 * @param newCodeContract java.lang.Integer
	 */
	public void setCodeContract(java.lang.Integer newCodeContract) {
		codeContract = newCodeContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:58:12)
	 * @param newCodeResource java.lang.Integer
	 */
	public void setCodeResource(java.lang.Integer newCodeResource) {
		codeResource = newCodeResource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:01:03)
	 * @param newContractDate java.sql.Date
	 */
	public void setContractDate(Date newContractDate) {
		contractDate = newContractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:00:37)
	 * @param newContractNumber java.lang.String
	 */
	public void setContractNumber(java.lang.String newContractNumber) {
		contractNumber = newContractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:05:27)
	 * @param newCurrContract java.lang.String
	 */
	public void setCurrContract(java.lang.String newCurrContract) {
		currContract = newCurrContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:58:39)
	 * @param newCustomer java.lang.String
	 */
	public void setCustomer(java.lang.String newCustomer) {
		customer = newCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:02:52)
	 * @param newDateCharge java.sql.Date
	 */
	public void setDateCharge(java.sql.Date newDateCharge) {
		dateCharge = newDateCharge;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:03:40)
	 * @param newDateEnd java.sql.Date
	 */
	public void setDateEnd(java.sql.Date newDateEnd) {
		dateEnd = newDateEnd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:03:18)
	 * @param newDateStart java.sql.Date
	 */
	public void setDateStart(java.sql.Date newDateStart) {
		dateStart = newDateStart;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:10:10)
	 * @param newDopCurr java.lang.String
	 */
	public void setDopCurr(java.lang.String newDopCurr) {
		dopCurr = newDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:59:07)
	 * @param newExecutor java.lang.String
	 */
	public void setExecutor(java.lang.String newExecutor) {
		executor = newExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:19:10)
	 * @param newHeaderId java.lang.Integer
	 */
	public void setHeaderId(java.lang.Integer newHeaderId) {
		headerId = newHeaderId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:11:55)
	 * @param newIsCustomerBeeline java.lang.Integer
	 */
	public void setIsCustomerBeeline(java.lang.Integer newIsCustomerBeeline) {
		isCustomerBeeline = newIsCustomerBeeline;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:08:03)
	 * @param newMainCurr java.lang.String
	 */
	public void setMainCurr(java.lang.String newMainCurr) {
		mainCurr = newMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:05:02)
	 * @param newNdsContract java.math.BigDecimal
	 */
	public void setNdsContract(java.math.BigDecimal newNdsContract) {
		ndsContract = newNdsContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:11:28)
	 * @param newNdsDopCurr java.math.BigDecimal
	 */
	public void setNdsDopCurr(java.math.BigDecimal newNdsDopCurr) {
		ndsDopCurr = newNdsDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:09:28)
	 * @param newNdsMainCurr java.math.BigDecimal
	 */
	public void setNdsMainCurr(java.math.BigDecimal newNdsMainCurr) {
		ndsMainCurr = newNdsMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:07:35)
	 * @param newNdsRub java.math.BigDecimal
	 */
	public void setNdsRub(java.math.BigDecimal newNdsRub) {
		ndsRub = newNdsRub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:05:52)
	 * @param newRateContract java.math.BigDecimal
	 */
	public void setRateContract(java.math.BigDecimal newRateContract) {
		rateContract = newRateContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:10:32)
	 * @param newRateDopCurr java.math.BigDecimal
	 */
	public void setRateDopCurr(java.math.BigDecimal newRateDopCurr) {
		rateDopCurr = newRateDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:08:28)
	 * @param newRateMainCurr java.math.BigDecimal
	 */
	public void setRateMainCurr(java.math.BigDecimal newRateMainCurr) {
		rateMainCurr = newRateMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 16:59:55)
	 * @param newResName java.lang.String
	 */
	public void setResName(java.lang.String newResName) {
		resName = newResName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:04:23)
	 * @param newSumContract java.math.BigDecimal
	 */
	public void setSumContract(BigDecimal newSumContract) {
		sumContract = newSumContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:10:57)
	 * @param newSumDopCurr java.math.BigDecimal
	 */
	public void setSumDopCurr(java.math.BigDecimal newSumDopCurr) {
		sumDopCurr = newSumDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:08:59)
	 * @param newSumMainCurr java.math.BigDecimal
	 */
	public void setSumMainCurr(java.math.BigDecimal newSumMainCurr) {
		sumMainCurr = newSumMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:06:14)
	 * @param newSumRub java.math.BigDecimal
	 */
	public void setSumRub(java.math.BigDecimal newSumRub) {
		sumRub = newSumRub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:12:28)
	 * @param newSumRubDifference java.math.BigDecimal
	 */
	public void setSumRubDifference(java.math.BigDecimal newSumRubDifference) {
		sumRubDifference = newSumRubDifference;
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

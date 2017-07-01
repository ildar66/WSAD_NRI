package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
/**
* Контейнер "платежей".
* Cписок начислений по договорам и услугам, участвующим в акте 
* (взаимозачета, зачета взаимных требований) для печати акта
* Creation date: (09.12.2003 17:16:52)
* @author: Shafigullin Ildar
*/
public class MutualPaymentsValueObject {
	private java.lang.Integer codeResource; // код услуги
	private java.lang.Integer codeContract; //код договора 
	private java.lang.Integer codeAkt; // код акта 
	private Date payDate; // дата платежа
	private java.lang.String payNumber; //номер платежа
	private java.lang.String contractNumber; //номер договора 
	private java.sql.Date contractDate; //дата договора 
	private java.lang.String orgPayer; //плательщик
	private java.lang.String resName; //наименование услуги 
	private java.sql.Date dateStart; // дата начала 
	private java.sql.Date dateEnd; //дата окончания 
	private BigDecimal sumRub; //сумма в рублях 
	private java.math.BigDecimal ndsRub; //НДС в рублях 
	private java.lang.String currContract; //валюта договора 
	private java.math.BigDecimal rateContract; // курс к валюте договора
	private java.math.BigDecimal sumContract; //сумма договора
	private java.math.BigDecimal ndsContract; //НДС договора 
	private java.lang.String mainCurr; //основная валюта акта
	private java.math.BigDecimal rateMainCurr; //курс к основной валюте акта
	private java.math.BigDecimal sumMainCurr; //сумма в основной валюте акта
	private java.math.BigDecimal ndsMainCurr; //НДС в основной валюте акта
	private java.lang.String dopCurr; //доп. валюта акта
	private java.math.BigDecimal rateDopCurr; // курс рубля к доп. валюте акта 
	private java.math.BigDecimal sumDopCurr; //сумма в доп. валюте акта 
	private java.math.BigDecimal ndsDopCurr; //НДС в доп. валюте акта 
	private java.lang.Integer headerId; //Порядковый номер  принадлежность HEADER
	private java.lang.String agent; // получатель платежа
	private BigDecimal sumWithoutMain; // сумма без НДС  в валюте акта
	/**
	 * MutualPaymentsValueObject constructor comment.
	 */
	public MutualPaymentsValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.01.2004 19:01:33)
	 * @return java.lang.String
	 */
	public java.lang.String getAgent() {
		return agent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:28:04)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeAkt() {
		return codeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:27:30)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeContract() {
		return codeContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:26:58)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeResource() {
		return codeResource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:30:09)
	 * @return java.sql.Date
	 */
	public java.sql.Date getContractDate() {
		return contractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:29:48)
	 * @return java.lang.String
	 */
	public java.lang.String getContractNumber() {
		return contractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:33:06)
	 * @return java.lang.String
	 */
	public java.lang.String getCurrContract() {
		return currContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:31:51)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateEnd() {
		return dateEnd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:31:32)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateStart() {
		return dateStart;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:36:21)
	 * @return java.lang.String
	 */
	public java.lang.String getDopCurr() {
		return dopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:19:35)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getHeaderId() {
		return headerId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:34:30)
	 * @return java.lang.String
	 */
	public java.lang.String getMainCurr() {
		return mainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:34:12)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsContract() {
		return ndsContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:38:35)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsDopCurr() {
		return ndsDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:35:55)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsMainCurr() {
		return ndsMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:32:43)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsRub() {
		return ndsRub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:30:47)
	 * @return java.lang.String
	 */
	public java.lang.String getOrgPayer() {
		return orgPayer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:28:33)
	 * @return java.sql.Date
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:29:24)
	 * @return java.lang.String
	 */
	public java.lang.String getPayNumber() {
		return payNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:33:29)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRateContract() {
		return rateContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:36:58)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRateDopCurr() {
		return rateDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:34:53)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRateMainCurr() {
		return rateMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:31:07)
	 * @return java.lang.String
	 */
	public java.lang.String getResName() {
		return resName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:33:52)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumContract() {
		return sumContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:37:34)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumDopCurr() {
		return sumDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:35:20)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumMainCurr() {
		return sumMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:32:16)
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getSumRub() {
		return sumRub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.01.2004 19:01:33)
	 * @param newAgent java.lang.String
	 */
	public void setAgent(java.lang.String newAgent) {
		agent = newAgent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:28:04)
	 * @param newCodeAkt java.lang.Integer
	 */
	public void setCodeAkt(java.lang.Integer newCodeAkt) {
		codeAkt = newCodeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:27:30)
	 * @param newCodeContract java.lang.Integer
	 */
	public void setCodeContract(java.lang.Integer newCodeContract) {
		codeContract = newCodeContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:26:58)
	 * @param newCodeResource java.lang.Integer
	 */
	public void setCodeResource(java.lang.Integer newCodeResource) {
		codeResource = newCodeResource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:30:09)
	 * @param newContractDate java.sql.Date
	 */
	public void setContractDate(java.sql.Date newContractDate) {
		contractDate = newContractDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:29:48)
	 * @param newContractNumber java.lang.String
	 */
	public void setContractNumber(java.lang.String newContractNumber) {
		contractNumber = newContractNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:33:06)
	 * @param newCurrContract java.lang.String
	 */
	public void setCurrContract(java.lang.String newCurrContract) {
		currContract = newCurrContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:31:51)
	 * @param newDateEnd java.sql.Date
	 */
	public void setDateEnd(java.sql.Date newDateEnd) {
		dateEnd = newDateEnd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:31:32)
	 * @param newDateStart java.sql.Date
	 */
	public void setDateStart(java.sql.Date newDateStart) {
		dateStart = newDateStart;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:36:21)
	 * @param newDopCurr java.lang.String
	 */
	public void setDopCurr(java.lang.String newDopCurr) {
		dopCurr = newDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:19:35)
	 * @param newHeaderId java.lang.Integer
	 */
	public void setHeaderId(java.lang.Integer newHeaderId) {
		headerId = newHeaderId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:34:30)
	 * @param newMainCurr java.lang.String
	 */
	public void setMainCurr(java.lang.String newMainCurr) {
		mainCurr = newMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:34:12)
	 * @param newNdsContract java.math.BigDecimal
	 */
	public void setNdsContract(java.math.BigDecimal newNdsContract) {
		ndsContract = newNdsContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:38:35)
	 * @param newNdsDopCurr java.math.BigDecimal
	 */
	public void setNdsDopCurr(java.math.BigDecimal newNdsDopCurr) {
		ndsDopCurr = newNdsDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:35:55)
	 * @param newNdsMainCurr java.math.BigDecimal
	 */
	public void setNdsMainCurr(java.math.BigDecimal newNdsMainCurr) {
		ndsMainCurr = newNdsMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:32:43)
	 * @param newNdsRub java.math.BigDecimal
	 */
	public void setNdsRub(java.math.BigDecimal newNdsRub) {
		ndsRub = newNdsRub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:30:47)
	 * @param newOrgPayer java.lang.String
	 */
	public void setOrgPayer(java.lang.String newOrgPayer) {
		orgPayer = newOrgPayer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:28:33)
	 * @param newPayDate java.sql.Date
	 */
	public void setPayDate(Date newPayDate) {
		payDate = newPayDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:29:24)
	 * @param newPayNumber java.lang.String
	 */
	public void setPayNumber(java.lang.String newPayNumber) {
		payNumber = newPayNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:33:29)
	 * @param newRateContract java.math.BigDecimal
	 */
	public void setRateContract(java.math.BigDecimal newRateContract) {
		rateContract = newRateContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:36:58)
	 * @param newRateDopCurr java.math.BigDecimal
	 */
	public void setRateDopCurr(java.math.BigDecimal newRateDopCurr) {
		rateDopCurr = newRateDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:34:53)
	 * @param newRateMainCurr java.math.BigDecimal
	 */
	public void setRateMainCurr(java.math.BigDecimal newRateMainCurr) {
		rateMainCurr = newRateMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:31:07)
	 * @param newResName java.lang.String
	 */
	public void setResName(java.lang.String newResName) {
		resName = newResName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:33:52)
	 * @param newSumContract java.math.BigDecimal
	 */
	public void setSumContract(java.math.BigDecimal newSumContract) {
		sumContract = newSumContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:37:34)
	 * @param newSumDopCurr java.math.BigDecimal
	 */
	public void setSumDopCurr(java.math.BigDecimal newSumDopCurr) {
		sumDopCurr = newSumDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:35:20)
	 * @param newSumMainCurr java.math.BigDecimal
	 */
	public void setSumMainCurr(java.math.BigDecimal newSumMainCurr) {
		sumMainCurr = newSumMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2003 17:32:16)
	 * @param newSumRub java.math.BigDecimal
	 */
	public void setSumRub(BigDecimal newSumRub) {
		sumRub = newSumRub;
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

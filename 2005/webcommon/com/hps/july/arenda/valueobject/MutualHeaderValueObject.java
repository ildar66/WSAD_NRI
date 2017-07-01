package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
/**
*  онтейнер "заголовка акта"
* Creation date: (10.12.2003 15:33:44)
* @author: Shafigullin Ildar
*/
public class MutualHeaderValueObject {
	private java.lang.Integer codeAkt; //код акта
	private java.lang.String numberAkt; // номер акта
	private Date dateAkt; //дата акта
	private java.lang.String position; //наименование позиции
	private java.lang.String header1; //заголовок 1
	private java.lang.String header2; //заголовок 1
	private java.sql.Date dateStartAkt; //дата начала акта
	private java.sql.Date dateEndAkt; //дата окончани€ акта
	private java.lang.String isCommonRate; //признак единого курса
	private BigDecimal commonRate; //значение единого курса
	private java.sql.Date commonRateDate; //дата единого курса
	private java.lang.String userHeader; //пользовательский заголовок 1
	private java.lang.String userFooter; // пользовательский заголовок 2
	private java.lang.String otvUser; //ответственный поисковик
	private java.lang.String mainCurr; //основна€ валюта акта
	private java.lang.String dopCurr; //дополнительна€ валюта акта
	private java.lang.String customer; //наименование заказчика
	private java.lang.String executor; //наименовнаие исполнител€
	private java.lang.String jobCustomer; //должность руководител€ заказчика
	private java.lang.String jobExecutor; //должность руководител€ исполнител€
	private java.lang.String fioCustomer; //‘»ќ руководител€ заказчика
	private java.lang.String fioExecutor; //‘»ќ руководител€ исполнител€
	private java.lang.String otvEconomist; //ответственный экономист
	private java.lang.Integer countPayments; //кол-во записей платежей в акте
	private java.lang.Integer countStartDebt; //кол-во записей нач. задолженности в акте
	private java.lang.Integer countcharges; //кол-во записей начислений в акте
	private java.lang.Integer countenddebt; //кол-во записей кон. задолженности в акте
	private java.lang.String header3; //пользовательский заголовок 3
	private java.math.BigDecimal mutualSumMain; //сумма взаимозачета в основной вал. акта
	private java.math.BigDecimal mutualNdsMain; //Ќƒ— взаимозачета в основной вал. акта
	private java.math.BigDecimal mutualSumDop; // сумма взаимозачета в дополнительной вал. акта
	private java.math.BigDecimal mutualNdsDop; //Ќƒ— взаимозачета в дополнительной вал. акта
	private java.lang.Integer headerId; //пор€дковый номер записи
	private java.lang.String highColontitul; //верхний колонтитул
	private java.lang.String town; //town
	private java.lang.String purposePayNds; //назначение платежа Ќƒ—	
	/**
	 * MutualHeaderValueObject constructor comment.
	 */
	public MutualHeaderValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:34:21)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeAkt() {
		return codeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:39:51)
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getCommonRate() {
		return commonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:40:13)
	 * @return java.sql.Date
	 */
	public java.sql.Date getCommonRateDate() {
		return commonRateDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:47:41)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountcharges() {
		return countcharges;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:48:00)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountenddebt() {
		return countenddebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:47:01)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountPayments() {
		return countPayments;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:47:25)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountStartDebt() {
		return countStartDebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:43:02)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomer() {
		return customer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:35:27)
	 * @return java.sql.Date
	 */
	public Date getDateAkt() {
		return dateAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:39:01)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateEndAkt() {
		return dateEndAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:38:28)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateStartAkt() {
		return dateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:42:36)
	 * @return java.lang.String
	 */
	public java.lang.String getDopCurr() {
		return dopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:43:30)
	 * @return java.lang.String
	 */
	public java.lang.String getExecutor() {
		return executor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:45:58)
	 * @return java.lang.String
	 */
	public java.lang.String getFioCustomer() {
		return fioCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:46:18)
	 * @return java.lang.String
	 */
	public java.lang.String getFioExecutor() {
		return fioExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:36:37)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader1() {
		return header1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:38:03)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader2() {
		return header2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:48:38)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader3() {
		return header3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 17:20:43)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getHeaderId() {
		return headerId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.01.2004 18:49:29)
	 * @return java.lang.String
	 */
	public java.lang.String getHighColontitul() {
		return highColontitul;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:39:25)
	 * @return java.lang.String
	 */
	public java.lang.String getIsCommonRate() {
		return isCommonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:45:07)
	 * @return java.lang.String
	 */
	public java.lang.String getJobCustomer() {
		return jobCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:45:27)
	 * @return java.lang.String
	 */
	public java.lang.String getJobExecutor() {
		return jobExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:42:16)
	 * @return java.lang.String
	 */
	public java.lang.String getMainCurr() {
		return mainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:50:12)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualNdsDop() {
		return mutualNdsDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:49:29)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualNdsMain() {
		return mutualNdsMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:49:49)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualSumDop() {
		return mutualSumDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:49:05)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualSumMain() {
		return mutualSumMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:34:50)
	 * @return java.lang.String
	 */
	public java.lang.String getNumberAkt() {
		return numberAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:46:37)
	 * @return java.lang.String
	 */
	public java.lang.String getOtvEconomist() {
		return otvEconomist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:41:52)
	 * @return java.lang.String
	 */
	public java.lang.String getOtvUser() {
		return otvUser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:35:53)
	 * @return java.lang.String
	 */
	public java.lang.String getPosition() {
		return position;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2005 12:02:51)
	 * @return java.lang.String
	 */
	public java.lang.String getTown() {
		return town;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:41:03)
	 * @return java.lang.String
	 */
	public java.lang.String getUserFooter() {
		return userFooter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:40:41)
	 * @return java.lang.String
	 */
	public java.lang.String getUserHeader() {
		return userHeader;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:34:21)
	 * @param newCodeAkt java.lang.Integer
	 */
	public void setCodeAkt(java.lang.Integer newCodeAkt) {
		codeAkt = newCodeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:39:51)
	 * @param newCommonRate java.math.BigDecimal
	 */
	public void setCommonRate(BigDecimal newCommonRate) {
		commonRate = newCommonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:40:13)
	 * @param newCommonRateDate java.sql.Date
	 */
	public void setCommonRateDate(java.sql.Date newCommonRateDate) {
		commonRateDate = newCommonRateDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:47:41)
	 * @param newCountcharges java.lang.Integer
	 */
	public void setCountcharges(java.lang.Integer newCountcharges) {
		countcharges = newCountcharges;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:48:00)
	 * @param newCountenddebt java.lang.Integer
	 */
	public void setCountenddebt(java.lang.Integer newCountenddebt) {
		countenddebt = newCountenddebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:47:01)
	 * @param newCountPayments java.lang.Integer
	 */
	public void setCountPayments(java.lang.Integer newCountPayments) {
		countPayments = newCountPayments;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:47:25)
	 * @param newCountStartDebt java.lang.Integer
	 */
	public void setCountStartDebt(java.lang.Integer newCountStartDebt) {
		countStartDebt = newCountStartDebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:43:02)
	 * @param newCustomer java.lang.String
	 */
	public void setCustomer(java.lang.String newCustomer) {
		customer = newCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:35:27)
	 * @param newDateAkt java.sql.Date
	 */
	public void setDateAkt(Date newDateAkt) {
		dateAkt = newDateAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:39:01)
	 * @param newDateEndAkt java.sql.Date
	 */
	public void setDateEndAkt(java.sql.Date newDateEndAkt) {
		dateEndAkt = newDateEndAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:38:28)
	 * @param newDateStartAkt java.sql.Date
	 */
	public void setDateStartAkt(java.sql.Date newDateStartAkt) {
		dateStartAkt = newDateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:42:36)
	 * @param newDopCurr java.lang.String
	 */
	public void setDopCurr(java.lang.String newDopCurr) {
		dopCurr = newDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:43:30)
	 * @param newExecutor java.lang.String
	 */
	public void setExecutor(java.lang.String newExecutor) {
		executor = newExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:45:58)
	 * @param newFioCustomer java.lang.String
	 */
	public void setFioCustomer(java.lang.String newFioCustomer) {
		fioCustomer = newFioCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:46:18)
	 * @param newFioExecutor java.lang.String
	 */
	public void setFioExecutor(java.lang.String newFioExecutor) {
		fioExecutor = newFioExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:36:37)
	 * @param newHeader1 java.lang.String
	 */
	public void setHeader1(java.lang.String newHeader1) {
		header1 = newHeader1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:38:03)
	 * @param newHeader2 java.lang.String
	 */
	public void setHeader2(java.lang.String newHeader2) {
		header2 = newHeader2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:48:38)
	 * @param newHeader3 java.lang.String
	 */
	public void setHeader3(java.lang.String newHeader3) {
		header3 = newHeader3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 17:20:43)
	 * @param newHeaderId java.lang.Integer
	 */
	public void setHeaderId(java.lang.Integer newHeaderId) {
		headerId = newHeaderId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.01.2004 18:49:29)
	 * @param newHighColontitul java.lang.String
	 */
	public void setHighColontitul(java.lang.String newHighColontitul) {
		highColontitul = newHighColontitul;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:39:25)
	 * @param newIsCommonRate java.lang.String
	 */
	public void setIsCommonRate(java.lang.String newIsCommonRate) {
		isCommonRate = newIsCommonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:45:07)
	 * @param newJobCustomer java.lang.String
	 */
	public void setJobCustomer(java.lang.String newJobCustomer) {
		jobCustomer = newJobCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:45:27)
	 * @param newJobExecutor java.lang.String
	 */
	public void setJobExecutor(java.lang.String newJobExecutor) {
		jobExecutor = newJobExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:42:16)
	 * @param newMainCurr java.lang.String
	 */
	public void setMainCurr(java.lang.String newMainCurr) {
		mainCurr = newMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:50:12)
	 * @param newMutualNdsDop java.math.BigDecimal
	 */
	public void setMutualNdsDop(java.math.BigDecimal newMutualNdsDop) {
		mutualNdsDop = newMutualNdsDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:49:29)
	 * @param newMutualNdsMain java.math.BigDecimal
	 */
	public void setMutualNdsMain(java.math.BigDecimal newMutualNdsMain) {
		mutualNdsMain = newMutualNdsMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:49:49)
	 * @param newMutualSumDop java.math.BigDecimal
	 */
	public void setMutualSumDop(java.math.BigDecimal newMutualSumDop) {
		mutualSumDop = newMutualSumDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:49:05)
	 * @param newMutualSumMain java.math.BigDecimal
	 */
	public void setMutualSumMain(java.math.BigDecimal newMutualSumMain) {
		mutualSumMain = newMutualSumMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:34:50)
	 * @param newNumberAkt java.lang.String
	 */
	public void setNumberAkt(java.lang.String newNumberAkt) {
		numberAkt = newNumberAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:46:37)
	 * @param newOtvEconomist java.lang.String
	 */
	public void setOtvEconomist(java.lang.String newOtvEconomist) {
		otvEconomist = newOtvEconomist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:41:52)
	 * @param newOtvUser java.lang.String
	 */
	public void setOtvUser(java.lang.String newOtvUser) {
		otvUser = newOtvUser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:35:53)
	 * @param newPosition java.lang.String
	 */
	public void setPosition(java.lang.String newPosition) {
		position = newPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2005 12:02:51)
	 * @param newTown java.lang.String
	 */
	public void setTown(java.lang.String newTown) {
		town = newTown;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:41:03)
	 * @param newUserFooter java.lang.String
	 */
	public void setUserFooter(java.lang.String newUserFooter) {
		userFooter = newUserFooter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 15:40:41)
	 * @param newUserHeader java.lang.String
	 */
	public void setUserHeader(java.lang.String newUserHeader) {
		userHeader = newUserHeader;
	}
	/**
	 * @return
	 */
	public java.lang.String getPurposePayNds() {
		return purposePayNds;
	}

	/**
	 * @param string
	 */
	public void setPurposePayNds(java.lang.String string) {
		purposePayNds = string;
	}

}

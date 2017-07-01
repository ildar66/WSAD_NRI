package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
/**
* Контейнер "заголовка акта взаимозачета"
* Creation date: (17.12.2003 16:41:34)
* @author: Shofigullin Ildar
*/
public class MutualHeaderAccValueObject {
	private java.lang.Integer codeAkt; //код акта
	private java.lang.String numberAkt; //номер акта
	private Date dateAkt; //дата акта
	private java.lang.String position; //наименование позиции
	private java.lang.String header1; //заголовок 1
	private java.lang.String header2; //заголовок 2
	private java.lang.String header3; //заголовок 3
	private java.lang.String header4; //заголовок 4
	private java.sql.Date dateStartAkt; //Дата начала акта
	private java.sql.Date dateEndAkt; //Дата окончания акта   
	private java.lang.String isCommonRate; //Признак единого курса
	private BigDecimal commonRate; //Единый курс
	private java.sql.Date commonRateDate; // Дата единого курса
	private java.lang.String userHeader; //Пользовательский заголовок
	private java.lang.String userFooter; //Пользовательский Footer
	private java.lang.String otvUser; //Отв. пользователь
	private java.lang.String mainCurr; //основная валюта акта
	private java.lang.String dopCurr; //доп. валюта акта
	private java.lang.String nameOrg1; //наименование 1 оранизации 
	private java.lang.String nameOrg2; //наименование 2 оранизации 
	private java.lang.String nameOrg3; //наименование 3 оранизации 
	private java.lang.String jobOrg1; //должность руководителя 1 организации
	private java.lang.String jobOrg2; //должность руководителя 2 организации
	private java.lang.String jobOrg3; //должность руководителя 3 организации
	private java.lang.String fioOrg1; //ФИО руководителя 1 организации
	private java.lang.String fioOrg2; //ФИО руководителя 2 организации
	private java.lang.String fioOrg3; //ФИО руководителя 3 организации
	private java.lang.String otvEconomist; //ответственный экономист 
	private java.lang.Integer countPayments; //количество записей платежей
	private java.lang.Integer countStartDebt; //количество записей нач. задолженности
	private java.lang.Integer countCharges; // количество записей начислений
	private java.lang.Integer countEndDebt; //количество записей кон. задолженности
	private java.math.BigDecimal mutualSumMain; //сумма взаимозачета в основной валюте
	private java.math.BigDecimal mutualNdsMain; //НДС взаимозачета в основной валюте
	private java.math.BigDecimal mutualSumDop; //сумма взаимозачета в доп. валюте
	private java.math.BigDecimal mutualNdsDop; //НДС взаимозачета в доп. валюте
	private java.lang.Integer headerId; //порядковый номер акта
	private java.lang.String highColontitul; //Верхний колонтитул
	private java.lang.String town; //город
	private java.lang.String purposePayNds; //назначение платежа НДС
	/**
	 * MutualHeaderAccValueObject constructor comment.
	 */
	public MutualHeaderAccValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:06:20)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCodeAkt() {
		return codeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:12:24)
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getCommonRate() {
		return commonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:12:46)
	 * @return java.sql.Date
	 */
	public java.sql.Date getCommonRateDate() {
		return commonRateDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:35:46)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountCharges() {
		return countCharges;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:36:04)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountEndDebt() {
		return countEndDebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:34:58)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountPayments() {
		return countPayments;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:35:22)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCountStartDebt() {
		return countStartDebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:07:27)
	 * @return java.sql.Date
	 */
	public Date getDateAkt() {
		return dateAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:11:25)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateEndAkt() {
		return dateEndAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:11:05)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateStartAkt() {
		return dateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:14:54)
	 * @return java.lang.String
	 */
	public java.lang.String getDopCurr() {
		return dopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:33:34)
	 * @return java.lang.String
	 */
	public java.lang.String getFioOrg1() {
		return fioOrg1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:33:54)
	 * @return java.lang.String
	 */
	public java.lang.String getFioOrg2() {
		return fioOrg2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:34:15)
	 * @return java.lang.String
	 */
	public java.lang.String getFioOrg3() {
		return fioOrg3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:09:18)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader1() {
		return header1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:09:44)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader2() {
		return header2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:10:08)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader3() {
		return header3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:10:29)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader4() {
		return header4;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:18:08)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getHeaderId() {
		return headerId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.01.2004 18:49:03)
	 * @return java.lang.String
	 */
	public java.lang.String getHighColontitul() {
		return highColontitul;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:11:49)
	 * @return java.lang.String
	 */
	public java.lang.String getIsCommonRate() {
		return isCommonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:32:13)
	 * @return java.lang.String
	 */
	public java.lang.String getJobOrg1() {
		return jobOrg1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:32:35)
	 * @return java.lang.String
	 */
	public java.lang.String getJobOrg2() {
		return jobOrg2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:32:54)
	 * @return java.lang.String
	 */
	public java.lang.String getJobOrg3() {
		return jobOrg3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:14:31)
	 * @return java.lang.String
	 */
	public java.lang.String getMainCurr() {
		return mainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:38:40)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualNdsDop() {
		return mutualNdsDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:36:52)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualNdsMain() {
		return mutualNdsMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:38:20)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualSumDop() {
		return mutualSumDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:36:30)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getMutualSumMain() {
		return mutualSumMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:15:26)
	 * @return java.lang.String
	 */
	public java.lang.String getNameOrg1() {
		return nameOrg1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:15:50)
	 * @return java.lang.String
	 */
	public java.lang.String getNameOrg2() {
		return nameOrg2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:31:42)
	 * @return java.lang.String
	 */
	public java.lang.String getNameOrg3() {
		return nameOrg3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:06:56)
	 * @return java.lang.String
	 */
	public java.lang.String getNumberAkt() {
		return numberAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:34:34)
	 * @return java.lang.String
	 */
	public java.lang.String getOtvEconomist() {
		return otvEconomist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:13:59)
	 * @return java.lang.String
	 */
	public java.lang.String getOtvUser() {
		return otvUser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:08:06)
	 * @return java.lang.String
	 */
	public java.lang.String getPosition() {
		return position;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2005 12:03:59)
	 * @return java.lang.String
	 */
	public java.lang.String getTown() {
		return town;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:13:38)
	 * @return java.lang.String
	 */
	public java.lang.String getUserFooter() {
		return userFooter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:13:14)
	 * @return java.lang.String
	 */
	public java.lang.String getUserHeader() {
		return userHeader;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:06:20)
	 * @param newCodeAkt java.lang.Integer
	 */
	public void setCodeAkt(java.lang.Integer newCodeAkt) {
		codeAkt = newCodeAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:12:24)
	 * @param newCommonRate java.math.BigDecimal
	 */
	public void setCommonRate(BigDecimal newCommonRate) {
		commonRate = newCommonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:12:46)
	 * @param newCommonRateDate java.sql.Date
	 */
	public void setCommonRateDate(java.sql.Date newCommonRateDate) {
		commonRateDate = newCommonRateDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:35:46)
	 * @param newCountCharges java.lang.Integer
	 */
	public void setCountCharges(java.lang.Integer newCountCharges) {
		countCharges = newCountCharges;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:36:04)
	 * @param newCountEndDebt java.lang.Integer
	 */
	public void setCountEndDebt(java.lang.Integer newCountEndDebt) {
		countEndDebt = newCountEndDebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:34:58)
	 * @param newCountPayments java.lang.Integer
	 */
	public void setCountPayments(java.lang.Integer newCountPayments) {
		countPayments = newCountPayments;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:35:22)
	 * @param newCountStartDebt java.lang.Integer
	 */
	public void setCountStartDebt(java.lang.Integer newCountStartDebt) {
		countStartDebt = newCountStartDebt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:07:27)
	 * @param newDateAkt java.sql.Date
	 */
	public void setDateAkt(Date newDateAkt) {
		dateAkt = newDateAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:11:25)
	 * @param newDateEndAkt java.sql.Date
	 */
	public void setDateEndAkt(java.sql.Date newDateEndAkt) {
		dateEndAkt = newDateEndAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:11:05)
	 * @param newDateStartAkt java.sql.Date
	 */
	public void setDateStartAkt(java.sql.Date newDateStartAkt) {
		dateStartAkt = newDateStartAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:14:54)
	 * @param newDopCurr java.lang.String
	 */
	public void setDopCurr(java.lang.String newDopCurr) {
		dopCurr = newDopCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:33:34)
	 * @param newFioOrg1 java.lang.String
	 */
	public void setFioOrg1(java.lang.String newFioOrg1) {
		fioOrg1 = newFioOrg1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:33:54)
	 * @param newFioOrg2 java.lang.String
	 */
	public void setFioOrg2(java.lang.String newFioOrg2) {
		fioOrg2 = newFioOrg2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:34:15)
	 * @param newFioOrg3 java.lang.String
	 */
	public void setFioOrg3(java.lang.String newFioOrg3) {
		fioOrg3 = newFioOrg3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:09:18)
	 * @param newHeader1 java.lang.String
	 */
	public void setHeader1(java.lang.String newHeader1) {
		header1 = newHeader1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:09:44)
	 * @param newHeader2 java.lang.String
	 */
	public void setHeader2(java.lang.String newHeader2) {
		header2 = newHeader2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:10:08)
	 * @param newHeader3 java.lang.String
	 */
	public void setHeader3(java.lang.String newHeader3) {
		header3 = newHeader3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:10:29)
	 * @param newHeader4 java.lang.String
	 */
	public void setHeader4(java.lang.String newHeader4) {
		header4 = newHeader4;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 13:18:08)
	 * @param newHeaderId java.lang.Integer
	 */
	public void setHeaderId(java.lang.Integer newHeaderId) {
		headerId = newHeaderId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.01.2004 18:49:03)
	 * @param newHighColontitul java.lang.String
	 */
	public void setHighColontitul(java.lang.String newHighColontitul) {
		highColontitul = newHighColontitul;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:11:49)
	 * @param newIsCommonRate java.lang.String
	 */
	public void setIsCommonRate(java.lang.String newIsCommonRate) {
		isCommonRate = newIsCommonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:32:13)
	 * @param newJobOrg1 java.lang.String
	 */
	public void setJobOrg1(java.lang.String newJobOrg1) {
		jobOrg1 = newJobOrg1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:32:35)
	 * @param newJobOrg2 java.lang.String
	 */
	public void setJobOrg2(java.lang.String newJobOrg2) {
		jobOrg2 = newJobOrg2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:32:54)
	 * @param newJobOrg3 java.lang.String
	 */
	public void setJobOrg3(java.lang.String newJobOrg3) {
		jobOrg3 = newJobOrg3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:14:31)
	 * @param newMainCurr java.lang.String
	 */
	public void setMainCurr(java.lang.String newMainCurr) {
		mainCurr = newMainCurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:38:40)
	 * @param newMutualNdsDop java.math.BigDecimal
	 */
	public void setMutualNdsDop(java.math.BigDecimal newMutualNdsDop) {
		mutualNdsDop = newMutualNdsDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:36:52)
	 * @param newMutualNdsMain java.math.BigDecimal
	 */
	public void setMutualNdsMain(java.math.BigDecimal newMutualNdsMain) {
		mutualNdsMain = newMutualNdsMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:38:20)
	 * @param newMutualSumDop java.math.BigDecimal
	 */
	public void setMutualSumDop(java.math.BigDecimal newMutualSumDop) {
		mutualSumDop = newMutualSumDop;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:36:30)
	 * @param newMutualSumMain java.math.BigDecimal
	 */
	public void setMutualSumMain(java.math.BigDecimal newMutualSumMain) {
		mutualSumMain = newMutualSumMain;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:15:26)
	 * @param newNameOrg1 java.lang.String
	 */
	public void setNameOrg1(java.lang.String newNameOrg1) {
		nameOrg1 = newNameOrg1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:15:50)
	 * @param newNameOrg2 java.lang.String
	 */
	public void setNameOrg2(java.lang.String newNameOrg2) {
		nameOrg2 = newNameOrg2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:31:42)
	 * @param newNameOrg3 java.lang.String
	 */
	public void setNameOrg3(java.lang.String newNameOrg3) {
		nameOrg3 = newNameOrg3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:06:56)
	 * @param newNumberAkt java.lang.String
	 */
	public void setNumberAkt(java.lang.String newNumberAkt) {
		numberAkt = newNumberAkt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:34:34)
	 * @param newOtvEconomist java.lang.String
	 */
	public void setOtvEconomist(java.lang.String newOtvEconomist) {
		otvEconomist = newOtvEconomist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:13:59)
	 * @param newOtvUser java.lang.String
	 */
	public void setOtvUser(java.lang.String newOtvUser) {
		otvUser = newOtvUser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:08:06)
	 * @param newPosition java.lang.String
	 */
	public void setPosition(java.lang.String newPosition) {
		position = newPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2005 12:03:59)
	 * @param newTown java.lang.String
	 */
	public void setTown(java.lang.String newTown) {
		town = newTown;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:13:38)
	 * @param newUserFooter java.lang.String
	 */
	public void setUserFooter(java.lang.String newUserFooter) {
		userFooter = newUserFooter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:13:14)
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

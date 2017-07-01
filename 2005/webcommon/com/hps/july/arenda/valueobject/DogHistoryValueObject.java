package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;

/**
 * Bean-Wrapper "истории договора"
 * Creation date: (04.11.2003 14:23:58)
 * @author: Dmitry Dneprov
 */
public class DogHistoryValueObject {
	private java.lang.String periodname;
	private java.math.BigDecimal summ;
	private java.lang.String currname;
	private java.lang.String ppnumber;
	private java.sql.Date ppdate;
	private java.math.BigDecimal ppsumrub;
	//курс платежа:
	private java.math.BigDecimal ratePay;
	//курс начисления:
	private java.math.BigDecimal rateCharge;
	private boolean isschetfact;
	private java.math.BigDecimal sumchargeabonent;
	private java.math.BigDecimal sumpayabonent;
	private java.math.BigDecimal tempsldsumm;
	private java.lang.String tempsldcurr;
	private java.lang.String actnum;
	private java.sql.Date actdate;
	private java.math.BigDecimal sldsumm;
	private java.lang.String sldcurr;
	private boolean isactschetfact;
	private java.lang.String actstate;
	private int idhistoryarenda;
	private Integer idchargearenda;
	private java.lang.Integer idpayarenda;
	private java.lang.Integer idchargeabonent;
	private java.lang.Integer idpayabonent;
	private java.lang.Integer idcodeact;
	private java.sql.Date sdate;
	private java.sql.Date edate;
	private java.lang.Integer idresourceabonent;
	private java.lang.String resabonentname;
	private java.lang.String arescode;
	private boolean isschetfakt3;
	private boolean isschetfakt2;
	private boolean isschetfakt1;
	private int countWorkAct;
	private String sldNotes;
	private String sldByHand;
	private BigDecimal ostSumForSF; //остаток суммы для счетов фактур
	/*
	 Признак выдачи СФ:
	 0-сумма остатка СФ <> 0 или состояние СФ <> "получена от арендодателя"("Не на всю сумму сделаны СФ, остаток СФ = "),
	 1-остатка СФ = 0 и состояние СФ >  "получена от арендодателя"("СФ не Получены от арендодателя"),
	 2-сумма остатка СФ = 0 и состояние СФ = "принята в бухгалтерии (СФ получены от арендодателя, но не приняты в бухгалтерии)",
	 3- сумма остатка СФ = 0 и состояние СФ =  "принята в бухгалтерии(СФ принята в бухгалтерии) ",
	 10-СФ учтена до строгого учета СФ("СФ по старому учету")
	*/
	private Integer flagSF;
	private BigDecimal ostSumForCwAct; //остаток суммы для акта выполненных работ(АВР).
	/*
	 Признак выдачи акта выполненных работ(АВР):
	 0-сумма остатка АВР <> 0 или состояние АВР <> "получена от арендодателя"("Не на всю сумму сделаны АВР, остаток АВР = "),
	 1-остатка АВР = 0 и состояние АВР >  "получена от арендодателя"("АВР не Получены от арендодателя"),
	 2-сумма остатка АВР = 0 и состояние АВР = "принята в бухгалтерии (АВР получены от арендодателя, но не приняты в бухгалтерии)",
	 3- сумма остатка АВР = 0 и состояние АВР =  "принята в бухгалтерии(АВР принята в бухгалтерии) ",
	 10-АВР учтена до строгого учета АВР("АВР по старому учету")
	*/
	private Integer flagCwAct;	
	/**
	 * DogHistoryValueObject constructor comment.
	 */
	public DogHistoryValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:33:09)
	 * @return java.sql.Date
	 */
	public java.sql.Date getActdate() {
		return actdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:32:51)
	 * @return java.lang.String
	 */
	public java.lang.String getActnum() {
		return actnum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:35:48)
	 * @return java.lang.String
	 */
	public java.lang.String getActstate() {
		return actstate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 13:57:37)
	 * @return java.lang.String
	 */
	public java.lang.String getArescode() {
		return arescode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.07.2005 21:55:42)
	 * @return int
	 */
	public int getCountWorkAct() {
		return countWorkAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:26:10)
	 * @return java.lang.String
	 */
	public java.lang.String getCurrname() {
		return currname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.11.2003 17:21:35)
	 * @return java.sql.Date
	 */
	public java.sql.Date getEdate() {
		return edate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:01:13)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdchargeabonent() {
		return idchargeabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 9:59:33)
	 * @return int
	 */
	public Integer getIdchargearenda() {
		return idchargearenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:02:00)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdcodeact() {
		return idcodeact;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 9:59:08)
	 * @return int
	 */
	public int getIdhistoryarenda() {
		return idhistoryarenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:01:27)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdpayabonent() {
		return idpayabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:00:29)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdpayarenda() {
		return idpayarenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 12:59:48)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdresourceabonent() {
		return idresourceabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:24:21)
	 * @return java.lang.String
	 */
	public java.lang.String getPeriodname() {
		return periodname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:27:14)
	 * @return java.sql.Date
	 */
	public java.sql.Date getPpdate() {
		return ppdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:26:58)
	 * @return java.lang.String
	 */
	public java.lang.String getPpnumber() {
		return ppnumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:27:38)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getPpsumrub() {
		return ppsumrub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.03.2004 16:15:55)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRateCharge() {
		return rateCharge;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:28:18)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRatePay() {
		return ratePay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 13:00:08)
	 * @return java.lang.String
	 */
	public java.lang.String getResabonentname() {
		return resabonentname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.11.2003 17:21:17)
	 * @return java.sql.Date
	 */
	public java.sql.Date getSdate() {
		return sdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:34:22)
	 * @return java.lang.String
	 */
	public java.lang.String getSldcurr() {
		return sldcurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:34:08)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSldsumm() {
		return sldsumm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:30:27)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumchargeabonent() {
		return sumchargeabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:25:31)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumm() {
		return summ;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:30:49)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumpayabonent() {
		return sumpayabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:31:54)
	 * @return java.lang.String
	 */
	public java.lang.String getTempsldcurr() {
		return tempsldcurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:31:38)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getTempsldsumm() {
		return tempsldsumm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:35:25)
	 * @return boolean
	 */
	public boolean isIsactschetfact() {
		return isactschetfact;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:28:51)
	 * @return boolean
	 */
	public boolean isIsschetfact() {
		return isschetfact;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.02.2004 14:40:11)
	 * @return boolean
	 */
	public boolean isIsschetfakt1() {
		return isschetfakt1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.02.2004 14:39:57)
	 * @return boolean
	 */
	public boolean isIsschetfakt2() {
		return isschetfakt2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.02.2004 14:39:39)
	 * @return boolean
	 */
	public boolean isIsschetfakt3() {
		return isschetfakt3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:33:09)
	 * @param newActdate java.sql.Date
	 */
	public void setActdate(java.sql.Date newActdate) {
		actdate = newActdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:32:51)
	 * @param newActnum java.lang.String
	 */
	public void setActnum(java.lang.String newActnum) {
		actnum = newActnum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:35:48)
	 * @param newActstate java.lang.String
	 */
	public void setActstate(java.lang.String newActstate) {
		actstate = newActstate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 13:57:37)
	 * @param newArescode java.lang.String
	 */
	public void setArescode(java.lang.String newArescode) {
		arescode = newArescode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.07.2005 21:55:42)
	 * @param newCountWorkAct int
	 */
	public void setCountWorkAct(int newCountWorkAct) {
		countWorkAct = newCountWorkAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:26:10)
	 * @param newCurrname java.lang.String
	 */
	public void setCurrname(java.lang.String newCurrname) {
		currname = newCurrname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.11.2003 17:21:35)
	 * @param newEdate java.sql.Date
	 */
	public void setEdate(java.sql.Date newEdate) {
		edate = newEdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:01:13)
	 * @param newIdchargeabonent java.lang.Integer
	 */
	public void setIdchargeabonent(java.lang.Integer newIdchargeabonent) {
		idchargeabonent = newIdchargeabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 9:59:33)
	 * @param newIdchargearenda int
	 */
	public void setIdchargearenda(Integer newIdchargearenda) {
		idchargearenda = newIdchargearenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:02:00)
	 * @param newIdcodeact java.lang.Integer
	 */
	public void setIdcodeact(java.lang.Integer newIdcodeact) {
		idcodeact = newIdcodeact;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 9:59:08)
	 * @param newIdhistoryarenda int
	 */
	public void setIdhistoryarenda(int newIdhistoryarenda) {
		idhistoryarenda = newIdhistoryarenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:01:27)
	 * @param newIdpayabonent java.lang.Integer
	 */
	public void setIdpayabonent(java.lang.Integer newIdpayabonent) {
		idpayabonent = newIdpayabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 10:00:29)
	 * @param newIdpayarenda java.lang.Integer
	 */
	public void setIdpayarenda(java.lang.Integer newIdpayarenda) {
		idpayarenda = newIdpayarenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 12:59:48)
	 * @param newIdresourceabonent java.lang.Integer
	 */
	public void setIdresourceabonent(java.lang.Integer newIdresourceabonent) {
		idresourceabonent = newIdresourceabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:35:25)
	 * @param newIsactschetfact boolean
	 */
	public void setIsactschetfact(boolean newIsactschetfact) {
		isactschetfact = newIsactschetfact;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:28:51)
	 * @param newIsschetfact boolean
	 */
	public void setIsschetfact(boolean newIsschetfact) {
		isschetfact = newIsschetfact;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.02.2004 14:40:11)
	 * @param newIsschetfakt1 boolean
	 */
	public void setIsschetfakt1(boolean newIsschetfakt1) {
		isschetfakt1 = newIsschetfakt1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.02.2004 14:39:57)
	 * @param newIsschetfakt2 boolean
	 */
	public void setIsschetfakt2(boolean newIsschetfakt2) {
		isschetfakt2 = newIsschetfakt2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.02.2004 14:39:39)
	 * @param newIsschetfakt3 boolean
	 */
	public void setIsschetfakt3(boolean newIsschetfakt3) {
		isschetfakt3 = newIsschetfakt3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:24:21)
	 * @param newPeriodname java.lang.String
	 */
	public void setPeriodname(java.lang.String newPeriodname) {
		periodname = newPeriodname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:27:14)
	 * @param newPpdate java.sql.Date
	 */
	public void setPpdate(java.sql.Date newPpdate) {
		ppdate = newPpdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:26:58)
	 * @param newPpnumber java.lang.String
	 */
	public void setPpnumber(java.lang.String newPpnumber) {
		ppnumber = newPpnumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:27:38)
	 * @param newPpsumrub java.math.BigDecimal
	 */
	public void setPpsumrub(java.math.BigDecimal newPpsumrub) {
		ppsumrub = newPpsumrub;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.03.2004 16:15:55)
	 * @param newRate1 java.math.BigDecimal
	 */
	public void setRateCharge(java.math.BigDecimal newRateCharge) {
		rateCharge = newRateCharge;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:28:18)
	 * @param newRate java.math.BigDecimal
	 */
	public void setRatePay(java.math.BigDecimal newRatePay) {
		ratePay = newRatePay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 13:00:08)
	 * @param newResabonentname java.lang.String
	 */
	public void setResabonentname(java.lang.String newResabonentname) {
		resabonentname = newResabonentname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.11.2003 17:21:17)
	 * @param newSdate java.sql.Date
	 */
	public void setSdate(java.sql.Date newSdate) {
		sdate = newSdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:34:22)
	 * @param newSldcurr java.lang.String
	 */
	public void setSldcurr(java.lang.String newSldcurr) {
		sldcurr = newSldcurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:34:08)
	 * @param newSldsumm java.math.BigDecimal
	 */
	public void setSldsumm(java.math.BigDecimal newSldsumm) {
		sldsumm = newSldsumm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:30:27)
	 * @param newSumchargeabonent java.math.BigDecimal
	 */
	public void setSumchargeabonent(java.math.BigDecimal newSumchargeabonent) {
		sumchargeabonent = newSumchargeabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:25:31)
	 * @param newSumm java.math.BigDecimal
	 */
	public void setSumm(java.math.BigDecimal newSumm) {
		summ = newSumm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:30:49)
	 * @param newSumpayabonent java.math.BigDecimal
	 */
	public void setSumpayabonent(java.math.BigDecimal newSumpayabonent) {
		sumpayabonent = newSumpayabonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:31:54)
	 * @param newTempsldcurr java.lang.String
	 */
	public void setTempsldcurr(java.lang.String newTempsldcurr) {
		tempsldcurr = newTempsldcurr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:31:38)
	 * @param newTempsldsumm java.math.BigDecimal
	 */
	public void setTempsldsumm(java.math.BigDecimal newTempsldsumm) {
		tempsldsumm = newTempsldsumm;
	}
	/**
	 * @return
	 */
	public String getSldByHand() {
		return sldByHand;
	}

	/**
	 * @return
	 */
	public String getSldNotes() {
		return sldNotes;
	}

	/**
	 * @param string
	 */
	public void setSldByHand(String aSldByHand) {
		if (aSldByHand != null && aSldByHand.equals("Y")) {
			sldByHand = "!";
		} else {
			sldByHand = " ";
		}
	}

	/**
	 * @param string
	 */
	public void setSldNotes(String string) {
		sldNotes = string;
	}

	/**
	 * @return
	 */
	public Integer getFlagSF() {
		return flagSF;
	}

	/**
	 * @return
	 */
	public BigDecimal getOstSumForSF() {
		return ostSumForSF;
	}

	/**
	 * @param integer
	 */
	public void setFlagSF(Integer integer) {
		flagSF = integer;
	}

	/**
	 * @param decimal
	 */
	public void setOstSumForSF(BigDecimal decimal) {
		ostSumForSF = decimal;
	}

	/**
	 * @return
	 */
	public Integer getFlagCwAct() {
		return flagCwAct;
	}

	/**
	 * @return
	 */
	public BigDecimal getOstSumForCwAct() {
		return ostSumForCwAct;
	}

	/**
	 * @param integer
	 */
	public void setFlagCwAct(Integer integer) {
		flagCwAct = integer;
	}

	/**
	 * @param decimal
	 */
	public void setOstSumForCwAct(BigDecimal decimal) {
		ostSumForCwAct = decimal;
	}

}

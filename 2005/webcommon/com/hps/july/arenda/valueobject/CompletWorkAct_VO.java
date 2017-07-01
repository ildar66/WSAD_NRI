package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.DomainObject;
/**
* Bean-Wrapper "Акты выполненных работ".
* Creation date: (26.10.2004 11:11:33)
* @author: Shafigullin Ildar
*/
public class CompletWorkAct_VO extends DomainObject {
	private java.lang.Integer idcwacode; //код акта выполненных работ
	private Date docdate; //Учетная дата документа
	private java.lang.String docnumber; //Номер документа
	private java.lang.Integer idContract; //Договор
	private java.lang.Integer currency; //Валюта
	private BigDecimal actSum; //Сумма акта
	private java.math.BigDecimal actNds; //В т ч НДС
	private java.lang.String actstate; //Состояние акта выполненных работ(O-оформляеттся, R-расчитан, C-закрыт)
	private java.sql.Date actstartdate; //Дата начала периода акта
	private java.sql.Date actenddate; //Дата окончания периода акта
	private byte[] acttext; //Тескт акта в формате WORD	
	private java.lang.String actfilename; //Имя файла
	private java.lang.String nameWork; //Наименование выполненной работы

	private CurrencyVO currencyVO; //Валюта VO
	private boolean editByHand; //Признак ручной установки суммы
	private java.math.BigDecimal ndsRate;
	private String createdByName = null;
	private String modifiedByName = null;
	private String numRegistryDoc = null;//Опись № 
	private Date dateRegistryDoc = null;//Опись от 		
	/**
	 * CompletWorkAct_VO constructor comment.
	 */
	public CompletWorkAct_VO() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:33:31)
	 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
	 */
	public CompletWorkAct_VO(CDBCRowObject ro) {
		idcwacode = (Integer) ro.getColumn("idcwacode").asObject();
		docdate = (Date) ro.getColumn("docdate").asObject();
		docnumber = ro.getColumn("docnumber").asString();
		idContract = (Integer) ro.getColumn("idcontract").asObject();
		currency = (Integer) ro.getColumn("currency").asObject();
		actSum = (BigDecimal) ro.getColumn("actsum").asObject();
		actNds = (BigDecimal) ro.getColumn("actnds").asObject();
		actstate = (String) ro.getColumn("actstate").asObject();
		actstartdate = (Date) ro.getColumn("actstartdate").asObject();
		actenddate = (Date) ro.getColumn("actenddate").asObject();
		actfilename = ro.getColumn("actfilename").asString();
		nameWork = ro.getColumn("namework").asString();
		//Инициализация VO валюта:
		initCurrencyVO(ro);
		editByHand = ro.getColumn("editbyhand").asString().equals("Y");
		setCreated((java.sql.Timestamp) ro.getColumn("created").asObject());
		setCreatedBy((Integer) ro.getColumn("createdby").asObject());
		setModified((java.sql.Timestamp) ro.getColumn("modified").asObject());
		setModifiedBy((Integer) ro.getColumn("modifiedby").asObject());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:25:00)
	 * @return java.sql.Date
	 */
	public java.sql.Date getActenddate() {
		return actenddate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:25:32)
	 * @return java.lang.String
	 */
	public java.lang.String getActfilename() {
		return actfilename;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:23:10)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getActNds() {
		return actNds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:24:39)
	 * @return java.sql.Date
	 */
	public java.sql.Date getActstartdate() {
		return actstartdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:23:31)
	 * @return java.lang.String
	 */
	public java.lang.String getActstate() {
		return actstate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:22:40)
	 * @return java.math.BigDecimal
	 */
	public BigDecimal getActSum() {
		return actSum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2004 18:32:13)
	 * @return byte[]
	 */
	public byte[] getActtext() {
		return acttext;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:22:16)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCurrency() {
		return currency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.10.2004 11:46:37)
	 * @return com.hps.july.arenda.valueobject.CurrencyVO
	 */
	public CurrencyVO getCurrencyVO() {
		return currencyVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:20:43)
	 * @return java.sql.Date
	 */
	public Date getDocdate() {
		return docdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:21:09)
	 * @return java.lang.String
	 */
	public java.lang.String getDocnumber() {
		return docnumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:21:33)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdContract() {
		return idContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:20:14)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdcwacode() {
		return idcwacode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.10.2004 12:39:33)
	 * @return java.lang.String
	 */
	public java.lang.String getNameWork() {
		return nameWork;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.11.2004 14:48:36)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsRate() {
		return ndsRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.10.2004 11:44:23)
	 */
	private void initCurrencyVO(CDBCRowObject ro) {
		if (ro.getColumn("currency").asObject() != null) {
			CurrencyVO currVO = new CurrencyVO((Integer) ro.getColumn("currency").asObject());
			currVO.setShortname(ro.getColumn("currname").asString());
			setCurrencyVO(currVO);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.11.2004 13:23:45)
	 * @return boolean
	 */
	public boolean isEditByHand() {
		return editByHand;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:25:00)
	 * @param newActenddate java.sql.Date
	 */
	public void setActenddate(java.sql.Date newActenddate) {
		actenddate = newActenddate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:25:32)
	 * @param newActfilename java.lang.String
	 */
	public void setActfilename(java.lang.String newActfilename) {
		actfilename = newActfilename;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:23:10)
	 * @param newActNds java.math.BigDecimal
	 */
	public void setActNds(java.math.BigDecimal newActNds) {
		actNds = newActNds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:24:39)
	 * @param newActstartdate java.sql.Date
	 */
	public void setActstartdate(java.sql.Date newActstartdate) {
		actstartdate = newActstartdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:23:31)
	 * @param newActstate java.lang.String
	 */
	public void setActstate(java.lang.String newActstate) {
		actstate = newActstate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:22:40)
	 * @param newActSum java.math.BigDecimal
	 */
	public void setActSum(BigDecimal newActSum) {
		actSum = newActSum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2004 18:32:13)
	 * @param newActtext byte[]
	 */
	public void setActtext(byte[] newActtext) {
		acttext = newActtext;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:22:16)
	 * @param newCurrency java.lang.Integer
	 */
	public void setCurrency(java.lang.Integer newCurrency) {
		currency = newCurrency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.10.2004 11:46:37)
	 * @param newCurrencyVO com.hps.july.arenda.valueobject.CurrencyVO
	 */
	public void setCurrencyVO(CurrencyVO newCurrencyVO) {
		currencyVO = newCurrencyVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:20:43)
	 * @param newDocdate java.sql.Date
	 */
	public void setDocdate(Date newDocdate) {
		docdate = newDocdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:21:09)
	 * @param newDocnumber java.lang.String
	 */
	public void setDocnumber(java.lang.String newDocnumber) {
		docnumber = newDocnumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.11.2004 13:23:45)
	 * @param newEditByHand boolean
	 */
	public void setEditByHand(boolean newEditByHand) {
		editByHand = newEditByHand;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:21:33)
	 * @param newIdContract java.lang.Integer
	 */
	public void setIdContract(java.lang.Integer newIdContract) {
		idContract = newIdContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:20:14)
	 * @param newIdcwacode java.lang.Integer
	 */
	public void setIdcwacode(java.lang.Integer newIdcwacode) {
		idcwacode = newIdcwacode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.10.2004 12:39:33)
	 * @param newNameWork java.lang.String
	 */
	public void setNameWork(java.lang.String newNameWork) {
		nameWork = newNameWork;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.11.2004 14:48:36)
	 * @param newNdsRate java.math.BigDecimal
	 */
	public void setNdsRate(java.math.BigDecimal newNdsRate) {
		ndsRate = newNdsRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 11:29:46)
	 */
	public String toString() {
		return "CompletWorkAct_VO: id=" + getIdcwacode() + "; docnumber=" + getDocnumber();
	}
	/**
	 * @return
	 */
	public String getCreatedByName() {
		return createdByName;
	}

	/**
	 * @return
	 */
	public String getModifiedByName() {
		return modifiedByName;
	}

	/**
	 * @param string
	 */
	public void setCreatedByName(String string) {
		createdByName = string;
	}

	/**
	 * @param string
	 */
	public void setModifiedByName(String string) {
		modifiedByName = string;
	}

	/**
	 * @return
	 */
	public Date getDateRegistryDoc() {
		return dateRegistryDoc;
	}

	/**
	 * @return
	 */
	public String getNumRegistryDoc() {
		return numRegistryDoc;
	}

	/**
	 * @param date
	 */
	public void setDateRegistryDoc(Date date) {
		dateRegistryDoc = date;
	}

	/**
	 * @param string
	 */
	public void setNumRegistryDoc(String string) {
		numRegistryDoc = string;
	}

}

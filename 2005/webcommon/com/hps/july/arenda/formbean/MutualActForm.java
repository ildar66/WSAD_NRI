package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.upload.FormFile;
import com.ibm.ivj.ejb.runtime.*;

import java.util.GregorianCalendar;
import java.util.Enumeration;
import org.apache.struts.action.*;
import java.sql.*;

import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.OperatorObject;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Bean-form
 * Форма "Для создания отчетов по актам".
 * Creation date: (26.07.2002 15:11:50)
 * @author: Sergey Gourov
 */
public class MutualActForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private com.hps.july.persistence.LeaseMutualReglamentAccessBean leaseMutualReglament;
	private int leaseMutualReglamentcode;
	private com.hps.july.persistence.CurrencyAccessBean currency;
	private int currencycode;
	private java.lang.String actState;
	private com.hps.july.web.util.StringAndSqlDateProperty documentDate;
	private java.lang.String documentNumber;
	private com.hps.july.web.util.StringAndSqlDateProperty actenddate;
	private com.hps.july.web.util.StringAndSqlDateProperty actstartdate;
	private java.lang.String additionalCurrency;
	private java.lang.String mainCurrency;

	private java.lang.String mutualPeriod;
	private Boolean commonRate;
	private java.lang.String actType;
	private java.lang.String calcRateType;
	private java.lang.String header;
	private java.lang.String footer;
	private java.lang.String documentNumberReglament;
	private com.hps.july.web.util.StringAndSqlDateProperty documentDateReglament;
	protected java.lang.String listForm;
	private java.lang.String reglamentState;
	private java.lang.Boolean isSchetFakt;
	private java.lang.Boolean mutualNDS;

	//	private byte[] wordfile;
	private boolean wordfilePresent;
	private FormFile wordfileFrm;
	private String wordfileName;
	private String wordfileAction;
	//для контроля за ведением договора:
	private PeopleVO operatorVO;
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:53:07)
	 */
	public MutualActForm() {
		super();
		setActState("O");
		documentDate = new StringAndSqlDateProperty();
		Date date = new Date(System.currentTimeMillis());
		actstartdate = new StringAndSqlDateProperty();
		setActstartdate(date);
		actenddate = new StringAndSqlDateProperty();
		setActenddate(date);
		documentDateReglament = new StringAndSqlDateProperty();

		setIsSchetFakt(new Boolean(false));
		setMutualNDS(new Boolean(false));

		setWordfileAction("");
		setWordfilePresent(false);

		listForm = "MutualActsListForm";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:21:31)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		LeaseMutualActNewAccessBean lma = (LeaseMutualActNewAccessBean) bean;

		if ("Add".equals(getAction())) {
			LeaseMutualActInfoAccessBean lmaiBean = new LeaseMutualActInfoAccessBean(getLeaseDocument());
			lmaiBean.setLastcalctime(new Timestamp(new GregorianCalendar().getTime().getTime()));
			lmaiBean.commitCopyHelper();
		}

		// Add, Replace or Delete word document
		//updateWordFile(lma,request);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:17:02)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		try {
			LeaseMutualActInfoAccessBean lmaiBean = new LeaseMutualActInfoAccessBean();
			lmaiBean.setInitKey_leasedocument(getLeaseDocument());
			lmaiBean.refreshCopyHelper();

			lmaiBean.getEJBRef().remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//вызываем процедуру freeAct для освобождения возможных связей:
		freeAct(getLeaseDocument(), request.getRemoteUser());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:11:50)
	 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setLeaseDocument(keyGen.getNextKey("tables.leasedocuments"));

		/* @param argLeaseDocument int
		 * @param argDocDate java.sql.Date
		 * @param argDocNumber java.lang.String
		 * @param argLeaseMutualReglament java.lang.Integer
		 * @param argState java.lang.String
		 * @param actstartdate java.sql.Date
		 * @param actenddate java.sql.Date
		 * @param argIsTemp boolean*/

		LeaseMutualActNewAccessBean bean =
			new LeaseMutualActNewAccessBean(
				getLeaseDocument(),
				getDocumentDate(),
				getDocumentNumber(),
				new Integer(getLeaseMutualReglamentcode()),
				getActState(),
				getActstartdate(),
				getActenddate(),
				false);
		//для разделения по филиалам:
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		bean.setRegionid(profile.getProfileAccess().getCurrRegion().getVo().getRegionid().intValue());
		//контроль доступа:
		if (operatorVO == null) {
			operatorVO = com.hps.july.arenda.cdbcobjects.CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
		}
		if (getOperatorVO() != null) {
			bean.setCreatedby(getOperatorVO().getMan());
			bean.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
			bean.setModifiedby(getOperatorVO().getMan());
			bean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		}

		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:40:12)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private CurrencyAccessBean constructCurrency() throws java.lang.Exception {
		if (currency == null) {
			if (getCurrencycode() != 0) {
				currency = new CurrencyAccessBean();
				currency.setInitKey_currency(getCurrencycode());
				currency.refreshCopyHelper();
			}
		}
		return currency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.07.2002 13:06:31)
	 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private LeaseMutualReglamentAccessBean constructLeaseMutualReglament() throws java.lang.Exception {
		if (leaseMutualReglament == null) {
			if (leaseMutualReglamentcode != 0) {
				leaseMutualReglament = new LeaseMutualReglamentAccessBean();
				leaseMutualReglament.setInitKey_leaseDocument(getLeaseMutualReglamentcode());
				leaseMutualReglament.refreshCopyHelper();
			}
		}
		return leaseMutualReglament;
	}
	public void fillRecord(AbstractEntityAccessBean bean) {
		setWordfileAction("");
		setWordfilePresent(false);
		try {
			LeaseMutualActBLOBAccessBean blob = new LeaseMutualActBLOBAccessBean();
			blob.setInitKey_leasedocument(getLeaseDocument());
			blob.refreshCopyHelper();
			setWordfileName(blob.getActfilename());
			if (getWordfileName() != null && !"".equals(getWordfileName().trim())) {
				setWordfilePresent(true);
			}
		} catch (Exception e) {
			setWordfileName("");
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.05.2004 11:39:16)
	 */
	private String freeAct(int actCode, String remoteUser) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = "";
		int taskCode = 0;
		try {
			String sql = "execute procedure freeAct(?, ?, ?)";
			System.out.println(sql + " actCode=" + actCode);
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, actCode); //код акта
			cs.setInt(2, taskCode); //код Журнала
			int operatorCode = OperatorObject.getOperatorCode(remoteUser).intValue();
			cs.setInt(3, operatorCode); //код оператора

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					System.out.println("Процедура 'freeAct' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'freeAct' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'freeAct'"); //temp
			}

		} catch (Exception ex) {
			System.out.println("Error in execute procedure 'freeAct'.MutualActForm.freeAct()");
			if (ex instanceof SQLException) {
				System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
			}
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				if (cs != null)
					cs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
		return errorTxt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:51:13)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getActenddate() {
		return actenddate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:51:13)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getActenddateFrm() {
		return actenddate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:53:25)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getActstartdate() {
		return actstartdate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:53:25)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getActstartdateFrm() {
		return actstartdate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:51:54)
	 * @return java.lang.String
	 */
	public java.lang.String getActState() {
		return actState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @return java.lang.String
	 */
	public java.lang.String getActType() {
		return actType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 15:31:54)
	 * @return java.lang.String
	 */
	public java.lang.String getAdditionalCurrency() {
		return additionalCurrency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:11:50)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @return java.lang.String
	 */
	public java.lang.String getCalcRateType() {
		return calcRateType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getCommonRate() {
		return commonRate;
	}
	public java.util.Enumeration getCurrencies() {
		try {
			CurrencyAccessBean bean = new CurrencyAccessBean();
			return bean.findAllOrderByNameAsc();
		} catch (Exception e) {
			return (new java.util.Vector()).elements();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:49:01)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 */
	public Currency getCurrency() throws Exception {
		CurrencyAccessBean bean = constructCurrency();
		if (bean != null)
			return (Currency) bean.getEJBRef();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:50:39)
	 * @return int
	 */
	public int getCurrencycode() {
		return currencycode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:11:50)
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		/*MutualActsListForm form = (MutualActsListForm) request.getSession().getAttribute("MutualActsListForm");
		setPeriod(form.getPeriod());
		setActtype(form.getActtype());
		setLeaseMutualReglamentcode(form.getMutualReglament());*/

		LeaseMutualActNewAccessBean bean = new LeaseMutualActNewAccessBean();
		bean.setInitKey_leaseDocument(getLeaseDocument());

		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 13:07:29)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getDocumentDate() {
		return documentDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 13:07:29)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getDocumentDateFrm() {
		return documentDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:36:55)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getDocumentDateReglament() {
		return documentDateReglament.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:36:55)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getDocumentDateReglamentFrm() {
		return documentDateReglament.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 13:10:27)
	 * @return java.lang.String
	 */
	public java.lang.String getDocumentNumber() {
		return documentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:36:17)
	 * @return java.lang.String
	 */
	public java.lang.String getDocumentNumberReglament() {
		return documentNumberReglament;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:32:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFooter() {
		return footer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:32:03)
	 * @return java.lang.String
	 */
	public java.lang.String getHeader() {
		return header;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (20.06.2003 18:37:30)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsSchetFakt() {
		return isSchetFakt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 12:41:59)
	 * @return int
	 */
	public int getLeaseDocument() {
		return leaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:45:32)
	 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
	 */
	public com.hps.july.persistence.LeaseMutualReglament getLeaseMutualReglament() throws Exception {
		LeaseMutualReglamentAccessBean bean = constructLeaseMutualReglament();
		return bean != null ? (LeaseMutualReglament) bean.getEJBRef() : null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:46:02)
	 * @return int
	 */
	public int getLeaseMutualReglamentcode() {
		return leaseMutualReglamentcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 15:31:54)
	 * @return java.lang.String
	 */
	public java.lang.String getMainCurrency() {
		return mainCurrency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @return java.lang.String
	 */
	public java.lang.String getMutualPeriod() {
		return mutualPeriod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.12.2005 14:17:54)
	 * @return com.hps.july.arenda.valueobject.PeopleVO
	 */
	private com.hps.july.arenda.valueobject.PeopleVO getOperatorVO() {
		return operatorVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.02.2003 17:12:50)
	 * @return java.sql.Date
	 * @param period java.lang.String "M"(month) or "Q"(quarter)
	 * @param startOrEnd int 0(start) or 1(end)
	 */
	private Date getPreviousPeriod(String period, int startOrEnd) {
		GregorianCalendar c = new GregorianCalendar();
		c.clear(GregorianCalendar.HOUR_OF_DAY);
		c.clear(GregorianCalendar.MINUTE);
		c.clear(GregorianCalendar.SECOND);
		c.clear(GregorianCalendar.MILLISECOND);
		if (period.equals("M")) {
			c.add(GregorianCalendar.MONTH, -1);
			switch (startOrEnd) {
				case 0 :
					c.set(GregorianCalendar.DAY_OF_MONTH, c.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
					break;
				case 1 :
					c.set(GregorianCalendar.DAY_OF_MONTH, c.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
					break;
			}
			return new Date(c.getTime().getTime());
		} else if (period.equals("Y")) {
			c.add(GregorianCalendar.MONTH, -12);
			switch (startOrEnd) {
				case 0 :
					c.set(GregorianCalendar.DAY_OF_MONTH, c.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
					break;
				case 1 :
					c.set(GregorianCalendar.DAY_OF_MONTH, c.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
					break;
			}
			return new Date(c.getTime().getTime());
		} else if (period.equals("Q")) {
			GregorianCalendar quarter = new GregorianCalendar();
			quarter.clear();
			quarter.set(c.get(GregorianCalendar.YEAR), 3, 1);
			while (c.getTime().compareTo(quarter.getTime()) >= 0) {
				quarter.add(GregorianCalendar.MONTH, 3);
			}
			quarter.add(GregorianCalendar.MONTH, -3);
			switch (startOrEnd) {
				case 0 :
					quarter.add(GregorianCalendar.MONTH, -3);
					quarter.set(GregorianCalendar.DAY_OF_MONTH, quarter.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
					break;
				case 1 :
					quarter.add(GregorianCalendar.DAY_OF_MONTH, -1);
					break;
			}
			return new Date(quarter.getTime().getTime());
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.12.2002 13:10:03)
	 * @return java.lang.String
	 */
	public java.lang.String getReglamentState() {
		return reglamentState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:11:50)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.MUTACT_EDIT;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getWordfileAction() {
		return wordfileAction;
	}
	/**
	 * 
	 * @return org.apache.struts.upload.FormFile
	 */
	public org.apache.struts.upload.FormFile getWordfileFrm() {
		return wordfileFrm;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getWordfileName() {
		return wordfileName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		//для контроля доступа:
		if (operatorVO == null) {
			operatorVO = com.hps.july.arenda.cdbcobjects.CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
		}

		MutualActsListForm form = (MutualActsListForm) request.getSession().getAttribute(listForm);
		setLeaseMutualReglamentcode(form.getMutualReglament());
		setActType(form.getActtype());
		setCalcRateType(form.getCalcRateType());
		setCommonRate(form.getCommonRate());
		setDocumentDateReglament(form.getDocumentDate());
		setDocumentNumberReglament(form.getDocumentNumber());
		setMutualPeriod(form.getPeriod());
		setMainCurrency(form.getMainCurrency());
		setAdditionalCurrency(form.getAdditionalCurrency());
		setReglamentState(form.getReglamentState());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		try {
			setDocumentNumber(new ArendaDocumentProcessorAccessBean().getActNumber(getLeaseMutualReglamentcode()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Enumeration e = new LeaseMutualActNewAccessBean().findByQBE2(new Integer(getLeaseMutualReglamentcode()), new Boolean(false), new Boolean(true), new Boolean(true), new Integer(2));
		if (e.hasMoreElements()) {
			LeaseMutualActNewAccessBean bean = (LeaseMutualActNewAccessBean) e.nextElement();
			java.util.GregorianCalendar c = new java.util.GregorianCalendar();
			c.setTime(bean.getActenddate());
			c.add(java.util.Calendar.DAY_OF_MONTH, 1);
			setActstartdate(new Date(c.getTime().getTime()));
		} else {
			e = new LeaseMutualContractsAccessBean().findLeaseArendaAgreementsByReglament(new Integer(getLeaseMutualReglamentcode()));
			if (e.hasMoreElements()) {
				LeaseMutualContractsAccessBean lmcBean = (LeaseMutualContractsAccessBean) e.nextElement();
				setActstartdate(lmcBean.getContract().getStartDate());
			} else {
				setActstartdate(getPreviousPeriod(getMutualPeriod(), 0));
			}
		}

		Date temp = getPreviousPeriod(getMutualPeriod(), 1);
		if (getActstartdate().compareTo(temp) < 0) {
			setActenddate(temp);
		} else {
			setActenddate(new Date(System.currentTimeMillis()));
		}

		java.util.GregorianCalendar c = new java.util.GregorianCalendar();
		c.setTime(getActenddate());
		c.add(java.util.Calendar.DATE, 1);
		setDocumentDate(new java.sql.Date(c.getTime().getTime()));
		//инициализация признака НДС по взаимозачету:
		c = new java.util.GregorianCalendar(2007, 0, 1);
		if (c.getTime().before(getDocumentDate())) {
			setMutualNDS(Boolean.TRUE);
		} else {
			setMutualNDS(Boolean.FALSE);
		}
	}
	/**
	 * 
	 * @return boolean
	 */
	public boolean isWordfilePresent() {
		return wordfilePresent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:51:13)
	 * @param newActenddate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setActenddate(Date newActenddate) {
		actenddate.setSqlDate(newActenddate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:51:13)
	 * @param newActenddate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setActenddateFrm(String newActenddate) {
		actenddate.setString(newActenddate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:53:25)
	 * @param newActstartdate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setActstartdate(Date newActstartdate) {
		actstartdate.setSqlDate(newActstartdate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2002 12:53:25)
	 * @param newActstartdate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setActstartdateFrm(String newActstartdate) {
		actstartdate.setString(newActstartdate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:51:54)
	 * @param newActState java.lang.String
	 */
	public void setActState(java.lang.String newActState) {
		actState = newActState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @param newActType java.lang.String
	 */
	public void setActType(java.lang.String newActType) {
		actType = newActType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 15:31:54)
	 * @param newAdditionalCurrency java.lang.String
	 */
	public void setAdditionalCurrency(java.lang.String newAdditionalCurrency) {
		additionalCurrency = newAdditionalCurrency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @param newCalcRateType java.lang.String
	 */
	public void setCalcRateType(java.lang.String newCalcRateType) {
		calcRateType = newCalcRateType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @param newCommonRate java.lang.Boolean
	 */
	public void setCommonRate(java.lang.Boolean newCommonRate) {
		commonRate = newCommonRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:49:01)
	 * @param newCurrency com.hps.july.persistence.CurrencyAccessBean
	 */
	public void setCurrency(com.hps.july.persistence.CurrencyAccessBean newCurrency) throws Exception {
		if (newCurrency == null) {
			currencycode = 0;
		} else {
			currencycode = newCurrency.getCurrency();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:50:39)
	 * @param newCurrencycode int
	 */
	public void setCurrencycode(int newCurrencycode) {
		currencycode = newCurrencycode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 13:07:29)
	 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDocumentDate(Date newDocumentDate) {
		documentDate.setSqlDate(newDocumentDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 13:07:29)
	 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDocumentDateFrm(String newDocumentDate) {
		documentDate.setString(newDocumentDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:36:55)
	 * @param newDocumentDateReglament com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDocumentDateReglament(Date newDocumentDateReglament) {
		documentDateReglament.setSqlDate(newDocumentDateReglament);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:36:55)
	 * @param newDocumentDateReglament com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDocumentDateReglamentFrm(String newDocumentDateReglament) {
		documentDateReglament.setString(newDocumentDateReglament);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 13:10:27)
	 * @param newDocumentNumber java.lang.String
	 */
	public void setDocumentNumber(java.lang.String newDocumentNumber) {
		documentNumber = newDocumentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:36:17)
	 * @param newDocumentNumberReglament java.lang.String
	 */
	public void setDocumentNumberReglament(java.lang.String newDocumentNumberReglament) {
		documentNumberReglament = newDocumentNumberReglament;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:32:35)
	 * @param newFooter java.lang.String
	 */
	public void setFooter(java.lang.String newFooter) {
		footer = newFooter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2002 10:32:03)
	 * @param newHeader java.lang.String
	 */
	public void setHeader(java.lang.String newHeader) {
		header = newHeader;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (20.06.2003 18:37:30)
	 * @param newIsSchetFakt java.lang.Boolean
	 */
	public void setIsSchetFakt(java.lang.Boolean newIsSchetFakt) {
		isSchetFakt = newIsSchetFakt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 12:41:59)
	 * @param newLeaseDocument int
	 */
	public void setLeaseDocument(int newLeaseDocument) {
		leaseDocument = newLeaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:45:32)
	 * @param newLeaseMutualReglament com.hps.july.persistence.LeaseMutualReglamentAccessBean
	 */
	public void setLeaseMutualReglament(com.hps.july.persistence.LeaseMutualReglamentAccessBean newLeaseMutualReglament) throws Exception {
		if (newLeaseMutualReglament == null) {
			leaseMutualReglamentcode = 0;
		} else {
			leaseMutualReglamentcode = newLeaseMutualReglament.getLeaseDocument();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.07.2002 15:46:02)
	 * @param newLeaseMutualReglamentcode int
	 */
	public void setLeaseMutualReglamentcode(int newLeaseMutualReglamentcode) {
		leaseMutualReglamentcode = newLeaseMutualReglamentcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 15:31:54)
	 * @param newMainCurrency java.lang.String
	 */
	public void setMainCurrency(java.lang.String newMainCurrency) {
		mainCurrency = newMainCurrency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2002 16:00:13)
	 * @param newMutualPeriod java.lang.String
	 */
	public void setMutualPeriod(java.lang.String newMutualPeriod) {
		mutualPeriod = newMutualPeriod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.12.2005 14:17:54)
	 * @param newOperatorVO com.hps.july.arenda.valueobject.PeopleVO
	 */
	private void setOperatorVO(com.hps.july.arenda.valueobject.PeopleVO newOperatorVO) {
		operatorVO = newOperatorVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.12.2002 13:10:03)
	 * @param newReglamentState java.lang.String
	 */
	public void setReglamentState(java.lang.String newReglamentState) {
		reglamentState = newReglamentState;
	}
	/**
	 * 
	 * @param newWordfileAction java.lang.String
	 */
	public void setWordfileAction(java.lang.String newWordfileAction) {
		wordfileAction = newWordfileAction;
	}
	/**
	 * 
	 * @param newWordfileFrm org.apache.struts.upload.FormFile
	 */
	public void setWordfileFrm(org.apache.struts.upload.FormFile newWordfileFrm) {
		wordfileFrm = newWordfileFrm;
	}
	/**
	 * 
	 * @param newWordfileName java.lang.String
	 */
	public void setWordfileName(java.lang.String newWordfileName) {
		wordfileName = newWordfileName;
	}
	/**
	 * 
	 * @param newWordfilePresent boolean
	 */
	public void setWordfilePresent(boolean newWordfilePresent) {
		wordfilePresent = newWordfilePresent;
	}
	private void updateWordFile(LeaseMutualActNewAccessBean bean, HttpServletRequest request) throws Exception {
		LeaseMutualActBLOBAccessBean blob = null;
		if ("1".equals(getWordfileAction())) {
			// Append or replace file
			System.out.println("MUTACTFORM: ADD or REPLACE word file");
			if (getWordfileFrm() != null && getWordfileFrm().getFileData() == null) {
				throw new UpdateValidationException("error.mutualacts.wordfile.empty");
			}
			try {
				try {
					blob = new LeaseMutualActBLOBAccessBean();
					blob.setInitKey_leasedocument(getLeaseDocument());
					blob.refreshCopyHelper();
					System.out.println("MUTACTFORM: BLOB found");
				} catch (Exception e) {
					blob = new LeaseMutualActBLOBAccessBean(getLeaseDocument());
					System.out.println("MUTACTFORM: BLOB created");
				}
				blob.setActfilename(getWordfileFrm().getFileName());
				blob.setActtext(getWordfileFrm().getFileData());
				blob.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				throw new UpdateValidationException("error.mutualacts.wordfile.update");
			}
		} else if ("2".equals(getWordfileAction())) {
			// Delete file
			System.out.println("MUTACTFORM: ADD or REPLACE word file");
			try {
				blob = new LeaseMutualActBLOBAccessBean();
				blob.setInitKey_leasedocument(getLeaseDocument());
				blob.refreshCopyHelper();
				blob.setActfilename(null);
				blob.setActtext(null);
				blob.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				throw new UpdateValidationException("error.mutualacts.wordfile.delete");
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		/*	if (getDocumentNumber() == null || getDocumentNumber().equals("")) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mutualact.docnumber"));
			}*/

		if (getActenddate().compareTo(getActstartdate()) <= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualact.wrongdates"));
		}

		if (!getReglamentState().equals("B")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualact.notcertainstate"));
		}

		/*	Enumeration e = new LeaseMutualActNewAccessBean().findLeaseMutualActNewByLeaseMutualReglament(new LeaseDocumentKey(getLeaseMutualReglamentcode()));
			while (e.hasMoreElements()) {
				LeaseMutualActNewAccessBean bean = (LeaseMutualActNewAccessBean) e.nextElement();
				if (getLeaseDocument() != bean.getLeaseDocument() && bean.getActState().equals("O")) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualact.haseditact"));
					break;
				}
			}*/ // убрано по просьбе аналитика

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#beforeUpdate(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean, javax.servlet.http.HttpServletRequest)
	 */
	public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request) throws Exception {
		LeaseMutualActNewAccessBean abean = (LeaseMutualActNewAccessBean) bean;
		//контроль доступа:
		if (operatorVO == null) {
			operatorVO = com.hps.july.arenda.cdbcobjects.CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
		}
		if (getOperatorVO() != null) {
			abean.setModifiedby(getOperatorVO().getMan());
			abean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		}
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getMutualNDS() {
		return mutualNDS;
	}

	/**
	 * @param boolean1
	 */
	public void setMutualNDS(java.lang.Boolean boolean1) {
		mutualNDS = boolean1;
	}

}

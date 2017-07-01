package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.arenda.valueobject.*;
import javax.servlet.http.*;
import com.hps.july.arenda.valueobject.LeaseAbonentBANValue;
import com.ibm.ivj.ejb.runtime.*;
import java.text.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 *  Form-Bean.
 * "—чета по абоненстским договорам".
 */
public class AbonentBillForm extends com.hps.july.web.util.EditForm {
	private int leasebill;
	private String num;
	private StringAndSqlDateProperty date;
	private String sum;
	private String sumnri;
	private String nds;
	private String ndsnri;
	private StringAndSqlDateProperty startdate;
	private StringAndSqlDateProperty enddate;
	private StringAndIntegerProperty ben;
	private boolean caneditben;
	private java.lang.String billstatus;
	private java.lang.Boolean useinnri;
	private java.lang.String changeuseinnri;
	private java.lang.String bensource;
	private java.lang.Boolean initialUseinnri;
	private java.lang.String recordstatus;
	private java.lang.String billType;
	private java.lang.String ab_ban;
	private boolean ab_useallben;
	private java.lang.String ab_benslist;
	private java.lang.String ab_orgCustomerInn;
	private java.lang.String ab_orgCustomername;
	private java.lang.String ab_bil_inn;
	private java.lang.String ab_bil_name;
	private CurrencyVO currencyVO; //¬алюта счета VO

	/**
	 * 
	 *
	 */
	public AbonentBillForm() {
		date = new StringAndSqlDateProperty();
		startdate = new StringAndSqlDateProperty();
		enddate = new StringAndSqlDateProperty();
		ben = new StringAndIntegerProperty();
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:21:31)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		if (getCaneditben() && ben.getInteger() != null) {
			((AbonentBillAccessBean) bean).setBensource("H");
		}

		if ((getInitialUseinnri() == null ^ getUseinnri() == null) || (getInitialUseinnri() != null && getUseinnri() != null && getInitialUseinnri().booleanValue() != getUseinnri().booleanValue())) {
			((AbonentBillAccessBean) bean).setChangeuseinnri("H");
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2002 11:32:20)
	 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
		return null;
	}

	/**
	 * 
	 */
	public void fillRecord(AbstractEntityAccessBean bean) {
		setInitialUseinnri(getUseinnri());
		try {
			AbonentBillAccessBean bill = (AbonentBillAccessBean) bean;
			setBen(bill.getBen());
			setDate(bill.getBilldate());
			setStartDate(bill.getBillperiodstart());
			setEndDate(bill.getBillperiodend());
			setNum(bill.getBillnumber());
			setBillType(bill.getBilltype());
			/*if(bill.getUseinnri() != null) {
				setUsenri(bill.getUseinnri().booleanValue());
			} my */

			AbonentBillValueObject vo = new AbonentBillValueObject(bill);
			sum = "" + vo.getSum();
			nds = "" + vo.getSumnds();
			sumnri = "" + vo.getNrisum();
			ndsnri = "" + vo.getNrisumnds();
			if (bill.getBen() != null) {
				caneditben = false;
			} else {
				caneditben = true;
			}
			//vo.getSumnsp();

			// Determine master document fields
			LeaseAbonentBANAccessBean lab = bill.getLeaseabonentban();
			setAb_ban(new Integer(lab.getBan()).toString());
			setAb_bil_inn(lab.getBil_inn());
			setAb_bil_name(lab.getBil_name());
			setAb_orgCustomerInn(lab.getOrgCustomer().getInn());
			setAb_orgCustomername(lab.getOrgCustomer().getName());
			setAb_useallben(lab.getUseallben());
			LeaseAbonentBANValue v = new LeaseAbonentBANValue(lab);
			setAb_benslist(v.getBens());
			initCurrencyVO(lab);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	/**
	 * 
	 * @param ab
	 */
	private void initCurrencyVO(LeaseAbonentBANAccessBean ab) {
		try {
			CurrencyAccessBean curAB = ab.getCurrency1();
			CurrencyVO curVO = new CurrencyVO(new Integer(curAB.getCurrency()));
			curVO.setShortname(curAB.getShortname());
			setCurrencyVO(curVO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ќшибка по валюте LeaseAbonentBANAccessBean");
		}
	}
		
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:55:34)
	 * @return java.lang.String
	 */
	public java.lang.String getAb_ban() {
		return ab_ban;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:57:13)
	 * @return java.lang.String
	 */
	public java.lang.String getAb_benslist() {
		return ab_benslist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:59:08)
	 * @return java.lang.String
	 */
	public java.lang.String getAb_bil_inn() {
		return ab_bil_inn;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:59:25)
	 * @return java.lang.String
	 */
	public java.lang.String getAb_bil_name() {
		return ab_bil_name;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:57:57)
	 * @return java.lang.String
	 */
	public java.lang.String getAb_orgCustomerInn() {
		return ab_orgCustomerInn;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:58:20)
	 * @return java.lang.String
	 */
	public java.lang.String getAb_orgCustomername() {
		return ab_orgCustomername;
	}
	/**
	 * 
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	/**
	 * 
	 * @return
	 */
	public Short getBen() {
		return ben.getInteger() != null ? new Short(ben.getInteger().shortValue()) : null;
	}

	/**
	 * 
	 * @return
	 */
	public String getBenFrm() {
		return ben.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 11:19:23)
	 * @return java.lang.String
	 */
	public java.lang.String getBensource() {
		return bensource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 10:45:25)
	 * @return java.lang.String
	 */
	public java.lang.String getBillstatus() {
		return billstatus;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:26:21)
	 * @return java.lang.String
	 */
	public java.lang.String getBillstatusTxt() {
		return AbonentBillValueObject.getBillstatusText(getBillstatus());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.04.2003 15:27:40)
	 * @return java.lang.String
	 */
	public java.lang.String getBillType() {
		return billType;
	}
	public boolean getCaneditben() {
		return caneditben;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 11:09:07)
	 * @return java.lang.String
	 */
	public java.lang.String getChangeuseinnri() {
		return changeuseinnri;
	}
	public AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
		AbonentBillAccessBean bean = new AbonentBillAccessBean();
		bean.setInitKey_leasebill(getLeasebill());
		return bean;
	}
	public java.sql.Date getDate() {
		return date.getSqlDate();
	}
	public String getDateFrm() {
		return date.getString();
	}
	public java.sql.Date getEndDate() {
		return enddate.getSqlDate();
	}
	public String getEndDateFrm() {
		return enddate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.04.2003 15:41:31)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getInitialUseinnri() {
		return initialUseinnri;
	}
	/**
	 * 
	 * @return int
	 */
	public int getLeasebill() {
		return leasebill;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNds() {
		return nds;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNdsnri() {
		return ndsnri;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNum() {
		return num;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2002 11:42:41)
	 * @return com.hps.july.persistence.OrganizationAccessBean
	 */
	public Organization getOrgCustomer() throws Exception {
		/*OrganizationAccessBean bean = constructCustomer();
		if (bean != null) {
			return (Organization) bean.getEJBRef();
		} else {*/
		return null;
		//}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.04.2003 15:56:06)
	 * @return java.lang.String
	 */
	public java.lang.String getRecordstatus() {
		return recordstatus;
	}
	public java.sql.Date getStartDate() {
		return startdate.getSqlDate();
	}
	public String getStartDateFrm() {
		return startdate.getString();
	}
	public int getState() {
		return com.hps.july.arenda.APPStates.ABONENT_BILL_EDIT;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSum() {
		return sum;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSumnri() {
		return sumnri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 10:50:32)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getUseinnri() {
		return useinnri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:56:29)
	 * @return boolean
	 */
	public boolean isAb_useallben() {
		return ab_useallben;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:55:34)
	 * @param newAb_ban java.lang.String
	 */
	public void setAb_ban(java.lang.String newAb_ban) {
		ab_ban = newAb_ban;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:57:13)
	 * @param newAb_benslist java.lang.String
	 */
	public void setAb_benslist(java.lang.String newAb_benslist) {
		ab_benslist = newAb_benslist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:59:08)
	 * @param newAb_bil_inn java.lang.String
	 */
	public void setAb_bil_inn(java.lang.String newAb_bil_inn) {
		ab_bil_inn = newAb_bil_inn;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:59:25)
	 * @param newAb_bil_name java.lang.String
	 */
	public void setAb_bil_name(java.lang.String newAb_bil_name) {
		ab_bil_name = newAb_bil_name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:57:57)
	 * @param newAb_orgCustomerInn java.lang.String
	 */
	public void setAb_orgCustomerInn(java.lang.String newAb_orgCustomerInn) {
		ab_orgCustomerInn = newAb_orgCustomerInn;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:58:20)
	 * @param newAb_orgCustomername java.lang.String
	 */
	public void setAb_orgCustomername(java.lang.String newAb_orgCustomername) {
		ab_orgCustomername = newAb_orgCustomername;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 10:56:29)
	 * @param newAb_useallben boolean
	 */
	public void setAb_useallben(boolean newAb_useallben) {
		ab_useallben = newAb_useallben;
	}
	public void setBen(Short newBen) {
		ben.setInteger(newBen != null ? new Integer(newBen.intValue()) : null);
	}
	public void setBenFrm(String newBen) {
		ben.setString(newBen);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 11:19:23)
	 * @param newBensource java.lang.String
	 */
	public void setBensource(java.lang.String newBensource) {
		bensource = newBensource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 10:45:25)
	 * @param newBillstatus java.lang.String
	 */
	public void setBillstatus(java.lang.String newBillstatus) {
		billstatus = newBillstatus;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.04.2003 15:27:40)
	 * @param newBillType java.lang.String
	 */
	public void setBillType(java.lang.String newBillType) {
		billType = newBillType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.02.2003 16:19:19)
	 * @param newCaneditben boolean
	 */
	public void setCaneditben(boolean newCaneditben) {
		caneditben = newCaneditben;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 11:09:07)
	 * @param newChangeuseinnri java.lang.String
	 */
	public void setChangeuseinnri(java.lang.String newChangeuseinnri) {
		changeuseinnri = newChangeuseinnri;
	}
	public void setDate(java.sql.Date newDate) {
		date.setSqlDate(newDate);
	}
	public void setDateFrm(String newDate) {
		date.setString(newDate);
	}
	public void setEndDate(java.sql.Date newDate) {
		enddate.setSqlDate(newDate);
	}
	public void setEndDateFrm(String newDate) {
		enddate.setString(newDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.04.2003 15:41:31)
	 * @param newInitialUseinnri java.lang.Boolean
	 */
	public void setInitialUseinnri(java.lang.Boolean newInitialUseinnri) {
		initialUseinnri = newInitialUseinnri;
	}
	/**
	 * 
	 * @param newLeasebill int
	 */
	public void setLeasebill(int newLeasebill) {
		leasebill = newLeasebill;
	}
	/**
	 * 
	 * @param newNds java.lang.String
	 */
	public void setNds(java.lang.String newNds) {
		nds = newNds;
	}
	/**
	 * 
	 * @param newNdsnri java.lang.String
	 */
	public void setNdsnri(java.lang.String newNdsnri) {
		ndsnri = newNdsnri;
	}
	/**
	 * 
	 * @param newNum java.lang.String
	 */
	public void setNum(java.lang.String newNum) {
		num = newNum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.04.2003 15:56:06)
	 * @param newRecordstatus java.lang.String
	 */
	public void setRecordstatus(java.lang.String newRecordstatus) {
		recordstatus = newRecordstatus;
	}
	public void setStartDate(java.sql.Date newStartDate) {
		startdate.setSqlDate(newStartDate);
	}
	public void setStartDateFrm(String newStartDate) {
		startdate.setString(newStartDate);
	}
	/**
	 * 
	 * @param newSum java.lang.String
	 */
	public void setSum(java.lang.String newSum) {
		sum = newSum;
	}
	/**
	 * 
	 * @param newSumnri java.lang.String
	 */
	public void setSumnri(java.lang.String newSumnri) {
		sumnri = newSumnri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.04.2003 10:50:32)
	 * @param newUseinnri java.lang.Boolean
	 */
	public void setUseinnri(java.lang.Boolean newUseinnri) {
		useinnri = newUseinnri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if (getCaneditben() && !ben.isEmpty() && !ben.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.abonentbill.ben"));
		}

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * @return
	 */
	public CurrencyVO getCurrencyVO() {
		return currencyVO;
	}

	/**
	 * @param currencyVO
	 */
	private void setCurrencyVO(CurrencyVO currencyVO) {
		this.currencyVO = currencyVO;
	}

}

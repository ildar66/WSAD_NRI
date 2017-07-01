package com.hps.july.arenda.formbean;

import com.hps.july.arenda.valueobject.CurrencyVO;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.math.BigDecimal;
/**
 * Form-Bean.
 * список "Позиций абонентского счета".
 * Creation date: (08.10.2002 14:15:05)
 * @author: Sergey Gourov
 */
public class AbonentBillPosesListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseBill;
	private java.lang.String ban;
	private String customername;
	private String customerinn;
	private java.lang.String customernameBill;
	private java.lang.String customerinnBill;
	private java.lang.String billNumber;
	private java.sql.Date billDate;
	private StringAndBigDecimalProperty sum;
	private StringAndBigDecimalProperty sumnds;
	private StringAndBigDecimalProperty sumnsp;
	private boolean flagworknri;
	private java.lang.String contractState;
	private boolean useallben;
	private java.lang.String bensList;
	private CurrencyVO currencyVO; //Валюта счета VO
	/**
	 * AbonentBillPosesList constructor comment.
	 */
	public AbonentBillPosesListForm() {
		super();
		setFinderMethodName("findByLeaseBill");

		sum = new StringAndBigDecimalProperty();
		sumnds = new StringAndBigDecimalProperty();
		sumnsp = new StringAndBigDecimalProperty();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 15:51:06)
	 * @return java.lang.String
	 */
	public java.lang.String getBan() {
		return ban;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 11:55:49)
	 * @return java.lang.String
	 */
	public java.lang.String getBensList() {
		return bensList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:22:21)
	 * @return java.sql.Date
	 */
	public java.sql.Date getBillDate() {
		return billDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:21:52)
	 * @return java.lang.String
	 */
	public java.lang.String getBillNumber() {
		return billNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 14:23:57)
	 * @return java.lang.String
	 */
	public java.lang.String getContractState() {
		return contractState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomerinn() {
		return customerinn;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomerinnBill() {
		return customerinnBill;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomername() {
		return customername;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomernameBill() {
		return customernameBill;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 14:15:05)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { new Integer(leaseBill)};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 14:21:26)
	 * @return int
	 */
	public int getLeaseBill() {
		return leaseBill;
	}
	public BigDecimal getSum() {
		return sum.getBigDecimal();
	}
	public String getSumFrm() {
		return sum.getString();
	}
	public BigDecimal getSumnds() {
		return sumnds.getBigDecimal();
	}
	public String getSumndsFrm() {
		return sumnds.getString();
	}
	public BigDecimal getSumnsp() {
		return sumnsp.getBigDecimal();
	}
	public String getSumnspFrm() {
		return sumnsp.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.04.2003 15:36:09)
	 * @return boolean
	 */
	public boolean isFlagworknri() {
		return flagworknri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 11:09:42)
	 * @return boolean
	 */
	public boolean isUseallben() {
		return useallben;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 15:51:06)
	 * @param newBan java.lang.String
	 */
	public void setBan(java.lang.String newBan) {
		ban = newBan;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 11:55:49)
	 * @param newBensList java.lang.String
	 */
	public void setBensList(java.lang.String newBensList) {
		bensList = newBensList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:22:21)
	 * @param newBillDate java.sql.Date
	 */
	public void setBillDate(java.sql.Date newBillDate) {
		billDate = newBillDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:21:52)
	 * @param newBillNumber java.lang.String
	 */
	public void setBillNumber(java.lang.String newBillNumber) {
		billNumber = newBillNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 14:23:57)
	 * @param newContractState java.lang.String
	 */
	public void setContractState(java.lang.String newContractState) {
		contractState = newContractState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @param newCustomerinn java.lang.String
	 */
	public void setCustomerinn(java.lang.String newCustomerinn) {
		customerinn = newCustomerinn;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @param newCustomerinnBill java.lang.String
	 */
	public void setCustomerinnBill(java.lang.String newCustomerinnBill) {
		customerinnBill = newCustomerinnBill;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @param newCustomername java.lang.String
	 */
	public void setCustomername(java.lang.String newCustomername) {
		customername = newCustomername;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 16:11:26)
	 * @param newCustomernameBill java.lang.String
	 */
	public void setCustomernameBill(java.lang.String newCustomernameBill) {
		customernameBill = newCustomernameBill;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.04.2003 15:36:09)
	 * @param newFlagworknri boolean
	 */
	public void setFlagworknri(boolean newFlagworknri) {
		flagworknri = newFlagworknri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.10.2002 14:21:26)
	 * @param newLeaseBill int
	 */
	public void setLeaseBill(int newLeaseBill) {
		leaseBill = newLeaseBill;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.10.2002 10:49:18)
	 * @param newSum java.math.BigDecimal
	 */
	public void setSum(java.math.BigDecimal newSum) {
		sum.setBigDecimal(newSum);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.10.2002 10:49:18)
	 * @param newSum java.math.BigDecimal
	 */
	public void setSumFrm(String newSum) {
		sum.setString(newSum);
	}
	public void setSumnds(java.math.BigDecimal newSumnds) {
		sumnds.setBigDecimal(newSumnds);
	}
	public void setSumndsFrm(String newSumnds) {
		sumnds.setString(newSumnds);
	}
	public void setSumnsp(java.math.BigDecimal newSumnsp) {
		sumnsp.setBigDecimal(newSumnsp);
	}
	public void setSumnspFrm(String newSumnsp) {
		sumnsp.setString(newSumnsp);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 11:09:42)
	 * @param newUseallben boolean
	 */
	public void setUseallben(boolean newUseallben) {
		useallben = newUseallben;
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
	/**
	 * 
	 * @param ab
	 */
	public void initCurrencyVO(LeaseAbonentBANAccessBean ab) {
		try {
			CurrencyAccessBean curAB = ab.getCurrency1();
			CurrencyVO curVO = new CurrencyVO(new Integer(curAB.getCurrency()));
			curVO.setShortname(curAB.getShortname());
			setCurrencyVO(curVO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка по валюте LeaseAbonentBANAccessBean");
		}
	}	
}

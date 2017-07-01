package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.util.*;
import com.hps.july.persistence.*;
/**
 * Bean-Wrapper "Счета по абоненстским договорам"
 * Creation date: (07.10.2002 18:51:32)
 * @author: Sergey Gourov
 */
public class AbonentBillValueObject {
	private com.hps.july.persistence.AbonentBillAccessBean o;
	private java.math.BigDecimal sum;
	private java.math.BigDecimal sumnds;
	private java.math.BigDecimal sumnsp;
	private java.util.Map paramsForPoses;
	private java.math.BigDecimal payed;
	private java.math.BigDecimal nrisum;
	private java.math.BigDecimal nrisumnds;
	private java.math.BigDecimal nrisumnsp;

	private java.lang.Short ben;
	private java.lang.String bensource;
	private java.sql.Date billdate;
	private java.lang.String billnumber;
	private java.sql.Date billperiodend;
	private java.sql.Date billperiodstart;
	private java.lang.String billstatus;
	private java.lang.String billtype;
	private int leasebill;
	private boolean flagworknri;
	private java.lang.Boolean useinnri;
	private java.lang.String recordstatus;
	private java.math.BigDecimal notpayed;
	private boolean summsdiffer;

	private String payednotes;
	private java.lang.String sumchangereason;
	/**
	 * AbonentBillValueObject constructor comment.
	 */
	public AbonentBillValueObject() {
		sum = new BigDecimal("0.00");
		sumnds = new BigDecimal("0.00");
		sumnsp = new BigDecimal("0.00");
		nrisum = new BigDecimal("0.00");
		nrisumnds = new BigDecimal("0.00");
		nrisumnsp = new BigDecimal("0.00");
		payed = new BigDecimal("0.00");
	}
	/**
	 * AbonentBillValueObject constructor comment.
	 */
	public AbonentBillValueObject(AbonentBillAccessBean bean) {
		o = bean;
		sum = new BigDecimal("0.00");
		sumnds = new BigDecimal("0.00");
		sumnsp = new BigDecimal("0.00");
		nrisum = new BigDecimal("0.00");
		nrisumnds = new BigDecimal("0.00");
		nrisumnsp = new BigDecimal("0.00");
		payed = new BigDecimal("0.00");

		try {
			bean.getSummopl();
			bean.getNotessummopl();

			Enumeration ebp = new AbonentBillPosAccessBean().findByLeaseBill(new Integer(o.getLeasebill()));
			while (ebp.hasMoreElements()) {
				AbonentBillPosAccessBean bpos = (AbonentBillPosAccessBean) ebp.nextElement();
				sum = sum.add(bpos.getSumm());
				sum.setScale(2, BigDecimal.ROUND_HALF_UP);
				sumnds = sumnds.add(bpos.getNdssumm());
				sumnds.setScale(2, BigDecimal.ROUND_HALF_UP);
				sumnsp = sumnsp.add(bpos.getNspsumm());
				sumnsp.setScale(2, BigDecimal.ROUND_HALF_UP);
				nrisum = nrisum.add(bpos.getSummnri());
				nrisum.setScale(2, BigDecimal.ROUND_HALF_UP);
				nrisumnds = nrisumnds.add(bpos.getNdssummnri());
				nrisumnds.setScale(2, BigDecimal.ROUND_HALF_UP);
				nrisumnsp = nrisumnsp.add(bpos.getNspsummnri());
				nrisumnsp.setScale(2, BigDecimal.ROUND_HALF_UP);
			}

			ebp = new LeaseAbonentDNOPAccessBean().findLeaseAbonentDNOPsByAbonentbill(new AbonentBillKey(bean.getLeasebill()));
			while (ebp.hasMoreElements()) {
				LeaseAbonentDNOPAccessBean ladBean = (LeaseAbonentDNOPAccessBean) ebp.nextElement();
				if (ladBean.getRecordstatus().equals("A")) {
					payed = payed.add(ladBean.getSumlinkusd()).setScale(2, BigDecimal.ROUND_HALF_UP);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:18:24)
	 * @return java.lang.Short
	 */
	public java.lang.Short getBen() {
		return ben;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:18:44)
	 * @return java.lang.String
	 */
	public java.lang.String getBensource() {
		return bensource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:19:32)
	 * @return java.sql.Date
	 */
	public java.sql.Date getBilldate() {
		return billdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:19:50)
	 * @return java.lang.String
	 */
	public java.lang.String getBillnumber() {
		return billnumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:23:35)
	 * @return java.sql.Date
	 */
	public java.sql.Date getBillperiodend() {
		return billperiodend;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:23:59)
	 * @return java.sql.Date
	 */
	public java.sql.Date getBillperiodstart() {
		return billperiodstart;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:26:21)
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
	 * 
	 * @param billstatus
	 * @return
	 */
	public static String getBillstatusText(String billstatus) {
		String billstatusTxt = "Неизвестный тип";
		if ("A".equals(billstatus)) {
			billstatusTxt = "в процессе подготовки";
		} else if ("G".equals(billstatus)) {
			billstatusTxt = "сформирован";
		} else if ("H".equals(billstatus)) {
			billstatusTxt = "hold";
		} else if ("R".equals(billstatus)) {
			billstatusTxt = "исторический "; //оставляют только заголовок счета
		} else if (billstatus == null) {
			billstatusTxt = "не указан";
		}
		return billstatusTxt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:26:34)
	 * @return java.lang.String
	 */
	public java.lang.String getBilltype() {
		return billtype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:26:48)
	 * @return int
	 */
	public int getLeasebill() {
		return leasebill;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 12:14:41)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNotpayed() {
		return notpayed;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 13:23:10)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNrisum() {
		return nrisum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 13:23:10)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNrisumnds() {
		return nrisumnds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 13:23:10)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNrisumnsp() {
		return nrisumnsp;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:51:55)
	 * @return com.hps.july.persistence.AbonentBillAccessBean
	 */
	public com.hps.july.persistence.AbonentBillAccessBean getO() {
		return o;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.10.2002 11:26:47)
	 * @return java.util.Map
	 */
	public java.util.Map getParamsForPoses() {
		return paramsForPoses;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 12:27:45)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getPayed() {
		return payed;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPayednotes() {
		return payednotes;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:53:07)
	 * @return java.lang.String
	 */
	public java.lang.String getRecordstatus() {
		return recordstatus;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:55:19)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSum() {
		return sum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.01.2004 10:40:02)
	 * @return java.lang.String
	 */
	public java.lang.String getSumchangereason() {
		return sumchangereason;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:55:57)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumnds() {
		return sumnds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:56:14)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumnsp() {
		return sumnsp;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:52:17)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getUseinnri() {
		return useinnri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:51:43)
	 * @return boolean
	 */
	public boolean isFlagworknri() {
		return flagworknri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 12:15:04)
	 * @return boolean
	 */
	public boolean isSummsdiffer() {
		return summsdiffer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:18:24)
	 * @param newBen java.lang.Short
	 */
	public void setBen(java.lang.Short newBen) {
		ben = newBen;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:18:44)
	 * @param newBensource java.lang.String
	 */
	public void setBensource(java.lang.String newBensource) {
		bensource = newBensource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:19:32)
	 * @param newBilldate java.sql.Date
	 */
	public void setBilldate(java.sql.Date newBilldate) {
		billdate = newBilldate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:19:50)
	 * @param newBillnumber java.lang.String
	 */
	public void setBillnumber(java.lang.String newBillnumber) {
		billnumber = newBillnumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:23:35)
	 * @param newBillperiodend java.sql.Date
	 */
	public void setBillperiodend(java.sql.Date newBillperiodend) {
		billperiodend = newBillperiodend;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:23:59)
	 * @param newBillperiodstart java.sql.Date
	 */
	public void setBillperiodstart(java.sql.Date newBillperiodstart) {
		billperiodstart = newBillperiodstart;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:26:21)
	 * @param newBillstatus java.lang.String
	 */
	public void setBillstatus(java.lang.String newBillstatus) {
		billstatus = newBillstatus;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:26:34)
	 * @param newBilltype java.lang.String
	 */
	public void setBilltype(java.lang.String newBilltype) {
		billtype = newBilltype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:51:43)
	 * @param newFlagworknri boolean
	 */
	public void setFlagworknri(boolean newFlagworknri) {
		flagworknri = newFlagworknri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:26:48)
	 * @param newLeasebill int
	 */
	public void setLeasebill(int newLeasebill) {
		leasebill = newLeasebill;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 12:14:41)
	 * @param newNotpayed java.math.BigDecimal
	 */
	public void setNotpayed(java.math.BigDecimal newNotpayed) {
		notpayed = newNotpayed;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 13:23:10)
	 * @param newNrisum java.math.BigDecimal
	 */
	public void setNrisum(java.math.BigDecimal newNrisum) {
		nrisum = newNrisum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 13:23:10)
	 * @param newNrisumnds java.math.BigDecimal
	 */
	public void setNrisumnds(java.math.BigDecimal newNrisumnds) {
		nrisumnds = newNrisumnds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 13:23:10)
	 * @param newNrisumnsp java.math.BigDecimal
	 */
	public void setNrisumnsp(java.math.BigDecimal newNrisumnsp) {
		nrisumnsp = newNrisumnsp;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:51:55)
	 * @param newO com.hps.july.persistence.AbonentBillAccessBean
	 */
	public void setO(com.hps.july.persistence.AbonentBillAccessBean newO) {
		o = newO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.10.2002 11:26:47)
	 * @param newParamsForPoses java.util.Map
	 */
	public void setParamsForPoses(java.util.Map newParamsForPoses) {
		paramsForPoses = newParamsForPoses;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2003 12:27:45)
	 * @param newPayed java.math.BigDecimal
	 */
	public void setPayed(java.math.BigDecimal newPayed) {
		payed = newPayed;
	}
	/**
	 * 
	 * @param newPayednotes java.lang.String
	 */
	public void setPayednotes(java.lang.String newPayednotes) {
		payednotes = newPayednotes;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:53:07)
	 * @param newRecordstatus java.lang.String
	 */
	public void setRecordstatus(java.lang.String newRecordstatus) {
		recordstatus = newRecordstatus;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:55:19)
	 * @param newSum java.math.BigDecimal
	 */
	public void setSum(java.math.BigDecimal newSum) {
		sum = newSum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.01.2004 10:40:02)
	 * @param newSumchangereason java.lang.String
	 */
	public void setSumchangereason(java.lang.String newSumchangereason) {
		sumchangereason = newSumchangereason;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.11.2003 12:15:04)
	 * @param newSummsdiffer boolean
	 */
	public void setSummsdiffer(boolean newSummsdiffer) {
		summsdiffer = newSummsdiffer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:55:57)
	 * @param newSumnds java.math.BigDecimal
	 */
	public void setSumnds(java.math.BigDecimal newSumnds) {
		sumnds = newSumnds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2002 18:56:14)
	 * @param newSumnsp java.math.BigDecimal
	 */
	public void setSumnsp(java.math.BigDecimal newSumnsp) {
		sumnsp = newSumnsp;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2003 13:52:17)
	 * @param newUseinnri java.lang.Boolean
	 */
	public void setUseinnri(java.lang.Boolean newUseinnri) {
		useinnri = newUseinnri;
	}
}

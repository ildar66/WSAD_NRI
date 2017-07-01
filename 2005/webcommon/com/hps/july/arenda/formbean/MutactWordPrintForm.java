package com.hps.july.arenda.formbean;

import com.hps.july.arenda.valueobject.*;

import java.math.BigDecimal;
import java.util.*;
/**
* ‘орма дл€ печати акта в Word-e (взаимозачета, сверки, взаимных требований).
* Creation date: (18.07.2002 11:50:43)
* @author: Shafigullin Ildar
*/
public class MutactWordPrintForm extends org.apache.struts.action.ActionForm {
	private java.util.ArrayList table1;
	private java.util.ArrayList table2;
	private java.util.ArrayList table3;
	private java.util.ArrayList table4;
	private java.lang.String actcode;
	private MutualHeaderValueObject header;
	private com.hps.july.arenda.valueobject.MutualHeaderAccValueObject headerAcc;
	private ArrayList headerAccList;
	private java.lang.Integer headerID;
	private com.hps.july.arenda.valueobject.SverkaHeaderValueObject sverkaHeader;
	private java.util.ArrayList table5;
	private com.hps.july.arenda.valueobject.SverkaContrResValueObject sverkaContrRes;
	private int idTask;
	private java.util.ArrayList table6;
	private ArrayList listSumMutualForPrintAct;
	private ArrayList listMutualDebtNds; // онечна€ задолженность по договорам и услугам, участвующим в акте (взаимозачета и взаимных требований)

	public MutactWordPrintForm() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 18:04:58)
	 * @return java.lang.String
	 */
	public java.lang.String getActcode() {
		return actcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2003 11:08:09)
	 * @return com.hps.july.arenda.valueobject.MutualHeaderValueObject
	 */
	public MutualHeaderValueObject getHeader() {
		return header;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:45:12)
	 * @return com.hps.july.arenda.valueobject.MutualHeaderAccValueObject
	 */
	public com.hps.july.arenda.valueobject.MutualHeaderAccValueObject getHeaderAcc() {
		return headerAcc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 14:04:18)
	 * @return java.util.ArrayList
	 */
	public ArrayList getHeaderAccList() {
		return headerAccList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 18:28:20)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getHeaderID() {
		return headerID;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 13:48:55)
	 * @return java.lang.String
	 */
	public int getIdTask() {
		return idTask;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.02.2004 12:12:29)
	 * @return java.lang.String
	 * @param customer java.lang.String
	 */
	public String getInfoForCustomer(String customer) {
		if (getTable2() == null || getTable2().size() == 0)
			return "";
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd.MM.yy");
		java.util.HashSet list = new java.util.HashSet();
		java.util.Iterator iter = getTable2().iterator();
		while (iter.hasNext()) {
			MutualChargesValueObject vo = (MutualChargesValueObject) iter.next();
			if (vo.getCustomer().equals(customer)) {
				if (vo.getContractDate() != null)
					list.add("є " + vo.getContractNumber() + " от " + formatter.format(vo.getContractDate()));
				else
					list.add("є " + vo.getContractNumber() + " от ");
			}
		}
		iter = list.iterator();
		StringBuffer buffer = new StringBuffer();
		while (iter.hasNext()) {
			buffer.append(iter.next());
			if (iter.hasNext())
				buffer.append(", ");
		}
		return buffer.toString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:41:44)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.ACT_PARAMS_PRINT;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 12:59:54)
	 * @return com.hps.july.arenda.valueobject.SverkaContrResValueObject
	 */
	public com.hps.july.arenda.valueobject.SverkaContrResValueObject getSverkaContrRes() {
		return sverkaContrRes;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 12:56:40)
	 * @return com.hps.july.arenda.valueobject.SverkaHeaderValueObject
	 */
	public com.hps.july.arenda.valueobject.SverkaHeaderValueObject getSverkaHeader() {
		return sverkaHeader;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 15:13:29)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable1() {
		if ((headerAccList != null) && (headerAccList.size() > 1)) {
			ArrayList list = new ArrayList();
			java.util.Iterator iter = table1.iterator();
			while (iter.hasNext()) {
				MutualStartDebtValueObject msdvo = (MutualStartDebtValueObject) iter.next();
				if (msdvo.getHeaderId().compareTo(headerID) == 0)
					list.add(msdvo);
			}
			return list;
		} else
			return table1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 15:13:51)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable2() {
		if ((headerAccList != null) && (headerAccList.size() > 1)) {
			ArrayList list = new ArrayList();
			java.util.Iterator iter = table2.iterator();
			while (iter.hasNext()) {
				MutualChargesValueObject mcvo = (MutualChargesValueObject) iter.next();
				if (mcvo.getHeaderId().compareTo(headerID) == 0)
					list.add(mcvo);
			}
			return list;
		} else
			return table2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 15:14:13)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable3() {
		if ((headerAccList != null) && (headerAccList.size() > 1)) {
			ArrayList list = new ArrayList();
			java.util.Iterator iter = table3.iterator();
			while (iter.hasNext()) {
				MutualPaymentsValueObject mpvo = (MutualPaymentsValueObject) iter.next();
				if (mpvo.getHeaderId().compareTo(headerID) == 0)
					list.add(mpvo);
			}
			return list;
		} else
			return table3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 12:57:25)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable4() {
		if ((headerAccList != null) && (headerAccList.size() > 1)) {
			ArrayList list = new ArrayList();
			java.util.Iterator iter = table4.iterator();
			while (iter.hasNext()) {
				MutualEndDebtValueObject medvo = (MutualEndDebtValueObject) iter.next();
				if (medvo.getHeaderId().compareTo(headerID) == 0)
					list.add(medvo);
			}
			return list;
		} else
			return table4;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 12:57:25)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable4_For(String customer, String executor) {
		ArrayList list = new ArrayList();
		if (getTable4() != null) {
			java.util.Iterator iter = getTable4().iterator();
			while (iter.hasNext()) {
				MutualEndDebtValueObject medvo = (MutualEndDebtValueObject) iter.next();
				if (customer.equals(medvo.getCustomer()) && executor.equals(medvo.getExecutor())) {
					list.add(medvo);
				}
			}
		}
		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 12:57:25)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable3_For(String orgpayer, String agent) {
		ArrayList list = new ArrayList();
		if (getTable3() != null) {
			java.util.Iterator iter = getTable3().iterator();
			while (iter.hasNext()) {
				MutualPaymentsValueObject mpvo = (MutualPaymentsValueObject) iter.next();
				if (orgpayer.equals(mpvo.getOrgPayer()) && agent.equals(mpvo.getAgent())) {
					list.add(mpvo);
				}
			}
		}
		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 12:57:25)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable3_For(String orgpayer, String agent, boolean isNds) {
		ArrayList list = new ArrayList();
		if (getTable3() != null) {
			java.util.Iterator iter = getTable3().iterator();
			while (iter.hasNext()) {
				MutualPaymentsValueObject mpvo = (MutualPaymentsValueObject) iter.next();
				if (orgpayer.equals(mpvo.getOrgPayer()) && agent.equals(mpvo.getAgent())) {
					if (isNds) {
						if (mpvo.getSumWithoutMain() != null && mpvo.getSumWithoutMain().intValue() == 0) {
							list.add(mpvo);
						}
					} else {
						if (mpvo.getSumWithoutMain() != null && mpvo.getSumWithoutMain().intValue() != 0) {
							list.add(mpvo);
						}
					}
				}
			}
		}
		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 12:57:25)
	 * @return java.util.ArrayList
	 */
	public java.math.BigDecimal getTable4_ItogoSumMain_For(String customer, String executor) {
		ArrayList list = getTable4_For(customer, executor);
		java.math.BigDecimal sum_sumMain = new java.math.BigDecimal(0);
		if (list != null) {
			java.util.Iterator iter = list.iterator();
			while (iter.hasNext()) {
				MutualEndDebtValueObject medvo = (MutualEndDebtValueObject) iter.next();
				if (medvo.getSumMain() != null) {
					sum_sumMain = sum_sumMain.add(medvo.getSumMain());
				}
			}
		}
		return sum_sumMain;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 12:57:25)
	 * @return java.util.ArrayList
	 */
	public MutualPaymentsValueObject getTable3_Itogo_For(String orgpayer, String agent) {
		ArrayList list = getTable3_For(orgpayer, agent);
		MutualPaymentsValueObject itogoVal = new MutualPaymentsValueObject();
		itogoVal.setSumRub(new BigDecimal(0));
		itogoVal.setNdsRub(new BigDecimal(0));
		itogoVal.setSumMainCurr(new BigDecimal(0));
		itogoVal.setNdsMainCurr(new BigDecimal(0));
		itogoVal.setSumWithoutMain(new BigDecimal(0));
		if (list != null) {
			java.util.Iterator iter = list.iterator();
			while (iter.hasNext()) {
				MutualPaymentsValueObject mpvo = (MutualPaymentsValueObject) iter.next();
				if (mpvo.getSumRub() != null) {
					itogoVal.setSumRub(itogoVal.getSumRub().add(mpvo.getSumRub()));
				}
				if (mpvo.getNdsRub() != null) {
					itogoVal.setNdsRub(itogoVal.getNdsRub().add(mpvo.getNdsRub()));
				}
				if (mpvo.getSumMainCurr() != null) {
					itogoVal.setSumMainCurr(itogoVal.getSumMainCurr().add(mpvo.getSumMainCurr()));
				}
				if (mpvo.getNdsMainCurr() != null) {
					itogoVal.setNdsMainCurr(itogoVal.getNdsMainCurr().add(mpvo.getNdsMainCurr()));
				}
				if (mpvo.getSumWithoutMain() != null) {
					itogoVal.setSumWithoutMain(itogoVal.getSumWithoutMain().add(mpvo.getSumWithoutMain()));
				}
			}
		}
		return itogoVal;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 12:57:26)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable5() {
		return table5;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.01.2004 15:47:20)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getTable6() {
		if ((headerAccList != null) && (headerAccList.size() > 1)) {
			ArrayList list = new ArrayList();
			java.util.Iterator iter = table6.iterator();
			while (iter.hasNext()) {
				MutTempDebtValueObject mtdvo = (MutTempDebtValueObject) iter.next();
				if (mtdvo.getHeaderId().compareTo(headerID) == 0)
					list.add(mtdvo);
			}
			return list;
		} else
			return table6;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 18:04:58)
	 * @param newActcode java.lang.String
	 */
	public void setActcode(java.lang.String newActcode) {
		actcode = newActcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.12.2003 11:08:09)
	 * @param newHeader com.hps.july.arenda.valueobject.MutualHeaderValueObject
	 */
	public void setHeader(MutualHeaderValueObject newHeader) {
		header = newHeader;
		headerID = newHeader.getHeaderId();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2003 17:45:12)
	 * @param newHeaderAcc com.hps.july.arenda.valueobject.MutualHeaderAccValueObject
	 */
	public void setHeaderAcc(com.hps.july.arenda.valueobject.MutualHeaderAccValueObject newHeaderAcc) {
		headerAcc = newHeaderAcc;
		headerID = newHeaderAcc.getHeaderId();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 14:04:18)
	 * @param newHeaderAccList java.util.ArrayList
	 */
	public void setHeaderAccList(ArrayList newHeaderAccList) {
		headerAccList = newHeaderAccList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.12.2003 18:28:20)
	 * @param newHeaderID java.lang.Integer
	 */
	public void setHeaderID(java.lang.Integer newHeaderID) {
		headerID = newHeaderID;
	}
	/**
	* Insert the method's description here.
	* Creation date: (23.12.2003 13:48:55)
	* @param newIdTask int
	*/
	public void setIdTask(int newIdTask) {
		idTask = newIdTask;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 12:59:54)
	 * @param newSverkaContrRes com.hps.july.arenda.valueobject.SverkaContrResValueObject
	 */
	public void setSverkaContrRes(com.hps.july.arenda.valueobject.SverkaContrResValueObject newSverkaContrRes) {
		sverkaContrRes = newSverkaContrRes;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 12:56:40)
	 * @param newSverkaHeader com.hps.july.arenda.valueobject.SverkaHeaderValueObject
	 */
	public void setSverkaHeader(com.hps.july.arenda.valueobject.SverkaHeaderValueObject newSverkaHeader) {
		sverkaHeader = newSverkaHeader;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 15:13:29)
	 * @param newTable1 java.util.ArrayList
	 */
	public void setTable1(java.util.ArrayList newTable1) {
		table1 = newTable1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 15:13:51)
	 * @param newTable2 java.util.ArrayList
	 */
	public void setTable2(java.util.ArrayList newTable2) {
		table2 = newTable2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2003 15:14:13)
	 * @param newTable3 java.util.ArrayList
	 */
	public void setTable3(java.util.ArrayList newTable3) {
		table3 = newTable3;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 12:57:25)
	 * @param newTable4 java.util.ArrayList
	 */
	public void setTable4(java.util.ArrayList newTable4) {
		table4 = newTable4;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2003 12:57:26)
	 * @param newTable5 java.util.ArrayList
	 */
	public void setTable5(java.util.ArrayList newTable5) {
		table5 = newTable5;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.01.2004 15:47:20)
	 * @param newTable6 java.util.ArrayList
	 */
	public void setTable6(java.util.ArrayList newTable6) {
		table6 = newTable6;
	}
	/**
	 * @return
	 */
	public ArrayList getListSumMutualForPrintAct() {
		return listSumMutualForPrintAct;
	}

	/**
	 * @param list
	 */
	public void setListSumMutualForPrintAct(ArrayList list) {
		listSumMutualForPrintAct = list;
	}

	/**
	 * @return
	 */
	public ArrayList getListMutualDebtNds() {
		if ((headerAccList != null) && (headerAccList.size() > 1)) {
			ArrayList list = new ArrayList();
			java.util.Iterator iter = listMutualDebtNds.iterator();
			while (iter.hasNext()) {
				MutualDebtNds_VO vo = (MutualDebtNds_VO) iter.next();
				if (vo.getHeaderId().compareTo(headerID) == 0)
					list.add(vo);
			}
			return list;
		} else
			return listMutualDebtNds;
	}

	/**
	 * @param list
	 */
	public void setListMutualDebtNds(ArrayList list) {
		listMutualDebtNds = list;
	}

}

/*
 * Created on 09.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCLeaseChargesObject;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.valueobject.LeaseCharge_TO;
import com.hps.july.valueobject.LeaseCharge_VO;
/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChargeListLinkToPaymentForm extends ChargeListForm {
	private int[] selectIds = new int[0];
	private boolean flagOperation;
	private Integer leasePayment;

	/**
	 * 
	 */
	public ChargeListLinkToPaymentForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.CHARGE_LIST_LINK_TO_PAYMENT;
	}

	/**
	 * @return
	 */
	public int[] getSelectIds() {
		return selectIds;
	}

	/**
	 * @param is
	 */
	public void setSelectIds(int[] is) {
		selectIds = is;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		//System.out.println("getSelectIds= " + getSelectIds().length);//temp
		initChargesList(request);
		if (getSelectIds().length > 0) {
			for (int i = 0; i < getSelectIds().length; i++) {
				int result = CDBCLeaseChargesObject.lnkOneChrg2PayAct(null, new Integer(getSelectIds()[i]), getLeasePayment(), "N", new Integer(1), new Integer(840));
				if (result != 0) {
					setFlagOperation(false);
					return;
				}
			}
			setFlagOperation(true);
		}
	}

	/**
	 * @return
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}

	/**
	 * @param b
	 */
	public void setFlagOperation(boolean b) {
		flagOperation = b;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	private void initChargesList(HttpServletRequest request) throws Exception {
		List list = null;
		if (getLeaseContract() != 0) {
			//Определяем главный договор:
			calcMainLeaseContractKey();
			list = new ArrayList();
			CDBCResultSet rSet =
				CDBCLeaseChargesObject.findListLinkToPayment(
					Boolean.TRUE,
					getMainLeaseContractKey(),
					getIsDate().booleanValue() ? Boolean.FALSE : Boolean.TRUE,
					getFromDate(),
					getToDate(),
					getIsResource().booleanValue() ? Boolean.FALSE : Boolean.TRUE,
					new Integer(getResource()),
					new Boolean(true),
					new String[] { "N", "C", "Z" },
					getSortBy());
			ListIterator iter = rSet.listIterator();
			LeaseCharge_TO to = null;
			CDBCRowObject ro = null;
			while (iter.hasNext()) {
				ro = (CDBCRowObject) iter.next();
				to = new LeaseCharge_TO(CDBC_MapFactory.createLeaseCharge(ro));
				to.setCurName(ro.getColumn("curname").asString());
				to.setResName(ro.getColumn("resname").asString());
				list.add(to);
			}
			setChargesList(list);
			//System.out.println("list size=" + list.size());//temp
			request.setAttribute("numberOfLines", String.valueOf(list.size()));
		} else {
			setChargesList(Collections.EMPTY_LIST);
			request.setAttribute("numberOfLines", "нет записей");
		}
	}

	/**
	 * @return
	 */
	public Integer getLeasePayment() {
		return leasePayment;
	}

	/**
	 * @param i
	 */
	public void setLeasePayment(Integer i) {
		leasePayment = i;
	}

}

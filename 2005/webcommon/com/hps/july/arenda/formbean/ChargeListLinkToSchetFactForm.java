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
import com.hps.july.valueobject.LeaseSchetFakt2Charge_TO;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChargeListLinkToSchetFactForm extends ChargeListForm {
	private int[] selectIds = new int[0];
	private boolean flagOperation;

	/**
	 * 
	 */
	public ChargeListLinkToSchetFactForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.CHARGE_LIST_LINK_TO_SCHET_FACT;
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
			ArrayList selIds = new ArrayList(getSelectIds().length);
			for (int i = 0; i < getSelectIds().length; i++) {
				selIds.add(new Integer(getSelectIds()[i]));
			}
			//добавляем позиции в форму "SchetFactDialogForm":
			SchetFactDialogForm sfForm = (SchetFactDialogForm) request.getSession().getAttribute("SchetFactDialogForm");
			for (Iterator iterator = getChargesList().iterator(); iterator.hasNext();) {
				LeaseCharge_TO lch_to = (LeaseCharge_TO) iterator.next();
				LeaseCharge_VO lch_vo = lch_to.getVo();
				if (selIds.contains(lch_vo.getLeaseDocPosition())) {
					LeaseSchetFakt2Charge_TO to = new LeaseSchetFakt2Charge_TO();
					to.setChargeVO(lch_vo);
					to.setLinkSumCharge(lch_vo.getOstSumForSF());
					to.setCurName(lch_to.getCurName());
					to.setResName(lch_to.getResName());

					sfForm.getLeaseSF2charges().add(to);
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
				CDBCLeaseChargesObject.findListLinkToSchetFact(
					Boolean.TRUE,
					getMainLeaseContractKey(),
					getIsDate().booleanValue() ? Boolean.FALSE : Boolean.TRUE,
					getFromDate(),
					getToDate(),
					getIsResource().booleanValue() ? Boolean.FALSE : Boolean.TRUE,
					new Integer(getResource()),
					new Boolean(true),
					new String[] { "N", "C" },
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

}

/*
 * Created on 11.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * "ѕриоритеты списани€ задолженности с договора" TO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeasePriorCntForAct_TO {
	private LeasePriorCntForAct_VO vo;
	private String docNumber;
	private Date docDate;
	/**
	 * 
	 */
	public LeasePriorCntForAct_TO(LeasePriorCntForAct_VO vo) {
		this.vo = vo;
	}

	/**
	 * @return
	 */
	public Date getDocDate() {
		return docDate;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @return
	 */
	public LeasePriorCntForAct_VO getVo() {
		return vo;
	}

	/**
	 * @param date
	 */
	public void setDocDate(Date date) {
		docDate = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @param act_VO
	 */
	private void setVo(LeasePriorCntForAct_VO act_VO) {
		vo = act_VO;
	}

}

/*
 * Created on 13.04.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Accounts_TO {
	Accounts_VO vo = null;
	Banks_VO bank_VO = null;

	/**
	 * 
	 */
	public Accounts_TO(Accounts_VO argVO) {
		vo = argVO;
	}

	/**
	 * @return
	 */
	public Accounts_VO getVo() {
		return vo;
	}

	/**
	 * @param accounts_VO
	 */
	public void setVo(Accounts_VO accounts_VO) {
		vo = accounts_VO;
	}

	/**
	 * @return
	 */
	public Banks_VO getBank_VO() {
		return bank_VO;
	}

	/**
	 * @param banks_VO
	 */
	public void setBank_VO(Banks_VO banks_VO) {
		bank_VO = banks_VO;
	}

}

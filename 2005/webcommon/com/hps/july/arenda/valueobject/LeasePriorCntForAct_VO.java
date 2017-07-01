/*
 * Created on 11.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

/**
 * @author IShaffigulin
 *
 * "Приоритеты списания задолженности с договора" VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeasePriorCntForAct_VO {
	private Integer idact; //Акт взаимозачета
	private Integer leasedocument; //Контракт
	private Integer priority; //Приоритет

	/**
	 * 
	 */
	public LeasePriorCntForAct_VO(Integer aIDact, Integer aLeaseDocument) {
		super();
		idact = aIDact;
		leasedocument = aLeaseDocument;
	}

	/**
	 * @return
	 */
	public Integer getIdact() {
		return idact;
	}

	/**
	 * @return
	 */
	public Integer getLeasedocument() {
		return leasedocument;
	}

	/**
	 * @return
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param integer
	 */
	public void setPriority(Integer integer) {
		priority = integer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "LeasePriorCntForAct_VO:idact=" + idact + " ;leasedocument=" + leasedocument + " ;priority=" + priority;
	}

}

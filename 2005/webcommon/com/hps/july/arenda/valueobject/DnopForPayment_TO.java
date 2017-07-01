/*
 * Created on 19.12.2006
 *
 * "Какие начисления закрывает платеж." TO.
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

import com.hps.july.valueobject.Base_TO;

/**
 * @author IShaffigulin
 *
 * "Какие начисления закрывает платеж." TO.
 */
public class DnopForPayment_TO extends Base_TO {
	private Dnop_VO vo = null;

	private String curChargeName = null; //валюта начисления
	private Date docDateAct = null; // дата акта, по которому создано данное начисление  (отображать если ldp.docposvid <> "N")
	private String docNumberAct = null; //номер акта, по которому создано данное начисление (отображать если ldp.docposvid <> "N")
	private Date docDateUsedInAct = null; //дата акта, в  котором участвует данная запись (в BROWSE - не отображать)
	private String docNumberUsedInAct = null; //номер акта, в  котором участвует данная запись (в BROWSE - не отображать)
	private String docPosVid = null; //"N" - начисление, "K" - учтено в акте, "Z" - задолженность по акту
	private String nameResource = null;//услуга
	private Date dateCharge = null; //Дата начисления (отображать если ldp.docposvid = "N")
	private Date beginDateCharge = null; //Период начисления с
	private Date endDateCharge = null; //Период начисления по
	private String billNumber = null; //номер счета
	private Date billDate = null; //дата счета
	/**
	 * 
	 */
	public DnopForPayment_TO(Dnop_VO vo) {
		super();
		setVo(vo);
	}
	/**
	 * @return
	 */
	public Dnop_VO getVo() {
		return vo;
	}

	/**
	 * @param dnop_VO
	 */
	private void setVo(Dnop_VO dnop_VO) {
		vo = dnop_VO;
	}

	/**
	 * @return
	 */
	public String getCurChargeName() {
		return curChargeName;
	}

	/**
	 * @return
	 */
	public Date getDocDateAct() {
		return docDateAct;
	}

	/**
	 * @return
	 */
	public Date getDocDateUsedInAct() {
		return docDateUsedInAct;
	}

	/**
	 * @return
	 */
	public String getDocNumberAct() {
		return docNumberAct;
	}

	/**
	 * @return
	 */
	public String getDocNumberUsedInAct() {
		return docNumberUsedInAct;
	}

	/**
	 * @return
	 */
	public String getDocPosVid() {
		return docPosVid;
	}

	/**
	 * @return
	 */
	public String getDocPosVidStr() {
		String docPosVidStr = docPosVid;
		if ("N".equals(docPosVid)) {
			docPosVidStr = "начисление";
		} else if ("K".equals(docPosVid)) {
			docPosVidStr = "учтено в акте";
		} else if ("Z".equals(docPosVid)) {
			docPosVidStr = "задолженность по акту";
		}
		return docPosVidStr;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		if ("N".equals(docPosVid)) {
			//"оплачено платежом";
			return null;
		} else {
			//"закрыто актом взаимозачета";
			return docNumberAct;
		}
	}

	/**
	 * @return
	 */
	public Date getDocDate() {
		if ("N".equals(docPosVid)) {
			//"оплачено платежом";
			return null;
		} else {
			//"закрыто актом взаимозачета";
			return docDateAct;
		}
	}

	/**
	 * @param string
	 */
	public void setCurChargeName(String string) {
		curChargeName = string;
	}

	/**
	 * @param date
	 */
	public void setDocDateAct(Date date) {
		docDateAct = date;
	}

	/**
	 * @param date
	 */
	public void setDocDateUsedInAct(Date date) {
		docDateUsedInAct = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumberAct(String string) {
		docNumberAct = string;
	}

	/**
	 * @param string
	 */
	public void setDocNumberUsedInAct(String string) {
		docNumberUsedInAct = string;
	}

	/**
	 * @param string
	 */
	public void setDocPosVid(String string) {
		docPosVid = string;
	}

	/**
	 * @return
	 */
	public Date getBeginDateCharge() {
		return beginDateCharge;
	}

	/**
	 * @return
	 */
	public Date getBillDate() {
		return billDate;
	}

	/**
	 * @return
	 */
	public String getBillNumber() {
		return billNumber;
	}

	/**
	 * @return
	 */
	public Date getDateCharge() {
		return dateCharge;
	}

	/**
	 * @return
	 */
	public Date getEndDateCharge() {
		return endDateCharge;
	}

	/**
	 * @return
	 */
	public String getNameResource() {
		return nameResource;
	}

	/**
	 * @param date
	 */
	public void setBeginDateCharge(Date date) {
		beginDateCharge = date;
	}

	/**
	 * @param date
	 */
	public void setBillDate(Date date) {
		billDate = date;
	}

	/**
	 * @param string
	 */
	public void setBillNumber(String string) {
		billNumber = string;
	}

	/**
	 * @param date
	 */
	public void setDateCharge(Date date) {
		dateCharge = date;
	}

	/**
	 * @param date
	 */
	public void setEndDateCharge(Date date) {
		endDateCharge = date;
	}

	/**
	 * @param string
	 */
	public void setNameResource(String string) {
		nameResource = string;
	}

}

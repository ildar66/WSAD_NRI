/*
 * Created on 19.12.2006
 *
 * "����� ���������� ��������� ������." TO.
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

import com.hps.july.valueobject.Base_TO;

/**
 * @author IShaffigulin
 *
 * "����� ���������� ��������� ������." TO.
 */
public class DnopForPayment_TO extends Base_TO {
	private Dnop_VO vo = null;

	private String curChargeName = null; //������ ����������
	private Date docDateAct = null; // ���� ����, �� �������� ������� ������ ����������  (���������� ���� ldp.docposvid <> "N")
	private String docNumberAct = null; //����� ����, �� �������� ������� ������ ���������� (���������� ���� ldp.docposvid <> "N")
	private Date docDateUsedInAct = null; //���� ����, �  ������� ��������� ������ ������ (� BROWSE - �� ����������)
	private String docNumberUsedInAct = null; //����� ����, �  ������� ��������� ������ ������ (� BROWSE - �� ����������)
	private String docPosVid = null; //"N" - ����������, "K" - ������ � ����, "Z" - ������������� �� ����
	private String nameResource = null;//������
	private Date dateCharge = null; //���� ���������� (���������� ���� ldp.docposvid = "N")
	private Date beginDateCharge = null; //������ ���������� �
	private Date endDateCharge = null; //������ ���������� ��
	private String billNumber = null; //����� �����
	private Date billDate = null; //���� �����
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
			docPosVidStr = "����������";
		} else if ("K".equals(docPosVid)) {
			docPosVidStr = "������ � ����";
		} else if ("Z".equals(docPosVid)) {
			docPosVidStr = "������������� �� ����";
		}
		return docPosVidStr;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		if ("N".equals(docPosVid)) {
			//"�������� ��������";
			return null;
		} else {
			//"������� ����� ������������";
			return docNumberAct;
		}
	}

	/**
	 * @return
	 */
	public Date getDocDate() {
		if ("N".equals(docPosVid)) {
			//"�������� ��������";
			return null;
		} else {
			//"������� ����� ������������";
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

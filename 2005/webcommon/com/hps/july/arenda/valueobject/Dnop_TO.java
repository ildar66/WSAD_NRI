/*
 * Created on 19.12.2006
 *
 * "��� �������� ����������" TO.
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

import com.hps.july.valueobject.Base_TO;

/**
 * @author IShaffigulin
 *
 * "��� �������� ����������" TO.
 */
public class Dnop_TO extends Base_TO {
	private Dnop_VO vo = null;

	private String curChargeName = null; //������ ����������
	private Date docDateAct = null; //���� ����, �� �������� ������� ������ ������   (���������� ���� ldp.docposvid <> "N")
	private String docNumberAct = null; //����� ����, �� �������� ������� ������ ������ (���������� ���� ldp.docposvid <> "N")
	private Date docDateUsedInAct = null; //���� ����, �  ������� ��������� ������ ������ (� BROWSE - �� ����������)
	private String docNumberUsedInAct = null; //����� ����, �  ������� ��������� ������ ������ (� BROWSE - �� ����������)
	private String docNumberPay = null; //����� ������� (���������� ���� ldp.docposvid = "N")
	private BigDecimal summRubPay = null; //����� ������� � ������ (���������� ���� ldp.docposvid = "N")
	private Date datePay = null; //���� ������� (���������� ���� ldp.docposvid = "N")
	private String docPosVid = null; //"N" - �������� ��������, "<> N" - ������� ����� ������������
	/**
	 * 
	 */
	public Dnop_TO(Dnop_VO vo) {
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
	public Date getDatePay() {
		return datePay;
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
	public String getDocNumberPay() {
		return docNumberPay;
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
			docPosVidStr = "�������� ��������";
		} else {
			docPosVidStr = "������� ����� ������������";
		}
		return docPosVidStr;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		if ("N".equals(docPosVid)) {
			//"�������� ��������";
			return docNumberPay;
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
			return datePay;
		} else {
			//"������� ����� ������������";
			return docDateAct;
		}
	}

	/**
	 * @return
	 */
	public BigDecimal getDocSummRub() {
		if ("N".equals(docPosVid)) {
			//"�������� ��������";
			return summRubPay;
		} else {
			//"������� ����� ������������";
			return vo.getPayRurSum();
		}
	}

	/**
	 * @return
	 */
	public BigDecimal getSummRubPay() {
		return summRubPay;
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
	public void setDatePay(Date date) {
		datePay = date;
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
	public void setDocNumberPay(String string) {
		docNumberPay = string;
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
	 * @param decimal
	 */
	public void setSummRubPay(BigDecimal decimal) {
		summRubPay = decimal;
	}

}

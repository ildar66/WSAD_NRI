/*
 * Created on 01.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * ���������� VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseCharge_VO extends LeaseDocPosition_VO {
	/**
	 * 
	 */
	public LeaseCharge_VO() {
		super();
	}

	private Integer leaseRule; //������� ����������
	private BigDecimal remainderSum; //������� ����������
	private BigDecimal remainderRate2Rur; //���� ��������� �������
	private String byHandRateRur; //������� ����������� ����� ������(Y/N)
	private String billNumber; //����� ����� ��� ������
	private Date billDate; //���� ����� ��� ������
	private String isSchetFakt1 = "N"; //������� �����_������� 1
	private String isSchetFakt2 = "N"; //������� �����_������� 2
	private String isSchetFakt3 = "N"; //������� �����_������� 3
	private Integer usedInCWAct; //��� ���� ����������� ����� � ������� ������������ ����������
	private String isWorkAct1 = "N"; //������� ������� ���� ����������� ����� 1
	private String isWorkAct2 = "N"; //������� ������� ���� ����������� ����� 2
	private String isWorkAct3 = "N"; //������� ������� ���� ����������� ����� 3
	private BigDecimal ostSumForSF; //������� ����� ��� ������ ������
	private BigDecimal ostSumForCwAct; //������� ����� ���� ����������� �����
	/*
	 ������� ������ ��:
	 0-����� ������� �� <> 0 ��� ��������� �� <> "�������� �� ������������"("�� �� ��� ����� ������� ��, ������� �� = "),
	 1-������� �� = 0 � ��������� �� >  "�������� �� ������������"("�� �� �������� �� ������������"),
	 2-����� ������� �� = 0 � ��������� �� = "������� � ����������� (�� �������� �� ������������, �� �� ������� � �����������)",
	 3- ����� ������� �� = 0 � ��������� �� =  "������� � �����������(�� ������� � �����������) ",
	 10-�� ������ �� �������� ����� ��("�� �� ������� �����")
	*/
	private Integer flagSF;
	private Integer flagCwAct;
	
	private String needSf  = "N"; //����������� �����_�������
	private String needCwAct  = "N"; //����������� �����_�������
	
	private String createdByName = null;
	private String modifiedByName = null;	

	/**
	 * 
	 */
	public LeaseCharge_VO(Integer key) {
		super(key);
		setDocPosType("C");
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
	public String getByHandRateRur() {
		return byHandRateRur;
	}

	/**
	 * @return
	 */
	public String getIsSchetFakt1() {
		return isSchetFakt1;
	}

	/**
	 * @return
	 */
	public String getIsSchetFakt2() {
		return isSchetFakt2;
	}

	/**
	 * @return
	 */
	public String getIsSchetFakt3() {
		return isSchetFakt3;
	}

	/**
	 * @return
	 */
	public String getIsWorkAct1() {
		return isWorkAct1;
	}

	/**
	 * @return
	 */
	public String getIsWorkAct2() {
		return isWorkAct2;
	}

	/**
	 * @return
	 */
	public String getIsWorkAct3() {
		return isWorkAct3;
	}

	/**
	 * @return
	 */
	public Integer getLeaseRule() {
		return leaseRule;
	}

	/**
	 * @return
	 */
	public BigDecimal getRemainderRate2Rur() {
		return remainderRate2Rur;
	}

	/**
	 * @return
	 */
	public BigDecimal getRemainderSum() {
		return remainderSum;
	}

	/**
	 * @return
	 */
	public Integer getUsedInCWAct() {
		return usedInCWAct;
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
	 * @param string
	 */
	public void setByHandRateRur(String string) {
		byHandRateRur = string;
	}

	/**
	 * @param string
	 */
	public void setIsSchetFakt1(String string) {
		isSchetFakt1 = string;
	}

	/**
	 * @param string
	 */
	public void setIsSchetFakt2(String string) {
		isSchetFakt2 = string;
	}

	/**
	 * @param string
	 */
	public void setIsSchetFakt3(String string) {
		isSchetFakt3 = string;
	}

	/**
	 * @param string
	 */
	public void setIsWorkAct1(String string) {
		isWorkAct1 = string;
	}

	/**
	 * @param string
	 */
	public void setIsWorkAct2(String string) {
		isWorkAct2 = string;
	}

	/**
	 * @param string
	 */
	public void setIsWorkAct3(String string) {
		isWorkAct3 = string;
	}

	/**
	 * @param integer
	 */
	public void setLeaseRule(Integer integer) {
		leaseRule = integer;
	}

	/**
	 * @param decimal
	 */
	public void setRemainderRate2Rur(BigDecimal decimal) {
		remainderRate2Rur = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setRemainderSum(BigDecimal decimal) {
		remainderSum = decimal;
	}

	/**
	 * @param integer
	 */
	public void setUsedInCWAct(Integer integer) {
		usedInCWAct = integer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return super.toString()
			+ " leaseRule="
			+ getLeaseRule()
			+ " remainderSum="
			+ getRemainderSum()
			+ " remainderRate2Rur="
			+ getRemainderRate2Rur()
			+ " byHandRateRur="
			+ getByHandRateRur()
			+ " billNumber="
			+ getBillNumber()
			+ " billDate="
			+ getBillDate()
			+ " usedInCWAct="
			+ getUsedInAct()
			+ " isSchetFakt1="
			+ getIsSchetFakt1()
			+ " isWorkAct1="
			+ getIsWorkAct1();
	}

	/**
	 * @return
	 */
	public BigDecimal getOstSumForSF() {
		return ostSumForSF;
	}

	/**
	 * @param decimal
	 */
	public void setOstSumForSF(BigDecimal decimal) {
		ostSumForSF = decimal;
	}

	/**
	 * @return
	 */
	public Integer getFlagSF() {
		return flagSF;
	}

	/**
	 * @param integer
	 */
	public void setFlagSF(Integer integer) {
		flagSF = integer;
	}

	/**
	 * @return
	 */
	public Integer getFlagCwAct() {
		return flagCwAct;
	}

	/**
	 * @return
	 */
	public BigDecimal getOstSumForCwAct() {
		return ostSumForCwAct;
	}

	/**
	 * @param integer
	 */
	public void setFlagCwAct(Integer integer) {
		flagCwAct = integer;
	}

	/**
	 * @param decimal
	 */
	public void setOstSumForCwAct(BigDecimal decimal) {
		ostSumForCwAct = decimal;
	}

	/**
	 * @return
	 */
	public String getNeedCwAct() {
		return needCwAct;
	}

	/**
	 * @return
	 */
	public String getNeedSf() {
		return needSf;
	}

	/**
	 * @param string
	 */
	public void setNeedCwAct(String string) {
		needCwAct = string;
	}

	/**
	 * @param string
	 */
	public void setNeedSf(String string) {
		needSf = string;
	}

	/**
	 * @return
	 */
	public String getCreatedByName() {
		return createdByName;
	}

	/**
	 * @return
	 */
	public String getModifiedByName() {
		return modifiedByName;
	}

	/**
	 * @param string
	 */
	public void setCreatedByName(String string) {
		createdByName = string;
	}

	/**
	 * @param string
	 */
	public void setModifiedByName(String string) {
		modifiedByName = string;
	}

}

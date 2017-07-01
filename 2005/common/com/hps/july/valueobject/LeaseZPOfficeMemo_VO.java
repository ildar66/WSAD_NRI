/*
 * Created on 18.05.2006
 *
 * ��������� ������� �� ��������� �� � ������� ��� VO
 */
package com.hps.july.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * "��������� ������� �� ��������� �� � ������� ���" VO
 */
public class LeaseZPOfficeMemo_VO extends DomainObject {
	private Integer idOfficeMemo = null; //pk
	private Integer leaseContract = null; //������ �� ������� �������
	private Integer leaseDopContract = null; //������ �� ��� ����������
	private String flagAddVendor = null; //������� �������� ������ ����������('I'-������� ������ ����������; 'N'-������ ������)
	private String flagAddVendorSite = null; //������� �������� ������ ���������(N/Y)
	private String flagAddContract = null; //������� �������� ���������(N/Y)
	private String typeActionZP = null; //��� �������� ��� ��('I'-�������; 'U'-��������)
	private Integer idZP = null; //������ �� ��
	private BigDecimal oldSumZP = null; //������� ����� ��
	private Integer idVendorSite = null; //��������� ����������
	private Integer idResource = null; //������� ��������
	private BigDecimal sumCharge = null; //����� � ���������� � �����
	private BigDecimal sumZP = null; //����� ��
	private BigDecimal sumNdsZP = null; //����� ��� ��
	private Integer idCurrCharge = null; //������ ��������
	private Date dateStartZP = null; //���� ������ ������� ��
	private Date dateEndZp = null; //���� ��������� ������� ��
	private String reason = null; //��������� ��� ���������
	private BigDecimal rateNds = null; //������ ���
	/**
	 * ������� ����������� �����:
	 * A - �� ���� ����������� �����
	 * B - �� ���� �������
	 * C - �� ���� �� �������
	 * D - ��������� ���� ������������� �������
	 * E - ��������� ���� ������������� �������
	 * F - �� � ����� ������ ��������������� ������������� �������
	 * G - �� � ����� ���������� ������ ��������������� �������� ������������� �������
	 * H - �� ��������� ���� ��������������� �������
	 * I - �� ������ ����� ���������� �������
	 * K - ������������� ����
	 * 
	 */
	private String rateCalcRule = null; //������� ����������� ����� ��� �������� � ����������
	private BigDecimal rateDelta = null; //������� � ��������� ��� ������� �����
	private Integer rateCalcRuleDay = null; //����� ������ ��� ��������� ��������� ������� �����
	private BigDecimal rateFix = null; //�������� �������������� �����(rateCalcRule = 'K') 
	/**
	 * 
	 * @param aIdOfficeMemo
	 */

	public LeaseZPOfficeMemo_VO(Integer aIdOfficeMemo) {
		super();
		this.idOfficeMemo = aIdOfficeMemo;
	}

	/**
	 * @return
	 */
	public Date getDateEndZp() {
		return dateEndZp;
	}

	/**
	 * @return
	 */
	public Date getDateStartZP() {
		return dateStartZP;
	}

	/**
	 * @return
	 */
	public String getFlagAddContract() {
		return flagAddContract;
	}

	/**
	 * @return
	 */
	public String getFlagAddVendor() {
		return flagAddVendor;
	}

	/**
	 * @return
	 */
	public String getFlagAddVendorSite() {
		return flagAddVendorSite;
	}

	/**
	 * @return
	 */
	public Integer getIdCurrCharge() {
		return idCurrCharge;
	}

	/**
	 * @return
	 */
	public Integer getIdOfficeMemo() {
		return idOfficeMemo;
	}

	/**
	 * @return
	 */
	public Integer getIdResource() {
		return idResource;
	}

	/**
	 * @return
	 */
	public Integer getIdVendorSite() {
		return idVendorSite;
	}

	/**
	 * @return
	 */
	public Integer getIdZP() {
		return idZP;
	}

	/**
	 * @return
	 */
	public Integer getLeaseContract() {
		return leaseContract;
	}

	/**
	 * @return
	 */
	public Integer getLeaseDopContract() {
		return leaseDopContract;
	}

	/**
	 * @return
	 */
	public BigDecimal getOldSumZP() {
		return oldSumZP;
	}

	/**
	 * @return
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumCharge() {
		return sumCharge;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumNdsZP() {
		return sumNdsZP;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumZP() {
		return sumZP;
	}

	/**
	 * @return
	 */
	public String getTypeActionZP() {
		return typeActionZP;
	}

	/**
	 * @param date
	 */
	public void setDateEndZp(Date date) {
		dateEndZp = date;
	}

	/**
	 * @param date
	 */
	public void setDateStartZP(Date date) {
		dateStartZP = date;
	}

	/**
	 * @param string
	 */
	public void setFlagAddContract(String string) {
		flagAddContract = string;
	}

	/**
	 * @param string
	 */
	public void setFlagAddVendor(String string) {
		flagAddVendor = string;
	}

	/**
	 * @param string
	 */
	public void setFlagAddVendorSite(String string) {
		flagAddVendorSite = string;
	}

	/**
	 * @param integer
	 */
	public void setIdCurrCharge(Integer integer) {
		idCurrCharge = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdOfficeMemo(Integer integer) {
		idOfficeMemo = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdResource(Integer integer) {
		idResource = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdVendorSite(Integer integer) {
		idVendorSite = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdZP(Integer integer) {
		idZP = integer;
	}

	/**
	 * @param integer
	 */
	public void setLeaseContract(Integer integer) {
		leaseContract = integer;
	}

	/**
	 * @param integer
	 */
	public void setLeaseDopContract(Integer integer) {
		leaseDopContract = integer;
	}

	/**
	 * @param decimal
	 */
	public void setOldSumZP(BigDecimal decimal) {
		oldSumZP = decimal;
	}

	/**
	 * @param string
	 */
	public void setReason(String string) {
		reason = string;
	}

	/**
	 * @param decimal
	 */
	public void setSumCharge(BigDecimal decimal) {
		sumCharge = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSumNdsZP(BigDecimal decimal) {
		sumNdsZP = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSumZP(BigDecimal decimal) {
		sumZP = decimal;
	}

	/**
	 * @param string
	 */
	public void setTypeActionZP(String string) {
		typeActionZP = string;
	}

	/**
	 * @return
	 */
	public String getRateCalcRule() {
		return rateCalcRule;
	}

	/**
	 * @return
	 */
	public Integer getRateCalcRuleDay() {
		return rateCalcRuleDay;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateDelta() {
		return rateDelta;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateFix() {
		return rateFix;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateNds() {
		return rateNds;
	}

	/**
	 * @param string
	 */
	public void setRateCalcRule(String string) {
		if ("".equals(string)) {
			rateCalcRule = null;
		} else {
			rateCalcRule = string;
		}

	}

	/**
	 * @param integer
	 */
	public void setRateCalcRuleDay(Integer integer) {
		rateCalcRuleDay = integer;
	}

	/**
	 * @param decimal
	 */
	public void setRateDelta(BigDecimal decimal) {
		rateDelta = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setRateFix(BigDecimal decimal) {
		rateFix = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setRateNds(BigDecimal decimal) {
		rateNds = decimal;
	}

}

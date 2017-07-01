/*
 * Created on 17.04.2006
 *
 * ��������� ������� �� ������ VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * ��������� ������� �� ������ VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeasePayOfficeMemo_VO extends DomainObject {
	public final static String ruleRate_onDogovor = "1";//�� ������� ��������	
	public final static String ruleRate_onDate = "2";//�� ������������ ����
	public final static String ruleRate_onHand = "3";//������������� ���� � ������ ������
	
	private Integer idOfficeMemo = null; //��� ���� �������(pk)
	private Integer leaseContract = null; //�������
	private Date beginDate = null; //���� ������
	private Date endDate = null; //���� ���������
	private String flagAvans = null; //������� ������("Y", "N")
	private String flag3face = null; //������� ������ 3 ����("Y", "N")
	private BigDecimal sum = null; //����� ���� ���
	private BigDecimal nds = null; //��� ���� ���
	private Integer currency = null; //������
	private String ruleRate = null; //������� ����������� �����
	private Integer orgAcc = null; //��������� ���� ��� ������
	private String purpose = null; //����������
	private String pp104 = null; //104 ���� ������� ���
	private String pp105 = null; //105 ���� ������� OKATO
	private Integer ppQueue = null; //����������� �������
	private String ppStatus = null; //������ �����������
	private String state = null; //���������("1-�����������","2-��������","3-���������")
	private BigDecimal sumRub = null; //����� � ������ (� ���)
	private BigDecimal ndsRub = null; //��� � ������
	private Date billDate = null; //���� ����� ��� ������
	private String billNumber = null; //����� ����� ��� ������
	private String rateCalcRule = null;//������� ����������� ����� ��� �������� � ����������
	private Integer rateCalcRuleDay = null;//����� ������ ��� ��������� ��������� ������� �����
	private BigDecimal rateDelta = null;//������� � ��������� ��� ������� �����
	private Date rateDate = null;//���� �����
	private BigDecimal rateValue = null;//���� ����� � ������
	private BigDecimal rateNds = null;//������ ���
	private Integer idZpNfs = null;//������ �� ��

	/**
	 * 
	 */
	public LeasePayOfficeMemo_VO(Integer aIdOfficeMemo) {
		super();
		this.idOfficeMemo = aIdOfficeMemo;
	}

	/**
	 * @return
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * @return
	 */
	public Integer getCurrency() {
		return currency;
	}

	/**
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @return
	 */
	public String getFlag3face() {
		return flag3face;
	}

	/**
	 * @return
	 */
	public String getFlagAvans() {
		return flagAvans;
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
	public Integer getLeaseContract() {
		return leaseContract;
	}

	/**
	 * @return
	 */
	public BigDecimal getNds() {
		return nds;
	}

	/**
	 * @return
	 */
	public Integer getOrgAcc() {
		return orgAcc;
	}

	/**
	 * @return
	 */
	public String getPp104() {
		return pp104;
	}

	/**
	 * @return
	 */
	public String getPp105() {
		return pp105;
	}

	/**
	 * @return
	 */
	public Integer getPpQueue() {
		return ppQueue;
	}

	/**
	 * @return
	 */
	public String getPpStatus() {
		return ppStatus;
	}

	/**
	 * @return
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @return
	 */
	public String getRuleRate() {
		return ruleRate;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return
	 */
	public BigDecimal getSum() {
		return sum;
	}

	/**
	 * @param date
	 */
	public void setBeginDate(Date date) {
		beginDate = date;
	}

	/**
	 * @param integer
	 */
	public void setCurrency(Integer integer) {
		currency = integer;
	}

	/**
	 * @param date
	 */
	public void setEndDate(Date date) {
		endDate = date;
	}

	/**
	 * @param string
	 */
	public void setFlag3face(String string) {
		flag3face = string;
	}

	/**
	 * @param string
	 */
	public void setFlagAvans(String string) {
		flagAvans = string;
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
	public void setLeaseContract(Integer integer) {
		leaseContract = integer;
	}

	/**
	 * @param decimal
	 */
	public void setNds(BigDecimal decimal) {
		nds = decimal;
	}

	/**
	 * @param integer
	 */
	public void setOrgAcc(Integer integer) {
		orgAcc = integer;
	}

	/**
	 * @param string
	 */
	public void setPp104(String string) {
		pp104 = string;
	}

	/**
	 * @param string
	 */
	public void setPp105(String string) {
		pp105 = string;
	}

	/**
	 * @param integer
	 */
	public void setPpQueue(Integer integer) {
		ppQueue = integer;
	}

	/**
	 * @param string
	 */
	public void setPpStatus(String string) {
		ppStatus = string;
	}

	/**
	 * @param string
	 */
	public void setPurpose(String string) {
		purpose = string;
	}

	/**
	 * @param string
	 */
	public void setRuleRate(String string) {
		ruleRate = string;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}

	/**
	 * @param decimal
	 */
	public void setSum(BigDecimal decimal) {
		sum = decimal;
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
	public BigDecimal getNdsRub() {
		return ndsRub;
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
	public Date getRateDate() {
		return rateDate;
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
	public BigDecimal getRateNds() {
		return rateNds;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateValue() {
		return rateValue;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumRub() {
		return sumRub;
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
	 * @param decimal
	 */
	public void setNdsRub(BigDecimal decimal) {
		ndsRub = decimal;
	}

	/**
	 * @param string
	 */
	public void setRateCalcRule(String string) {
		rateCalcRule = string;
	}

	/**
	 * @param integer
	 */
	public void setRateCalcRuleDay(Integer integer) {
		rateCalcRuleDay = integer;
	}

	/**
	 * @param date
	 */
	public void setRateDate(Date date) {
		rateDate = date;
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
	public void setRateNds(BigDecimal decimal) {
		rateNds = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setRateValue(BigDecimal decimal) {
		rateValue = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSumRub(BigDecimal decimal) {
		sumRub = decimal;
	}

	/**
	 * @return
	 */
	public Integer getIdZpNfs() {
		return idZpNfs;
	}

	/**
	 * @param integer
	 */
	public void setIdZpNfs(Integer integer) {
		idZpNfs = integer;
	}

}

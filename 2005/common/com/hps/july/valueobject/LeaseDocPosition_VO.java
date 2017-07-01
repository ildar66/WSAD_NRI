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
 * "Позиции документов" VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseDocPosition_VO extends DomainObject {
	private Integer leaseDocPosition; //Уникальный код позиции документа
	private String docPosType; //Тип позиции(C-Начисления, P-Оплаты, O-leasepayorder)
	private Date date; //Дата
	private Integer leaseContract; //Договор
	/*
	 * Источник получения позиции:
	 * A - Автоматическая генерация
	 * B - Из биллинга
	 * P - Из Platinum
	 * M - Внесено пользователем
	 */
	private String source; //Источник получения позиции
	/*
	 * Вид позиции:
	 * Q-взаимозачет
	 * K-компенсация задолженности закрытого периода
	 * Z-задолженность в открытом периоде
	 * N-Обычная позиция
	 * C-Коррекция
	 */
	private String docPosVid; //Вид позиции
	private Date beginDate; //Дата начала периода
	private Date endDate; //Дата конца периода
	private Integer act; //по какому акту созданы
	private Integer usedInAct; //Акт в котором учтено
	private Integer resource; //Ресурс
	private BigDecimal summ; //Сумма с НДС
	private Integer currency; //Валюта
	private BigDecimal sumNds; //НДС
	private Integer operator; //Оператор
	private Integer willBeInAct; //Необходимо учесть в акте

	/**
	 * 
	 */
	public LeaseDocPosition_VO(Integer key) {
		super();
		setLeaseDocPosition(key);
	}

	/**
	 * 
	 */
	public LeaseDocPosition_VO() {
		super();
	}

	/**
	 * @return
	 */
	public Integer getAct() {
		return act;
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
	public Date getDate() {
		return date;
	}

	/**
	 * @return
	 */
	public String getDocPosType() {
		return docPosType;
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
	public Date getEndDate() {
		return endDate;
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
	public Integer getLeaseDocPosition() {
		return leaseDocPosition;
	}

	/**
	 * @return
	 */
	public Integer getOperator() {
		return operator;
	}

	/**
	 * @return
	 */
	public Integer getResource() {
		return resource;
	}

	/**
	 * @return
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumm() {
		return summ;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumNds() {
		return sumNds;
	}

	/**
	 * @return
	 */
	public Integer getUsedInAct() {
		return usedInAct;
	}

	/**
	 * @return
	 */
	public Integer getWillBeInAct() {
		return willBeInAct;
	}

	/**
	 * @param integer
	 */
	public void setAct(Integer integer) {
		act = integer;
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
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param string
	 */
	public void setDocPosType(String string) {
		docPosType = string;
	}

	/**
	 * @param string
	 */
	public void setDocPosVid(String string) {
		docPosVid = string;
	}

	/**
	 * @param date
	 */
	public void setEndDate(Date date) {
		endDate = date;
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
	public void setLeaseDocPosition(Integer integer) {
		leaseDocPosition = integer;
	}

	/**
	 * @param integer
	 */
	public void setOperator(Integer integer) {
		operator = integer;
	}

	/**
	 * @param integer
	 */
	public void setResource(Integer integer) {
		resource = integer;
	}

	/**
	 * @param string
	 */
	public void setSource(String string) {
		source = string;
	}

	/**
	 * @param decimal
	 */
	public void setSumm(BigDecimal decimal) {
		summ = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSumNds(BigDecimal decimal) {
		sumNds = decimal;
	}

	/**
	 * @param integer
	 */
	public void setUsedInAct(Integer integer) {
		usedInAct = integer;
	}

	/**
	 * @param integer
	 */
	public void setWillBeInAct(Integer integer) {
		willBeInAct = integer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "LeaseContract= "
			+ getLeaseContract()
			+ " LeaseDocPosition="
			+ getLeaseDocPosition()
			+ " Summ="
			+ getSumm()
			+ " SumNds="
			+ getSumNds();
	}

}

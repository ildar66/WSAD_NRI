/*
 * Created on 14.02.2007
 *
 * Конечная задолженность по договорам и услугам, участвующим в акте (взаимозачета и взаимных требований)
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * Конечная задолженность по договорам и услугам, участвующим в акте (взаимозачета и взаимных требований)
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MutualDebtNds_VO {
	//private Integer actCode;//код акта
	private String customer;//наименование заказчика.
	private String executor;//наименование исполнителя.
	private Integer headerId;//порядковый номер принадлежности.
	private BigDecimal sumMain;//конечная сумма сальдо в основной валюте.
	private String currMain;//основная валюта акта.
	/**
	 * 
	 */
	public MutualDebtNds_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @return
	 */
	public String getExecutor() {
		return executor;
	}

	/**
	 * @param string
	 */
	public void setCustomer(String string) {
		customer = string;
	}

	/**
	 * @param string
	 */
	public void setExecutor(String string) {
		executor = string;
	}

	/**
	 * @return
	 */
	public String getCurrMain() {
		return currMain;
	}

	/**
	 * @return
	 */
	public Integer getHeaderId() {
		return headerId;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumMain() {
		return sumMain;
	}

	/**
	 * @param string
	 */
	public void setCurrMain(String string) {
		currMain = string;
	}

	/**
	 * @param integer
	 */
	public void setHeaderId(Integer integer) {
		headerId = integer;
	}

	/**
	 * @param decimal
	 */
	public void setSumMain(BigDecimal decimal) {
		sumMain = decimal;
	}

}

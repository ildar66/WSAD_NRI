/*
 * Created on 11.12.2006
 *
 * "Фактические данные по договорам Аренды" статусы для FactsLeaseTO. 
 */
package com.hps.july.arenda.valueobject;

import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * "Фактические данные по договорам Аренды" статусы для FactsLeaseTO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FactsLeaseColStatusDogOnDate {
	private Date date;
	private String colorCharge;//цвет начисления "0"-прозрачный, "R"-красный
	private String hintCharge;//hint начисления
	private String colorSF;//цвет счетов-фактур "0"-прозрачный, "R"-красный
	private String hintSF;//hint счетов-фактур
	private String colorCWA;//цвет актов выполненных работ "0"-прозрачный, "R"-красный
	private String hintCWA;//hint актов выполненных работ
	private String colorPay;//цвет платежей "0"-прозрачный, "R"-красный
	private String hintPay;//hint платежей

	/**
	 * 
	 */
	public FactsLeaseColStatusDogOnDate(java.sql.Date aDate) {
		super();
		setDate(aDate);
	}
	/**
	 * 
	 */
	public FactsLeaseColStatusDogOnDate() {
		super();
	}	

	/**
	 * @return
	 */
	public String getColorCharge() {
		return colorCharge;
	}

	/**
	 * @return
	 */
	public String getColorCWA() {
		return colorCWA;
	}

	/**
	 * @return
	 */
	public String getColorPay() {
		return colorPay;
	}

	/**
	 * @return
	 */
	public String getColorSF() {
		return colorSF;
	}

	/**
	 * @return
	 */
	public String getHintCharge() {
		return hintCharge;
	}

	/**
	 * @return
	 */
	public String getHintCWA() {
		return hintCWA;
	}

	/**
	 * @return
	 */
	public String getHintPay() {
		return hintPay;
	}

	/**
	 * @return
	 */
	public String getHintSF() {
		return hintSF;
	}

	/**
	 * @param string
	 */
	public void setColorCharge(String string) {
		colorCharge = string;
	}

	/**
	 * @param string
	 */
	public void setColorCWA(String string) {
		colorCWA = string;
	}

	/**
	 * @param string
	 */
	public void setColorPay(String string) {
		colorPay = string;
	}

	/**
	 * @param string
	 */
	public void setColorSF(String string) {
		colorSF = string;
	}

	/**
	 * @param string
	 */
	public void setHintCharge(String string) {
		hintCharge = string;
	}

	/**
	 * @param string
	 */
	public void setHintCWA(String string) {
		hintCWA = string;
	}

	/**
	 * @param string
	 */
	public void setHintPay(String string) {
		hintPay = string;
	}

	/**
	 * @param string
	 */
	public void setHintSF(String string) {
		hintSF = string;
	}

	/**
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}

/*
 * Created on 16.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SumMutualForPrintAct_VO {
	private String numberDoc;//����� ��������  ������
	private Date dateDoc;//���� �������� ������
	private String listAbonentDog;//������ ����������� ���������
	private String currMain;//�������� ������
	private String currDop;//�������������� ������
	private String allString;//��� ������
	private BigDecimal summMain;//����� ����������� ���� � �������� ������
	private BigDecimal ndsMain;//��� ����������� ���� � �������� ������
	private BigDecimal summDop;//����� ����������� ���� � �������������� ������
	private BigDecimal ndsDop;//��� ����������� ���� � �������������� ������

	/**
	 * 
	 */
	public SumMutualForPrintAct_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getAllString() {
		return allString;
	}

	/**
	 * @return
	 */
	public String getCurrDop() {
		return currDop;
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
	public Date getDateDoc() {
		return dateDoc;
	}

	/**
	 * @return
	 */
	public String getListAbonentDog() {
		return listAbonentDog;
	}

	/**
	 * @return
	 */
	public BigDecimal getNdsDop() {
		return ndsDop;
	}

	/**
	 * @return
	 */
	public BigDecimal getNdsMain() {
		return ndsMain;
	}

	/**
	 * @return
	 */
	public String getNumberDoc() {
		return numberDoc;
	}

	/**
	 * @return
	 */
	public BigDecimal getSummDop() {
		return summDop;
	}

	/**
	 * @return
	 */
	public BigDecimal getSummMain() {
		return summMain;
	}

	/**
	 * @param string
	 */
	public void setAllString(String string) {
		allString = string;
	}

	/**
	 * @param string
	 */
	public void setCurrDop(String string) {
		currDop = string;
	}

	/**
	 * @param string
	 */
	public void setCurrMain(String string) {
		currMain = string;
	}

	/**
	 * @param date
	 */
	public void setDateDoc(Date date) {
		dateDoc = date;
	}

	/**
	 * @param string
	 */
	public void setListAbonentDog(String string) {
		listAbonentDog = string;
	}

	/**
	 * @param decimal
	 */
	public void setNdsDop(BigDecimal decimal) {
		ndsDop = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNdsMain(BigDecimal decimal) {
		ndsMain = decimal;
	}

	/**
	 * @param string
	 */
	public void setNumberDoc(String string) {
		numberDoc = string;
	}

	/**
	 * @param decimal
	 */
	public void setSummDop(BigDecimal decimal) {
		summDop = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSummMain(BigDecimal decimal) {
		summMain = decimal;
	}

}

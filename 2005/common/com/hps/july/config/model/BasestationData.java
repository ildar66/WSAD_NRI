/*
 * Created on 04.08.2006
 *
 * Base Station Data Model
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class BasestationData implements Serializable {
	
	//static final long serialVersionUID = 2848430719578093914L;
	
	private String state900;
	private String state1800;
	private java.util.Date mount900;
	private java.util.Date mount1800;
	private java.util.Date test900;
	private java.util.Date test1800;
	private java.util.Date testAfs900;
	private java.util.Date testAfs1800;
	private java.util.Date connect900;
	private java.util.Date connect1800;
	private java.util.Date onair900;
	private java.util.Date onair1800;
	private String recordStatus;
	private String type;
	private ControllerVO controller;
	private Integer number;
	private String name;
	private String dopInfo;
	private java.math.BigDecimal hset;
	private Integer antPlace;
	private String permitGSM;
	private String permitDCS;
	private Integer apartment;
	private final static String PLAN = "Планируется"; 
	private final static String MODERN = "В эфире (тестирование)"; 
	private final static String WORK = "Коммерческая эксплуатация"; 
	private final static String DEMOUNT = "Демонтирована"; 
	
	public final static String BSTYPE_GSM = "GSM 900";
	public final static String BSTYPE_DCS = "DCS 1800";
	public final static String BSTYPE_GSMDCS = "GSM 900/DCS 1800";
	

	public BasestationData() {
		super();
		controller = new ControllerVO();
	}
	
	public static String getStateName(String argState) {
		if ("P".equals(argState))
			return PLAN;
		else if ("M".equals(argState))
			return MODERN;
		else if ("W".equals(argState))
			return WORK;
		else if ("D".equals(argState))
			return DEMOUNT;
		else
			return "";
	}
	
	public static String getBSTypeName(String argBstype) {
		if ("S".equals(argBstype))
			return BSTYPE_GSM;
		else if ("C".equals(argBstype))
			return BSTYPE_DCS;
		else if ("G".equals(argBstype))
			return BSTYPE_GSMDCS;
		else
			return "";
	}
	
	public String getStateByName(String argState) {
		if (PLAN.equals(argState))
			return "P";
		else if (MODERN.equals(argState))
			return "M";
		else if (WORK.equals(argState))
			return "W";
		else if (DEMOUNT.equals(argState))
			return "D";
		else
			return "";
	}

	/**
	 * @return
	 */
	public java.util.Date getConnect1800() {
		return connect1800;
	}

	/**
	 * @return
	 */
	public java.util.Date getConnect900() {
		return connect900;
	}

	/**
	 * @return
	 */
	public java.util.Date getMount1800() {
		return mount1800;
	}

	/**
	 * @return
	 */
	public java.util.Date getMount900() {
		return mount900;
	}

	/**
	 * @return
	 */
	public java.util.Date getOnair1800() {
		return onair1800;
	}

	/**
	 * @return
	 */
	public java.util.Date getOnair900() {
		return onair900;
	}

	/**
	 * @return
	 */
	public String getState1800() {
		return state1800;
	}

	/**
	 * @return
	 */
	public String getState900() {
		return state900;
	}

	/**
	 * @return
	 */
	public java.util.Date getTest1800() {
		return test1800;
	}

	/**
	 * @return
	 */
	public java.util.Date getTest900() {
		return test900;
	}

	/**
	 * @return
	 */
	public java.util.Date getTestAfs1800() {
		return testAfs1800;
	}

	/**
	 * @return
	 */
	public java.util.Date getTestAfs900() {
		return testAfs900;
	}

	/**
	 * @param date
	 */
	public void setConnect1800(java.util.Date date) {
		connect1800 = date;
	}

	/**
	 * @param date
	 */
	public void setConnect900(java.util.Date date) {
		connect900 = date;
	}

	/**
	 * @param date
	 */
	public void setMount1800(java.util.Date date) {
		mount1800 = date;
	}

	/**
	 * @param date
	 */
	public void setMount900(java.util.Date date) {
		mount900 = date;
	}

	/**
	 * @param date
	 */
	public void setOnair1800(java.util.Date date) {
		onair1800 = date;
	}

	/**
	 * @param date
	 */
	public void setOnair900(java.util.Date date) {
		onair900 = date;
	}

	/**
	 * @param string
	 */
	public void setState1800(String string) {
		state1800 = string;
	}

	/**
	 * @param string
	 */
	public void setState900(String string) {
		state900 = string;
	}

	/**
	 * @param date
	 */
	public void setTest1800(java.util.Date date) {
		test1800 = date;
	}

	/**
	 * @param date
	 */
	public void setTest900(java.util.Date date) {
		test900 = date;
	}

	/**
	 * @param date
	 */
	public void setTestAfs1800(java.util.Date date) {
		testAfs1800 = date;
	}

	/**
	 * @param date
	 */
	public void setTestAfs900(java.util.Date date) {
		testAfs900 = date;
	}

	/**
	 * @return
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param string
	 */
	public void setRecordStatus(String string) {
		recordStatus = string;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param string
	 */
	public void setType(String string) {
		type = string;
	}

	/**
	 * @return
	 */
	public ControllerVO getController() {
		return controller;
	}

	/**
	 * @param controllerVO
	 */
	public void setController(ControllerVO controllerVO) {
		controller = controllerVO;
	}

	/**
	 * @return
	 */
	public Integer getAntPlace() {
		return antPlace;
	}

	/**
	 * @return
	 */
	public Integer getApartment() {
		return apartment;
	}

	/**
	 * @return
	 */
	public String getDopInfo() {
		return dopInfo;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getHset() {
		return hset;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @return
	 */
	public String getPermitDCS() {
		return permitDCS;
	}

	/**
	 * @return
	 */
	public String getPermitGSM() {
		return permitGSM;
	}

	/**
	 * @param integer
	 */
	public void setAntPlace(Integer integer) {
		antPlace = integer;
	}

	/**
	 * @param integer
	 */
	public void setApartment(Integer integer) {
		apartment = integer;
	}

	/**
	 * @param string
	 */
	public void setDopInfo(String string) {
		dopInfo = string;
	}

	/**
	 * @param decimal
	 */
	public void setHset(java.math.BigDecimal decimal) {
		hset = decimal;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param integer
	 */
	public void setNumber(Integer integer) {
		number = integer;
	}

	/**
	 * @param string
	 */
	public void setPermitDCS(String string) {
		permitDCS = string;
	}

	/**
	 * @param string
	 */
	public void setPermitGSM(String string) {
		permitGSM = string;
	}

}

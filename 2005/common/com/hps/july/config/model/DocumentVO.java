package com.hps.july.config.model;

import java.io.Serializable;

/**
 * Value object to hold inventory document properties
 *
 * @author dima
 *
 */
public class DocumentVO implements Serializable, Comparable, Cloneable {

	private int code;
	private String docnumber;
	private int docindex;
	private java.util.Date docdate;
	private ExpeditionVO expeditor;
	private StoreVO store1;
	private StoreVO store2;
	private int configSource;
	private int configDest;
	private String state;
	private boolean haveChanges;
	private boolean haveInserts;
	private boolean haveDeletes;
	
	
	public DocumentVO() {
		super();
		expeditor = new ExpeditionVO();
		store1 = new StoreVO();
		store2 = new StoreVO();
		state = "1";
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();	
	}
	
	public void assignObject(DocumentVO newdoc) {
		System.out.println("fucking assignDocumentVO");
		this.code = newdoc.code;
		this.docnumber = newdoc.docnumber;
		this.docindex = newdoc.docindex;
		this.docdate = newdoc.docdate;
		this.expeditor = newdoc.expeditor;
		this.store1 = newdoc.store1;
		this.store2 = newdoc.store2;
		this.configSource = newdoc.configSource;
		this.configDest = newdoc.configDest;
		this.state = newdoc.state;
		this.haveChanges = newdoc.haveChanges;
		this.haveDeletes = newdoc.haveDeletes;
		this.haveInserts = newdoc.haveInserts;
	}
	
	public DocumentVO(int acode, String adocnumber, int adocindex, java.util.Date adocdate, ExpeditionVO aexpedition) {
		super();
		code = acode;
		docnumber = adocnumber;
		docindex = adocindex;
		docdate = adocdate;
		expeditor = aexpedition;
	}
	
	public static String getStateName(String argState) {
		if ("1".equals(argState))
			return "Вводится";
		else if ("2".equals(argState))
			return "Обсчитан";
		return "";
	}
	
	public String toString() {
		return getDocindex() + " " + getDocnumber();
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		DocumentVO other = (DocumentVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	public int compareTo(Object other) {
		int result = docdate.compareTo(((DocumentVO)other).docdate);
		if (result == 0) {
			result = toString().compareTo(((DocumentVO)other).toString());
		}
		return result;
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param i
	 */
	public void setCode(int i) {
		code = i;
	}

	/**
	 * @return
	 */
	public java.util.Date getDocdate() {
		return docdate;
	}

	/**
	 * @return
	 */
	public int getDocindex() {
		return docindex;
	}

	/**
	 * @return
	 */
	public String getDocnumber() {
		return docnumber;
	}

	/**
	 * @return
	 */
	public ExpeditionVO getExpeditor() {
		return expeditor;
	}

	/**
	 * @param date
	 */
	public void setDocdate(java.util.Date date) {
		docdate = date;
	}

	/**
	 * @param i
	 */
	public void setDocindex(int i) {
		docindex = i;
	}

	/**
	 * @param string
	 */
	public void setDocnumber(String string) {
		docnumber = string;
	}

	/**
	 * @param expeditionVO
	 */
	public void setExpeditor(ExpeditionVO expeditionVO) {
		System.out.println("setExpeditionVO");
		System.out.println(expeditionVO.toString());
		expeditor = expeditionVO;
	}

	/**
	 * @return
	 */
	public StoreVO getStore1() {
		return store1;
	}

	/**
	 * @return
	 */
	public StoreVO getStore2() {
		return store2;
	}

	/**
	 * @param storeVO
	 */
	public void setStore1(StoreVO storeVO) {
		store1 = storeVO;
	}

	/**
	 * @param storeVO
	 */
	public void setStore2(StoreVO storeVO) {
		store2 = storeVO;
	}

	/**
	 * @return
	 */
	public int getConfigDest() {
		return configDest;
	}

	/**
	 * @return
	 */
	public int getConfigSource() {
		return configSource;
	}

	/**
	 * @param i
	 */
	public void setConfigDest(int i) {
		configDest = i;
	}

	/**
	 * @param i
	 */
	public void setConfigSource(int i) {
		configSource = i;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}

	/**
	 * @return
	 */
	public boolean isHaveChanges() {
		return haveChanges;
	}

	/**
	 * @return
	 */
	public boolean isHaveDeletes() {
		return haveDeletes;
	}

	/**
	 * @return
	 */
	public boolean isHaveInserts() {
		return haveInserts;
	}

	/**
	 * @param b
	 */
	public void setHaveChanges(boolean b) {
		haveChanges = b;
	}

	/**
	 * @param b
	 */
	public void setHaveDeletes(boolean b) {
		haveDeletes = b;
	}

	/**
	 * @param b
	 */
	public void setHaveInserts(boolean b) {
		haveInserts = b;
	}

}

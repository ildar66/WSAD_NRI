/*
 * Created on 24.01.2006
 *
 */
package com.hps.july.valueobject;

/**
 * ��������� �������� ����� ������������ 
 * @author Dneprov Dmitry
 *
 */
public class ComplexDocument {
	
	public final static Integer DOCTYPE_BTSMOUNTACT = new Integer(1);
	
	private Integer compdoc; // ��� ���������� ���������
	private Integer compdoctype; // ��� ���������� ���������
	private String bsnumber; // ����� ��
	private String contrnumber; // ����� �����������
	private String repnumber; // ����� ��������
	private Integer equipment; // �������� ������������
	private Integer organization; // ����������� - ��������
	private String orgexped; // ��� �����������
	private Integer owner; // ��������
	private Integer worker; // ���������
	private java.sql.Date date; // ���� ���������
	private Integer projectid; // ������ ������������� ��
	private boolean needapprove; // ��������� ������������ ���������
	private Integer document; // ��� ��������� ����� ������������
	
	
	public ComplexDocument(Integer argCompdoctype, String argBsNumber, String argContrNumber,
			String argRepNumber, Integer argEquipment, Integer argOrganization, String argOrgExped,
			Integer argOwner, Integer argWorker, java.sql.Date argDate, Integer argProjectid,
			boolean argNeedApprove) {
		compdoctype = argCompdoctype;
		bsnumber = argBsNumber;
		contrnumber = argContrNumber;
		repnumber = argRepNumber;
		equipment = argEquipment;
		organization = argOrganization;
		orgexped = argOrgExped;
		owner = argOwner;
		worker = argWorker;
		date = argDate;
		projectid = argProjectid;
		needapprove = argNeedApprove;
	}
		
	/**
	 * @return
	 */
	public String getBsnumber() {
		return bsnumber;
	}

	/**
	 * @return
	 */
	public Integer getCompdoc() {
		return compdoc;
	}

	/**
	 * @return
	 */
	public Integer getCompdoctype() {
		return compdoctype;
	}

	/**
	 * @return
	 */
	public String getContrnumber() {
		return contrnumber;
	}

	/**
	 * @return
	 */
	public java.sql.Date getDate() {
		return date;
	}

	/**
	 * @return
	 */
	public Integer getEquipment() {
		return equipment;
	}

	/**
	 * @return
	 */
	public Integer getOrganization() {
		return organization;
	}

	/**
	 * @return
	 */
	public String getOrgexped() {
		return orgexped;
	}

	/**
	 * @return
	 */
	public Integer getOwner() {
		return owner;
	}

	/**
	 * @return
	 */
	public Integer getProjectid() {
		return projectid;
	}

	/**
	 * @return
	 */
	public String getRepnumber() {
		return repnumber;
	}

	/**
	 * @return
	 */
	public Integer getWorker() {
		return worker;
	}

	/**
	 * @param string
	 */
	public void setBsnumber(String string) {
		bsnumber = string;
	}

	/**
	 * @param integer
	 */
	public void setCompdoc(Integer integer) {
		compdoc = integer;
	}

	/**
	 * @param integer
	 */
	public void setCompdoctype(Integer integer) {
		compdoctype = integer;
	}

	/**
	 * @param string
	 */
	public void setContrnumber(String string) {
		contrnumber = string;
	}

	/**
	 * @param date
	 */
	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	/**
	 * @param integer
	 */
	public void setEquipment(Integer integer) {
		equipment = integer;
	}

	/**
	 * @param integer
	 */
	public void setOrganization(Integer integer) {
		organization = integer;
	}

	/**
	 * @param string
	 */
	public void setOrgexped(String string) {
		orgexped = string;
	}

	/**
	 * @param integer
	 */
	public void setOwner(Integer integer) {
		owner = integer;
	}

	/**
	 * @param integer
	 */
	public void setProjectid(Integer integer) {
		projectid = integer;
	}

	/**
	 * @param string
	 */
	public void setRepnumber(String string) {
		repnumber = string;
	}

	/**
	 * @param integer
	 */
	public void setWorker(Integer integer) {
		worker = integer;
	}

	/**
	 * @return
	 */
	public boolean isNeedapprove() {
		return needapprove;
	}

	/**
	 * @param b
	 */
	public void setNeedapprove(boolean b) {
		needapprove = b;
	}

	/**
	 * @return
	 */
	public Integer getDocument() {
		return document;
	}

	/**
	 * @param integer
	 */
	public void setDocument(Integer integer) {
		document = integer;
	}

}

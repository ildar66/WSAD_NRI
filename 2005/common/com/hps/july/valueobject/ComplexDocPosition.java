/*
 * Created on 24.01.2006
 *
 */
package com.hps.july.valueobject;

/**
 * ������� ���������� ���������
 * @author Dmitry Dneprov
 *
 */
public class ComplexDocPosition {

	private Integer compdocpos; // �������
	private Integer compdoc; // ��������� ��������
	private Integer tagid; // ���
	private Integer resource; // ������
	private String serial; // �������� �����
	private java.math.BigDecimal qty; // ����������
	private String comment; // �����������
	private Integer docposition; // ��� ������� ��������� ����� ������������
	
	public ComplexDocPosition(Integer argCompdocpos, Integer argTagid, Integer argResource, String argSerial, 
				java.math.BigDecimal argQty, String argComment) {
		compdocpos = argCompdocpos;
		tagid = argTagid;
		resource = argResource;
		serial = argSerial;
		qty = argQty;
		comment = argComment;
	}
	
	/**
	 * @return
	 */
	public String getComment() {
		return comment;
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
	public Integer getCompdocpos() {
		return compdocpos;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getQty() {
		return qty;
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
	public String getSerial() {
		return serial;
	}

	/**
	 * @return
	 */
	public Integer getTagid() {
		return tagid;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
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
	public void setCompdocpos(Integer integer) {
		compdocpos = integer;
	}

	/**
	 * @param decimal
	 */
	public void setQty(java.math.BigDecimal decimal) {
		qty = decimal;
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
	public void setSerial(String string) {
		serial = string;
	}

	/**
	 * @param integer
	 */
	public void setTagid(Integer integer) {
		tagid = integer;
	}

	/**
	 * @return
	 */
	public Integer getDocposition() {
		return docposition;
	}

	/**
	 * @param integer
	 */
	public void setDocposition(Integer integer) {
		docposition = integer;
	}

}

package com.hps.july.basestation.valueobject;

import com.hps.july.cdbc.lib.*;
/**
* ��������.�������� ���������� ������������ ���� "�������".
* Creation date: (09.07.2005 14:43:48)
* @author: Shafigullin Ildar
*/
public class Repiter_VO extends Equipment_VO {
    /**
    * ������� �������� ������������� ���� ��� ���������� ������������ ���� "��������". 
    * ������� ������������ ��������� � ��������� "��������� ������������" (equipment)
    * � "����� ��������" (storageplaces).
    */
    private java.lang.Integer donor_sect; //������ �� �������� ������
    private java.lang.Integer donor_ant; //������ �� �������� �������
    private java.lang.String donor_type; //��� ����������� � ���_ �������(A-���������, B-����������, C-���������� �����)
    private java.lang.String repiter_class;
    //����� ������������(A-������, ���������, B-������, ���������, C-������, ��������� � ��������� �������, D-������� ��������, ���������, E-����� ��������, ���������)
    private java.lang.Integer resource; //������ �� ������_�������
    private java.math.BigDecimal reppower; //�������� ��������
    private java.math.BigDecimal bandwidth; //������ ������
    private java.lang.Integer numchanals; //����� �������
    private java.lang.Integer number; //����� ��������
/**
 * Repiter_VO constructor comment.
 */
public Repiter_VO(CDBCRowObject ro) {
	super(ro);
	setDonor_sect((Integer)ro.getColumn("donor_sect").asObject());
	setDonor_ant((Integer)ro.getColumn("donor_ant").asObject());
	setDonor_type(ro.getColumn("donor_type").asString());
	setRepiter_class(ro.getColumn("repiter_class").asString());
	setResource((Integer)ro.getColumn("resource").asObject());
	setReppower((java.math.BigDecimal)ro.getColumn("reppower").asObject());
	setBandwidth((java.math.BigDecimal)ro.getColumn("bandwidth").asObject());
	setNumchanals((Integer)ro.getColumn("numchanals").asObject());
	setNumber((Integer)ro.getColumn("number").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:56:44)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBandwidth() {
	return bandwidth;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:48:17)
 * @return java.lang.Integer
 */
public java.lang.Integer getDonor_ant() {
	return donor_ant;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:47:46)
 * @return java.lang.Integer
 */
public java.lang.Integer getDonor_sect() {
	return donor_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:48:50)
 * @return java.lang.String
 */
public java.lang.String getDonor_type() {
	return donor_type;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:57:46)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:57:24)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumchanals() {
	return numchanals;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:50:39)
 * @return java.lang.String
 */
public java.lang.String getRepiter_class() {
	return repiter_class;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:56:08)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getReppower() {
	return reppower;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:55:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:56:44)
 * @param newBandwidth java.math.BigDecimal
 */
public void setBandwidth(java.math.BigDecimal newBandwidth) {
	bandwidth = newBandwidth;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:48:17)
 * @param newDonor_ant java.lang.Integer
 */
public void setDonor_ant(java.lang.Integer newDonor_ant) {
	donor_ant = newDonor_ant;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:47:46)
 * @param newDonor_sect java.lang.Integer
 */
public void setDonor_sect(java.lang.Integer newDonor_sect) {
	donor_sect = newDonor_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:48:50)
 * @param newDonor_type java.lang.String
 */
public void setDonor_type(java.lang.String newDonor_type) {
	donor_type = newDonor_type;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:57:46)
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:57:24)
 * @param newNumchanals java.lang.Integer
 */
public void setNumchanals(java.lang.Integer newNumchanals) {
	numchanals = newNumchanals;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:50:39)
 * @param newRepiter_class java.lang.String
 */
public void setRepiter_class(java.lang.String newRepiter_class) {
	repiter_class = newRepiter_class;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:56:08)
 * @param newReppower java.math.BigDecimal
 */
public void setReppower(java.math.BigDecimal newReppower) {
	reppower = newReppower;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 14:55:32)
 * @param newResource java.lang.Integer
 */
public void setResource(java.lang.Integer newResource) {
	resource = newResource;
}
}

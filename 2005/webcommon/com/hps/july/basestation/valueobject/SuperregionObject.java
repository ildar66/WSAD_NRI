package com.hps.july.basestation.valueobject;

/**
 * ��������� �����-��������� � ����������� � ������������
 */
public class SuperregionObject {
	private int supregid;
	private java.lang.String supregname;
public SuperregionObject(int asupregId, String asupregname) {
	super();
	supregid = asupregId;
	supregname = asupregname;
}
public int getSupregid() {
	return supregid;
}
public java.lang.String getSupregname() {
	return supregname;
}
public void setSupregid(int newSupregid) {
	supregid = newSupregid;
}
public void setSupregname(java.lang.String newSupregname) {
	supregname = newSupregname;
}
}

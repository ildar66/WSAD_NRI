package com.hps.july.siteinfo.valueobject;

/**
 * Класс-контейнер с параметрами супер региона (код и имя)
 */
public class SuperregionVO
	implements java.io.Serializable
{
	private int supregid;
	private java.lang.String supregname;
public SuperregionVO(int asupregId, String asupregname) {
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

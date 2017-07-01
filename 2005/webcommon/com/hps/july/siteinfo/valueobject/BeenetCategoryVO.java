package com.hps.july.siteinfo.valueobject;

public class BeenetCategoryVO
{
	private Integer categid;
	private String categname;
public BeenetCategoryVO() {
	super();
}
public BeenetCategoryVO(int categid, String categname)
{
	super();
	this.categid = new Integer(categid);
	this.categname = categname;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getCategid() {
	return categid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCategname() {
	return categname;
}
/**
 * 
 * @param newCategid java.lang.Integer
 */
public void setCategid(java.lang.Integer newCategid) {
	categid = newCategid;
}
/**
 * 
 * @param newCategname java.lang.String
 */
public void setCategname(java.lang.String newCategname) {
	categname = newCategname;
}
}

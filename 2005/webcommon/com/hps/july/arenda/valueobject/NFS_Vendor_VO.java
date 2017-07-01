package com.hps.july.arenda.valueobject;

/**
 * Контейнер для строк таблицы:nfs_vendors "Справочник поставщиков NFS".
 * Creation date: (11.06.2004 12:54:54)
 * @author: Shafigullin Ildar
 */
public class NFS_Vendor_VO {
	private java.lang.Integer id;//код поставщика в NFS
	private java.lang.String name;//наименование
	private java.lang.String inn;//ИНН
	private java.lang.Integer vendorcode;//номер поставщика в NFS
/**
 * NFS_Vendor_VO constructor comment.
 */
public NFS_Vendor_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 13:07:19)
 * @param id java.lang.Integer
 * @param name java.lang.String
 * @param inn java.lang.String
 */
public NFS_Vendor_VO(Integer id, String name, String inn) {
	this.id = id;
	this.name = name;
	this.inn = inn;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 12:59:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 13:05:58)
 * @return java.lang.String
 */
public java.lang.String getInn() {
	return inn;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 13:04:55)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 15:39:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getVendorcode() {
	return vendorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 15:39:47)
 * @param newVendorcode java.lang.Integer
 */
public void setVendorcode(java.lang.Integer newVendorcode) {
	vendorcode = newVendorcode;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "Vendor.id=" + id + " ;name=" +getName()+ " ;inn="+ getInn();
}
}

package com.hps.july.arenda.valueobject;

/**
 * Контейнер для строк таблицы:nfs_vendors "Справочник отделений поставщиков nfs".
 * Creation date: (11.06.2004 14:04:27)
 * @author: Shafigullin Ildar
 */
public class NFS_VendorSite_VO {
	private java.lang.Integer id;//код отделения поставщика в nfs
	private java.lang.String name;//наименование отделения поставщика
	private java.lang.String kpp;//КПП
	private java.lang.String code;//код отделения
/**
 * NFS_VendorSite_VO constructor comment.
 */
public NFS_VendorSite_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 14:13:59)
 * @param id java.lang.Integer
 * @param name java.lang.String
 * @param kpp java.lang.String
 * @param code java.lang.String 
 */
public NFS_VendorSite_VO(Integer id, String name, String kpp, String code) {
	this.id = id;
	this.name = name;
	this.kpp = kpp;
	this.code = code;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 14:26:35)
 * @return java.lang.String
 */
public java.lang.String getCode() {
	return code;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 14:09:48)
 * @return java.lang.Integer
 */
public java.lang.Integer getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 14:11:35)
 * @return java.lang.String
 */
public java.lang.String getKpp() {
	return kpp;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 14:10:13)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "VendorSite.id=" + id + "; name=" +getName()+ "; kpp="+ getKpp() + "; code=" + getCode();
}
}

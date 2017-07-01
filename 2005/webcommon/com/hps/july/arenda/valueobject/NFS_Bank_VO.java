package com.hps.july.arenda.valueobject;

/**
 * Контейнер для строк таблицы:nfs_banks "Банки из системы NFS"
 * Creation date: (16.06.2004 15:09:10)
 * @author: Shafigullin Ildar
 */
public class NFS_Bank_VO {
	private java.lang.Integer id;//Код банка в системе NFS
	private java.lang.String name;//наименование банка
	private java.lang.String bik;//бик банка
	private java.lang.String korschet;//кор счет
/**
 * NFS_Bank_VO constructor comment.
 */
public NFS_Bank_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:52:48)
 * @param id java.lang.Integer
 * @param name java.lang.String
 * @param bik java.lang.String
 * @param korschet java.lang.String
 */
public NFS_Bank_VO(Integer id, String name, String bik, String korschet) {
	this.id = id;
	this.name = name;
	this.bik = bik;
	this.korschet = korschet;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 15:12:10)
 * @return java.lang.String
 */
public java.lang.String getBik() {
	return bik;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 15:10:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 15:12:46)
 * @return java.lang.String
 */
public java.lang.String getKorschet() {
	return korschet;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 15:11:06)
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
	return "Bank.id=" + id + " ;name=" +getName()+ " ;korschet="+ getKorschet();
}
}

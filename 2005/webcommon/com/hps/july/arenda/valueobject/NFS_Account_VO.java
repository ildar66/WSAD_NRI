package com.hps.july.arenda.valueobject;

import com.hps.july.logic.PrimaryKeyTwo;
/**
* Контейнер для строк таблицы:nfs_accounts "Расчетные счета NFS"
* Creation date: (16.06.2004 15:16:35)
* @author: Shafigullin Ildar
*/
public class NFS_Account_VO {
	/**
	* 'Уникальный идентификатор счета';
	*/
	private NFS_Account_VO.NFS_Account_PK id;
	/**
	* 'Уникальный идентификатор счета';
	*/	
	public static class NFS_Account_PK extends PrimaryKeyTwo {
		public NFS_Account_PK(String idAccountNfs, String idVendorSiteNfs) {
			super(idAccountNfs, idVendorSiteNfs);
		}
	}
	private NFS_Bank_VO bank;
	private java.lang.String accountNum;
/**
 * NFS_Account_VO constructor comment.
 */
public NFS_Account_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:58:09)
 * @param pk com.hps.july.arenda.valueobject.NFS_Account_VO
 * @param accNumber java.lang.String
 */
public NFS_Account_VO(NFS_Account_VO.NFS_Account_PK pk, String accNumber) {
	id = pk;
	this.accountNum = accNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:56:02)
 * @return java.lang.String
 */
public java.lang.String getAccountNum() {
	return accountNum;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:50:31)
 * @return com.hps.july.arenda.valueobject.NFS_Bank_VO
 */
public NFS_Bank_VO getBank() {
	return bank;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:56:02)
 * @param newAccountNum java.lang.String
 */
public void setAccountNum(java.lang.String newAccountNum) {
	accountNum = newAccountNum;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:50:31)
 * @param newBank com.hps.july.arenda.valueobject.NFS_Bank_VO
 */
public void setBank(NFS_Bank_VO newBank) {
	bank = newBank;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "NFS_Account_VO: PK=" + id.toString();
}
}

package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
/**
 * Bean-form для отчета из NFS.
 * Creation date: (10.06.2004 15:21:40)
 * @author: Shafigullin Ildar
 */
public class NFS_PrintForm extends ActionForm {
	private java.lang.Integer idZpNfs;
	private com.hps.july.arenda.valueobject.NFS_ZP_VO zp;
	private java.lang.Integer idContractNfs;
	private com.hps.july.arenda.valueobject.NFS_Contract_VO contract;
	private com.hps.july.arenda.valueobject.NFS_SchetFakt_VO sf;
	private java.lang.Integer idSchetFaktNfs;
	private java.lang.Integer idPayNfs;
	private com.hps.july.arenda.valueobject.NFS_Pay_VO pay;
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 16:28:49)
 * @return com.hps.july.arenda.valueobject.NFS_Contract_VO
 */
public com.hps.july.arenda.valueobject.NFS_Contract_VO getContract() {
	return contract;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 16:27:23)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdContractNfs() {
	return idContractNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 12:42:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdPayNfs() {
	return idPayNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 18:03:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdSchetFaktNfs() {
	return idSchetFaktNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 16:33:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdZpNfs() {
	return idZpNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 12:42:40)
 * @return com.hps.july.arenda.valueobject.NFS_Pay_VO
 */
public com.hps.july.arenda.valueobject.NFS_Pay_VO getPay() {
	return pay;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 18:02:27)
 * @return com.hps.july.arenda.valueobject.NFS_SchetFakt_VO
 */
public com.hps.july.arenda.valueobject.NFS_SchetFakt_VO getSf() {
	return sf;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 17:06:16)
 * @return com.hps.july.arenda.valueobject.NFS_ZP_VO
 */
public com.hps.july.arenda.valueobject.NFS_ZP_VO getZp() {
	return zp;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 16:34:53)
 */
public void init() {
	if (idZpNfs != null) {
		CDBCRowObject ro = CDBC_NFS_Object.findZP_NFS(idZpNfs.intValue());
		if (ro != null) {
			NFS_ZP_VO zp = new NFS_ZP_VO(ro);
			zp.initVendor(ro);
			zp.getVendor().setVendorcode((Integer)ro.getColumn("codevendor_zp").asObject());			
			zp.initSite(ro);
			zp.initDomainInfo(ro);
			this.zp = zp;
		}
	}
	if (idContractNfs != null) {
		CDBCRowObject ro = CDBC_NFS_Object.findContract_NFS(idContractNfs.intValue());
		if (ro != null) {
			NFS_Contract_VO contract = new NFS_Contract_VO(ro);
			this.contract = contract;
		}
	}
	if (idSchetFaktNfs != null) {
		CDBCRowObject ro = CDBC_NFS_Object.findSchetFakt_NFS(idSchetFaktNfs.intValue());
		if (ro != null) {
			com.hps.july.arenda.valueobject.NFS_SchetFakt_VO sf = new com.hps.july.arenda.valueobject.NFS_SchetFakt_VO(ro);
			sf.calcNds(ro);
			sf.initRecipient(ro);
			sf.initAccount(ro);
			sf.initVendor(ro);
			sf.getVendor().setVendorcode((Integer)ro.getColumn("codevendor_sf").asObject());
			sf.initSite(ro);
			sf.initDomainInfo(ro);			
			this.sf = sf;
		}
	}
	if (idPayNfs != null) {
		CDBCRowObject ro = CDBC_NFS_Object.findPay_NFS(idPayNfs.intValue());
		if (ro != null) {
			com.hps.july.arenda.valueobject.NFS_Pay_VO pay = new com.hps.july.arenda.valueobject.NFS_Pay_VO(ro);
			pay.calcNds(ro);
			pay.initRecipient(ro);
			pay.initAccount(ro);
			this.pay = pay;
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 16:27:23)
 * @param newIdContractNfs java.lang.Integer
 */
public void setIdContractNfs(java.lang.Integer newIdContractNfs) {
	idContractNfs = newIdContractNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 12:42:03)
 * @param newIdPayNfs java.lang.Integer
 */
public void setIdPayNfs(java.lang.Integer newIdPayNfs) {
	idPayNfs = newIdPayNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 18:03:47)
 * @param newIdSchetFaktNfs java.lang.Integer
 */
public void setIdSchetFaktNfs(java.lang.Integer newIdSchetFaktNfs) {
	idSchetFaktNfs = newIdSchetFaktNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 16:33:09)
 * @param newIdZpNfs java.lang.Integer
 */
public void setIdZpNfs(java.lang.Integer newIdZpNfs) {
	idZpNfs = newIdZpNfs;
}
}

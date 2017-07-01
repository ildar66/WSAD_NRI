package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Требования"
 */
public class ReqValue {
	private com.hps.july.persistence.RequestAccessBean so;
	private String expedition;
	private String expeditioncode;
	private String type;
	private java.math.BigDecimal qty;
	private String pcode;
	private String pname;
	private String pfio;
	private String pdov;
	private java.sql.Date pdovdate;
	private String wcode;
	private String wname;
	private String wpos;
	private String poscode;
	private String posname;
	private String posid;
public ReqValue(Object o) {
	expedition = "?";
	expeditioncode = "";
	// pcode
	// pname
	// pfio
	// pdov
	// pdovdate
	// wcode
	// wname
	// wpos
	
	type = "";
	if(o instanceof RequestAccessBean) {
		so = (RequestAccessBean)o;
		try {
			so.refreshCopyHelper();
			ExpeditionAccessBean exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(so.getFrom().getStorageplace());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				expedition = exp.getExpeditor().getMan().getFullName();
				expeditioncode = ""+exp.getExpeditor().getWorker();
				type = "W";
				pcode = "";
				pname = "";
				pfio = "";
				pdov = "";
				pdovdate = so.getInsurancedate();
				wcode = expeditioncode;
				wname = expedition;
				wpos = exp.getExpeditor().getPosition().getName();
			} else if(exp.getOrganization() != null) {
				expedition = exp.getOrganization().getName();
				expeditioncode = ""+exp.getOrganization().getOrganization();
				type = "P";
				pcode = expeditioncode;
				pname = expedition;
				pfio = so.getInsuranseMan();
				pdov = so.getInsuranceact();
				pdovdate = so.getInsurancedate();
				wcode = "";
				wname = "";
				wpos = "";
			}
			if(so.getPosition() != null) {
				PositionAccessBean p = so.getPosition();
				poscode = ""+p.getStorageplace();
				posname = p.getName();
				if(p.getGsmid() != null) {
					posid = "D"+p.getGsmid()+" ";
				}
				if(p.getDampsid() != null) {
					posid += "A"+p.getDampsid()+" ";
				}
			} else {
				poscode = "";
				posname = "";
				posid = "";
			}
		} catch(Exception e) {
//			e.printStackTrace(System.out);
		}
	} else {
		so = null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 20:41:51)
 * @return java.lang.String
 */
public java.lang.String getExpedition() {
	return expedition;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 12:14:18)
 * @return java.lang.String
 */
public java.lang.String getExpeditioncode() {
	return expeditioncode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPcode() {
	return pcode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPdov() {
	return pdov;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getPdovdate() {
	return pdovdate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPfio() {
	return pfio;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPname() {
	return pname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPoscode() {
	return poscode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
public java.math.BigDecimal getQty() {
	return qty;
}
public RequestAccessBean getSo() {
	return so;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 21:03:36)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWcode() {
	return wcode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWname() {
	return wname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWpos() {
	return wpos;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 20:41:51)
 * @param newExpedition java.lang.String
 */
public void setExpedition(java.lang.String newExpedition) {
	expedition = newExpedition;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 12:14:18)
 * @param newExpeditioncode java.lang.String
 */
public void setExpeditioncode(java.lang.String newExpeditioncode) {
	expeditioncode = newExpeditioncode;
}
/**
 * 
 * @param newPcode java.lang.String
 */
public void setPcode(java.lang.String newPcode) {
	pcode = newPcode;
}
/**
 * 
 * @param newPdov java.lang.String
 */
public void setPdov(java.lang.String newPdov) {
	pdov = newPdov;
}
/**
 * 
 * @param newPdovdate java.sql.Date
 */
public void setPdovdate(java.sql.Date newPdovdate) {
	pdovdate = newPdovdate;
}
/**
 * 
 * @param newPfio java.lang.String
 */
public void setPfio(java.lang.String newPfio) {
	pfio = newPfio;
}
/**
 * 
 * @param newPname java.lang.String
 */
public void setPname(java.lang.String newPname) {
	pname = newPname;
}
/**
 * 
 * @param newPoscode java.lang.String
 */
public void setPoscode(java.lang.String newPoscode) {
	poscode = newPoscode;
}
/**
 * 
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * 
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
public void setQty(java.math.BigDecimal newQty) {
	qty = newQty;
}
public void setSo(RequestAccessBean newSo) {
	so = newSo;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 21:03:36)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
/**
 * 
 * @param newWcode java.lang.String
 */
public void setWcode(java.lang.String newWcode) {
	wcode = newWcode;
}
/**
 * 
 * @param newWname java.lang.String
 */
public void setWname(java.lang.String newWname) {
	wname = newWname;
}
/**
 * 
 * @param newWpos java.lang.String
 */
public void setWpos(java.lang.String newWpos) {
	wpos = newWpos;
}
}

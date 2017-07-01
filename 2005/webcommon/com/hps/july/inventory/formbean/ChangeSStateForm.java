package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * Форма изменения состояния документа "Акт замены/модернизации на складе"
 */
public class ChangeSStateForm
	extends AbstractDocumentStateForm
{
	private String acttype;
public ChangeSStateForm() {
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	try {
		ChangeActAccessBean abean = (ChangeActAccessBean)bean;
		acttype = abean.getActtype();
	} catch(Exception e) {
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getActtype() {
	return acttype;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHSST;
}
/**
 * 
 * @param newActtype java.lang.String
 */
public void setActtype(java.lang.String newActtype) {
	acttype = newActtype;
}
}

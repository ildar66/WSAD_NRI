package com.hps.july.dictionary.formbean;

import java.math.BigDecimal;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;

/**
 * Форма выбора класса оборудования перед добавлением
 */
public class ChooseRtypeForm extends EditForm {
	private String rtype;
public ChooseRtypeForm() {
	try {
		initRecord(null);
	} catch(Exception e) {
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
public java.lang.String getRtype() {
	return rtype;
}
public int getState() {
	return com.hps.july.dictionary.APPStates.CHORTYPE;
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	setAction("Add");
	rtype = "other";
}
public void setRtype(java.lang.String newRtype) {
	rtype = newRtype;
}
}

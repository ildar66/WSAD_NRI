package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import java.sql.Date;
/**
 * Form-Bean.
 * список параметров 11-го отчета "Аренды".
 * Creation date: (20.02.2003 12:34:39)
 * @author: Sergey Gourov
 */
public class ArendaReport11ParamsForm extends ReportForm {
	private com.hps.july.web.util.StringAndSqlDateProperty date;
	private com.hps.july.web.util.StringAndIntegerProperty economistcode;
	private java.lang.String economistname;
/**
 * ArendaReport2ParamsForm constructor comment.
 */
public ArendaReport11ParamsForm() {
	super();
	date = new StringAndSqlDateProperty();
	economistcode = new StringAndIntegerProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateFrm() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 17:11:07)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getEconomistcode() {
	return economistcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 17:11:07)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getEconomistcodeFrm() {
	return economistcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 10:34:33)
 * @return java.lang.String
 */
public java.lang.String getEconomistname() {
	return economistname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 12:34:39)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ARENDA_REPORT11_PARAMS;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDate(Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateFrm(String newDate) {
	date.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 17:11:07)
 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setEconomistcode(Integer newEconomistcode) {
	economistcode.setInteger(newEconomistcode);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 17:11:07)
 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setEconomistcodeFrm(String newEconomistcode) {
	economistcode.setString(newEconomistcode);
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 10:34:33)
 * @param newEconomistname java.lang.String
 */
public void setEconomistname(java.lang.String newEconomistname) {
	economistname = newEconomistname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (economistcode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.report.economist"));
		setEconomistname("");
	} else if (!economistcode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.report.economist"));
		setEconomistname("");
	} else {
		try {
			WorkerAccessBean economist = new WorkerAccessBean();
			economist.setInitKey_worker(getEconomistcode().intValue());
			economist.refreshCopyHelper();
		} catch (Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.report.economist"));
				setEconomistname("");
			}
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}

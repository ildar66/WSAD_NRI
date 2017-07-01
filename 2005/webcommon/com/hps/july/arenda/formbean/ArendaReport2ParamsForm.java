package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import java.sql.Date;
/**
 * Form-Bean.
 * список параметров 2-го отчета "Аренды".
 * Creation date: (20.02.2003 12:34:39)
 * @author: Sergey Gourov
 */
public class ArendaReport2ParamsForm extends ReportForm {
	private com.hps.july.web.util.StringAndSqlDateProperty date;
/**
 * ArendaReport2ParamsForm constructor comment.
 */
public ArendaReport2ParamsForm() {
	super();
	date = new StringAndSqlDateProperty();
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
 * Creation date: (20.02.2003 12:34:39)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ARENDA_REPORT2_PARAMS;
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
}

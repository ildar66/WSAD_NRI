package com.hps.july.arenda.formbean;

import java.math.*;
import com.hps.july.web.util.*;
import java.sql.Date;
/**
 * Form-Bean ������ ���������� 9-�� ������ "������".
 * Creation date: (20.02.2003 14:35:33)
 * @author: Sergey Gourov
 */
public class ArendaReport9ParamsForm extends ReportForm {
	private com.hps.july.web.util.StringAndSqlDateProperty startdate;
	private com.hps.july.web.util.StringAndSqlDateProperty finishdate;
/**
 * ArendaReport3ParamsForm constructor comment.
 */
public ArendaReport9ParamsForm() {
	super();
	startdate = new StringAndSqlDateProperty();
	finishdate = new StringAndSqlDateProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:40:42)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getFinishdate() {
	return finishdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:40:42)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getFinishdateFrm() {
	return finishdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:37:29)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartdate() {
	return startdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:37:29)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getStartdateFrm() {
	return startdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:35:33)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ARENDA_REPORT9_PARAMS;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:40:42)
 * @param newFinishdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setFinishdate(Date newFinishdate) {
	finishdate.setSqlDate(newFinishdate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:40:42)
 * @param newFinishdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setFinishdateFrm(String newFinishdate) {
	finishdate.setString(newFinishdate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:37:29)
 * @param newStartdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartdate(Date newStartdate) {
	startdate.setSqlDate(newStartdate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 14:37:29)
 * @param newStartdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartdateFrm(String newStartdate) {
	startdate.setString(newStartdate);
}
}

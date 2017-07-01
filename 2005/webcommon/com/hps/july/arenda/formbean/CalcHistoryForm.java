package com.hps.july.arenda.formbean;

import java.util.*;
/**
 * Form-Bean.
 * Расчет истории
 * Creation date: (05.06.2003 13:58:07)
 * @author: Sergey Gourov
 */
public class CalcHistoryForm extends org.apache.struts.action.ActionForm {
	private java.lang.String countRecord = "1";
	private java.lang.String reportType = "1";
	private int leaseDocument;
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 14:06:01)
 * @return java.lang.String
 */
public java.lang.String getCountRecord() {
	return countRecord;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 14:23:15)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 14:04:57)
 * @return java.lang.String
 */
public java.lang.String getReportType() {
	return reportType;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 14:06:01)
 * @param newCountRecord java.lang.String
 */
public void setCountRecord(java.lang.String newCountRecord) {
	countRecord = newCountRecord;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 14:23:15)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 14:04:57)
 * @param newReportType java.lang.String
 */
public void setReportType(java.lang.String newReportType) {
	reportType = newReportType;
}
}

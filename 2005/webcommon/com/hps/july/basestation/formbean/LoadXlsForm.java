package com.hps.july.basestation.formbean;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.*;

/**
 * Форма загрузки данных
 */
public class LoadXlsForm extends com.hps.july.web.util.EditForm{
	private boolean maxReport;
	private org.apache.struts.upload.FormFile xslFile;
	private java.lang.String diapazon;
	private boolean vertic;
	private boolean cross;
	private ArrayList range = new ArrayList();
	private java.util.ArrayList r900 = new ArrayList();
	private java.util.ArrayList r1800 = new ArrayList();
	private java.lang.String step1;
	private java.util.ArrayList range1800 = new ArrayList();
public LoadXlsForm(){
	maxReport = false;	
	cross=false;
	vertic=false;
	setLastVisited(true);
	diapazon = "900";
}
/**
 * Insert the method's description here.
 * Creation date: (29.06.2005 11:46:13)
 */
public void checkRangeSize(java.util.ArrayList arList, int index) {
	int asize = arList.size();
	if (asize < (index+1)) {
		for (int i=0; i < index+1 - asize; i++) {
			arList.add(new RangeAllow());
		}
	}	
}
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception{
	return null;
}
public int getApplication(){
	return 0;
}
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request){
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2005 10:43:06)
 * @return java.lang.String
 */
public java.lang.String getDiapazon() {	
	return diapazon;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 15:32:39)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getR1800() {
	return r1800;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 15:32:04)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getR900() {
	return r900;
}
/**
 * Insert the method's description here.
 * Creation date: (29.06.2005 11:27:33)
 * @return java.util.ArrayList
 */
public RangeAllow getRange(int index) {
	checkRangeSize(range, index);
	System.err.println(">>>>>>>>>>>>>> " + index + ">>>>>>" + range.get(index));
	return (RangeAllow)range.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 15:39:37)
 * @return java.util.ArrayList
 */
public RangeAllow getRange1800(int index) {
	checkRangeSize(range1800, index);
	System.err.println(">>>>>>>>>>>>>> " + index + ">>>>>>" + range1800.get(index));
	return (RangeAllow)range1800.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 15:39:37)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getRange1800All() {
	return range1800;
}
/**
 * Insert the method's description here.
 * Creation date: (29.06.2005 12:51:18)
 * @return java.util.ArrayList
 */
public ArrayList getRangeAll() {
	return range;
}
public int getState(){
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 13:01:17)
 * @return java.lang.String
 */
public java.lang.String getStep1() {
	return step1;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 15:59:21)
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getXslFile() {
	return xslFile;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2005 10:56:29)
 * @return boolean
 */
public boolean isCross() {
	return cross;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 14:59:57)
 * @return boolean
 */
public boolean isMaxReport() {
	return maxReport;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2005 10:55:38)
 * @return boolean
 */
public boolean isVertic() {
	return vertic;
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	System.err.println("******LOAD RECORD");
	range = new ArrayList();
	
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2005 10:56:29)
 * @param newCross boolean
 */
public void setCross(boolean newCross) {
	cross = newCross;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2005 10:43:06)
 * @param newDiapazon java.lang.String
 */
public void setDiapazon(java.lang.String newDiapazon) {	
	diapazon = newDiapazon;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 14:59:57)
 * @param newMaxReport boolean
 */
public void setMaxReport(boolean newMaxReport) {
	maxReport = newMaxReport;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 15:32:39)
 * @param newR1800 java.util.ArrayList
 */
public void setR1800(java.util.ArrayList newR1800) {
	r1800 = newR1800;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 15:32:04)
 * @param newR900 java.util.ArrayList
 */
public void setR900(java.util.ArrayList newR900) {
	r900 = newR900;
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 13:01:17)
 * @param newStep1 java.lang.String
 */
public void setStep1(java.lang.String newStep1) {
	step1 = newStep1;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2005 10:55:38)
 * @param newVertic boolean
 */
public void setVertic(boolean newVertic) {
	//range.clear();
	vertic = newVertic;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 15:59:21)
 * @param newXslFile org.apache.struts.upload.FormFile
 */
public void setXslFile(org.apache.struts.upload.FormFile newXslFile) {
	xslFile = newXslFile;
}
}

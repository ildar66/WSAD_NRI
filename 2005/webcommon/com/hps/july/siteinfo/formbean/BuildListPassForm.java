package com.hps.july.siteinfo.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.StringAndIntegerProperty;
/**
 * ‘орма запроса на формирование списка прохода в WORD.
 */
public class BuildListPassForm extends com.hps.july.web.util.BrowseForm {
	
	private int storageplace;
	private boolean workerBeeline;
	private boolean paspDataWorkerBeeline;
	private boolean workerNoBeeline;
	private boolean paspDataWorkerNoBeeline;
	private boolean carBeeline;
	private boolean carNoBeeline;
	private int showword;
	private boolean haveWordDoc;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public BuildListPassForm() {
	//this.setFinderMethodName( "" );
	storageplace = 0;
	workerBeeline = true;
	paspDataWorkerBeeline = true;
	workerNoBeeline = true;
	paspDataWorkerNoBeeline = true;
	carBeeline = true;
	carNoBeeline = true;
	showword = 0;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:17:33)
 * @return java.lang.Object[]
 */
public  Object[] getFilterParams(){
	return new Object[]{};
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2004 17:50:03)
 * @return int
 */
public int getShowword() {
	return showword;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:04:58)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:07:55)
 * @return boolean
 */
public boolean isCarBeeline() {
	return carBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:08:15)
 * @return boolean
 */
public boolean isCarNoBeeline() {
	return carNoBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (02.03.2004 12:42:17)
 * @return boolean
 */
public boolean isHaveWordDoc() {
	return haveWordDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:06:28)
 * @return boolean
 */
public boolean isPaspDataWorkerBeeline() {
	return paspDataWorkerBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:07:27)
 * @return boolean
 */
public boolean isPaspDataWorkerNoBeeline() {
	return paspDataWorkerNoBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:05:43)
 * @return boolean
 */
public boolean isWorkerBeeline() {
	return workerBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:06:55)
 * @return boolean
 */
public boolean isWorkerNoBeeline() {
	return workerNoBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:07:55)
 * @param newCarBeeline boolean
 */
public void setCarBeeline(boolean newCarBeeline) {
	carBeeline = newCarBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:08:15)
 * @param newCarNoBeeline boolean
 */
public void setCarNoBeeline(boolean newCarNoBeeline) {
	carNoBeeline = newCarNoBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (02.03.2004 12:42:17)
 * @param newHaveWordDoc boolean
 */
public void setHaveWordDoc(boolean newHaveWordDoc) {
	haveWordDoc = newHaveWordDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:06:28)
 * @param newPaspDataWorkerBeeline boolean
 */
public void setPaspDataWorkerBeeline(boolean newPaspDataWorkerBeeline) {
	paspDataWorkerBeeline = newPaspDataWorkerBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:07:27)
 * @param newPaspDataWorkerNoBeeline boolean
 */
public void setPaspDataWorkerNoBeeline(boolean newPaspDataWorkerNoBeeline) {
	paspDataWorkerNoBeeline = newPaspDataWorkerNoBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (05.02.2004 17:50:03)
 * @param newShowword int
 */
public void setShowword(int newShowword) {
	showword = newShowword;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:04:58)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:05:43)
 * @param newWorkerBeeline boolean
 */
public void setWorkerBeeline(boolean newWorkerBeeline) {
	workerBeeline = newWorkerBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2003 15:06:55)
 * @param newWorkerNoBeeline boolean
 */
public void setWorkerNoBeeline(boolean newWorkerNoBeeline) {
	workerNoBeeline = newWorkerNoBeeline;
}
public String toString() {
	StringBuffer buf = new StringBuffer();
	buf.append("Inside BuildListPassForm\n");
	buf.append("storageplace="+storageplace+"\n");
	buf.append("workerBeeline="+workerBeeline+"\n");
	buf.append("paspDataWorkerBeeline="+paspDataWorkerBeeline+"\n");
	buf.append("workerNoBeeline="+workerNoBeeline+"\n");
	buf.append("paspDataWorkerNoBeeline="+paspDataWorkerNoBeeline+"\n");
	buf.append("carBeeline="+carBeeline+"\n");
	buf.append("carNoBeeline="+carNoBeeline+"\n");
	buf.append("-----------------------\n");
	return buf.toString();
}
}

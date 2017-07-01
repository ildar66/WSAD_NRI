package com.hps.july.platinum.valueobject;

import java.util.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;

/**
 * Insert the type's description here.
 * Creation date: (18.02.2002 10:42:32)
 * @author: Oleg Gashnikov
 */
public class WorkerValue {
	
 
	private java.lang.String p_status;	//from platinum table
	private java.lang.String namePlatinum; //100 chars
	private java.util.Map url;
	private java.lang.String jspriznak;
	private int worker;
	private java.lang.String nameNri;
	private java.lang.String otvuserplatinum;
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @return java.lang.String
 */
public java.lang.String getJspriznak() {
	return jspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 15:20:40)
 * @return java.lang.String
 */
public java.lang.String getNameNri() {
	return nameNri;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:25:57)
 * @return java.lang.String
 */
public java.lang.String getNamePlatinum() {
	return namePlatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 10:45:56)
 * @return java.lang.String
 */
public java.lang.String getOtvuserplatinum() {
	return otvuserplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 18:21:45)
 * @return java.lang.String
 */
public java.lang.String getP_status() {
	return p_status;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @return java.util.Map
 */
public java.util.Map getUrl() {	
	return url;
	}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 15:07:25)
 * @return int
 */
public int getWorker() {
	return worker;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @param newJspriznak java.lang.String
 */
public void setJspriznak(java.lang.String newJspriznak) {
	jspriznak = newJspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 15:20:40)
 * @param newNameNri java.lang.String
 */
public void setNameNri(java.lang.String newNameNri) {
	nameNri = newNameNri;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:25:57)
 * @param newNamePlatinum java.lang.String
 */
public void setNamePlatinum(java.lang.String newNamePlatinum) {
	namePlatinum = newNamePlatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 10:45:56)
 * @param newOtvuserplatinum java.lang.String
 */
public void setOtvuserplatinum(java.lang.String newOtvuserplatinum) {
	otvuserplatinum = newOtvuserplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 18:21:45)
 * @param newP_status java.lang.String
 */
public void setP_status(java.lang.String newP_status) {
	p_status = newP_status;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @param newUrl java.util.Map
 */
public void setUrl(java.util.Map newUrl) {	
	url = newUrl;
	}
/**
 * Insert the method's description here.
 * Creation date: (04.01.2003 15:07:25)
 * @param newWorker int
 */
public void setWorker(int newWorker) {
	worker = newWorker;
}
}

package com.hps.july.arenda.valueobject;

import java.sql.Date;
import com.hps.july.web.util.*;
/**
 * Bean-Wrapper "Документов аренды".
 * Creation date: (23.05.2003 14:16:13)
 * @author: Sergey Gourov
 */
public class LeaseDocumentValueObject {
	private int leaseDocument;
	private java.lang.String value;
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:30:24)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:31:16)
 * @return java.lang.String
 */
public java.lang.String getValue() {
	return value;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:30:24)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:31:16)
 * @param newValue java.lang.String
 */
public void setValue(java.lang.String newValue) {
	value = newValue;
}
}

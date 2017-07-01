package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.arenda.sessionbean.*;
/**
 * bean-form
 * Лист истории оплат договоров.
 * Creation date: (04.11.2003 14:37:20)
 * @author: Dmitry Dneprov
 */
public class DogHistPayListForm extends com.hps.july.web.util.BrowseForm {
	private int idhistoryarenda;
/**
 * DogHistoryListForm constructor comment.
 */
public DogHistPayListForm() {
	super();
	setFinderMethodName("findByQBE");
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2003 14:37:20)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	
	return new Object[] {new Integer(getIdhistoryarenda()), new Integer(1)};
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 15:05:25)
 * @return int
 */
public int getIdhistoryarenda() {
	return idhistoryarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 15:05:25)
 * @param newIdhistoryarenda int
 */
public void setIdhistoryarenda(int newIdhistoryarenda) {
	idhistoryarenda = newIdhistoryarenda;
}
}

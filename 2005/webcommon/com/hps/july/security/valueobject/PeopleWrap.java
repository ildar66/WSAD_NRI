package com.hps.july.security.valueobject;

import com.hps.july.persistence.PeopleAccessBean;
import com.hps.july.security.formbean.*;
import java.util.*;

/**
 * Объект-значение для хранения физического лица.
 * Creation date: (01.04.2003 14:34:48)
 * @author: Alexander Makanin
 */
public class PeopleWrap {
	private com.hps.july.persistence.PeopleAccessBean ab;
	private String firstOperator;
	private int operatorToCopy;
/**
 * PeopleWrap constructor comment.
 */
public PeopleWrap() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:42:43)
 * @return com.hps.july.persistence.PeopleAccessBean
 */
public com.hps.july.persistence.PeopleAccessBean getAb() {
	return ab;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:43:07)
 * @return int
 */
public String getFirstOperator() {
	return firstOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 17:54:30)
 * @return int
 */
public int getOperatorToCopy() {
	return operatorToCopy;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:42:43)
 * @param newAb com.hps.july.persistence.PeopleAccessBean
 */
public void setAb(com.hps.july.persistence.PeopleAccessBean newAb) {
	ab = newAb;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:43:07)
 * @param newFirstOperator int
 */
public void setFirstOperator(String newFirstOperator) {
	firstOperator = newFirstOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 17:54:30)
 * @param newOperatorToCopy int
 */
public void setOperatorToCopy(int newOperatorToCopy) {
	operatorToCopy = newOperatorToCopy;
}
}

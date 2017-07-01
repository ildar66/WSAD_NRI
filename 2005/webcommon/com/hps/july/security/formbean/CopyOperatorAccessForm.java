package com.hps.july.security.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;

/**
 * Форма копирования оператора.
 * Creation date: (27.03.2003 9:34:33)
 * @author: Alexander Makanin
 */
public class CopyOperatorAccessForm extends EditForm {
    private int operator;
    private int operatorToCopy;
    private int man;
    private String fullName;
    private String firstOperator;
    /**
     * CopyOperatorAccessForm constructor comment.
     */
    public CopyOperatorAccessForm() {
        super();
        setAction("Add");
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 11:44:04)
     * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
     * @param request javax.servlet.http.HttpServletRequest
     */
    public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
        throws Exception {
        return null;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 11:44:04)
     * @return int
     */
    public int getApplication() {
        return com.hps.july.constants.Applications.SECURITY;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 11:44:04)
     */
    public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
        return null;
    }
    /**
     * Insert the method's description here.
     * Creation date: (01.04.2003 15:14:03)
     * @return java.lang.String
     */
    public java.lang.String getFirstOperator() {
        return firstOperator;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 12:18:04)
     * @return java.lang.String
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 12:06:34)
     * @return int
     */
    public int getMan() {
        return man;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 11:47:35)
     * @return int
     */
    public int getOperator() {
        return operator;
    }
    /**
    * Insert the method's description here.
    * Creation date: (18.06.2002 16:12:47)
    * @return java.util.Enumeration
    */
    public java.util.Enumeration getOperators() {
        try {
            OperatorAccessBean bean = new OperatorAccessBean();
            return bean.findOperatorsByMan(new PeopleKey(man));
        } catch (Exception e) {
            return (new java.util.Vector()).elements();
        }
    }
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 17:41:48)
 * @return int
 */
public int getOperatorToCopy() {
	return operatorToCopy;
}
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 11:44:04)
     * @return int
     */
    public int getState() {
        return com.hps.july.security.APPStates.ACCRIGHTCPY;
    }
    /**
     * Insert the method's description here.
     * Creation date: (01.04.2003 15:14:03)
     * @param newFirstOperator java.lang.String
     */
    public void setFirstOperator(java.lang.String newFirstOperator) {
        firstOperator = newFirstOperator;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 12:18:04)
     * @param newFullname java.lang.String
     */
    public void setFullName(String newFullName) {
        fullName = newFullName;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 12:06:34)
     * @param newMan int
     */
    public void setMan(int newMan) {
        man = newMan;
    }
    /**
     * Insert the method's description here.
     * Creation date: (31.03.2003 11:47:35)
     * @param newOperator int
     */
    public void setOperator(int newOperator) {
        operator = newOperator;
    }
/**
 * Insert the method's description here.
 * Creation date: (02.04.2003 17:41:48)
 * @param newOperatorToCopy int
 */
public void setOperatorToCopy(int newOperatorToCopy) {
	operatorToCopy = newOperatorToCopy;
}
}

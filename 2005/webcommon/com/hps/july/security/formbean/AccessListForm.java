package com.hps.july.security.formbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;

import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (08.12.2005 11:47:17)
 * @author: Shafigullin Ildar
 */
public class AccessListForm extends com.hps.july.web.util.BrowseForm {
    private Integer operator = null;
    private String orderBy = null;
    private java.lang.String operation = null;
    private int[] viewplan = new int[0];
    private int[] editplan = new int[0];
    private int[] viewfact = new int[0];
    private int[] editfact = new int[0];
    private int[] viewarenda = new int[0];
    private int[] editarenda = new int[0];
  	private java.util.List listAnoveAccessForOperator;
/**
 * AccessListForm constructor comment.
 */
public AccessListForm() {
    super();
    setOrderBy("regname");
    setOperation("");
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 16:05:39)
 * @return java.util.List
 */
private java.util.Collection createAccessList() {
    HashMap hashAccessList = new java.util.HashMap();
    RegionsAccess_VO vo = null;
    Integer regid = null;
    com.hps.july.commonbean.KeyGeneratorAccessBean gen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
    //Editfact:
    for (int i = 0; i < getEditfact().length; i++) {
        regid = new Integer(getEditfact()[i]);
        vo = (RegionsAccess_VO) hashAccessList.get(regid);
        if (vo != null) {
            vo.setEditfact("Y");
        } else {
            vo = new RegionsAccess_VO(getNextKey(gen), getOperator(), "R", null, regid, "N", "N", "N", "Y", "N", "N");
            hashAccessList.put(regid, vo);
        }
    }
    //Editplan:
    for (int i = 0; i < getEditplan().length; i++) {
        regid = new Integer(getEditplan()[i]);
        vo = (RegionsAccess_VO) hashAccessList.get(regid);
        if (vo != null) {
            vo.setEditplan("Y");
        } else {
            vo = new RegionsAccess_VO(getNextKey(gen), getOperator(), "R", null, regid, "N", "N", "Y", "N", "N", "N");
            hashAccessList.put(regid, vo);
        }
    }
    //Viewfact:
    for (int i = 0; i < getViewfact().length; i++) {
        regid = new Integer(getViewfact()[i]);
        vo = (RegionsAccess_VO) hashAccessList.get(regid);
        if (vo != null) {
            vo.setViewfact("Y");
        } else {
            vo = new RegionsAccess_VO(getNextKey(gen), getOperator(), "R", null, regid, "N", "Y", "N", "N", "N", "N");
            hashAccessList.put(regid, vo);
        }
    }
    //Viewplan:
    for (int i = 0; i < getViewplan().length; i++) {
        regid = new Integer(getViewplan()[i]);
        vo = (RegionsAccess_VO) hashAccessList.get(regid);
        if (vo != null) {
            vo.setViewplan("Y");
        } else {
            vo = new RegionsAccess_VO(getNextKey(gen), getOperator(), "R", null, regid, "Y", "N", "N", "N", "N", "N");
            hashAccessList.put(regid, vo);
        }
    }
    //Editarenda:
    for (int i = 0; i < getEditarenda().length; i++) {
        regid = new Integer(getEditarenda()[i]);
        vo = (RegionsAccess_VO) hashAccessList.get(regid);
        if (vo != null) {
            vo.setEditarenda("Y");
        } else {
            vo = new RegionsAccess_VO(getNextKey(gen), getOperator(), "R", null, regid, "N", "N", "N", "N", "N", "Y");
            hashAccessList.put(regid, vo);
        }
    }
    //Viewarenda:
    for (int i = 0; i < getViewarenda().length; i++) {
        regid = new Integer(getViewarenda()[i]);
        vo = (RegionsAccess_VO) hashAccessList.get(regid);
        if (vo != null) {
            vo.setViewarenda("Y");
        } else {
            vo = new RegionsAccess_VO(getNextKey(gen), getOperator(), "R", null, regid, "N", "N", "N", "N", "Y", "N");
            hashAccessList.put(regid, vo);
        }
    }
    return hashAccessList.values();
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
    return "com.hps.july.cdbc.objects.CDBC_RegionsAccess_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 20:08:41)
 * @return int[]
 */
private int[] getEditarenda() {
	return editarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @return int[]
 */
private int[] getEditfact() {
	return editfact;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @return int[]
 */
private int[] getEditplan() {
	return editplan;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (08.12.2005 11:47:17)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] { getOperator(), getOrderBy()};
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findAccessByOperator";
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2005 15:00:13)
 * @return java.util.List
 */
public java.util.List getListAnoveAccessForOperator() {
	return listAnoveAccessForOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2005 11:34:11)
 */
private Integer getNextKey(com.hps.july.commonbean.KeyGeneratorAccessBean gen) {
    Integer nextKey = null;
    try {
        nextKey = new Integer(gen.getNextKey("tables.regionsaccess"));
    } catch (Exception e) {
	    System.out.println("Ошибка генерация ключа tables.regionsaccess");
        e.printStackTrace();
    }
    return nextKey;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:00:38)
 * @return java.lang.String
 */
public java.lang.String getOperation() {
	return operation;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 12:52:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 12:52:49)
 * @return java.lang.String
 */
public java.lang.String getOrderBy() {
	return orderBy;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 20:08:21)
 * @return int[]
 */
private int[] getViewarenda() {
	return viewarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @return int[]
 */
private int[] getViewfact() {
	return viewfact;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @return int[]
 */
private int[] getViewplan() {
	return viewplan;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    operationTask();
    java.util.List list = com.hps.july.cdbc.objects.CDBC_RegionsAccess_Object.findListAnoveAccessForOperator(operator, getOrderBy());
    setListAnoveAccessForOperator(list);
    ParamsParser.setState(request, Applications.SECURITY, com.hps.july.security.APPStates.ACCESS_LIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:04:25)
 */
private void operationTask() {
    //System.out.println("operation=" + operation); //temp
    if("save".equals(getOperation())) {
    	//System.out.println("getEditfact().length=" + getEditfact().length + "; getEditfact()[1]=" + getEditfact()[1]); //temp	 
    	com.hps.july.cdbc.objects.CDBC_RegionsAccess_Object.deleteAccessByOperator(getOperator());
    	java.util.Collection accessColl = createAccessList();
    	//System.out.println("accessColl.toStr=" + accessColl.toString()); //temp
    	com.hps.july.cdbc.objects.CDBC_RegionsAccess_Object.addAccessByOperator(accessColl);
        setOperation("");
        resetMass();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 16:55:36)
 */
private void resetMass() {
    viewplan = new int[0];
    editplan = new int[0];
    viewfact = new int[0];
    editfact = new int[0];
    viewarenda = new int[0];
    editarenda = new int[0];
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 20:08:41)
 * @param newEditarenda int[]
 */
public void setEditarenda(int[] newEditarenda) {
	editarenda = newEditarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @param newEditfact int[]
 */
public void setEditfact(int[] newEditfact) {
	editfact = newEditfact;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @param newEditplan int[]
 */
public void setEditplan(int[] newEditplan) {
	editplan = newEditplan;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2005 15:00:13)
 * @param newListAnoveAccessForOperator java.util.List
 */
private void setListAnoveAccessForOperator(java.util.List newListAnoveAccessForOperator) {
	listAnoveAccessForOperator = newListAnoveAccessForOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:00:38)
 * @param newOperation java.lang.String
 */
public void setOperation(java.lang.String newOperation) {
	operation = newOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 12:52:49)
 * @param newOperator java.lang.Integer
 */
public void setOperator(java.lang.Integer newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 12:52:49)
 * @param newOrderBy java.lang.String
 */
public void setOrderBy(java.lang.String newOrderBy) {
	orderBy = newOrderBy;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 20:08:21)
 * @param newViewarenda int[]
 */
public void setViewarenda(int[] newViewarenda) {
	viewarenda = newViewarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @param newViewfact int[]
 */
public void setViewfact(int[] newViewfact) {
	viewfact = newViewfact;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2005 19:10:34)
 * @param newViewplan int[]
 */
public void setViewplan(int[] newViewplan) {
	viewplan = newViewplan;
}
}

package com.hps.july.basestation.formbean;

import java.sql.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.persistence.*;

/**
 * Форма журнала загрузки данных
 */
public class XlsJournalForm extends BrowseForm {
    private Boolean isRecendtime;
    private StringAndSqlDateProperty beginDate;
    private StringAndSqlDateProperty endDate;
    private Boolean isOperator;

    private Boolean isKeyfields;
    private Boolean isImpsesid;
    private String key_ses;

    private Integer order;

    private Enumeration people;
    private int operator;
    private Integer taskid;
public XlsJournalForm() {
    super();
    
    isRecendtime = new Boolean(false);
    java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
    beginDate = new StringAndSqlDateProperty();
    beginDate.setSqlDate(date);
    endDate = new StringAndSqlDateProperty();
    endDate.setSqlDate(date);
    
    isImpsesid = new Boolean(false);
    isKeyfields = new Boolean(false);
    key_ses = "";
    
    isOperator = new Boolean(true);
    people = null;
    operator = 0;
    
    order = new Integer(1);

    setFinderMethodName("findByQBE2");
}
public String getBegindatefrm(){
	return beginDate.getString();
}
public String getEnddatefrm(){
	return endDate.getString();
}
public java.lang.Object[] getFilterParams() {

	Boolean tempSesid;
	Integer sesid = null; 
	if(//Если все флажки сброшены, то устанавливаем key_ses в 0, чтобы поиск выполнился но ничего не нашлось
		isImpsesid.equals(Boolean.FALSE) &&
		isKeyfields.equals(Boolean.FALSE) &&
		isOperator.equals(Boolean.TRUE) &&
		isRecendtime.equals(Boolean.TRUE)
		)
	{
		//tempSesid = Boolean.TRUE;
		sesid = new Integer(0);
		tempSesid = isImpsesid;
	} else {
		tempSesid = isImpsesid;
		try{sesid = new Integer(key_ses);}catch(Exception e){sesid = new Integer(0);}
	} 
			
    return new Object[] {
	    revertBoolean(isRecendtime), 
	    	new Timestamp(beginDate.getSqlDate().getTime()),	new Timestamp(
		    	endDate.getSqlDate().getTime()+(1000*60*60*24)),
	    revertBoolean(isOperator),			new Integer(operator),
	    isKeyfields,						key_ses,
	    tempSesid,							sesid,
	    // Boolean isTaskId, Integer taskId
		(taskid != null)?Boolean.TRUE:Boolean.FALSE, (taskid != null)?taskid:new Integer(0),
	    order
        };    
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsImpsesid() {
	return isImpsesid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsKeyfields() {
	return isKeyfields;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsOperator() {
	return isOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsRecendtime() {
	return isRecendtime;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:22:23)
 * @return java.lang.String
 */
public java.lang.String getKey_ses() {
	return key_ses;
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 17:26:36)
 * @return int
 */
public int getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 17:15:47)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getPeople() {
	try{
    	people = new OperatorAccessBean().findOperatorsWithImportSessions();
    	return people;
    }catch(Exception e){
	    System.out.println("Error in XlsJournalForm.new PeopleAccessBean().findOperatorByImportSessionOrderByLastName();");
	    e.printStackTrace(System.out);
    }
    return null;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getTaskid() {
	return taskid;
}
private Boolean revertBoolean(Boolean value) {

	return value.equals(Boolean.FALSE) ? Boolean.TRUE : Boolean.FALSE;
}
public void setBegindatefrm(String beginFrm){
	beginDate.setString(beginFrm);
}
public void setEnddatefrm(String endFrm){
	endDate.setString(endFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @param newIsImpsesid java.lang.Boolean
 */
public void setIsImpsesid(java.lang.Boolean newIsImpsesid) {
	isImpsesid = newIsImpsesid;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @param newIsKeyfields java.lang.Boolean
 */
public void setIsKeyfields(java.lang.Boolean newIsKeyfields) {
	isKeyfields = newIsKeyfields;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @param newIsOperator java.lang.Boolean
 */
public void setIsOperator(java.lang.Boolean newIsOperator) {
	isOperator = newIsOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2003 17:07:09)
 * @param newIsRecendtime java.lang.Boolean
 */
public void setIsRecendtime(java.lang.Boolean newIsRecendtime) {
	isRecendtime = newIsRecendtime;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:22:23)
 * @param newKey_ses java.lang.String
 */
public void setKey_ses(java.lang.String newKey_ses) {
	key_ses = newKey_ses;
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 17:26:36)
 * @param newOperator int
 */
public void setOperator(int newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 17:15:47)
 * @param newPeople java.util.Enumeration
 */
public void setPeople(java.util.Enumeration newPeople) {
	people = newPeople;
}
/**
 * 
 * @param newTaskid java.lang.Integer
 */
public void setTaskid(java.lang.Integer newTaskid) {
	taskid = newTaskid;
}
}

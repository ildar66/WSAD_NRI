package com.hps.july.dataimport.dataobjects;

import java.sql.Timestamp;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.jdbcpersistence.lib.*;

/**
   * Запись в лог записи базовой станции
*/

public class BsRecordLogger {
 private BlockData blockData;   
	private Integer impsesid;
    private String keyFields="?";
    
    private String result;
    private String errorLabel="message.empty";
    private String param1;
    private String param2;
    private String param3;
    private Timestamp recendtime;
    private AbstractImportObject obj;

    public final static String RESULT_S="S";
    public final static String RESULT_E="E";
    public final static String ACTION_I="I";
    public final static String ACTION_U="U";

    private String action=ACTION_I;
    

    private ImportRecordAccessBean bean;


public BsRecordLogger() {
	super();
	bean=new ImportRecordAccessBean();
}
public BsRecordLogger(BlockData data) {
	super();
	bean=new ImportRecordAccessBean();
	blockData=data;
	this.impsesid=data.getSessid();
}
public BsRecordLogger(BlockData data,String keyFields) {
	this(data);
	this.keyFields=keyFields;
}
public BsRecordLogger(BlockData data, String keyFields, String action) {
    this(data, keyFields);

    this.action = action;
    
}
public void commit() throws Exception {

    bean =
        new ImportRecordAccessBean(
            new KeyGeneratorAccessBean().getNextKey(TablesRef.IMPORTRECORDS),
            impsesid.intValue(),
    /*int argImpSesid,*/ recendtime,
    /*java.sql.Timestamp argRecendtime,*/ action,
    /*String argAction,*/ result,
    /*String argResult,*/ errorLabel
    /*String argErrlabel*/);

    bean.setKeyfields(keyFields);
    bean.setParam1(param1);
    bean.setParam2(param2);
    bean.setParam3(param3);
    bean.setResult(result);
    /*
    DebugSupport.printlnTest(
        "BsRecordLogger before commit param1=" + param1 + " param2=" + param2);
    */
    bean.commitCopyHelper();

    DebugSupport.printlnTest(
        "BsRecordLogger write message label="
            + errorLabel
            + " keyFields="
            + keyFields
            + " param1="
            + param1
            + " param2="
            + param2
            + " param3="
            + param3);

    return;
}
public java.lang.String getAction() throws Exception  {
    return bean.getIaction();
}
public java.lang.String getErrorLabel() throws Exception   {
	return bean.getErrlabel();
}
public java.lang.Integer getImpsesid() throws Exception  {
    return new Integer(bean.getImportsessionKey().impsesid);
}
public java.lang.String getKeyFields() throws Exception  {
	return bean.getKeyfields();
}
public String getParam1() throws Exception  {
    return bean.getParam1();
}
public String getParam2() throws Exception  {
    return bean.getParam2();
}
public String getParam3() throws Exception  {
    return bean.getParam3();
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:49:09)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getRecendtime() throws Exception  {
	return bean.getRecendtime();
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:49:09)
 * @return java.lang.String
 */
public java.lang.String getResult() throws Exception {
	return bean.getResult();
}
public void setAction(java.lang.String newAction) {
    action = newAction;
}
public void setErrorLabel(java.lang.String newErrorLabel) {
	errorLabel = newErrorLabel;
}
public void setImpsesid(java.lang.Integer newImpsesid) {
    impsesid = newImpsesid;
}
public void setKeyFields(java.lang.String newKeyFields) {
    keyFields = newKeyFields;
}
public void setParam1(java.lang.String newParam1) {
    param1 = newParam1;
}
public void setParam2(java.lang.String newParam2) {
    param2 = newParam2;
}
public void setParam3(java.lang.String newParam3) {
    param3 = newParam3;
}
public void setRecendtime(java.sql.Timestamp newRecendtime) {
    recendtime = newRecendtime;
}
public void setResult(String newResult) {
    result = newResult;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 18:39:25)
 */
public void writeError(String errLabel) {
    blockData.incErrcount();
    try {
        //setImpsesid(sessid);
        //setAction(action);
        //setKeyFields(key);
        setErrorLabel(errLabel);
        setResult(RESULT_E);
        setRecendtime(new Timestamp(System.currentTimeMillis()));

        commit();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 18:39:25)
 */
public void writeError(
    
    String errLabel,
    String par1) {
blockData.incErrcount();
    try {
        //setImpsesid(sessid);
        //setAction(action);
        //setKeyFields(key);
        setErrorLabel(errLabel);
        setResult(RESULT_E);
        setRecendtime(new Timestamp(System.currentTimeMillis()));
        setParam1(par1);

        commit();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 18:39:25)
 */
public void writeError(String errLabel, String par1, String par2) {
    blockData.incErrcount();
    try {

         //DebugSupport.printlnTest("label=" + errLabel + " par1=" + par1 + " par2=" + par2);
        //setImpsesid(sessid);
        //setAction(action);
        //setKeyFields(key);
        setErrorLabel(errLabel);
        setResult(RESULT_E);
        setRecendtime(new Timestamp(System.currentTimeMillis()));
        setParam1(par1);
        setParam2(par2);

        commit();
        /*
        DebugSupport.printlnTest(
            "after create label="
                + getErrorLabel()
                + " par1="
                + getParam1()
                + " par2="
                + getParam2());
*/
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 18:39:25)
 */
public void writeError(
    
    String errLabel,
    String par1,String par2,String par3) {
blockData.incErrcount();
    try {
        //setImpsesid(sessid);
        //setAction(action);
        //setKeyFields(key);
        setErrorLabel(errLabel);
        setResult(RESULT_E);
        setRecendtime(new Timestamp(System.currentTimeMillis()));
        setParam1(par1);
        setParam1(par2);
        setParam1(par3);

        commit();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 18:39:25)
 */
public void writeSuccess() {

    try {
        
        setResult(RESULT_S);
        setRecendtime(new Timestamp(System.currentTimeMillis()));
        commit();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }

}
}

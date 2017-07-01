package com.hps.july.dataimport.dataobjects;

import java.sql.Timestamp;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.jdbcpersistence.lib.*;

/**
   * Запись в лог результата импорта базовых станций
*/
public class BsSessionLogger {
	private Integer sessionId;
    private Integer importtaskid;
    private Integer operatorid;
    private String filename;
    private Integer filesize;
    private Timestamp filetime;
    private Timestamp importstart;
    private Timestamp importend;
    private Integer reccount;
    private Integer errcount;

	private Integer id= new Integer(2003);
	private ImportSessionAccessBean bean;
	
public BsSessionLogger() throws Exception {
    super();
    
    

}
public void commit() throws Exception {

    

    bean.setErrcount(errcount.intValue());
    bean.setReccount(reccount.intValue());
    bean.setImportend(importend);
    bean.setFiletime(filetime);

    bean.commitCopyHelper();
}
private void create() throws Exception {
    try {
        sessionId =
            new Integer(new KeyGeneratorAccessBean().getNextKey(TablesRef.IMPORTSESSIONS));

        bean = new ImportSessionAccessBean(
        /*int argImpsesid,*/ sessionId.intValue(),
        /*int argImpTaskid,*/ this.importtaskid.intValue(),
        /*java.sql.Timestamp argImportStart,*/ importstart == null
        ? new java.sql.Timestamp(0)
        : importstart,
        /*java.sql.Timestamp argImportEnd,*/ importend == null
        ? new java.sql.Timestamp(0)
        : importend,
        /*int argOperator,*/ operatorid.intValue(),
        /*String argFilename,*/ filename,
        /*int argFilesize,*/ filesize.intValue(),
        /*int argReccount,*/ reccount == null ? 0 : reccount.intValue(),
        /*int argErrcount*/ errcount == null ? 0 : errcount.intValue());
    } catch (Exception e) {
	    e.printStackTrace();
        throw e;
    }
}
public java.lang.Integer getErrcount() throws Exception {
	return new Integer(bean.getErrcount());
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @return java.lang.String
 */
public java.lang.String getFilename() throws Exception  {
	return bean.getFilename();
}
public Integer getFilesize() throws Exception  {
    return new Integer(bean.getFilesize());
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getFiletime()  throws Exception {
	return bean.getFiletime();
}
public java.lang.Integer getId() throws Exception  {
    return new Integer(bean.getImpsesid());
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getImportend() throws Exception  {
	return bean.getImportend();
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getImportstart() throws Exception  {
	return bean.getImportstart();
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 20:20:52)
 * @return java.lang.Integer
 */
public java.lang.Integer getImporttaskid() throws Exception  {
	return new Integer(bean.getImporttaskKey().imptaskid);
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperatorid() throws Exception  {
	return new Integer(bean.getOperatorKey().operator);
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getReccount() throws Exception  {
	return reccount;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 12:49:29)
 * @return java.lang.Integer
 */
public java.lang.Integer getSessionId() {
	return sessionId;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @param newErrcount java.lang.Integer
 */
public void setErrcount(java.lang.Integer newErrcount)  {
	errcount = newErrcount;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @param newFilename java.lang.String
 */
public void setFilename(java.lang.String newFilename) {
	filename = newFilename;
}
public void setFilesize(Integer newFilesize) {
    filesize = newFilesize;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @param newFiletime java.sql.Timestamp
 */
public void setFiletime(java.sql.Timestamp newFiletime) {
	filetime = newFiletime;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:36:59)
 * @param newId java.lang.Integer
 */
public void setId(java.lang.Integer newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @param newImportend java.sql.Timestamp
 */
public void setImportend(java.sql.Timestamp newImportend) {
	importend = newImportend;
}
public void setImportstart(java.sql.Timestamp newImportstart) {
    importstart = newImportstart;
}
public void setImporttaskid(java.lang.Integer newImporttaskid) throws Exception {
    importtaskid = newImporttaskid;

    create();

}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 14:16:04)
 * @param newOperatorid java.lang.Integer
 */
public void setOperatorid(java.lang.Integer newOperatorid) {
	operatorid = newOperatorid;
}
public void setReccount(java.lang.Integer newReccount) {
	reccount = newReccount;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 12:49:29)
 * @param newSessionId java.lang.Integer
 */
public void setSessionId(java.lang.Integer newSessionId) {
	sessionId = newSessionId;
}
}

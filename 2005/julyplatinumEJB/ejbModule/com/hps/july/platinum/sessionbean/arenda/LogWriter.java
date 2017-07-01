package com.hps.july.platinum.sessionbean.arenda;

/**
 * Insert the type's description here.
 * Creation date: (17.01.2003 11:25:44)
 * @author: Alexander Shrago
 */
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
//import org.apache.struts.util.*;
import java.util.*;
public class LogWriter {
    private KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    private Vector messages = new Vector();
private PIEQueryAccessBean query;
/**
 * LogWriter constructor comment.
 */
public LogWriter() {
    super();
    
}
/**
 * LogWriter constructor comment.
 */
public LogWriter(int idQuery) throws Exception {
    super();
    query = new PIEQueryAccessBean();
    query.setInitKey_idquery(idQuery);
    query.refreshCopyHelper();
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:40:00)
 * @param mes com.hps.july.platinum.sessionbean.arenda.LogMessage
 */
public void addMessage(LogMessage mes) {
    messages.add(mes);
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 14:59:51)
 * @return java.util.Vector
 */
public java.util.Vector getMessages() {
	return messages;
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:42:05)
 */
public void log() throws Exception {
    LogMessage mes = null;
    Enumeration enum = messages.elements();
    while (enum.hasMoreElements()) {
        mes = (LogMessage) enum.nextElement();
        log(mes);

    }
}
public void log(LogMessage message) throws Exception {

    if (message.template.getQueryStatus() != null) {
	     query.refreshCopyHelper();
	    Integer obj=query.getIdobjnriint();
	    query.setIdobjnriint(obj);
        query.setStatus(message.template.getQueryStatus());
        query.commitCopyHelper();
    }

    if (!message.template.isActive())
        return;

    Object[] args = message.getArgs();

    PIEQueryLogAccessBean log =
        new PIEQueryLogAccessBean(
            keygen.getNextKey(TablesRef.PIE_QUERY_LOG),
            query.getIdquery(),
            message.template.getType(),
            message.template.getCode(),
            message.getMessage(),
            new java.sql.Timestamp(System.currentTimeMillis()));
    log.commitCopyHelper();

    if (args != null) {
        if (args[0] instanceof Integer)
            log.setInt1((Integer) args[0]);
        else
            if (args[0] instanceof java.sql.Date)
                log.setDate1((java.sql.Date) args[0]);
            else
                if (args[0] instanceof java.math.BigDecimal)
                    log.setDec1((java.math.BigDecimal) args[0]);

        if (args.length > 1) {
            if (args[1] instanceof Integer)
                log.setInt2((Integer) args[1]);
            else
                if (args[1] instanceof java.sql.Date)
                    log.setDate2((java.sql.Date) args[1]);
                else
                    if (args[1] instanceof java.math.BigDecimal)
                        log.setDec2((java.math.BigDecimal) args[1]);
        }
        if (args.length > 2) {
            if (args[2] instanceof Integer)
                log.setInt3((Integer) args[2]);
            else
                if (args[2] instanceof java.sql.Date)
                    log.setDate3((java.sql.Date) args[2]);
                else
                    if (args[2] instanceof java.math.BigDecimal)
                        log.setDec3((java.math.BigDecimal) args[2]);
        }

        log.commitCopyHelper();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:26)
 * @param newIdQuery int
 */
public void setIdQuery(int idQuery) throws Exception{
    query = new PIEQueryAccessBean();
    query.setInitKey_idquery(idQuery);
    query.refreshCopyHelper();
}
}

package com.hps.july.inventory.actionbean;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;

/**
 * Общий обработчик форм документов.
 */
public class NIProcessAction
	extends AbstractProcessAction
{
public void deleteDocument(Integer docId, ActionErrors errors)
	throws UpdateValidationException
{
	try {
		JdbcConnection jdbc = new JdbcConnection();
		Connection c = jdbc.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			cs = c.prepareCall("EXECUTE PROCEDURE DELETEDOCUMENT(?)");
			cs.setInt(1,docId.intValue());
			boolean b = cs.execute();
			rs = cs.getResultSet();
			if(rs.next()) {
				int errorcode = rs.getInt(1); // Error code
				int edpos = rs.getInt(2); // ErrorDocumentPosition
				int cdc = rs.getInt(3); // ConflictDocumentCode
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.document.delete."+errorcode,new Integer(edpos),new Integer(cdc)));
//System.out.println("ERR:"+errorcode+", EDP:"+edpos+", CDC:"+cdc);
			} else {
//System.out.println("SUCCESS DELETE CALL for DocumentId:"+docId);
			}
		} finally {
			if(rs != null) { rs.close(); }
			if(cs != null) { cs.close(); }
			if(c != null) { c.close(); }
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.document.delete");
	}
}
public ActionForward processDelete(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
	throws java.lang.Exception
{
	if(com.hps.july.util.AppUtils.getInventoryVariant() == 2 && editForm instanceof DocumentForm) {
		DocumentForm df = (DocumentForm)editForm;
		deleteDocument(df.getDocumentId(),errors);
		return null;
	} else {
		return super.processDelete(mapping,request,errors,editForm);
	}
}
}

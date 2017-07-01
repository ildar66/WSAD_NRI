package com.hps.july.cdbc.objects;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import com.hps.july.cdbc.lib.*;

/**
 * Класс для работы с ошибками обсчета документа.
 * Creation date: (24.09.2004 17:54:39)
 * @author: Dmitry Dneprov
 */
public class CDBCInventoryDocumentError {
/**
 * CDBCInventoryDocumentError constructor comment.
 */
public CDBCInventoryDocumentError() {
	super();
}
	/**
	 * Возвращает список ошибок, возникших при обсчете документа.
	 * @TODO: Написать описание параметров
	 */
	public boolean addDocumentError(Integer argDocument, Integer argDocposition, Integer argErrorLevel, String argErrorText) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("INSERT INTO  documenterrors (document, docposition, errorlevel, errortext) ");
		sqlb.append("VALUES (?, ?, ?, ?) ");
		params.add(argDocument);
		params.add(argDocposition);
		params.add(argErrorLevel);
		params.add(argErrorText);
//System.out.println("AddError:["+argDocument+","+argDocposition+","+argErrorLevel+","+argErrorText+"]");
		CDBCResultSet res = new CDBCResultSet();
		return res.executeUpdate(sqlb.toString(), params.toArray());
	}
	
	/**
	 * Возвращает список ошибок, возникших при обсчете документа.
	 */
	public boolean addDocumentError(Integer argDocument, Integer argDocposition, String argErrorText ) {
		return addDocumentError(argDocument, argDocposition, new Integer(1), argErrorText);
	}
	/**
	 * Очищает список ошибок, возникших при обсчете документа.
	 */
	public boolean clearDocumentErrors(Integer argDocument) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("DELETE FROM documenterrors ");
		sqlb.append("WHERE document = ? ");
		if(argDocument != null) {
			params.add(argDocument);
		} else {
			params.add(new Integer(0));
		}

		CDBCResultSet res = new CDBCResultSet();
		return res.executeUpdate(sqlb.toString(), params.toArray());
	}
/**
 * Возвращает состояние документа
 */
public String getDocumentState(Integer argDocument)
{
	if(argDocument == null) {
		return null;
	}
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT state FROM documents WHERE document = ?");
	params.add(argDocument);

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("state").asString();
	} else {
		return null;
	}
}
	/**
	 * Возвращает список ошибок, возникших при обсчете документа.
	 */
	public CDBCResultSet listDocumentErrors(
		Integer argDocument
		)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT errorid, docposition, errortext, errorlevel ");
		sqlb.append("FROM documenterrors ");
		sqlb.append("WHERE document = ? ");
		sqlb.append("ORDER BY docposition ASC, errorlevel DESC, errorid ASC");
		params.add(argDocument);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
}

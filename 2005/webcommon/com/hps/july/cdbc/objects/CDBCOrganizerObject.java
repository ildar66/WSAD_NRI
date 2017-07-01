package com.hps.july.cdbc.objects;

import java.util.ListIterator;
import java.util.LinkedList;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.util.ResponseUtils;

/**
 * Объект для работы с задачами, операторами, ролями.
 */
public class CDBCOrganizerObject {
public CDBCOrganizerObject() {
	super();
}
public CDBCResultSet findOperatorTasks(String argLogin)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE t.* ");
	sqlb.append("FROM tasks t, roles2tasks r2t, operators2roles o2r, operators o, people p ");
	sqlb.append("WHERE o.loiginid = ? AND o2r.operator = o.operator AND o.isenabled = 'Y' AND ");
	sqlb.append("r2t.role = o2r.role AND t.task = r2t.task AND p.man = o.man AND p.isactive = 'Y' ");
	sqlb.append("ORDER BY t.task ");
	params.add(argLogin);
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
}

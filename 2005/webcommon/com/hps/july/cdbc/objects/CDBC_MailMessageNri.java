/*
 * Created on 26.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.MailRecipient_VO;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_MailMessageNri {
	private static final String getRecipients_SQL = "SELECT UNIQUE w.man, email, trim(lastname)||' '||trim(firstname)||' '||trim(middlename) name FROM workers w, operators o, people p WHERE w.man = o.man AND o.man = p.man AND w.isactive = 'Y' AND email IS NOT NULL";
	public final static java.util.List findListMailRecipients(Boolean isLastTime, Timestamp lastTime, String orderBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(getRecipients_SQL);
		//calculate where clause:
		if (isLastTime.booleanValue()) {
			sb.append(" AND lastLoginTime > ? ");
			params.add(lastTime);
		}

		//append order by clause:
		if (orderBy != null)
			sb.append(" order by " + orderBy);
		System.out.println(sb.toString()); //temp
		res.executeQuery(sb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Integer man = (Integer)ro.getColumn("man").asObject();
			String email = ro.getColumn("email").asString();
			String name = ro.getColumn("name").asString();
			MailRecipient_VO vo = new MailRecipient_VO(man, name, email);
			ret.add(vo);
		}
		return ret;
	}
	
}

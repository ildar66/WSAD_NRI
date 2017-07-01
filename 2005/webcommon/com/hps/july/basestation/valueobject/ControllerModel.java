package com.hps.july.basestation.valueobject;

import java.util.*;
import java.sql.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Модель контроллера
 */
public class ControllerModel {
	private static final String QUERY_START =
		"SELECT c.equipment contrcode, c.number contrnumber, c.name contrname, NVL('D'  || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) contrposname, p.posstate posstate, "+
		"c.switch swcode, sw.number swnumber, TRIM(swsp.name) swname, NVL('D'  || swp.gsmid || ' ','') ||  NVL('A' || swp.dampsid || ' ','') || TRIM(swpsp.name) swposname "+
		"FROM controllers c, equipment e, positions p, storageplaces sp, outer (switches sw, equipment swe, storageplaces swsp, positions swp, storageplaces swpsp) "+
		"WHERE c.equipment = e.equipment AND e.position = p.storageplace AND p.storageplace = sp.storageplace "+
		"AND c.switch = sw.equipment AND swe.equipment = sw.equipment AND sw.equipment = swsp.storageplace AND swe.position = swp.storageplace AND swp.storageplace = swpsp.storageplace ";

	private Integer key;
	private String name;
public ControllerModel() {
	super();
}
public static Vector find(Boolean useNumber, Integer number, String order)
    throws java.lang.Exception
{
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection con = null;

    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer(QUERY_START);

    if(useNumber != null && useNumber.booleanValue() && number != null) {
	   sb.append(" AND c.number = ");
	   sb.append(number);
	   sb.append(" ");
    }
    
    //append order by clause
    String orderBy = null;
	if(order != null && !"".equals(order.trim())) {
	    sb.append("ORDER BY ");
	    sb.append(order);
    }

	System.out.println("SQL:\n" + sb + "\n");

	Vector result = new Vector();
    JdbcConnection jcon = new JdbcConnection();
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    ps = con.prepareStatement(sb.toString());

	    int j = 1;
/*
	    if(addSearchBy) {
		    ps.setString(j++, searchstring);
	    }
*/
	    rs = ps.executeQuery();
	    while (rs.next()) {
			ControllerLookupObject clo = new ControllerLookupObject(rs);
		    result.add(clo);
	    }
	} catch (Exception e) {
		e.printStackTrace(System.out);
	} finally {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			ps.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
	    }
	    try {
		    con.close();
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
    }
    return result;
}
public ControllerAccessBean getAccessBean() {
	if(key == null) {
		return null;
	} else {
		try {
			ControllerAccessBean p = new ControllerAccessBean();
			p.setInitKey_storageplace(key.intValue());
			p.refreshCopyHelper();
			return p;
		} catch(Exception e) {
			return null;
		}
	}
}
public static ControllerAccessBean getById(int id) {
	try {
		ControllerAccessBean byId = new ControllerAccessBean();
		byId.setInitKey_storageplace(id);
		byId.refreshCopyHelper();
		return byId;
	} catch(Exception e) {
		System.out.println("CONTROLLER BY ID:"+id+" not found");
		return null;
	}
}
/**
 * find first ocured Controller by Number and planstate
 * @TODO: realize planstate filter
 */
public static ControllerAccessBean getByNumber(Integer number) {
	ControllerAccessBean byNumber = null;
	try {
		Vector v = find(Boolean.TRUE, (number == null)?new Integer(0):number, null);
		if(v.size() > 0) {
			ControllerLookupObject clo = (ControllerLookupObject)v.get(0);
			byNumber = new ControllerAccessBean();
			byNumber.setInitKey_storageplace(clo.getContrcode());
			byNumber.refreshCopyHelper();
		}
	} catch(Exception e) {
		// no switch with this id
		// oops occured
	}
	return byNumber;
}
public static ControllerAccessBean getFromIdAndNumber(int id, Integer number)
	throws Exception
{
	ControllerAccessBean res = null;
	ControllerAccessBean contrById = ControllerModel.getById(id);
	ControllerAccessBean contrByNumber = ControllerModel.getByNumber(number);
	if(number == null) {
		return res;
	}
	if(contrById != null) {
		if(contrByNumber != null) {
			if(contrById.getNumber() == contrByNumber.getNumber()) {
				res = contrById;
			} else {
				res = contrByNumber;
			}
		} else {
			res = contrById;
		}
	} else {
		if(contrByNumber != null) {
			res = contrByNumber;
		} else {
			// res = null; // Null yet
		}
	}
	return res;
}
public java.lang.Integer getKey() {
	return key;
}
public java.lang.String getName() {
	return name;
}
public void refresh() {
	ControllerAccessBean b = getAccessBean();
	if(b == null) {
		name = "";
	} else {
		try {
			name = b.getName();
		} catch(javax.naming.NamingException ne) {
		} catch(javax.ejb.ObjectNotFoundException onfe) {
		} catch(java.rmi.RemoteException re) {
		} catch(javax.ejb.CreateException ce) {
		} catch(javax.ejb.FinderException fe) {
		}
	}
}
public void setKey(java.lang.Integer newKey) {
	key = newKey;
}
protected void setName(java.lang.String newName) {
	name = newName;
}
}

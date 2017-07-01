package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
 * JDBC - Объект для работы с "Комментарии юристов".
* Creation date: (22.07.2005 20:25:05)
* @author: Shafigullin Ildar
*/
public class CDBC_LawyearNote_Object {
    private static final String findLawyearNote_byPosition_SQL =
        "SELECT id, number, idPosition, idContract, note, created, createdBy, getNamePeople(createdBy) createdName, modified, modifiedBy, getNamePeople(modifiedBy) modifiedName "
            + "FROM lawyearNoteOnPosition "
            + "WHERE idPosition=? ";
    private static final String findLawyearNote_SQL =
        "SELECT id, number, idPosition, idContract, note, created, createdBy, getNamePeople(createdBy) createdName, modified, modifiedBy, getNamePeople(modifiedBy) modifiedName "
            + "FROM lawyearNoteOnPosition ";
    private final static java.lang.String addLawyearNote_SQL =
        "INSERT INTO lawyearNoteOnPosition(id, number, idPosition, idContract, note, created, createdBy, modified, modifiedBy) "
            + "VALUES (?,?,?,?,?,?,?,?,?) ";
    private final static java.lang.String editLawyearNote_SQL =
        "UPDATE lawyearNoteOnPosition SET number=?, idPosition=?, idContract=?, note=?, created=?, createdBy=?, modified=?, modifiedBy=? "
            + "WHERE id = ?";
    private final static java.lang.String deleteLawyearNote_SQL = "DELETE FROM lawyearNoteOnPosition WHERE id = ?";
    private static final String findCountLawyearNote_byPosition_SQL =
        "SELECT max(number) num FROM lawyearNoteOnPosition WHERE idPosition=? ";
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 10:46:40)
 * @param LawyearNote com.hps.july.arenda.valueobject.LawyearNoteOnPosition_VO 
 */
public static boolean addLawyearNote(LawyearNoteOnPosition_VO vo) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(addLawyearNote_SQL);
        //обязательные поля(not null):
        st.setInt(1, vo.getId().intValue());
        st.setInt(2, vo.getNumber().intValue());
        st.setInt(3, vo.getIdPosition().intValue());
        //необязательные поля(null):
        if (vo.getIdContract() != null)
            st.setInt(4, vo.getIdContract().intValue());
        else
            st.setObject(4, null);
        st.setString(5, vo.getNote());
        st.setTimestamp(6, vo.getCreated());
        if (vo.getCreatedBy() != null)
            st.setInt(7, vo.getCreatedBy().intValue());
        else
            st.setObject(7, null);
        st.setTimestamp(8, vo.getModified());
        if (vo.getModifiedBy() != null)
            st.setInt(9, vo.getModifiedBy().intValue());
        else
            st.setObject(9, null);

        if (st.executeUpdate() != 1) {
            System.out.println("Insert LawyearNote:Id=" + vo.getId() + " failed");
            return false;
        }
        return true;
    } catch (SQLException e) {
        System.out.println("SQLException: CODE=" + e.getErrorCode());
        e.printStackTrace(System.out);
        return false;
    } finally {
        try {
            if (st != null)
                st.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 11:57:29)
 */
public static boolean deleteLawyearNote(int aID) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(deleteLawyearNote_SQL);
		st.setInt(1, aID);

		if (st.executeUpdate() != 1) {
			System.out.println("Delete LawyearNote:Id=" + aID+ " failed");
			return false;
		}
		return true;
	} catch (SQLException e) {
		System.out.println("SQLException: CODE=" + e.getErrorCode());
		e.printStackTrace(System.out);
		return false;
	} finally {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 10:46:40)
 * @param LawyearNote com.hps.july.arenda.valueobject.LawyearNoteOnPosition_VO 
 */
public static boolean editLawyearNote(LawyearNoteOnPosition_VO vo) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(editLawyearNote_SQL);
        //обязательные поля(not null):
        st.setInt(1, vo.getNumber().intValue());
        st.setInt(2, vo.getIdPosition().intValue());
        //необязательные поля(null):
        if (vo.getIdContract() != null)
            st.setInt(3, vo.getIdContract().intValue());
        else
            st.setObject(3, null);
        st.setString(4, vo.getNote());
        st.setTimestamp(5, vo.getCreated());
        if (vo.getCreatedBy() != null)
            st.setInt(6, vo.getCreatedBy().intValue());
        else
            st.setObject(6, null);
        st.setTimestamp(7, vo.getModified());
        if (vo.getModifiedBy() != null)
            st.setInt(8, vo.getModifiedBy().intValue());
        else
            st.setObject(8, null);
        //входной параметр:
        st.setInt(9, vo.getId().intValue());

        if (st.executeUpdate() != 1) {
            System.out.println("Update LawyearNote:Id=" + vo.getId() + " failed");
            return false;
        }
        return true;
    } catch (SQLException e) {
        System.out.println("SQLException: CODE=" + e.getErrorCode());
        e.printStackTrace(System.out);
        return false;
    } finally {
        try {
            if (st != null)
                st.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
/**
 * findCountLawyearNote_byPosition
 * Creation date: (25.07.2005 12:27:54)
 */
public static Integer findCountLawyearNote_byPosition(int position) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    //add generic query string: 
    sqlb.append(findCountLawyearNote_byPosition_SQL);
    //executeQuery:
    res.executeQuery(sqlb.toString(), new Object[] { new Integer(position)});
    Integer count = null;
    ListIterator iter = res.listIterator();
    if (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        count = (Integer) ro.getColumn("num").asObject();
        if (count == null)
            count = new Integer(0);
    }
    return count;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 13:57:38)
 */
public static CDBCRowObject findLawyearNote(int aID) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findLawyearNote_SQL + "WHERE id = " + aID;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Возвращает список Комментарии юристов.
 * Creation date: (27.05.2004 12:17:32)
 */
public static CDBCResultSet findLawyearNote_byPosition(Integer position, String aSortBy) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    //add generic query string: 
    sqlb.append(findLawyearNote_byPosition_SQL);
    //append order by clause:
    if (aSortBy != null)
        sqlb.append(" order by " + aSortBy);

    //executeQuery:
    res.executeQuery(sqlb.toString(), new Object[] { position });

    return res;
}
}

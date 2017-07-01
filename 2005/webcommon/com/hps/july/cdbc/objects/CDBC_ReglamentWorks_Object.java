package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
 * JDBC - Объект для работы с "Регламент работ".
* Creation date: (22.07.2005 20:25:05)
* @author: Shafigullin Ildar
*/
public class CDBC_ReglamentWorks_Object {
    private static final String findReglamentWork_SQL =
        "SELECT idWork, equipment, man, dateWork, typeWork, noteWork, created, createdBy, getNamePeople(createdBy) createdName, modified, modifiedBy, getNamePeople(modifiedBy) modifiedName, getNamePeople(man) manName "
            + "FROM ReglamentWorks ";
    private final static java.lang.String addReglamentWork_SQL =
        "INSERT INTO ReglamentWorks(idWork, equipment, man, dateWork, typeWork, noteWork, created, createdBy, modified, modifiedBy) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?) ";
    private final static java.lang.String editReglamentWork_SQL =
        "UPDATE ReglamentWorks SET equipment=?, man=?, dateWork=?, typeWork=?, noteWork=?, created=?, createdBy=?, modified=?, modifiedBy=? "
            + "WHERE idWork = ? ";
    private final static java.lang.String deleteReglamentWork_SQL = "DELETE FROM ReglamentWorks WHERE idWork = ? ";
    private static final String findListEquipNameFromPosition_SQL =
        "SELECT eq.equipment, getFullStorageName(eq.equipment,1) storageName FROM equipment eq, storageplaces stp WHERE eq.equipment = stp.storageplace AND position = ? ";
    private static final String findListReglamentWorkTypes_SQL = "SELECT idtype, nametype  FROM ReglamentWorkTypes ";
    private final static java.lang.String addReglamentWorkType_SQL =
        "INSERT INTO ReglamentWorkTypes(idtype, nametype) " + "VALUES (?,?) ";
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 10:46:40)
 * @param vo com.hps.july.arenda.valueobject.ReglamentWorks_VO
 */
public static boolean addReglamentWork(ReglamentWorks_VO vo) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(addReglamentWork_SQL);
        //обязательные поля(not null):
        st.setInt(1, vo.getIdWork().intValue());
        st.setInt(2, vo.getEquipment().intValue());
        st.setInt(3, vo.getMan().intValue());
        st.setDate(4, vo.getDateWork());
        //необязательные поля(null):
        if (vo.getTypeWork() != null)
            st.setInt(5, vo.getTypeWork().intValue());
        else
            st.setObject(5, null);
        st.setString(6, vo.getNoteWork());
        st.setTimestamp(7, vo.getCreated());
        if (vo.getCreatedBy() != null)
            st.setInt(8, vo.getCreatedBy().intValue());
        else
            st.setObject(8, null);
        st.setTimestamp(9, vo.getModified());
        if (vo.getModifiedBy() != null)
            st.setInt(10, vo.getModifiedBy().intValue());
        else
            st.setObject(10, null);

        if (st.executeUpdate() != 1) {
            System.out.println("Insert ReglamentWork:idWork=" + vo.getIdWork() + " failed");
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
 * Creation date: (12.08.2005 15:28:10)
 * @param vo com.hps.july.basestation.valueobject.ReglamentWorkType_VO
 */
public static boolean addReglamentWorkType(ReglamentWorkType_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(vo.getIdtype()), vo.getNametype()};
    return res.executeUpdate(addReglamentWorkType_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 11:57:29)
 */
public static boolean deleteReglamentWork(int aID) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(deleteReglamentWork_SQL);
		st.setInt(1, aID);

		if (st.executeUpdate() != 1) {
			System.out.println("Delete ReglamentWork:Id=" + aID+ " failed");
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
 * @param vo com.hps.july.arenda.valueobject.ReglamentWorks_VO 
 */
public static boolean editReglamentWork(ReglamentWorks_VO vo) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(editReglamentWork_SQL);
        //обязательные поля(not null):
        st.setInt(1, vo.getEquipment().intValue());
        st.setInt(2, vo.getMan().intValue());
        st.setDate(3, vo.getDateWork());
        //необязательные поля(null):
        if (vo.getTypeWork() != null)
            st.setInt(4, vo.getTypeWork().intValue());
        else
            st.setObject(4, null);
        st.setString(5, vo.getNoteWork());
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
        //входной параметр:
        st.setInt(10, vo.getIdWork().intValue());

        if (st.executeUpdate() != 1) {
            System.out.println("Update ReglamentWork:Id=" + vo.getIdWork() + " failed");
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
 * Creation date: (28.07.2005 17:46:06)
 */
public static List findListEquipNameFromPosition(int positionID, String filterEquipment, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = findListEquipNameFromPosition_SQL;
    if (filterEquipment != null)
        sql += " AND stp.type in(" + filterEquipment + ") ";
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        int equipment = ((Integer) ro.getColumn("equipment").asObject()).intValue();
        String storageName = ro.getColumn("storagename").asString();
        EquipmentName_TO to = new EquipmentName_TO(equipment, storageName);
        ret.add(to);
    }
    return ret;
}
/**
 * Возвращает список Регламент работ.
 * Creation date: (27.05.2004 12:17:32)
 */
public static CDBCResultSet findListReglamentWorks_byPosition(Integer position, String aSortBy) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    //add generic query string: 
    sqlb.append(findReglamentWork_SQL);
    //append order by clause:
    if (aSortBy != null)
        sqlb.append(" order by " + aSortBy);

    //executeQuery:
    res.executeQuery(sqlb.toString(), new Object[] { position });

    return res;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 18:36:40)
 */
public static List findListReglamentWorkTypes(String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    String sql = findListReglamentWorkTypes_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, null);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        int id =((Integer)ro.getColumn("idtype").asObject()).intValue();
		String name= ro.getColumn("nametype").asString();
        ReglamentWorkType_VO vo = new ReglamentWorkType_VO (id, name);
        ret.add(vo);
    }
    return ret;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 13:57:38)
 */
public static CDBCRowObject findReglamentWork(int aID) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findReglamentWork_SQL+ "WHERE idWork = " + aID;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
}

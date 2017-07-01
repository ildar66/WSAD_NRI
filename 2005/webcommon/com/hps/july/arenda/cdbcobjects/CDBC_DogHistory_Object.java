package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
 * JDBC - Объект для работы с "Историей договоров аренды".
 * Creation date: (30.07.2005 11:57:58)
 * @author: Shafigullin Ildar
 */
public class CDBC_DogHistory_Object {
    private final static java.lang.String findFlagsFromLeaseCharges_SQL =
        "SELECT isschetfakt1, isschetfakt2, isschetfakt3, isworkact1, isworkact2, isworkact3  "
            + "FROM LeaseCharges "
            + "WHERE leaseDocPosition=?";
    private final static java.lang.String editFlagsFromLeaseCharges_SQL =
        "UPDATE LeaseCharges SET isschetfakt1=?, isschetfakt2=?, isschetfakt3=?, isworkact1=?, isworkact2=?, isworkact3=? "
            + "WHERE leaseDocPosition=?";
/**
 * Insert the method's description here.
 * Creation date: (30.07.2005 14:41:40)
 */
public static boolean editFlagsFromLeaseCharges(FlagsFromLeaseCharges_TO vo) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(editFlagsFromLeaseCharges_SQL);
        //обязательные поля(not null):
        st.setString(1, (vo.getIsschetfakt1()==true)? "Y": "N");
        st.setString(2, (vo.getIsschetfakt2()==true)? "Y": "N");
        st.setString(3, (vo.getIsschetfakt3()==true)? "Y": "N");
        st.setString(4, (vo.getIsworkact1()==true)? "Y": "N");
        st.setString(5, (vo.getIsworkact2()==true)? "Y": "N");
        st.setString(6, (vo.getIsworkact3()==true)? "Y": "N");
        //необязательные поля(null):
 
        //входной параметр:
        st.setInt(7, vo.getLeasedocposition().intValue());

        if (st.executeUpdate() != 1) {
            System.out.println("Update LeaseCharges: leasedocposition=" + vo.getLeasedocposition() + " failed");
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
 * Creation date: (30.07.2005 12:13:14)
 */
public static FlagsFromLeaseCharges_TO findFlagsFromLeaseCharges(Integer leaseDocPosition) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { leaseDocPosition };
    String sql = findFlagsFromLeaseCharges_SQL;
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    FlagsFromLeaseCharges_TO to = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        String aIsschetfakt1 = ro.getColumn("isschetfakt1").asString();
        String aIsschetfakt2 = ro.getColumn("isschetfakt2").asString();
        String aIsschetfakt3 = ro.getColumn("isschetfakt3").asString();
        String aIsworkact1 = ro.getColumn("isworkact1").asString();
        String aIsworkact2 = ro.getColumn("isworkact2").asString();
        String aIsworkact3 = ro.getColumn("isworkact3").asString();

        to =
            new FlagsFromLeaseCharges_TO(
                leaseDocPosition,
                    "Y".equals(aIsschetfakt1) ? true : false,
                    "Y".equals(aIsschetfakt2) ? true : false,
                    "Y".equals(aIsschetfakt3) ? true : false,
                    "Y".equals(aIsworkact1) ? true : false,
                    "Y".equals(aIsworkact2) ? true : false,
                    "Y".equals(aIsworkact3) ? true : false);
    }
    return to;
}
}

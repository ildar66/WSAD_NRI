package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
/**
 * JDBC - Объект для работы со служебными записками.
* Creation date: (22.07.2004 17:56:06)
* @author: Shafigullin Ildar
*/
public class CDBC_Memo_Object {
	private final static java.lang.String findMemo_SQL =
		"SELECT idHeader, abonentContract, number, date, man, type, target, usetype, from, to, "
			+ "leasebill, filename, filetext, state, arendaContract, getNamePeople(man) namePeople, getPhonePeople(man,0) phonePeople, loanContract "
			+ "FROM OfficeMemoHeaders ";
	private final static java.lang.String addMemo_SQL =
		"INSERT INTO OfficeMemoHeaders(idHeader, abonentContract, number, date, man, type, target, "
			+ "usetype, from, to, leasebill, filename, filetext, state, arendaContract, loanContract) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String editMemo_SQL =
		"UPDATE OfficeMemoHeaders SET abonentContract=?, number=?, date=?, man=?, type=?, target=?, "
			+ "usetype=?, from=?, to=?, leasebill=?, filename=?, filetext=?, state=?, arendaContract=? "
			+ "WHERE idHeader = ?";
	private final static java.lang.String findMemoTarget_SQL =
		"SELECT idtarget, name FROM OfficeMemoTargets ";			
	private final static java.lang.String deleteMemo_SQL = "DELETE FROM OfficeMemoHeaders WHERE idHeader = ?";
	private final static java.lang.String storeWord_SQL =
		"UPDATE OfficeMemoHeaders SET filetext=?, filename=? "
			+ "WHERE idHeader = ?";
	private final static java.lang.String findMemoDetach_SQL =
		"SELECT idHeader, abonentContract, number, date, man, type, target, usetype, from, to, "
			+ "leasebill, filename, filetext, state, arendaContract, getNamePeople(man) namePeople, getPhonePeople(man,0) phonePeople, "
			+ "position, getNamePosition(position) positionName, orgCustomer, getNameOrg(orgCustomer) orgCustomerName, getInnOrg(orgCustomer) orgCustomerInn, txtArendaContract "
			+ "FROM OfficeMemoHeaders ";
	private final static java.lang.String addMemoDetach_SQL =
		"INSERT INTO OfficeMemoHeaders(idHeader, abonentContract, number, date, man, type, target, "
			+ "usetype, from, to, leasebill, filename, filetext, state, arendaContract, position, orgCustomer, txtArendaContract) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String editMemoDetach_SQL =
		"UPDATE OfficeMemoHeaders SET abonentContract=?, number=?, date=?, man=?, type=?, target=?, "
			+ "usetype=?, from=?, to=?, leasebill=?, filename=?, filetext=?, state=?, arendaContract=? , position=?, orgCustomer=?, txtArendaContract=? "
			+ "WHERE idHeader = ?";	
	private final static java.lang.String atachMemo_SQL =
		"UPDATE OfficeMemoHeaders SET abonentContract=? "
			+ "WHERE idHeader = ?";				
/**
 * CDBC_Memo_Object constructor comment.
 */
public CDBC_Memo_Object() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 10:46:40)
 * @param memo com.hps.july.arenda.valueobject.Memo_VO
 */
public static boolean addMemo(Memo_VO memo) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(addMemo_SQL);
		//обязательные поля(not null):
		st.setInt(1, memo.getIdHeader().intValue());
		//AbonentContract изменено на необязательное:
        if (memo.getAbonentContract() != null)
            st.setInt(2, memo.getAbonentContract().intValue());
		else
			st.setObject(2, null);
		st.setString(3, memo.getNumber());
		st.setDate(4, memo.getDate());
		st.setInt(5, memo.getManVO().getMan().intValue());
		st.setString(6, memo.getType());
		st.setInt(7, memo.getTarget().intValue());
		//необязательные поля(null):
		st.setString(8, memo.getUsetype());
		st.setString(9, memo.getFrom());
		st.setString(10, memo.getTo());
		if (memo.getLeasebill() != null)
			st.setInt(11, memo.getLeasebill().intValue());
		else
			st.setObject(11, null);
		st.setString(12, memo.getFilename());
		st.setBytes(13, memo.getFiletext());
		st.setString(14, memo.getState());
		if (memo.getArendaContract() != null)
			st.setInt(15, memo.getArendaContract().intValue());
		else
			st.setObject(15, null);
		if (memo.getLoanContract() != null)
			st.setInt(16, memo.getLoanContract().intValue());
		else
			st.setObject(16, null);			

		if (st.executeUpdate() != 1) {
			System.out.println("Insert Memo:IdHeader=" + memo.getIdHeader() + " failed");
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
 * @param memo com.hps.july.arenda.valueobject.Memo_VO
 */
public static boolean addMemoDetach(Memo_VO memo) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(addMemoDetach_SQL);
		//обязательные поля(not null):
		st.setInt(1, memo.getIdHeader().intValue());
		//AbonentContract изменено на необязательное:
        if (memo.getAbonentContract() != null)
            st.setInt(2, memo.getAbonentContract().intValue());
		else
			st.setObject(2, null);
		st.setString(3, memo.getNumber());
		st.setDate(4, memo.getDate());
		st.setInt(5, memo.getManVO().getMan().intValue());
		st.setString(6, memo.getType());
		st.setInt(7, memo.getTarget().intValue());
		//необязательные поля(null):
		st.setString(8, memo.getUsetype());
		st.setString(9, memo.getFrom());
		st.setString(10, memo.getTo());
		if (memo.getLeasebill() != null)
			st.setInt(11, memo.getLeasebill().intValue());
		else
			st.setObject(11, null);
		st.setString(12, memo.getFilename());
		st.setBytes(13, memo.getFiletext());
		st.setString(14, memo.getState());
		if (memo.getArendaContract() != null)
			st.setInt(15, memo.getArendaContract().intValue());
		else
			st.setObject(15, null);
		if (memo.getPositionVO() != null)
			st.setInt(16, memo.getPositionVO().getStorageplace());
		else
			st.setObject(16, null);
		if (memo.getOrgCustomer().getOrganization() != null)
			st.setInt(17, memo.getOrgCustomer().getOrganization().intValue());
		else
			st.setObject(17, null);
		st.setString(18, memo.getTxtArendaContract());

		if (st.executeUpdate() != 1) {
			System.out.println("Insert Memo:IdHeader=" + memo.getIdHeader() + " failed");
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
 * Creation date: (15.03.2005 17:28:40)
 */
public static boolean atachMemo(int idHeader, int abonentContract) throws Exception  {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(atachMemo_SQL);
        st.setInt(1, abonentContract);
        //входной параметр:
        st.setInt(2, idHeader);
        if (st.executeUpdate() != 1) {
            System.out.println("AtachMemo:IdHeader=" + idHeader + " to abonentContract="+abonentContract+" failed");
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
public static boolean deleteMemo(int idHeader) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(deleteMemo_SQL);
		st.setInt(1, idHeader);

		if (st.executeUpdate() != 1) {
			System.out.println("Delete Memo:IdHeader=" + idHeader + " failed");
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
 * Creation date: (27.07.2004 10:47:16)
 * @param memo com.hps.july.arenda.valueobject.Memo_VO
 */
public static boolean editMemo(Memo_VO memo) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(editMemo_SQL);
		//AbonentContract изменено на необязательное:        
        if (memo.getAbonentContract() != null)
            st.setInt(1, memo.getAbonentContract().intValue());
		else
			st.setObject(1, null);            
        //обязательные поля(not null):
        st.setString(2, memo.getNumber());
        st.setDate(3, memo.getDate());
        st.setInt(4, memo.getManVO().getMan().intValue());
        st.setString(5, memo.getType());
        st.setInt(6, memo.getTarget().intValue());
        //необязательные поля(null):
        st.setString(7, memo.getUsetype());
        st.setString(8, memo.getFrom());
        st.setString(9, memo.getTo());
        if (memo.getLeasebill() != null)
            st.setInt(10, memo.getLeasebill().intValue());
        else
            st.setObject(10, null);
        st.setString(11, memo.getFilename());
        st.setBytes(12, memo.getFiletext());
        st.setString(13, memo.getState());
        if (memo.getArendaContract() != null)
            st.setInt(14, memo.getArendaContract().intValue());
        else
            st.setObject(14, null);
        //входной параметр:
        st.setInt(15, memo.getIdHeader().intValue());

        if (st.executeUpdate() != 1) {
            System.out.println("Update Memo:IdHeader=" + memo.getIdHeader() + " failed");
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
 * Creation date: (27.07.2004 10:47:16)
 * @param memo com.hps.july.arenda.valueobject.Memo_VO
 */
public static boolean editMemoDetach(Memo_VO memo) throws Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(editMemoDetach_SQL);
		//AbonentContract изменено на необязательное:        
        if (memo.getAbonentContract() != null)
            st.setInt(1, memo.getAbonentContract().intValue());
		else
			st.setObject(1, null);            
        //обязательные поля(not null):
        st.setString(2, memo.getNumber());
        st.setDate(3, memo.getDate());
        st.setInt(4, memo.getManVO().getMan().intValue());
        st.setString(5, memo.getType());
        st.setInt(6, memo.getTarget().intValue());
        //необязательные поля(null):
        st.setString(7, memo.getUsetype());
        st.setString(8, memo.getFrom());
        st.setString(9, memo.getTo());
        if (memo.getLeasebill() != null)
            st.setInt(10, memo.getLeasebill().intValue());
        else
            st.setObject(10, null);
        st.setString(11, memo.getFilename());
        st.setBytes(12, memo.getFiletext());
        st.setString(13, memo.getState());
        if (memo.getArendaContract() != null)
            st.setInt(14, memo.getArendaContract().intValue());
        else
            st.setObject(14, null);
		if (memo.getPositionVO() != null)
			st.setInt(15, memo.getPositionVO().getStorageplace());
		else
			st.setObject(15, null);
		if (memo.getOrgCustomer().getOrganization() != null)
			st.setInt(16, memo.getOrgCustomer().getOrganization().intValue());
		else
			st.setObject(16, null);
		st.setString(17, memo.getTxtArendaContract());            
        //входной параметр:
        st.setInt(18, memo.getIdHeader().intValue());

        if (st.executeUpdate() != 1) {
            System.out.println("Update Memo:IdHeader=" + memo.getIdHeader() + " failed");
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
 * Creation date: (27.07.2004 15:45:33)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public static CDBCResultSet findAllMemoTargets() {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findMemoTarget_SQL+ " order by idTarget";
	//append order by clause:
	//sql += " order by name";
	res.executeQuery(sql, null);
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 14:47:06)
 * @return java.util.ArrayList
 * @param abonentContract java.lang.Integer
 */
public static ArrayList findListArendaContracts(Integer abonentContract) {
	Connection con = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	ArrayList list = new ArrayList();
	String s = "execute procedure getLstArndForAb(" + abonentContract + ")";
	try {
		con = new JdbcConnection().getConnection();
		cs = con.prepareCall(s);
		rs = cs.executeQuery();
		while (rs.next()) {
			Memo_ArendaContractInfo_VO vo = new Memo_ArendaContractInfo_VO(new Integer(rs.getInt(1)));
			vo.setInfo(rs.getString(2));
			list.add(vo);
		}
	} catch (Exception ex) {
		System.out.println("Error in execute procedure 'getLstArndForAb'.CDBC_Memo_Object.findListArendaContracts()");
		if (ex instanceof SQLException) {
			System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
		}
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (cs != null)
				cs.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

	return list;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 14:47:06)
 * @return java.util.ArrayList
 * @param abonentContract java.lang.Integer
 */
public static ArrayList findListArendaContracts(Integer abonentContract, Integer organizationID, int positionID) {
	Connection con = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	ArrayList list = new ArrayList();
	String s = "execute procedure getLstArndForAb(" + abonentContract + ", "+organizationID+", "+positionID+")";
	try {
		con = new JdbcConnection().getConnection();
		cs = con.prepareCall(s);
		rs = cs.executeQuery();
		while (rs.next()) {
			Memo_ArendaContractInfo_VO vo = new Memo_ArendaContractInfo_VO(new Integer(rs.getInt(1)));
			vo.setInfo(rs.getString(2));
			list.add(vo);
		}
	} catch (Exception ex) {
		System.out.println("Error in execute procedure 'getLstArndForAb'.CDBC_Memo_Object.findListArendaContracts()");
		if (ex instanceof SQLException) {
			System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
		}
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (cs != null)
				cs.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

	return list;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 18:17:23)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param idLeaseDoc java.lang.Integer
 */
public static CDBCResultSet findListMemo(Integer idLeaseDoc, String aSortBy) {
    CDBCResultSet res = new CDBCResultSet();
    String sql = null;
    if (idLeaseDoc.intValue()!=-1)
        sql = findMemo_SQL + "WHERE abonentContract = " + idLeaseDoc;
    else
        sql = findMemo_SQL + "WHERE abonentContract is NULL ";
    //append order by clause:
    sql += " order by " + aSortBy;
    res.executeQuery(sql, null);
    return res;
}
/**
* Insert the method's description here.
* Creation date: (22.07.2004 18:17:23)
* @return com.hps.july.cdbc.lib.CDBCResultSet
* @param idLeaseDoc java.lang.Integer
*/
public static CDBCResultSet findListMemoDetach(
    Integer idLeaseDoc,
    Boolean isSearchString,    Integer filterObj,    String searchString,
    Boolean isDataPerion,    java.sql.Date fromDate,    java.sql.Date toDate,
    String aSortBy) {
	    
    StringBuffer sqlb = new StringBuffer();
    ArrayList params = new ArrayList();
    CDBCResultSet res = new CDBCResultSet();
    
    if (idLeaseDoc.intValue() != -1)
        sqlb.append(findMemoDetach_SQL + "WHERE abonentContract = " + idLeaseDoc);
    else
        sqlb.append(findMemoDetach_SQL + "WHERE abonentContract is NULL ");
    //calculate filter clause:
    if (isSearchString.booleanValue()) {
        int filter = filterObj.intValue();
        if (filter == 0) {
            sqlb.append(" AND lower(number) matches '" + searchString.toLowerCase() + "' ");
        } else if (filter == 1) {
			sqlb.append(" AND lower(getNamePosition(position)) matches '" + searchString.toLowerCase() + "' ");
        }
    }
    if (isDataPerion.booleanValue()) {
        sqlb.append(" AND date >= ? AND date <= ? ");
        params.add(fromDate);
        params.add(toDate);
    }
    //append order by clause:
    sqlb.append(" order by " + aSortBy);
    res.executeQuery(sqlb.toString(), params.toArray());
    return res;
}
/**
 * Insert the method's description here.
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param idLeaseDoc java.lang.Integer
 */
public static CDBCResultSet findLoanContractListMemo(Integer idLeaseDoc, String aSortBy) {
    CDBCResultSet res = new CDBCResultSet();
    String sql = null;
    if (idLeaseDoc.intValue()!=-1)
        sql = findMemo_SQL + "WHERE loanContract = " + idLeaseDoc;
    else
        sql = findMemo_SQL + "WHERE loanContract is NULL ";
    //append order by clause:
    sql += " order by " + aSortBy;
    res.executeQuery(sql, null);
    return res;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:33:46)
 * @return com.hps.july.cdbc.lib.CDBCRowObject
 * @param idHeader int
 */
public static CDBCRowObject findMemo(int idHeader) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findMemo_SQL + "WHERE idHeader = " + idHeader;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:33:46)
 * @return com.hps.july.cdbc.lib.CDBCRowObject
 * @param idHeader int
 */
public static CDBCRowObject findMemoDetach(int idHeader) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findMemoDetach_SQL+ "WHERE idHeader = " + idHeader;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 17:05:26)
 * @return com.hps.july.cdbc.lib.CDBCRowObject
 * @param idTarget int
 */
public static CDBCRowObject findMemoTarget(int idTarget) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findMemoTarget_SQL + "WHERE idTarget = " + idTarget;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	boolean test1 = false;
	boolean test2 = false;
	boolean test3 = false;
	boolean test4 = true;
	boolean test5 = false;
	boolean test6 = false;
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test1) {
		Integer idLeaseDoc = new Integer(1760);
		CDBCResultSet rs = CDBC_Memo_Object.findListMemo(idLeaseDoc, "number desc");
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			com.hps.july.arenda.valueobject.Memo_VO vo = new com.hps.july.arenda.valueobject.Memo_VO(ro);
			count++;
			System.out.println(vo);
		}
		System.out.println("count findListMemo =" + count);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test2) {
		String id = "4";
		Memo_VO memo = new Memo_VO();
		memo.setIdHeader(new Integer(id));
		memo.setAbonentContract(new Integer("1760"));
		memo.setNumber(id);
		memo.setDate(new java.sql.Date(System.currentTimeMillis()));
		memo.setManVO(new PeopleVO(new Integer(3)));
		memo.setType(id);
		memo.setTarget(new Integer(3)); //1-3
		try {
			System.out.println("test3=" + addMemo(memo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	if (test3) {
		String id = "4";
		Memo_VO memo = new Memo_VO();
		memo.setIdHeader(new Integer(id));
		memo.setAbonentContract(new Integer("1760"));
		memo.setNumber(id);
		memo.setDate(new java.sql.Date(System.currentTimeMillis()));
		memo.setManVO(new PeopleVO(new Integer(3)));
		memo.setType("9"); //char(1)
		memo.setTarget(new Integer(3)); //1-3
		try {
			System.out.println("test4=" + editMemo(memo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	if (test4) {
		CDBCResultSet rs = findAllMemoTargets();
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			MemoTarget_VO vo = new MemoTarget_VO((Integer)ro.getColumn("idtarget").asObject());
			vo.setName(ro.getColumn("name").asString());
			System.out.println(vo);
		}
		System.out.println("count findAllMemoTargets =" + count);
	}
}
/**
 * Сохранение документа WORD.
 * Creation date: (29.11.2004 12:33:44)
 * @return boolean
 * @param idHeader int
 * @param filename java.lang.String
 * @param text byte[]
 * @exception java.lang.Exception The exception description.
 */
public static boolean storeWord(
    int id,
    String filename,
    byte[] text)
    throws java.lang.Exception {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
    PreparedStatement st = null;
    try {
        con = jcon.getConnection();
        st = con.prepareStatement(storeWord_SQL);
        //данные:
        st.setBytes(1, text);
        st.setString(2, filename);

        //входной параметр:
        st.setInt(3, id);

        if (st.executeUpdate() != 1) {
            System.out.println(
                "storeWord :Id=" + id + " failed");
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
}

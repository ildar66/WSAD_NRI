package com.hps.july.arenda.cdbcobjects;

import java.util.*;
import java.sql.*;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import com.hps.july.terrabyte.ext.client.*;
import com.hps.july.terrabyte.core.*;
import com.hps.july.valueobject.*;

/**
 * "Акты према-передачи" CDBC_Object.
 * Creation date: (07.11.2005 12:14:30)
 * @author: Shafigullin Ildar
 */
public class CDBC_LoanAktGetPut_Object {
    private static final String FIND_SQL =
        "SELECT idAct, loanContract , numberAct , dateAct , OurMan , OtherMan , typeAct , idleasebill , "
            + "modified , created , createdby, modifiedby, getNamePeople(OurMan) ourManName "
            + "FROM loanActsGetPut ";
    private final static java.lang.String EDIT_SQL =
        "UPDATE loanActsGetPut SET loanContract =?, numberAct =?, dateAct =?, OurMan =?, OtherMan =?, typeAct =?, idleasebill =?, "
            + "modified=?, created =?, createdby=?, modifiedby=? "
            + "WHERE idAct=? ";
    private final static java.lang.String ADD_SQL =
        "INSERT INTO loanActsGetPut (idAct, loanContract , numberAct , dateAct , OurMan , OtherMan , typeAct , idleasebill ,modified , created , createdby, modifiedby) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
    private final static java.lang.String DELETE_SQL = "DELETE FROM loanActsGetPut WHERE idAct = ?";
    private final static java.lang.String storeWord_SQL = "UPDATE loanActsGetPut SET acttext=?, actfilename=? WHERE idAct = ?";
    /**
     * Insert the method's description here.
     * Creation date: (09.11.2005 12:04:50)
     */
    public static final boolean add(LoanAktGetPut_VO vo) {
        CDBCResultSet res = new CDBCResultSet();
        Object[] params =
            {
                vo.getIdAct(),
                vo.getLoanContract(),
                vo.getNumberAct(),
                vo.getDateAct(),
                vo.getOurMan(),
                vo.getOtherMan(),
                vo.getTypeAct(),
                vo.getIdLeasebill(),
                vo.getModified(),
                vo.getCreated(),
                vo.getCreatedBy(),
                vo.getModifiedBy()};
        return res.executeUpdate(ADD_SQL, params);
    }
    /**
     * Insert the method's description here.
     * Creation date: (09.11.2005 12:13:05)
     */
    public static final boolean delete(LoanAktGetPut_VO vo) {
        CDBCResultSet res = new CDBCResultSet();
        Object[] params = { vo.getIdAct()};
        return res.executeUpdate(DELETE_SQL, params);
    }
    /**
     * Insert the method's description here.
     * Creation date: (09.11.2005 12:10:45)
     */
    public static final boolean edit(LoanAktGetPut_VO vo) {
        CDBCResultSet res = new CDBCResultSet();
        Object[] params =
            {
                vo.getLoanContract(),
                vo.getNumberAct(),
                vo.getDateAct(),
                vo.getOurMan(),
                vo.getOtherMan(),
                vo.getTypeAct(),
                vo.getIdLeasebill(),
                vo.getModified(),
                vo.getCreated(),
                vo.getCreatedBy(),
                vo.getModifiedBy(),
                vo.getIdAct()};
        return res.executeUpdate(EDIT_SQL, params);
    }
    /**
     * Insert the method's description here.
     * Creation date: (09.11.2005 16:54:13)
     * @param id int
     */
    public final static LoanAktGetPut_TO find(int aID) {
        CDBCResultSet res = new CDBCResultSet();
        Object[] params = { new Integer(aID)};
        String sql = FIND_SQL + " WHERE idAct = ? ";
        res.executeQuery(sql, params);
        ListIterator list = res.listIterator();
        CDBCRowObject ro = null;
        LoanAktGetPut_TO to = null;
        if (list.hasNext()) {
            ro = (CDBCRowObject) list.next();
            to = new LoanAktGetPut_TO(CDBC_Helper.createLoanAktGetPut(ro));
            to.setOurManName(ro.getColumn("ourmanname").asString());
        }
        return to;
    }
    /**
     * Insert the method's description here.
     * Creation date: (07.11.2005 12:19:16)
     */
    public static final List getList(int loanContract, String sortBy) {
        List ret = new ArrayList();
        CDBCRowObject ro = null;
        CDBCResultSet res = new CDBCResultSet();
        Object[] params = { new Integer(loanContract)};
        String sql = FIND_SQL + " WHERE loanContract =? ";
        //append order by clause:
        if (sortBy != null)
            sql += " order by " + sortBy;
        res.executeQuery(sql, params);
        ListIterator iter = res.listIterator();
        LoanAktGetPut_TO to = null;
        while (iter.hasNext()) {
            ro = (CDBCRowObject) iter.next();
            //LoanAktGetPut_VO vo = CDBC_Helper.createLoanAktGetPut(ro);
            to = new LoanAktGetPut_TO(CDBC_Helper.createLoanAktGetPut(ro));
            to.setOurManName(ro.getColumn("ourmanname").asString());
            ret.add(to);
        }
        return ret;
    }
/**
 * Insert the method's description here.
 * Creation date: (17.11.2005 10:21:14)
 */
public final static WordDocument loadWordExternal(Integer id, String remoteUser) throws Exception {
    TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
    Document doc = client.getDocumentLastVersionByObject(id, ObjectTypes.ARENDA_ACTS, remoteUser);
    java.io.InputStream stream = doc.getData();
    byte [] text = new byte[stream.available()];
    stream.read(text);
    stream.close();
    String filename = doc.getDocumentName();
    return new WordDocument(id, text, filename);
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2005 12:46:39)
 */

public final static boolean storeWord(int id, String filename,  byte[] actText) throws Exception {
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = jcon.getConnection();
		st = con.prepareStatement(storeWord_SQL);
		//данные:
		st.setBytes(1, actText);
		st.setString(2, filename);

		//входной параметр:
		st.setInt(3, id);

		if (st.executeUpdate() != 1) {
			System.out.println("storeWord :Id=" + id + " failed");
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
 * Creation date: (17.11.2005 9:43:21)
 */
public final static void storeWordExternal(WordDocument doc, String remoteUser) throws Exception {
    //String host = com.hps.july.util.AppUtils.getNamedValueString("TERRABYTE_HOST");
    //int port = com.hps.july.util.AppUtils.getNamedValueInt("TERRABYTE_PORT");
    //String operator = "NRI";
    TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
    Integer nriType = DocumentTypes.ARENDA_ACT_TAKE_HANDING_OVER_RETURN;
    String mimeType = "application/msword";
    client.addObjectDocument(
        new java.io.ByteArrayInputStream(doc.getText()),
        doc.getFilename(),
        doc.getId(),
        ObjectTypes.ARENDA_ACTS,
        remoteUser,
        nriType,
        mimeType);
    //client.addObjectDocument(doc, objectId, objectType, userName);    
}
}

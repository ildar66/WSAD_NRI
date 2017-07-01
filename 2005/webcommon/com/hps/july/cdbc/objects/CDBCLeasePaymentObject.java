package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.OperatorObject;
import com.hps.july.util.*;

import java.sql.*;
import java.util.*;

/**
 * ������ ��� ������ � ��������� ������.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCLeasePaymentObject {
	public final static int ACTION_FROM_NRI = 0;//�� ��������� � NRI
	public final static int ACTION_TO_Nri =1;//������ � NRI
	/**
	 * CDBCPositionObject constructor comment.
	 */
	public CDBCLeasePaymentObject() {
		super();
	}
	/**
	 * ���������� ������ �������� �� �������� ������
	 */
	public CDBCResultSet findByQBE5(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		Boolean isResource,
		Integer resource,
		Boolean isDocposvid,
		String[] docposvid,
		java.lang.Integer order)
		throws java.lang.Exception {

		int i;
		Object[] args = null;

		// Prepare query	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ldp.leasedocposition, ldp.date, ldp.resource, res.name resname, ");
		sb.append("po.orgacc, lp.isschetfakt, lp.officememonumber, lp.docnumber, lp.summrub, lp.flagOplNds, ");
		sb.append("ldp.summ, ldp.currency, cur.shortname, po.paypurpose, ldp.usedinact, ");
		sb.append("lp.paymentstate, org.name orgname,  ");
		sb.append("(SELECT acc.account FROM accounts acc WHERE acc.accountid = po.orgacc) account, ");
		sb.append("(SELECT org1.bik FROM accounts acc1, banks org1 WHERE acc1.accountid = po.orgacc AND org1.idBank=acc1.bank) bik, ");
		sb.append("(SELECT org2.name FROM accounts acc2, banks org2 WHERE acc2.accountid = po.orgacc AND org2.idBank=acc2.bank) bankname ");
		sb.append("FROM leasedocpositions ldp, leasepayments lp, outer leasepayorder po, ");
		sb.append("leasecontracts lc, ");
		sb.append("resources res, currencies cur, vendorsites org ");
		sb.append("WHERE ");
		sb.append("lp.leasedocposition = ldp.leasedocposition ");
		sb.append("AND po.leasedocposition = lp.leasedocposition ");
		sb.append("AND lc.leasedocument = ldp.leasecontract ");
		sb.append("AND res.resource = ldp.resource ");
		sb.append("AND cur.currency = ldp.currency ");
		sb.append("AND org.idVendorSite = lc.orgexecutor ");

		//calculate where clause
		if (isLeaseContract.booleanValue())
			sb.append(" AND ldp.leasecontract =  " + leaseContract.toString());
		if (isDate.booleanValue()) {
			sb.append(" AND ldp.date >= ? AND ldp.date <= ? ");
			args = new Object[] { fromDate, toDate };
		}
		if (isResource.booleanValue())
			sb.append(" AND ldp.resource = " + resource.toString());
		if (isDocposvid.booleanValue()) {
			String s = "'" + docposvid[0] + "'";
			for (int ii = 1; ii < docposvid.length; ii++) {
				s = s + ",'" + docposvid[ii] + "'";
			}
			sb.append(" AND ldp.docposvid IN (" + s + ") ");
		}

		//append order by clause
		String orderBy = null;
		switch (order.intValue()) {
			case 1 :
				orderBy = "date asc";
				break;
			case 2 :
				orderBy = "date desc";
				break;
		}
		sb.append(" ORDER BY ");
		sb.append(orderBy);

		//System.out.println("SQL=" + sb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), args);
		return res;
	}
	/**
	 * Main ����� ��� �������� ������ ������ �������.
	 * Creation date: (10.03.2004 16:03:42)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) throws Exception {

		com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("LEASEPAYMENTS");
		tc.start();
		CDBCLeasePaymentObject o = new CDBCLeasePaymentObject();
			CDBCResultSet rs = o.findByQBE5(Boolean.TRUE, new Integer(4227), // Boolean isLeaseContract, Integer leaseContract
		Boolean.FALSE, null, null, // Boolean isDate, Date fromDate, Date toDate
		new Boolean(false), new Integer(0), // Boolean isResource, Integer resource
	new Boolean(true), new String[] { "N", "C" }, // Boolean isDocposvid, String[] docposvid
		new Integer(1));
		tc.finish("SQL");

		tc.start();
		java.util.ListIterator it = rs.listIterator();
		System.out.println("start");
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			CDBCColumnObject co1 = (CDBCColumnObject) ro.getColumn("leasedocposition");
			CDBCColumnObject co2 = (CDBCColumnObject) ro.getColumn("resname");
			System.out.println("" + co1.asObject() + "  '" + co2.asString() + "'");
		}
		tc.finish("Iterate");
	}
	/**
	 *create procedure movePayNfs2Nri(
		-- ��������� ��������� ���� ���������� �� ������� NFS ������ � ������� NRI
		i_idPayNfs integer,          -- ��� ������� � ������� NFS
		i_BaseContract integer,     -- ��� �������� �������� ������ NRI
		i_operator integer,          -- ��� ���������
		i_action integer          --  1 ������ � NRI, 0 �� ��������� � NRI
		) returning
		integer,      -- ������� ������ (0-��� ������, ����� ������)
		char(255);    -- ����� ������
	 * Creation date: (17.06.2004 16:57:23)
	 * @return java.lang.String
	 * @param idPayNfs int
	 */
	public final static String movePayNfs2Nri(String remoteUser, int idPayNfs, int mainLeaseDoc, int movePayNfsFlag) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = "";
		try {
			String sql = "execute procedure movePayNfs2Nri(?, ?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			//System.out.println("idPayNfs= " + idPayNfs); //temp
			//System.out.println("mainLeaseDoc= " + mainLeaseDoc); //temp
			// Set operatorCode:
			int operatorCode = 0;
			try {
				operatorCode = OperatorObject.getOperatorCode(remoteUser).intValue();
			} catch (Exception e) {
				System.out.println("���������� ��������� 'operatorCode'."); //temp	
				e.printStackTrace();
			}
			System.out.println("operatorCode= " + operatorCode); //temp			

			cs.setInt(1, idPayNfs); //��� ������� � ������� NFS
			cs.setInt(2, mainLeaseDoc); //��� �������� �������� ������ NRI		
			cs.setInt(3, operatorCode); //��� ��������� ������������ �������
			cs.setInt(4, movePayNfsFlag); //1- ������ � NRI, 0- �� ��������� � NRI
			System.out.println("execute procedure movePayNfs2Nri(" + idPayNfs + ", " + mainLeaseDoc + ", " + operatorCode + ", " + movePayNfsFlag + ")");
			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- ������� ������ (0 ��� ������)
				if (result == 0) {
					System.out.println("��������� 'movePayNfs2Nri' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- ��������� �� �������
					System.out.println("��������� 'movePayNfs2Nri' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'movePayNfs2Nri'"); //temp
			}

		} catch (Exception ex) {
			catchMetod(ex);
		} finally {
			finallyMetod(con, cs, rs);
		}
		return errorTxt;

	}
	/**
	 * 
	 * @param con
	 * @param cs
	 * @param rs
	 */
	private static void finallyMetod(Connection con, CallableStatement cs, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (cs != null)
				cs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	/**
	 * 
	 * @param e
	 */
	private final static void catchMetod(Exception e) {
		if (e instanceof SQLException) {
			SQLException sqlExec = (SQLException) e;
			while (sqlExec != null) {
				System.out.println("Error code=" + sqlExec.getErrorCode());
				sqlExec = sqlExec.getNextException();
			}
		}
		e.printStackTrace(System.out);
	}
	
	/**
	 * ��� �������� "������ �� ���" ������� ������� nfs_lnkpays 
	 * @param idPayNri
	 * @return boolean
	 */
	public final static Integer isPaymentFromNfs(int idPayNri) {
		Integer idPayNfs = null;
		CDBCResultSet res = new CDBCResultSet();
		String s = "SELECT idPayNfs FROM nfs_lnkPays WHERE idPayNri = ? ";
		res.executeQuery(s, new Object[] { new Integer(idPayNri) });
		ListIterator iter = res.listIterator();
		if (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			idPayNfs = (Integer)ro.getColumn("idPayNfs").asObject();			
		}
		return idPayNfs;
	}
}
